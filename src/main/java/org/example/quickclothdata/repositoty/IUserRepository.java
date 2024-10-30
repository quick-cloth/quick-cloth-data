package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.User;
import org.example.quickclothdata.payload.response.SalesByUserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
    User findByDocument(BigInteger document);
    @Query("SELECT u FROM User u WHERE u.user_name = :userName")
    User findByUserName(String userName);
    User findByEmail(String email);
    User findByPhone(BigInteger phone);
    @Query("SELECT u FROM User u WHERE u.role.name = :roleName")
    List<User> findByRole(String roleName);

    @Query("""
            SELECT
                s.uuid AS uuid,
                s.sale_date AS saleDate,
                s.value AS value,
                s.pay_points AS payPoints,
                w as wardrobe
            FROM Sale s
            JOIN s.wardrobe w
            WHERE s.user.uuid = :userUuid
            AND s.sale_date BETWEEN :startDate AND :endDate
            """)
    List<SalesByUserProjection> findSalesByUser(UUID userUuid, LocalDate startDate, LocalDate endDate);
}
