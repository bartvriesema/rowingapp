package org.vriesema.novi.rowingapp.controllers.dtos;

import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;

import java.io.Serializable;
import java.util.List;

public class TrainingScheduleDto implements Serializable {
    private Long trainingScheduleId;
    private Crew crew;
    private List<TrainingSession> trainingSessionList;

    public static TrainingScheduleDto fromTrainingSchedule(TrainingSchedule trainingSchedule) {
        if (trainingSchedule == null) return null;

        TrainingScheduleDto trainingScheduleDto = new TrainingScheduleDto();

        trainingScheduleDto.trainingScheduleId = trainingSchedule.getTrainingScheduleId();
        trainingScheduleDto.crew = trainingSchedule.getCrew();
        trainingScheduleDto.trainingSessionList = trainingSchedule.getTrainingSessions();

        return trainingScheduleDto;
    }

    public TrainingSchedule toTrainingSchedule() {
        TrainingSchedule trainingSchedule = new TrainingSchedule();

        trainingSchedule.setTrainingScheduleId(trainingScheduleId);
        trainingSchedule.setCrew(crew);
        trainingSchedule.setTrainingSessions(trainingSessionList);

        return trainingSchedule;
    }

    public Long getTrainingScheduleId() {
        return trainingScheduleId;
    }

    public void setTrainingScheduleId(Long trainingScheduleId) {
        this.trainingScheduleId = trainingScheduleId;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public List<TrainingSession> getTrainingSessionList() {
        return trainingSessionList;
    }

    public void setTrainingSessionList(List<TrainingSession> trainingSessionList) {
        this.trainingSessionList = trainingSessionList;
    }
}
