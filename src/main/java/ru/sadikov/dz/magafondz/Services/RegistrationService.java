package ru.sadikov.dz.magafondz.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sadikov.dz.magafondz.Reprository.IUsersRepository;
import ru.sadikov.dz.magafondz.models.Role;
import ru.sadikov.dz.magafondz.models.Users;

@Service
public class RegistrationService {

    private final IUsersRepository iUsersRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public RegistrationService( IUsersRepository iUsersRepository, PasswordEncoder passwordEncoder) {

        this.iUsersRepository = iUsersRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    public void  register(Users users,Role role){
    users.setPassword(passwordEncoder.encode(users.getPassword()));
    role.getRole();
    iUsersRepository.save(users);
    }
}
