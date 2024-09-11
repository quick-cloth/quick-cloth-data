package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.*;
import org.example.quickclothdata.payload.request.BankEmployeeRequest;
import org.example.quickclothdata.payload.request.FoundationEmployeeRequest;
import org.example.quickclothdata.repositoty.*;
import org.example.quickclothdata.service.intf.IUserService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final ITypeDocumentRepository typeDocumentRepository;
    private final IFoundationEmployeeRepository foundationEmployeeRepository;
    private final IBankEmployeeRepository bankEmployeeRepository;

    public UserService(IUserRepository userRepository, IRoleRepository roleRepository, ITypeDocumentRepository typeDocumentRepository, IFoundationEmployeeRepository foundationEmployeeRepository, IBankEmployeeRepository bankEmployeeRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.typeDocumentRepository = typeDocumentRepository;
        this.foundationEmployeeRepository = foundationEmployeeRepository;
        this.bankEmployeeRepository = bankEmployeeRepository;
    }

    @Override
    public User saveUserClient(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByUUID(UUID uuid) {
        return userRepository.findById(uuid).orElse(null);
    }

    @Override
    public User findUserByIdentification(BigInteger identification) {
        return userRepository.findByDocument(identification);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public BankEmployee saveUserBankEmployee(BankEmployeeRequest user) {
        User userBankEmployee = userRepository.save(user.getUser());
        BankEmployee bankEmployee = BankEmployee.builder()
                .clotheBank(user.getClotheBank())
                .user(userBankEmployee)
                .build();
        return bankEmployeeRepository.save(bankEmployee);
    }

    @Override
    public FoundationEmployee saveUserFoundationEmployee(FoundationEmployeeRequest user) {
        User userBankEmployee = userRepository.save(user.getUser());
        FoundationEmployee bankEmployee = FoundationEmployee.builder()
                .foundation(user.getFoundation())
                .user(userBankEmployee)
                .build();
        return foundationEmployeeRepository.save(bankEmployee);
    }

    @Override
    public TypeDocument saveTypeDocument(TypeDocument typeDocument) {
        return typeDocumentRepository.save(typeDocument);
    }

    @Override
    public List<TypeDocument> getAllTypeDocument() {
        return typeDocumentRepository.findAll();
    }

    @Override
    public TypeDocument findTypeDocumentByUUID(UUID uuid) {
        return typeDocumentRepository.findById(uuid).orElse(null);
    }
}
