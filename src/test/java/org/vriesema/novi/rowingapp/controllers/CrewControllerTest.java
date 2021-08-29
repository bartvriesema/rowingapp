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
import org.vriesema.novi.rowingapp.controllers.dtos.CrewDto;
import org.vriesema.novi.rowingapp.controllers.dtos.ResultDto;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.model.rowingclub.Result;
import org.vriesema.novi.rowingapp.service.CrewService;
import org.vriesema.novi.rowingapp.service.ResultService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CrewControllerTest {

    @Mock
    private CrewService crewService;
    @Mock
    private ResultService resultService;
    @InjectMocks
    private CrewController underTest;

    @Nested
    class WhenGettingCrews {
        private MockMvc mockMvc;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        }

        @Test
        void testGetCrews() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/crews").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenGettingCrewById {
        private final long CREW_ID = 30;
        private MockMvc mockMvc;
        @Mock
        Crew crew;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            crew = new Crew();
            crew.setId(CREW_ID);
            crew.setCrewName("Test crew");
        }

        @Test
        void testGetCrewById() throws Exception {
            when(crewService.findByCrewId(CREW_ID)).thenReturn(Optional.of(crew));
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/crews/30").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

        }

    }

    @Nested
    class WhenAddingCrew {
        private MockMvc mockMvc;

        @Mock
        private CrewDto crewDto;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            crewDto = new CrewDto();
            crewDto.setCrewName("Test crew");
        }

        @Test
        void testAddCrew() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    post("/api/users/crews").
                    content(new ObjectMapper().writeValueAsString(crewDto.toCrew())).
                    contentType(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            verify((crewService), times(1)).addCrew(Mockito.any(Crew.class));
            Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenGettingResults {
        private MockMvc mockMvc;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        }

        @Test
        void testGetResults() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/crews/results").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenAddingResult {
        private MockMvc mockMvc;
        @Mock
        private ResultDto resultDto;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            resultDto = new ResultDto();
            resultDto.setResultId(42);
            resultDto.setDescription("Test omschrijving");
        }

        @Test
        void testAddResult() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    post("/api/users/crews/results").
                    content(new ObjectMapper().writeValueAsString(resultDto.toResult())).
                    contentType(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), result.getResponse().getStatus());
        }
    }

    @Nested
    class WhenGettingResultByCrewId {
        private final long CREW_ID = 8;
        private MockMvc mockMvc;
        @Mock
        List<Result> resultList;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

            resultList = new ArrayList<>();
            Result result1 = new Result();
            result1.setResultId(1L);
            result1.setDescription("Eerste resultaat");
            resultList.add(result1);

            Result result2 = new Result();
            result2.setResultId(2L);
            result2.setDescription("Tweede resultaat");
            resultList.add(result2);
        }

        @Test
        void testGetResultsByCrewIdEmptyResults() throws Exception {
            when(resultService.getResultsByCrewId(CREW_ID)).thenReturn(new ArrayList<>());
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/crews/results/8").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
        }

        @Test
        void testGetResultsByCrewIdWithResults() throws Exception {
            when(resultService.getResultsByCrewId(CREW_ID)).thenReturn(resultList);
            RequestBuilder requestBuilder = MockMvcRequestBuilders.
                    get("/api/users/crews/results/8").
                    accept(MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

        }
    }
}