package tv.nosy.climan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tv.nosy.climan.entities.Abonnement;

public interface AbonnementRepository extends JpaRepository<Abonnement, String>{
    
}
