package tv.nosy.climan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tv.nosy.climan.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String>{
    
}
