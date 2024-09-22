package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Wardrobe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IWardRobeRepository extends JpaRepository<Wardrobe, UUID> {
    @Query("SELECT w FROM Wardrobe w WHERE w.clotheBank.uuid = :clotheBankUuid")
    List<Wardrobe> findAllByClotheBankUuid(UUID clotheBankUuid);
}
