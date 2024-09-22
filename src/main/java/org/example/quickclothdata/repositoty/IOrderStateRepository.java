package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IOrderStateRepository extends JpaRepository<OrderState, UUID> {
    @Query("SELECT os FROM OrderState os WHERE os.name = :orderName")
    OrderState findOrderStateByName(String orderName);
}
