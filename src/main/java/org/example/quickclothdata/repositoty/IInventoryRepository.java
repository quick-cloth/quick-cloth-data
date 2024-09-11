package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IInventoryRepository extends JpaRepository<Inventory, UUID> {
    @Query("SELECT i FROM Inventory i WHERE i.wardrope.uuid = :wardRopeUuid")
    List<Inventory> findAllByWardRopeUuid(UUID wardRopeUuid);
}
