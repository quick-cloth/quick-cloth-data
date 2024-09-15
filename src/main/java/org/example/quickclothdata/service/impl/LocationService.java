package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.City;
import org.example.quickclothdata.model.Department;
import org.example.quickclothdata.repositoty.ICityRepository;
import org.example.quickclothdata.repositoty.IDepartmentRepository;
import org.example.quickclothdata.service.intf.ILocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocationService implements ILocationService {
    private final ICityRepository cityRepository;
    private final IDepartmentRepository departmentRepository;

    public LocationService(ICityRepository cityRepository, IDepartmentRepository departmentRepository) {
        this.cityRepository = cityRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentByUuid(UUID uuid) {
        return departmentRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<City> getAllCitiesByDepartment(UUID departmentUuid) {
        return cityRepository.findAllByDepartmentUuid(departmentUuid);
    }

    @Override
    public City findCityByUuid(UUID cityUuid) {
        return cityRepository.findById(cityUuid).orElse(null);
    }
}
