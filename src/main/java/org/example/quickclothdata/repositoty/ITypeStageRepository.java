package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.TypeStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ITypeStageRepository extends JpaRepository<TypeStage, UUID> {
    TypeStage findByName(String name);
}
