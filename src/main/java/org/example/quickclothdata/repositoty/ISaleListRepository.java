package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.SaleList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ISaleListRepository extends JpaRepository<SaleList, UUID> {
    @Query("SELECT sl FROM SaleList sl WHERE sl.sale.uuid = :saleUuid")
    List<SaleList> findAllBySaleUuid(UUID saleUuid);

    @Query("SELECT sl FROM SaleList " +
            "sl JOIN sl.sale s " +
            "WHERE s.user.uuid = :userUuid")
    List<SaleList> findAllByUserUuid(UUID userUuid);
}
