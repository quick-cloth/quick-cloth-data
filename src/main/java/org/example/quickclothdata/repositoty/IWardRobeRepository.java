package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Wardrobe;
import org.example.quickclothdata.payload.response.CustomerProjection;
import org.example.quickclothdata.payload.response.MinimumStockProjection;
import org.example.quickclothdata.payload.response.TopSellingClothesProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IWardRobeRepository extends JpaRepository<Wardrobe, UUID> {
    @Query("SELECT w FROM Wardrobe w WHERE w.clotheBank.uuid = :clotheBankUuid")
    List<Wardrobe> findAllByClotheBankUuid(UUID clotheBankUuid);

    @Query(value = """
    SELECT
        tc.name AS name,
        tg.name AS gender,
        ts.name AS stage,
        COALESCE(SUM(sl.quantity), 0) AS quantity,
        COALESCE(SUM(sl.value * sl.quantity), 0) AS value
    FROM SaleList sl
    JOIN sl.sale s ON sl.sale.uuid = s.uuid
    JOIN sl.clothe c ON sl.clothe.uuid = c.uuid
    JOIN c.typeClothe tc ON c.typeClothe.uuid = tc.uuid
    JOIN c.typeGender tg ON c.typeGender.uuid = tg.uuid
    JOIN c.typeStage ts ON c.typeStage.uuid = ts.uuid
    WHERE s.wardrobe.uuid = :wardrobeUuid
    GROUP BY tc.name, tg.name, ts.name
    ORDER BY quantity DESC
    """)
    List<TopSellingClothesProjection> getTopSellingClothes(UUID wardrobeUuid);

    /**
     * Find the users that have bought clothes from a wardrobe
     * @param wardrobeUuid the wardrobe uuid
     * @param clotheUuids the clothes uuids
     * @return the users that have bought clothes from a wardrobe
     */
    @Query("SELECT DISTINCT u.uuid AS uuid, u.name AS name, u.last_name AS lastName, u.user_name AS userName, u.points AS points " +
           "FROM SaleList sl " +
           "JOIN sl.sale s " +
           "JOIN s.user u " +
           "WHERE s.wardrobe.uuid = :wardrobeUuid " +
           "AND sl.clothe.uuid IN :clotheUuids")
    List<CustomerProjection> findCustomersByWardrobeAndClothes(@Param("wardrobeUuid") UUID wardrobeUuid,
                                                               @Param("clotheUuids") List<UUID> clotheUuids);
    
    @Query(value = """
    SELECT
    i.stock AS stock,
    i.minimum_stock AS minimumStock,
    i.wardrobe.uuid AS wardrobeUuid,
    i.uuid AS inventoryUuid,
    c AS clothe
    FROM Inventory i
    JOIN Clothe c ON i.clothe.uuid = c.uuid
    JOIN Wardrobe w ON i.wardrobe.uuid = w.uuid
    WHERE w.uuid = :wardrobeUuid
    """)
    List<MinimumStockProjection> findMinimumStocksByWardrobeUuid(UUID wardrobeUuid);
}
