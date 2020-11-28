package tv.nosy.climan.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tv.nosy.climan.dao.ClientRepository;
import tv.nosy.climan.entities.Client;

@RestController
public class ClientRestService {
    @Autowired
    private ClientRepository clirep;

    @Secured(value = {"ROLE_ADMIN", "ROLE_MODERATOR"})
    @RequestMapping(value = "/save-client", method = RequestMethod.POST)
    public Client save(@RequestBody Client c){
        return clirep.save(c);
    }

    @Secured(value = {"ROLE_ADMIN", "ROLE_MODERATOR", "ROLE_GUEST"})
    @RequestMapping(value = "/liste-client", method = RequestMethod.GET)
    public Page<Client> listClient(int page, int size){
        return clirep.findAll(PageRequest.of(page, size));
    }

    @RequestMapping(value = "getLoggedUser")
    public Map<String, Object> getLoggedUse(HttpSession session){
        SecurityContext sc = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");

        String name = sc.getAuthentication().getName();
        List<String> roles = new ArrayList<>();

        for(GrantedAuthority ga:sc.getAuthentication().getAuthorities()){
            roles.add(ga.getAuthority());
        }
        Map<String, Object> result = new HashMap<>();
        result.put("username", name);
        result.put("roles", roles);

        return result;
    }
}
