package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IOrderListRepository extends JpaRepository<OrderList, UUID> {

    @Query("SELECT ol FROM OrderList ol WHERE ol.order.uuid = :orderUuid")
    List<OrderList> findAllByOrderUuid(UUID orderUuid);
}
