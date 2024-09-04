package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.Role;
import org.example.quickclothdata.model.TypeDocument;
import org.example.quickclothdata.model.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    User saveUser(User user);
    User findUserByUUID(UUID uuid);
    Role saveRole(Role role);
    Role findRoleByName(String name);
    TypeDocument saveTypeDocument(TypeDocument typeDocument);
    List<TypeDocument> getAllTypeDocument();
    TypeDocument findTypeDocumentByUUID(UUID uuid);
}
