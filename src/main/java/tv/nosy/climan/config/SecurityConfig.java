package tv.nosy.climan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    
    @Autowired
    private PasswordEncoder pe = new BCryptPasswordEncoder();

    @Autowired
    public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("admin").password(pe.encode("1234")).roles("ADMIN");
        // auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        // auth.inMemoryAuthentication().withUser("moderator").password("1234").roles("MODERATOR");
        // auth.inMemoryAuthentication().withUser("guest").password("1234").roles("GUEST");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest()
                    .authenticated()
                        .and()
            .formLogin()
                .loginPage("/login")
                .permitAll();
    }
}
