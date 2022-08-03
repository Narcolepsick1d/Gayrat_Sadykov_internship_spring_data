package ru.sadikov.dz.magafondz.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sadikov.dz.magafondz.Reprository.IUsersRepository;
import ru.sadikov.dz.magafondz.Reprository.RoleRepository;
import ru.sadikov.dz.magafondz.models.Role;
import ru.sadikov.dz.magafondz.models.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private Users users;
    @Autowired
    private IUsersRepository userRepo;
    @Autowired
    RoleRepository roleRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    public void saveUserWithDefaultRole(Users users){
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        String endcodedPassword = encoder.encode(users.getPassword());
        users.setPassword(endcodedPassword);
        Role role= roleRepo.findByName("User");
        users.addRole(role);
        userRepo.save(users);
    }
    public void deleteUsers(Integer id){
        userRepo.deleteById(id);
    }
    public void registerDefaultUser(Users user) {

        Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);
        encodePassword(user);
        userRepo.save(user);
    }


    public List<Users> listAll() {
        return userRepo.findAll();
    }

    public Users get(Integer id) {
        return userRepo.findById(id).get();
    }

    public List<Role> listRoles() {
        return roleRepo.findAll();
    }

    public void save(Users user) {
        encodePassword(user);
        userRepo.save(user);
    }

    private void encodePassword(Users user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
}
