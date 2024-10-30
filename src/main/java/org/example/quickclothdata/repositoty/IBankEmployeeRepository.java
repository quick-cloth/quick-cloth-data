package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.BankEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IBankEmployeeRepository extends JpaRepository<BankEmployee, UUID> {
    @Query("SELECT u FROM BankEmployee u WHERE u.user.user_name = :username")
    BankEmployee findByUserUserName(String username);
}
