package ru.sadikov.dz.magafondz.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.sadikov.dz.magafondz.Reprository.IUsersRepository;
import ru.sadikov.dz.magafondz.models.Users;
import ru.sadikov.dz.magafondz.security.CustomUserDetails;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsersRepository iUsersRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users users=iUsersRepository.findByEmail(s);
        if(users==null){
            throw new UsernameNotFoundException("user not found");
        }
        return new CustomUserDetails(users);
    }
}
