package ru.sadikov.dz.magafondz.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.sadikov.dz.magafondz.models.Role;
import ru.sadikov.dz.magafondz.models.Users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CustomUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private final Users users;
    public CustomUserDetails(Users users){this.users =users;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role roles = users.getRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

            authorities.add(new SimpleGrantedAuthority(roles.getRole()));

        return authorities;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    public String getFullName() {
        return users.getName() + " " + users.getSurname();
    }
}
