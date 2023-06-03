package com.example.demo.service;


import com.example.demo.model.entiti.UserEntity;
import com.example.demo.model.entiti.UserRoleEntity;
import com.example.demo.model.user.MobileUserDetails;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MobileUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public MobileUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).map(this::map).orElseThrow(()
                -> new UsernameNotFoundException("User with email " + username + " not found."));
    }

    private UserDetails map (UserEntity userEntity) {
        return new MobileUserDetails(userEntity.getPassword(), userEntity.getEmail(),
                userEntity.getFirstName(),userEntity.getLastName(),userEntity.getUserRole().stream().map(this::map).toList());
    }

    private GrantedAuthority map(UserRoleEntity userRole){
        return new SimpleGrantedAuthority("ROLE_" + userRole.getUserRole().name());
    }
}
