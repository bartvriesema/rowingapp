package org.vriesema.novi.rowingapp.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.vriesema.novi.rowingapp.model.rowingclub.HeartRate;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;
import org.vriesema.novi.rowingapp.repository.HeartrateRepository;
import org.vriesema.novi.rowingapp.repository.RowerRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RowerServiceImplTest {

    @Mock
    private RowerRepository rowerRepository;
    @Mock
    private HeartrateRepository heartrateRepository;
    @InjectMocks
    private RowerServiceImpl underTest;

    @Nested
    class WhenAddingRower {
        @Mock
        private Rower rower;

        @BeforeEach
        void setup() {
            rower = new Rower();
            rower.setPersonId(88L);
            rower.setRower(false);
            rower.setGender("male");
            rower.setFirstName("Test");
            rower.setLastName("de Tester");
            rower.setNumberOfVictoryPoints(4);
        }

        @Test
        void testAddRower() {
            when(rowerRepository.save(Mockito.any())).thenReturn(rower);

            underTest.addRower(rower);

            Assertions.assertTrue(rower.isRower());
            assertEquals("de Tester", rower.getLastName());
        }
    }

    @Nested
    class WhenAddingHeartRate {
        private final long ROWER_ID = 20;
        private List<HeartRate> heartRateList;
        @Mock
        private HeartRate heartRate;
        @Mock
        private Rower rower;

        @BeforeEach
        void setup() {
            heartRate = new HeartRate();
            heartRate.setHeartRate(53);
            heartRate.setHeartRateDate(LocalDate.parse("2021-03-14"));

            rower = new Rower();
            rower.setPersonId(ROWER_ID);
            rower.setRower(true);
            rower.setGender("male");
            rower.setFirstName("Test");
            rower.setLastName("de Tester");

            heartRateList = new ArrayList<>();
            HeartRate heartRate1 = new HeartRate();
            HeartRate heartRate2 = new HeartRate();
            HeartRate heartRate3 = new HeartRate();

            heartRate1.setHeartRate(52);
            heartRate2.setHeartRate(55);
            heartRate3.setHeartRate(52);

            heartRateList.add(heartRate1);
            heartRateList.add(heartRate2);
            heartRateList.add(heartRate3);

        }

        @Test
        void testAddHeartRate() {
            when(rowerRepository.findById(ROWER_ID)).thenReturn(Optional.of(rower));
            when(underTest.getHeartRateList(ROWER_ID)).thenReturn(heartRateList);

            underTest.addHeartRate(ROWER_ID, heartRate);

            assertEquals("Test", heartRate.getRower().getFirstName());
            assertEquals("male", heartRate.getRower().getGender());
            assertEquals(53, heartRate.getAverageHeartRate());
        }
    }

    @Nested
    class WhenGettingAverageHeartRate {
        private final long ROWER_ID = 53;
        @Mock
        private List<HeartRate> heartRateList;
        @Mock
        Rower rower;

        @BeforeEach
        void setup() {
            rower = new Rower();
            rower.setPersonId(ROWER_ID);
            rower.setRower(true);
            rower.setGender("male");
            rower.setFirstName("Test");
            rower.setLastName("de Tester");

            heartRateList = new ArrayList<>();
            HeartRate heartRate1 = new HeartRate();
            HeartRate heartRate2 = new HeartRate();
            HeartRate heartRate3 = new HeartRate();

            heartRate1.setHeartRate(48);
            heartRate2.setHeartRate(51);
            heartRate3.setHeartRate(57);

            heartRateList.add(heartRate1);
            heartRateList.add(heartRate2);
            heartRateList.add(heartRate3);

            rower.setHeartrateList(heartRateList);
        }

        @Test
        void testGetAverageHeartRate() {
            when(rowerRepository.findById(ROWER_ID)).thenReturn(Optional.of(rower));
            when(underTest.getHeartRateList(ROWER_ID)).thenReturn(heartRateList);

            long assertedAverage = underTest.getAverageHeartRate(ROWER_ID);

            assertEquals(52, assertedAverage);
        }
    }

    @Nested
    class WhenGettingRowers {
        @Test
        void testGetRowers() {
            underTest.getRowers();
            verify((rowerRepository), times(1)).findAll();
        }
    }

    @Nested
    class WhenFindingRowersByCrewId {
        private final long CREW_ID = 51;

        @Test
        void testFindRowersByCrewId() {
            underTest.findRowersByCrewId(CREW_ID);
            verify((rowerRepository), times(1)).findRowersByCrewId(CREW_ID);
        }
    }

    @Nested
    class WhenFindingRowerById {
        private final long ROWER_ID = 33;

        @Test
        void testFindRowerById() {
            underTest.findRowerById(ROWER_ID);
            verify((rowerRepository), times(1)).findById(ROWER_ID);
        }

    }

    @Nested
    class WhenGettingHeartRateList {
        private final long ROWER_ID = 48;
        @Mock
        Rower rower;

        @BeforeEach
        void setup() {
            rower = new Rower();
            rower.setPersonId(ROWER_ID);
        }

        @Test
        void testGetHeartRateList() {
            when(rowerRepository.findById(ROWER_ID)).thenReturn(Optional.of(rower));
            underTest.getHeartRateList(ROWER_ID);
            verify((heartrateRepository), times(1)).findByRower(Mockito.any(Rower.class));
        }
    }
}