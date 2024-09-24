package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDonationRepository extends JpaRepository<Donation, UUID> {
}
