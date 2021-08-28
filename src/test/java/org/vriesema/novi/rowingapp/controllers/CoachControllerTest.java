package org.vriesema.novi.rowingapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.vriesema.novi.rowingapp.controllers.dtos.CoachDto;
import org.vriesema.novi.rowingapp.model.rowingclub.Coach;
import org.vriesema.novi.rowingapp.service.CoachService;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CoachControllerTest {

    @Mock
    private CoachService coachService;
    @InjectMocks
    private CoachController underTest;

    @Nested
    class WhenGettingCoaches {
        private MockMvc mockMvc;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        }

        @Test
        void testGetCoaches() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/coaches").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenGettingClubCoaches {
        private MockMvc mockMvc;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        }

        @Test
        void testGetClubCoaches() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/coaches/clubcoaches").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenAddingCoach {
        private long COACH_ID = 52;
        private MockMvc mockMvc;
        @Mock
        private CoachDto coachDto;

        @BeforeEach
        void setup() {
            coachDto = new CoachDto();
            coachDto.setCoachId(COACH_ID);
            coachDto.setClubCoach(true);
            coachDto.setCrewCoach(true);
            coachDto.setFirstName("Test");
            coachDto.setLastName("de Test");

            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        }

        @Test
        void testAddCoach() throws Exception {
            when(coachService.addCoach(Mockito.any(Coach.class))).thenReturn(COACH_ID);
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    post("/api/users/coaches").
                    content(new ObjectMapper().writeValueAsString(coachDto.toCoach())).
                    contentType(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());


        }
    }

    @Nested
    class WhenUpdatingCoach {
        private final long COACH_ID = 11;
        private MockMvc mockMvc;
        @Mock
        private CoachDto coachDto;

        @BeforeEach
        void setup() {
            coachDto = new CoachDto();
            coachDto.setCoachId(COACH_ID);
            coachDto.setClubCoach(true);
            coachDto.setCrewCoach(true);
            coachDto.setFirstName("Test");
            coachDto.setLastName("de Test");

            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        }

        @Test
        void testUpdateCoach() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    put("/api/users/coaches/11").
                    content(new ObjectMapper().writeValueAsString(coachDto.toCoach())).
                    contentType(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), result.getResponse().getStatus());

        }
    }
}