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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.vriesema.novi.rowingapp.controllers.dtos.TrainingScheduleDto;
import org.vriesema.novi.rowingapp.controllers.dtos.TrainingSessionDto;
import org.vriesema.novi.rowingapp.controllers.dtos.TrainingTypeDto;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingType;
import org.vriesema.novi.rowingapp.service.TrainingScheduleService;
import org.vriesema.novi.rowingapp.service.TrainingSessionService;
import org.vriesema.novi.rowingapp.service.TrainingTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrainingControllerTest {

    @Mock
    private TrainingScheduleService trainingScheduleService;
    @Mock
    private TrainingTypeService trainingTypeService;
    @Mock
    private TrainingSessionService trainingSessionService;
    @InjectMocks
    private TrainingController underTest;

    @Nested
    class WhenGettingTrainingSchedules {
        private MockMvc mockMvc;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        }

        @Test
        void testGetTrainingSchedules() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/training").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenAddingTrainingSchedule {
        private MockMvc mockMvc;
        @Mock
        private TrainingScheduleDto trainingScheduleDto;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            trainingScheduleDto = new TrainingScheduleDto();
            trainingScheduleDto.setTrainingScheduleId(1L);
        }

        @Test
        void testAddTrainingSchedule() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    post("/api/users/training").
                    content(new ObjectMapper().writeValueAsString(trainingScheduleDto.toTrainingSchedule())).
                    contentType(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            verify((trainingScheduleService), times(1)).addTrainingSchedule(Mockito.any(TrainingSchedule.class));
            Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), result.getResponse().getStatus());

        }
    }

    @Nested
    class WhenGettingTrainingScheduleByCrewId {
        private MockMvc mockMvc;
        private final long CREW_ID = 64;
        @Mock
        TrainingSchedule trainingSchedule;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
            trainingSchedule = new TrainingSchedule();
            trainingSchedule.setTrainingScheduleId(1L);
        }

        @Test
        void testGetTrainingScheduleByCrewIdNotFound() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/training/64").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());

        }

        @Test
        void testGetTrainingScheduleByCrewIdFound() throws Exception {
            when(trainingScheduleService.getTrainingScheduleByCrewId(CREW_ID)).thenReturn(Optional.of(trainingSchedule));
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/training/64").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

        }
    }

    @Nested
    class WhenGettingTrainingTypes {
        private MockMvc mockMvc;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        }

        @Test
        void testGetTrainingTypes() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/training/types").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

        }
    }

    @Nested
    class WhenAddingTrainingType {
        private MockMvc mockMvc;
        @Mock
        private TrainingTypeDto trainingTypeDto;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            trainingTypeDto = new TrainingTypeDto();
            trainingTypeDto.setTrainingTypeId(1L);
        }

        @Test
        void testAddTrainingType() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    post("/api/users/training/types").
                    content(new ObjectMapper().writeValueAsString(trainingTypeDto.toTrainingType())).
                    contentType(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            verify((trainingTypeService), times(1)).addTrainingType(Mockito.any(TrainingType.class));
            Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), result.getResponse().getStatus());

        }
    }

    @Nested
    class WhenGettingTrainingSessions {
        private MockMvc mockMvc;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        }

        @Test
        void testGetTrainingSessions() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/training/sessions").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

        }
    }

    @Nested
    class WhenGettingTrainingSessionsByCrewId {
        private MockMvc mockMvc;
        private long CREW_ID = 21;

        @Mock
        List<TrainingSession> trainingSessionList;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
            trainingSessionList = new ArrayList<>();
            TrainingSession trainingSession1 = new TrainingSession();
            trainingSession1.setTrainingSessionId(1L);
            trainingSession1.setShortDescription("Korte tekst");
            TrainingSession trainingSession2 = new TrainingSession();
            trainingSession2.setTrainingSessionId(2L);
            trainingSession2.setShortDescription("Korte tekst");
            trainingSessionList.add(trainingSession1);
            trainingSessionList.add(trainingSession2);

        }

        @Test
        void testGetTrainingSessionsByCrewId() throws Exception {
            when(trainingSessionService.getTrainingSessionsByCrewId(CREW_ID)).thenReturn(trainingSessionList);
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/training/sessions/crew/21").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

        }
    }

    @Nested
    class WhenGettingTrainingSessionById {
        private MockMvc mockMvc;
        private long TRAINING_SESSION_ID = 23;

        @Mock
        TrainingSession trainingSession;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
            trainingSession = new TrainingSession();
            trainingSession.setTrainingSessionId(1L);
            trainingSession.setShortDescription("Korte tekst");
        }

        @Test
        void testGetTrainingSessionsByIdFound() throws Exception {
            when(trainingSessionService.getTrainingSessionById(TRAINING_SESSION_ID)).thenReturn(Optional.of(trainingSession));
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/training/sessions/23").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

        }

        @Test
        void testGetTrainingSessionsByIdNotFound() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/training/sessions/23").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());

        }
    }

    @Nested
    class WhenAddingTrainingSession {
        private MockMvc mockMvc;
        @Mock
        private TrainingSessionDto trainingSessionDto;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            trainingSessionDto = new TrainingSessionDto();
            trainingSessionDto.setTrainingSessionId(1);
            trainingSessionDto.setShortDescription("Korte tekst");
        }

        @Test
        void testAddTrainingSession() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    post("/api/users/training/sessions").
                    content(new ObjectMapper().writeValueAsString(trainingSessionDto.toTrainingSession())).
                    contentType(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            verify((trainingSessionService), times(1)).addTrainingSession(Mockito.any(TrainingSession.class));
            Assertions.assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());

        }
    }

    @Nested
    class WhenUpdatingTrainingSession {
        private long TRAINING_SESSION_ID = 27;
        private MockMvc mockMvc;
        @Mock
        private TrainingSessionDto trainingSessionDto;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            trainingSessionDto = new TrainingSessionDto();
            trainingSessionDto.setTrainingSessionId(1);
            trainingSessionDto.setShortDescription("Korte tekst");
        }

        @Test
        void testUpdateTrainingSession() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    put("/api/users/training/sessions/27").
                    content(new ObjectMapper().writeValueAsString(trainingSessionDto.toTrainingSession())).
                    contentType(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            verify((trainingSessionService), times(1)).updateTrainingSession(Mockito.anyLong(), Mockito.any(TrainingSession.class));
            Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), result.getResponse().getStatus());

        }
    }
}