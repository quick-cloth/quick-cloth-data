package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IDonationRepository extends JpaRepository<Donation, UUID> {

    @Query("SELECT d FROM Donation d WHERE d.clothe_bank.uuid = :clotheBankUuid")
    List<Donation> findAllByClotheBankUuid(UUID clotheBankUuid);
}
