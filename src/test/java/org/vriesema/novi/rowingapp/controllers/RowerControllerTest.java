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
import org.vriesema.novi.rowingapp.controllers.dtos.HeartRateDto;
import org.vriesema.novi.rowingapp.controllers.dtos.RowerDto;
import org.vriesema.novi.rowingapp.model.rowingclub.HeartRate;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;
import org.vriesema.novi.rowingapp.service.RowerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RowerControllerTest {

    @Mock
    private RowerService rowerService;
    @InjectMocks
    private RowerController underTest;

    @Nested
    class WhenGettingRowers {
        private MockMvc mockMvc;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        }

        @Test
        void testGetRowers() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/rowers").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenGettingRowersByCrewId {
        private MockMvc mockMvc;
        private final long CREW_ID = 4;
        @Mock
        List<Rower> rowerList;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            rowerList = new ArrayList<>();
            Rower rower1 = new Rower();
            rower1.setPersonId(1L);
            rower1.setFirstName("Tester");
            rowerList.add(rower1);
            Rower rower2 = new Rower();
            rower2.setPersonId(2L);
            rower2.setFirstName("Piet");
            rowerList.add(rower2);
        }

        @Test
        void testGetRowersByCrewIdWithRowers() throws Exception {
            when(rowerService.findRowersByCrewId(CREW_ID)).thenReturn(rowerList);
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/rowers/crew/4").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }

        @Test
        void testGetRowersByCrewIdNotFound() throws Exception {
            when(rowerService.findRowersByCrewId(CREW_ID)).thenReturn(new ArrayList<>());
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/rowers/crew/4").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenAddingRower {
        private MockMvc mockMvc;
        @Mock
        private RowerDto rowerDto;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            rowerDto = new RowerDto();
            rowerDto.setRowerId(1);
            rowerDto.setFirstName("Test");
        }

        @Test
        void testAddRower() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    post("/api/users/rowers").
                    content(new ObjectMapper().writeValueAsString(rowerDto.toRower())).
                    contentType(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            verify((rowerService), times(1)).addRower(Mockito.any(Rower.class));
            Assertions.assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenGettingRowerById {
        private MockMvc mockMvc;
        private final long ROWER_ID = 3;

        @Mock
        Rower rower;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
            rower = new Rower();
            rower.setFirstName("Test");
            rower.setPersonId(3L);
        }

        @Test
        void testGetRowerByIdFound() throws Exception {
            when(rowerService.findRowerById(ROWER_ID)).thenReturn(Optional.of(rower));
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/rowers/3").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }

        @Test
        void testGetRowerByIdNotFound() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/rowers/3").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenGettingHeartrateByRowerId {
        private MockMvc mockMvc;
        private final long ROWER_ID = 79;
        @Mock
        List<HeartRate> heartRateList;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            heartRateList = new ArrayList<>();

            HeartRate heartRate1 = new HeartRate();
            heartRate1.setHeartRate(55);
            heartRate1.setHeartRateId(1L);
            heartRateList.add(heartRate1);

            HeartRate heartRate2 = new HeartRate();
            heartRate2.setHeartRateId(2L);
            heartRate2.setHeartRate(56);
            heartRateList.add(heartRate2);
        }

        @Test
        void testGetHeartRateByRowerId() throws Exception {
            when(rowerService.getHeartRateList(ROWER_ID)).thenReturn(heartRateList);
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/rowers/heartrate/79").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenAddingHeartRate {
        private MockMvc mockMvc;
        private final long ROWER_ID = 46;
        @Mock
        private HeartRateDto heartRateDto;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            heartRateDto = new HeartRateDto();
            heartRateDto.setHeartRate(55);
            heartRateDto.setHeartRateId(1L);
        }

        @Test
        void testAddHeartRate() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    post("/api/users/rowers/heartrate/46").
                    content(new ObjectMapper().writeValueAsString(heartRateDto)).
                    contentType(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }
    }
}