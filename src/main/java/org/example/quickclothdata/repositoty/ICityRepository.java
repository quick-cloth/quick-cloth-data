package org.example.quickclothdata.repositoty;

import org.example.quickclothdata.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ICityRepository extends JpaRepository<City, UUID> {

    @Query("SELECT c FROM City c WHERE c.department.uuid = :departmentUuid")
    List<City> findAllByDepartmentUuid(UUID departmentUuid);
}
