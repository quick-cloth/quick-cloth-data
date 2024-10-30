package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.TypeClothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ITypeClotheRepository extends JpaRepository<TypeClothe, UUID> {
    TypeClothe findByName(String name);
}
