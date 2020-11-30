package tv.nosy.climan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tv.nosy.climan.entities.Achat;

public interface AchatRepository extends JpaRepository<Achat, Long> {
    @Query("select a from Achat a where a.client = :id")
    public Achat findByClient(@Param("id") Long id);

    @Query("select a from Achat a where a.box = :ref")
    public Achat findByBox(@Param("ref") String id);
}
