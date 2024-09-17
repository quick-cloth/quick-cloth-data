package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, UUID> {
    @Query("SELECT s FROM Sale s WHERE s.wardrope.uuid = :wardRopeUuid")
    List<Sale> findAllByWardRopeUuid(UUID wardRopeUuid);
}
