package tv.nosy.climan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tv.nosy.climan.entities.Achat;

public interface AchatRepository extends JpaRepository<Achat, Long> {
    
}
