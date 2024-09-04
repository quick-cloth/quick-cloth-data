package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IInventoryRepository extends JpaRepository<Inventory, UUID> {
}
