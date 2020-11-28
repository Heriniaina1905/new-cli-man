package tv.nosy.climan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tv.nosy.climan.entities.Box;

public interface BoxRepository extends JpaRepository<Box, String>{
    
}
