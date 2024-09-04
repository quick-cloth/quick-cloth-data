package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.Role;
import org.example.quickclothdata.model.TypeDocument;
import org.example.quickclothdata.model.User;
import org.example.quickclothdata.repositoty.IRoleRepository;
import org.example.quickclothdata.repositoty.ITypeDocumentRepository;
import org.example.quickclothdata.repositoty.IUserRepository;
import org.example.quickclothdata.service.intf.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final ITypeDocumentRepository typeDocumentRepository;

    public UserService(IUserRepository userRepository, IRoleRepository roleRepository, ITypeDocumentRepository typeDocumentRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.typeDocumentRepository = typeDocumentRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByUUID(UUID uuid) {
        return userRepository.findById(uuid).orElse(null);
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
