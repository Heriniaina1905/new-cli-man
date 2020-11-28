package tv.nosy.climan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tv.nosy.climan.dao.RoleRepository;
import tv.nosy.climan.dao.UserRepository;
import tv.nosy.climan.entities.Role;
import tv.nosy.climan.entities.User;

@RestController
@Secured(value = "ROLE_ADMIN")
public class UserRestService {

    @Autowired
    private UserRepository ur;

    @Autowired
    private RoleRepository rr;

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public User save(@RequestBody User vao) {
        return ur.save(vao);
    }

    @RequestMapping(value = "/listUser")
    public List<User> findAll() {
        return ur.findAll();
    }             

    @RequestMapping(value = "/saveRole", method = RequestMethod.POST)
    public Role save(@RequestBody Role vao) {
        return rr.save(vao);
    }

    @RequestMapping(value = "/listRoles")
    public List<Role> findAllRoles() {
        return rr.findAll();

    }

    @RequestMapping(value = "/addRoleToUser")
    public User addRoleToUser(String username, String role) {
        Optional<User> u = ur.findById("username");
        Optional<Role> r = rr.findById("role");
        u.get().getRoles().add(r.get());
        ur.save(u.get());

        return u.get();
    }
}
