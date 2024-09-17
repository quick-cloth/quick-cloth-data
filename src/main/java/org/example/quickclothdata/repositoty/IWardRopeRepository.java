package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Wardrope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IWardRopeRepository extends JpaRepository<Wardrope, UUID> {
    @Query("SELECT w FROM Wardrope w WHERE w.clotheBank.uuid = :clotheBankUuid")
    List<Wardrope> findAllByClotheBankUuid(UUID clotheBankUuid);
}
