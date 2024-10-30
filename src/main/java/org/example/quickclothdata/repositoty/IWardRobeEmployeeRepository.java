package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.WardRobeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IWardRobeEmployeeRepository extends JpaRepository<WardRobeEmployee, UUID> {
    @Query("SELECT u FROM WardRobeEmployee u WHERE u.user.user_name = :username")
    WardRobeEmployee findByUserUserName(String username);
}
