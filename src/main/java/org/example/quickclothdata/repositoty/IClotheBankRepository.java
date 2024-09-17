package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.ClotheBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IClotheBankRepository extends JpaRepository<ClotheBank, UUID> {
    @Query("SELECT cb FROM ClotheBank cb WHERE cb.foundation.uuid = :foundationUuid")
    List<ClotheBank> findAllByFoundationUuid(UUID foundationUuid);
}
