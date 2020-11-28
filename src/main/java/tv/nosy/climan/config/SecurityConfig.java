package tv.nosy.climan.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    
    // private PasswordEncoder pe = new BCryptPasswordEncoder();

    @Autowired
    public void globalConfig(AuthenticationManagerBuilder auth, DataSource datasource) throws Exception {

        // auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
        // auth.inMemoryAuthentication().withUser("test_admin").password("{noop}test_admin").roles("ADMIN");
        // auth.inMemoryAuthentication().withUser("moderator").password("{noop}1234").roles("MODERATOR");
        // auth.inMemoryAuthentication().withUser("guest").password("{noop}1234").roles("GUEST");


        auth.jdbcAuthentication()
            .dataSource(datasource)
            .usersByUsernameQuery("select username as principal, password as credentials, true from users where username = ?")
            .authoritiesByUsernameQuery("select user_username  as principal, roles_nom as role from users_roles where user_username  = ?")
        .rolePrefix("ROLE_");
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .anyRequest()
                    .authenticated()
                        .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
            .defaultSuccessUrl("/index.html");
    }
}
