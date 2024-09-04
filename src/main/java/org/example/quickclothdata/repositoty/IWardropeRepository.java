package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Wardrope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IWardropeRepository extends JpaRepository<Wardrope, UUID> {
}
