package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Clothe;
import org.example.quickclothdata.model.TypeClothe;
import org.example.quickclothdata.model.TypeGender;
import org.example.quickclothdata.model.TypeStage;
import org.example.quickclothdata.payload.response.ClotheByAllTypesProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IClotheRepository extends JpaRepository<Clothe, UUID> {
    @Query("SELECT c " +
       "FROM Clothe c " +
       "JOIN c.typeClothe tc " +
       "JOIN c.typeGender tg " +
       "JOIN c.typeStage ts " +
       "WHERE c.typeGender.uuid = :typeGenderUuid " +
       "AND c.typeClothe.uuid = :typeClotheUuid " +
       "AND c.typeStage.uuid = :typeStageUuid")
    ClotheByAllTypesProjection findClothesByAllTypes(@Param("typeGenderUuid") UUID typeGenderUuid,
                                                     @Param("typeClotheUuid") UUID typeClotheUuid,
                                                     @Param("typeStageUuid") UUID typeStageUuid);
}
