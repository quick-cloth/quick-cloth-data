package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.*;
import org.example.quickclothdata.payload.request.BankEmployeeRequest;
import org.example.quickclothdata.payload.request.FoundationEmployeeRequest;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public interface IUserService {
    User saveUserClient(User user);

    User findUserByUUID(UUID uuid);

    User findUserByIdentification(BigInteger identification);

    Role saveRole(Role role);

    Role findRoleByName(String name);

    BankEmployee saveUserBankEmployee(BankEmployeeRequest user);
    FoundationEmployee saveUserFoundationEmployee(FoundationEmployeeRequest user);

    TypeDocument saveTypeDocument(TypeDocument typeDocument);

    List<TypeDocument> getAllTypeDocument();

    TypeDocument findTypeDocumentByUUID(UUID uuid);
}
