package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.ContactUser;
import org.example.quickclothdata.model.Foundation;
import org.example.quickclothdata.model.TypeMeetUs;
import org.example.quickclothdata.repositoty.IContactUserRepository;
import org.example.quickclothdata.repositoty.IFoundationEmployeeRepository;
import org.example.quickclothdata.repositoty.IFoundationRespositoy;
import org.example.quickclothdata.repositoty.ITypeMeetUsRepository;
import org.example.quickclothdata.service.intf.IFoundationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FoundationService implements IFoundationService {
    private final IFoundationRespositoy foundationRepository;
    private final ITypeMeetUsRepository typeMeetUsRepository;
    private final IContactUserRepository contactUserRepository;
    private final IFoundationEmployeeRepository foundationEmployeeRepository;

    public FoundationService(IFoundationRespositoy foundationRepository, ITypeMeetUsRepository typeMeetUsRepository, IContactUserRepository contactUserRepository, IFoundationEmployeeRepository foundationEmployeeRepository) {
        this.foundationRepository = foundationRepository;
        this.typeMeetUsRepository = typeMeetUsRepository;
        this.contactUserRepository = contactUserRepository;
        this.foundationEmployeeRepository = foundationEmployeeRepository;
    }


    @Override
    public Foundation saveFoundation(Foundation foundation) {
        return foundationRepository.save(foundation);
    }

    @Override
    public Foundation findFoundationByUuid(UUID uuid) {
        return foundationRepository.findById(uuid).orElse(null);
    }

    @Override
    public ContactUser saveContactUser(ContactUser contactUser) {
        return contactUserRepository.save(contactUser);
    }

    @Override
    public List<TypeMeetUs> getAllTypeMeetUs() {
        return typeMeetUsRepository.findAll();
    }
}
