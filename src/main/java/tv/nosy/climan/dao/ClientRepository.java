package tv.nosy.climan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tv.nosy.climan.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
