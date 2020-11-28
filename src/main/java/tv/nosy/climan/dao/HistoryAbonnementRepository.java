package tv.nosy.climan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tv.nosy.climan.entities.HistoryAbonnement;

public interface HistoryAbonnementRepository extends JpaRepository<HistoryAbonnement, Long>{
    
}
