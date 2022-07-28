package ru.sadikov.dz.magafondz.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.sadikov.dz.magafondz.models.Users;
import ru.sadikov.dz.magafondz.security.CustomUserDetailsService;

@Component
public class UsersValidator implements Validator {
    private  final CustomUserDetailsService userDetailsService;
@Autowired
    public UsersValidator(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Users.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
    Users users = (Users) o;
        try {
            userDetailsService.loadUserByUsername(users.getEmail());
        } catch (UsernameNotFoundException ignored) {
            return; // все ок, пользователь не найден
        }

        errors.rejectValue("username", "", "Человек с таким именем пользователя уже существует");
    }

    }

