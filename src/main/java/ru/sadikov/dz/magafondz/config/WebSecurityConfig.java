package ru.sadikov.dz.magafondz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.sadikov.dz.magafondz.Services.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("USER","ADMIN","MANAGER","MENTOR")
                .antMatchers("/userslist/users","/userslist/users/new","/userslist/users/edit/**").hasRole("ADMIN")
                .antMatchers("/employeelist","/employeelist/showNewEmployeeForm","//employeelist/showNewEmployeeForm/**").hasRole("MANAGER")
                .antMatchers("/internlist","/internlist/showNewInternForm","/internlist/showNewInternForm/**").hasRole("MENTOR")
                .anyRequest().authenticated()
                .and()

                .formLogin().permitAll().successForwardUrl("/index")
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
//        http.authorizeRequests()
//                .antMatchers("/users/**").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .usernameParameter("email")
//                .defaultSuccessUrl("/users")
//                .permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/").permitAll();
    }
}
