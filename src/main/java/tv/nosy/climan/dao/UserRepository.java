package tv.nosy.climan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tv.nosy.climan.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
    
}
