package org.vriesema.novi.rowingapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.vriesema.novi.rowingapp.payload.AuthenticationRequest;
import org.vriesema.novi.rowingapp.service.CustomUserDetailsService;
import org.vriesema.novi.rowingapp.utils.JwtUtil;

import java.security.Principal;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private CustomUserDetailsService userDetailsService;
    @Mock
    private JwtUtil jwtUtl;
    @InjectMocks
    private AuthenticationController underTest;

    @Nested
    class WhenAuthenticated {
        private MockMvc mockMvc;
        @Mock
        private Authentication authentication;
        @Mock
        private Principal principal;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        }

        @Test
        void testAuthenticated() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/authenticated").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenCreatingAuthenticationToken {
        private MockMvc mockMvc;

        @Mock
        private AuthenticationRequest authenticationRequest;

        @BeforeEach
        void setup() {
            authenticationRequest = new AuthenticationRequest();
            authenticationRequest.setPassword("TESTEN");
            authenticationRequest.setUsername("TESTER");

            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        }

        @Test
        void testCreateAuthenticationToken() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    post("/api/authenticate").
                    content(new ObjectMapper().writeValueAsString(authenticationRequest)).
                    contentType(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            verify((authenticationManager), times(1)).authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class));
            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }
    }
}