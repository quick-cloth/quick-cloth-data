package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Foundation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IFoundationRespositoy extends JpaRepository<Foundation, UUID> {

    @Query("SELECT f FROM Foundation f WHERE f.clotheBank.uuid = :clotheBankUuid")
    List<Foundation> findByClotheBank(UUID clotheBankUuid);
}
