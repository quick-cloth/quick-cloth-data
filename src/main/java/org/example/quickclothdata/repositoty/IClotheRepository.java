package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Clothe;
import org.example.quickclothdata.model.TypeClothe;
import org.example.quickclothdata.model.TypeGender;
import org.example.quickclothdata.model.TypeStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IClotheRepository extends JpaRepository<Clothe, UUID> {
    @Query("SELECT c FROM Clothe c WHERE c.typeGender = ?1 AND c.typeClothe = ?2 AND c.typeStage = ?3")
    Clothe findByTypeGenderAndTypeClotheAndTypeStage(TypeGender typeGender, TypeClothe typeClothe, TypeStage typeStage);
}
