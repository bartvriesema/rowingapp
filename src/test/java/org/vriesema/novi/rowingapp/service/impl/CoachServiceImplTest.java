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
import org.vriesema.novi.rowingapp.exceptions.RecordNotFoundException;
import org.vriesema.novi.rowingapp.model.rowingclub.Coach;
import org.vriesema.novi.rowingapp.repository.CoachRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoachServiceImplTest {

    @InjectMocks
    private CoachServiceImpl underTest;
    @Mock
    private CoachRepository coachRepository;

    @Nested
    class WhenAddingCoach {
        private final long COACH_ID = 42;
        @Mock
        private Coach coach;

        @BeforeEach
        void setup() {
            coach = new Coach();
            coach.setFirstName("Test");
            coach.setLastName("Tester");
            coach.setPersonId(COACH_ID);
            coach.setClubCoach(true);

        }

        @Test
        void testAddCoach() {
            when(coachRepository.save(Mockito.any())).thenReturn(coach);
            long returnedId = underTest.addCoach(coach);
            Assertions.assertEquals(COACH_ID, returnedId);
        }
    }

    @Nested
    class WhenUpdatingCoach {
        private final long COACH_ID = 53;
        @Mock
        private Coach coach;

        @BeforeEach
        void setup() {
            coach = new Coach();
            coach.setFirstName("Test");
            coach.setLastName("Tester");
            coach.setPersonId(COACH_ID);
            coach.setClubCoach(true);
        }

        @Test
        void testUpdateCoach() {
            when(coachRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(coach));
            underTest.updateCoach(COACH_ID, coach);

            Optional<Coach> savedCoach = coachRepository.findById(COACH_ID);
            if (savedCoach.isEmpty()) {
                throw new RecordNotFoundException();
            }

            Assertions.assertNotNull(savedCoach);
            Assertions.assertEquals("Tester", savedCoach.get().getLastName());

        }

    }

    @Nested
    class WhenUpdatingFields {
        @Mock
        private Coach newCoach;
        @Mock
        private Coach currentCoach;

        @BeforeEach
        void setup() {
            newCoach = new Coach();
            newCoach.setFirstName("Geen test");

            currentCoach = new Coach();
            currentCoach.setFirstName("Test");
            currentCoach.setLastName("de Tester");
            currentCoach.setGender("female");

        }

        @Test
        void testUpdateFields() {
            newCoach = underTest.updateFields(newCoach, currentCoach);
            Assertions.assertEquals("Geen test", newCoach.getFirstName());
            Assertions.assertEquals("female", newCoach.getGender());
            Assertions.assertEquals("de Tester", newCoach.getLastName());

        }
    }

    @Nested
    class WhenGettingCoaches {
        @Test
        void testGetCoaches() {
            underTest.getCoaches();
            verify((coachRepository), times(1)).findAll();
        }

    }

    @Nested
    class WhenGettingClubCoaches {
        @BeforeEach
        void setup() {
        }

        @Test
        void testGetClubCoaches() {
            underTest.getClubCoaches();
            verify((coachRepository), times(1)).findByClubCoachTrue();
        }
    }
}