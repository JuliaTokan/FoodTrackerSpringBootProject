package ua.external.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.external.spring.entity.UserRole;
import ua.external.spring.repository.UserRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    public Optional<UserRole> findUserRoleById(Long id){
        return userRoleRepository.findById(id);
    }

    public List<UserRole> findAllUserRoles(){
        return userRoleRepository.findAll();
    }

    public Optional<UserRole> findUserRoleByName(String role){
        return userRoleRepository.findByName(role);
    }

    public boolean create(UserRole role){
        userRoleRepository.save(role);
        return true;
    }
}
