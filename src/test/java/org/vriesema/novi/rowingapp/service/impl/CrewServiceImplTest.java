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
import org.vriesema.novi.rowingapp.exceptions.RecordNotFoundException;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;
import org.vriesema.novi.rowingapp.repository.CrewRepository;
import org.vriesema.novi.rowingapp.repository.TrainingScheduleRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CrewServiceImplTest {

    @Mock
    private CrewRepository crewRepository;
    @Mock
    private TrainingScheduleRepository trainingScheduleRepository;
    @InjectMocks
    private CrewServiceImpl underTest;

    @Nested
    class WhenAddingCrew {
        private final long CREW_ID = 42;
        private final long TRAININGSCHEDULE_ID = 37;
        @Mock
        private Crew crew;
        @Mock
        private TrainingSchedule trainingSchedule;

        @BeforeEach
        void setup() {
            crew = new Crew();
            crew.setCrewName("Test crew");
            crew.setId(CREW_ID);

            trainingSchedule = new TrainingSchedule();
            trainingSchedule.setCrew(crew);
            trainingSchedule.setTrainingScheduleId(TRAININGSCHEDULE_ID);
        }

        @Test
        void testAddCrew() {
            when(crewRepository.save(Mockito.any())).thenReturn(crew);
            when(trainingScheduleRepository.findByCrewId(CREW_ID)).thenReturn(Optional.of(trainingSchedule));
            underTest.addCrew(crew);
            Optional<TrainingSchedule> optionalTrainingSchedule = trainingScheduleRepository.findByCrewId(crew.getId());
            if (optionalTrainingSchedule.isEmpty()) {
                throw new RecordNotFoundException();
            }

            TrainingSchedule trainingSchedule = optionalTrainingSchedule.get();

            Assertions.assertEquals("Test crew", trainingSchedule.getCrew().getCrewName());
        }

    }

    @Nested
    class WhenGettingCrews {
        @Test
        void testGetCrews() {
            underTest.getCrews();
            verify((crewRepository), times(1)).findAll();
        }
    }

    @Nested
    class WhenFindingByCrewId {
        private final long CREW_ID = 10;

        @Test
        void testFindCrewById() {
            underTest.findByCrewId(CREW_ID);
            verify((crewRepository), times(1)).findById(CREW_ID);
        }
    }
}