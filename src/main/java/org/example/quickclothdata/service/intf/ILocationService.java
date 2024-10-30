package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.City;
import org.example.quickclothdata.model.Department;

import java.util.List;
import java.util.UUID;

public interface ILocationService {
    List<Department> getAllDepartments();
    Department findDepartmentByUuid(UUID uuid);
    List<City> getAllCitiesByDepartment(UUID departmentUuid);
    City findCityByUuid(UUID cityUuid);
}
