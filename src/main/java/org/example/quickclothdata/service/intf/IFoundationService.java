package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.ContactUser;
import org.example.quickclothdata.model.Foundation;
import org.example.quickclothdata.model.TypeMeetUs;

import java.util.List;
import java.util.UUID;

public interface IFoundationService {
    Foundation saveFoundation(Foundation foundation);
    Foundation findFoundationByUuid(UUID uuid);
    ContactUser saveContactUser(ContactUser contactUser);
    List<TypeMeetUs> getAllTypeMeetUs();
}
