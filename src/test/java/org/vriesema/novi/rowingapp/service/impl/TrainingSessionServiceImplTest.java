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
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingType;
import org.vriesema.novi.rowingapp.repository.TrainingSessionRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrainingSessionServiceImplTest {


    @Mock
    private TrainingSessionRepository trainingSessionRepository;
    @InjectMocks
    private TrainingSessionServiceImpl underTest;

    @Nested
    class WhenAddingTrainingSession {
        private final long TRAINING_SESSION_ID = 67;
        @Mock
        private TrainingSession trainingSession;

        @BeforeEach
        void setup() {
            trainingSession = new TrainingSession();

            trainingSession.setTrainingSessionId(TRAINING_SESSION_ID);
            trainingSession.setStartTime(LocalDateTime.parse("2021-07-05T12:00:00"));
            trainingSession.setEndTime(LocalDateTime.parse("2021-07-05T14:00:00"));
            trainingSession.setTrainingSchedule(new TrainingSchedule());
            trainingSession.setTrainingType(new TrainingType());
        }

        @Test
        void testAddTrainingSession() {
            when(trainingSessionRepository.save(Mockito.any())).thenReturn(trainingSession);

            long returnedId = underTest.addTrainingSession(trainingSession);

            Assertions.assertEquals(TRAINING_SESSION_ID, returnedId);

        }
    }

    @Nested
    class WhenUpdatingTrainingSession {
        private final long TRAINING_SESSION_ID = 68;
        @Mock
        private TrainingSession newTrainingSession;

        @BeforeEach
        void setup() {
            newTrainingSession = new TrainingSession();
            newTrainingSession.setTrainingSessionId(TRAINING_SESSION_ID);
            newTrainingSession.setStartTime(LocalDateTime.parse("2021-05-05T13:00:00"));
            newTrainingSession.setEndTime(LocalDateTime.parse("2021-05-05T15:00:00"));
            newTrainingSession.setTrainingSchedule(new TrainingSchedule());
            newTrainingSession.setTrainingType(new TrainingType());
            newTrainingSession.setLongDescription("Lange beschrijving");
            newTrainingSession.setShortDescription("Kort");

        }

        @Test
        void testUpdateTrainingSession() {
            when(trainingSessionRepository.findTrainingSessionByTrainingSessionId(Mockito.anyLong())).thenReturn(Optional.of(newTrainingSession));
            underTest.updateTrainingSession(TRAINING_SESSION_ID, newTrainingSession);

            Optional<TrainingSession> savedTrainingSession = trainingSessionRepository.findTrainingSessionByTrainingSessionId(TRAINING_SESSION_ID);
            if (savedTrainingSession.isEmpty()) {
                throw new RecordNotFoundException();
            }

            Assertions.assertNotNull(savedTrainingSession);
            Assertions.assertNotNull(savedTrainingSession.get().getTrainingSchedule());
            Assertions.assertEquals("Lange beschrijving", savedTrainingSession.get().getLongDescription());

        }
    }

    @Nested
    class WhenUpdatingFields {
        @Mock
        private TrainingSession newTrainingSession;
        @Mock
        private TrainingSession currentTrainingSession;

        @BeforeEach
        void setup() {
            newTrainingSession = new TrainingSession();
            newTrainingSession.setLongDescription("Veel langere beschrijving");
            currentTrainingSession = new TrainingSession();
            currentTrainingSession.setLongDescription("Huidige lange beschrijving");
            currentTrainingSession.setShortDescription("Korte beschrijving van nu");

        }

        @Test
        void testUpdateFields() {
            newTrainingSession = underTest.updateFields(newTrainingSession, currentTrainingSession);
            Assertions.assertEquals("Korte beschrijving van nu", newTrainingSession.getShortDescription());
            Assertions.assertEquals("Veel langere beschrijving", newTrainingSession.getLongDescription());

        }
    }
}