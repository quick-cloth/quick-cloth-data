package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ICampaignRepository extends JpaRepository<Campaign, UUID> {
    @Query("SELECT c FROM Campaign c " +
            "WHERE c.clotheBank.uuid = :clotheBankUuid " +
            "AND (COALESCE(:startDate, c.creation_date) <= c.creation_date) " +
            "AND (COALESCE(:endDate, c.end_date) >= c.end_date)")
    List<Campaign> findAllByClotheBankUuid(UUID clotheBankUuid, LocalDate startDate, LocalDate endDate);

    @Query("""
            SELECT c FROM Campaign c
            WHERE :date BETWEEN c.creation_date AND c.end_date
            """)
    List<Campaign> findAllActiveCampaigns(LocalDate date);
}
