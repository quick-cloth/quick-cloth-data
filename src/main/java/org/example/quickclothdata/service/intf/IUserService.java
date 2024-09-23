package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.*;
import org.example.quickclothdata.payload.request.BankEmployeeRequest;
import org.example.quickclothdata.payload.request.FoundationEmployeeRequest;
import org.example.quickclothdata.payload.request.WardrobeEmployeeRequest;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public interface IUserService {
    User saveUserClient(User user);
    User findUserByUUID(UUID uuid);
    User findUserByIdentification(BigInteger identification);
    User findUserByUserName(String userName);
    User findUserbyEmail(String email);
    User findUserByPhoneNumber(BigInteger phoneNumber);
    List<User> findUsersByRole(String roleName);
    Role saveRole(Role role);
    Role findRoleByName(String name);
    BankEmployee saveUserBankEmployee(BankEmployeeRequest user);
    FoundationEmployee saveUserFoundationEmployee(FoundationEmployeeRequest user);
    WardRobeEmployee saveUserWardropeEmployee(WardrobeEmployeeRequest user);
    TypeDocument saveTypeDocument(TypeDocument typeDocument);
    List<TypeDocument> getAllTypeDocument();
    TypeDocument findTypeDocumentByUUID(UUID uuid);
    WardRobeEmployee findWarRobeEmployeeByUsername(String username);
    BankEmployee findBankEmployeeByUsername(String username);
}
