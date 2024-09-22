package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ICampaignRepository extends JpaRepository<Campaign, UUID> {
    @Query("SELECT c FROM Campaign c WHERE c.clotheBank.uuid = :clotheBankUuid")
    List<Campaign> findAllByClotheBankUuid(UUID clotheBankUuid);
}
