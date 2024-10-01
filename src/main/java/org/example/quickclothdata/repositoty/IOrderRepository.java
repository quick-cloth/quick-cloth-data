package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IOrderRepository extends JpaRepository<Order, UUID> {

    @Query("SELECT o FROM Order o " +
            "WHERE o.wardrobe.clotheBank.uuid = :clotheBankUuid " +
            "AND (COALESCE(:orderStateUuid, o.orderState.uuid) = o.orderState.uuid) " +
            "AND (COALESCE(:wardRobeUuid, o.wardrobe.uuid) = o.wardrobe.uuid)")
    List<Order> findAllByClotheBankUuid(UUID clotheBankUuid, UUID orderStateUuid, UUID wardRobeUuid);

    @Query("SELECT o FROM Order o " +
            "WHERE o.wardrobe.uuid = :wardRopeUuid")
    List<Order> findAllByWardRopeUuid(UUID wardRopeUuid);
}
