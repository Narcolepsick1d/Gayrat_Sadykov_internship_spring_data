package ru.sadikov.dz.magafondz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sadikov.dz.magafondz.Reprository.IUsersRepository;
import ru.sadikov.dz.magafondz.models.Users;

import java.util.Collection;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsersRepository iUsersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users= iUsersRepository.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("Email "+ username + "not found"));
        return new org.springframework.security.core.userdetails.User(users.getEmail(),users.getPassword(),
                getAuthorities(users));

    }
    public static Collection<? extends GrantedAuthority> getAuthorities(Users users){
        String[] userRoles=users.getOwnerRole().stream().map((role) ->role.getRole() ).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}
