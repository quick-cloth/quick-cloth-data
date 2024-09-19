package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
    User findByDocument(BigInteger document);
    @Query("SELECT u FROM User u WHERE u.user_name = :userName")
    User findByUserName(String userName);
    User findByEmail(String email);
    User findByPhone(BigInteger phone);
    @Query("SELECT u FROM User u WHERE u.role.name = :roleName")
    List<User> findByRole(String roleName);
}
