package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.ContactUser;
import org.example.quickclothdata.model.Foundation;
import org.example.quickclothdata.model.FoundationEmployee;
import org.example.quickclothdata.model.TypeMeetUs;
import org.example.quickclothdata.payload.request.FoundationRequest;
import org.example.quickclothdata.repositoty.IContactUserRepository;
import org.example.quickclothdata.repositoty.IFoundationEmployeeRepository;
import org.example.quickclothdata.repositoty.IFoundationRespositoy;
import org.example.quickclothdata.repositoty.ITypeMeetUsRepository;
import org.example.quickclothdata.service.intf.IFoundationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class FoundationService implements IFoundationService {
    private final IFoundationRespositoy foundationRepository;
    private final ITypeMeetUsRepository typeMeetUsRepository;
    private final IContactUserRepository contactUserRepository;


    public FoundationService(IFoundationRespositoy foundationRepository, ITypeMeetUsRepository typeMeetUsRepository, IContactUserRepository contactUserRepository) {
        this.foundationRepository = foundationRepository;
        this.typeMeetUsRepository = typeMeetUsRepository;
        this.contactUserRepository = contactUserRepository;
    }

    @Transactional
    @Override
    public Foundation saveFoundation(Foundation foundation) {
        contactUserRepository.save(foundation.getContactUser());
        return foundationRepository.save(foundation);
    }

    @Override
    public Foundation findFoundationByUuid(UUID uuid) {
        return foundationRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<TypeMeetUs> getAllTypeMeetUs() {
        return typeMeetUsRepository.findAll();
    }

    @Override
    public TypeMeetUs findTypeMeetUsByName(String name) {
        return typeMeetUsRepository.findByName(name);
    }

    @Override
    public List<Foundation> getAllFoundationsByClotheBank(UUID clotheBankUuid) {
        return foundationRepository.findByClotheBank(clotheBankUuid);
    }

    @Override
    public TypeMeetUs findTypeMeetUsByUuid(UUID uuid) {
        return typeMeetUsRepository.findById(uuid).orElse(null);
    }
}
