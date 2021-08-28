package org.vriesema.novi.rowingapp.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.vriesema.novi.rowingapp.model.authentication.Authority;
import org.vriesema.novi.rowingapp.model.authentication.User;
import org.vriesema.novi.rowingapp.repository.UserRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl underTest;

    @Nested
    class WhenCreatingUser {
        @Mock
        private User user;

        @BeforeEach
        void setup() {
            user = new User();
            user.setUsername("USERNAME");
            user.setEnabled(true);
        }

        @Test
        void testCreateUser() {
            when(userRepository.save(Mockito.any())).thenReturn(user);

            String assertedUserName = underTest.createUser(user);

            Assertions.assertEquals("USERNAME", assertedUserName);

        }
    }

    @Nested
    class WhenUpdatingUser {
        private final String USERNAME = "USERNAME";
        @Mock
        private User newUser;
        @Mock
        private User currentUser;

        @BeforeEach
        void setup() {
            newUser = new User();
            newUser.setEnabled(true);
            newUser.setUsername(USERNAME);
            newUser.addAuthority(new Authority(USERNAME, "TEST"));

            currentUser = new User();
            currentUser.setUsername(USERNAME);
            currentUser.setEnabled(false);
        }

        @Test
        void testUpdateUser() {
            when(userRepository.findById(USERNAME)).thenReturn(Optional.of(currentUser));
            underTest.updateUser(USERNAME, newUser);
            verify((userRepository), times(1)).save(Mockito.any());

        }
    }

    @Nested
    class WhenGettingAuthorities {
        private final String USERNAME = "USERNAME";
        @Mock
        User testUser;

        @BeforeEach
        void setup() {
            testUser = new User();
            testUser.setUsername(USERNAME);
            testUser.addAuthority(new Authority(USERNAME, "TEST"));
        }

        @Test
        void testGetAuthorities() {
            when(userRepository.findById(USERNAME)).thenReturn(Optional.of(testUser));
            Set<Authority> authoritySet = underTest.getAuthorities(USERNAME);
            Assertions.assertNotNull(authoritySet);
            Assertions.assertTrue(authoritySet.stream().anyMatch(c -> Objects.equals(c.getAuthority(), "TEST")));
        }
    }

    @Nested
    class WhenAddingAuthority {
        private final String USERNAME = "USERNAME";
        private final String AUTHORITY = "AUTHORITY";
        @Mock
        private User testUser;

        @BeforeEach
        void setup() {
            testUser = new User();
            testUser.addAuthority(new Authority(USERNAME, AUTHORITY));
            testUser.setUsername(USERNAME);
        }

        @Test
        void testAddAuthorities() {
            when(userRepository.findById(USERNAME)).thenReturn(Optional.of(testUser));
            underTest.addAuthority(USERNAME, AUTHORITY);
            verify((userRepository), times(1)).save(Mockito.any());
        }
    }

    @Nested
    class WhenRemovingAuthority {
        private final String USERNAME = "USERNAME";
        private final String AUTHORITY = "AUTHORITY";
        @Mock
        private User testUser;

        @BeforeEach
        void setup() {
            testUser = new User();
            testUser.addAuthority(new Authority(USERNAME, AUTHORITY));
            testUser.setUsername(USERNAME);
        }

        @Test
        void testRemoveAuthority() {
            when(userRepository.findById(USERNAME)).thenReturn(Optional.of(testUser));
            underTest.removeAuthority(USERNAME, AUTHORITY);
            verify((userRepository), times(1)).save(Mockito.any());
        }
    }

    @Nested
    class WhenGettingUsers {
        @BeforeEach
        void setup() {
        }

        @Test
        void testGetUsers() {
            underTest.getUsers();
            verify((userRepository), times(1)).findAll();
        }
    }

    @Nested
    class WhenGettingUser {
        private final String USERNAME = "USERNAME";

        @Test
        void testGetUser() {
            underTest.getUser(USERNAME);
            verify((userRepository), times(1)).findById(USERNAME);
        }
    }

    @Nested
    class WhenUserExists {
        private final String USERNAME = "USERNAME";

        @Test
        void testUserExits() {
            underTest.userExists(USERNAME);
            verify((userRepository), times(1)).existsById(USERNAME);
        }

    }

    @Nested
    class WhenDeletingUser {
        private final String USERNAME = "USERNAME";

        @Test
        void testDeleteUser() {
            underTest.deleteUser(USERNAME);
            verify((userRepository), times(1)).deleteById(USERNAME);
        }
    }
}