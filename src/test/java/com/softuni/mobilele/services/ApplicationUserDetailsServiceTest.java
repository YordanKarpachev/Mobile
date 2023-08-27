package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.domain.entities.UserRoleEntity;
import com.softuni.mobilele.domain.enums.UserRoleEnum;
import com.softuni.mobilele.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opentest4j.AssertionFailedError;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserDetailsServiceTest {

    private final String EXISTING_EMAIL = "admin@example.de";
    private final String NOT_EXISTING_EMAIL = "peter@example.de";
    private ApplicationUserDetailsService toTest;

    @Mock
    UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        toTest = new ApplicationUserDetailsService(mockUserRepository);
    }


    @Test
    void testUserFound() {
        UserRoleEntity testAdminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
        UserRoleEntity testUserRole = new UserRoleEntity().setRole(UserRoleEnum.USER);

        UserEntity testUserEntity = new UserEntity();
        testUserEntity.setEmail(EXISTING_EMAIL);
        testUserEntity.setPassword("topsecret");
        testUserEntity.setRoles(List.of(testUserRole, testAdminRole));

        when(mockUserRepository.findByEmail(EXISTING_EMAIL))
                .thenReturn(Optional.of(testUserEntity));

        UserDetails adminDetails = toTest.loadUserByUsername(EXISTING_EMAIL);
        Assertions.assertNotNull(adminDetails);
        Assertions.assertEquals(EXISTING_EMAIL, adminDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getPassword(), adminDetails.getPassword());
        Assertions.assertEquals(2, adminDetails.getAuthorities().size());
        assertRole(adminDetails.getAuthorities(),  "ROLE_ADMIN");
        assertRole(adminDetails.getAuthorities(),  "ROLE_USER");
    }

    private  void assertRole(Collection<? extends GrantedAuthority> grantedAuthorities, String role){
        grantedAuthorities
                .stream()
                .filter(a -> role.equals(a.getAuthority()))
                .findAny().orElseThrow(() -> new AssertionFailedError("Role " + role + "not found"));
    }

    @Test
    void testUserNotFound(){
        assertThrows(UsernameNotFoundException.class, () -> {
            toTest.loadUserByUsername(NOT_EXISTING_EMAIL);
        });
    }

}