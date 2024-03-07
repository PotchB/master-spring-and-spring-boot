package com.devpob.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.devpob.myfirstwebapp.constants.Role;
import com.devpob.myfirstwebapp.pojo.AppUser;

@Configuration
public class SpringSecurityConfiguration {
    // Typically, when storing usernames and passwords, you'd make use of LDAP or Database
    // To keep things simple, we'll make use of InMemory configurator, for now

    // InMemoryUserDetailsManager(UserDetails... users)
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        
        AppUser user1 = new AppUser("devpob", "dummy", Role.ADMIN);
        AppUser user2 = new AppUser("in28minutes", "dummy", Role.USER);

        UserDetails userDetails1 = createNewUser(user1);
        UserDetails userDetails2 = createNewUser(user2);

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(AppUser appUser) {

        UserDetails userDetails = User.builder()
                                        .username(appUser.getUsername())
                                        .password(passwordEncoder().encode(appUser.getPassword()))
                                        .roles(appUser.getRole().toString())
                                        .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                    auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());

        // Instructor's code
        // http.csrf().disable();
        // http.headers().frameOptions().disable();

        http.csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2/**")));
        http.headers(headers -> headers.frameOptions(withDefaults()).disable());
        
        return http.build();
    }
}