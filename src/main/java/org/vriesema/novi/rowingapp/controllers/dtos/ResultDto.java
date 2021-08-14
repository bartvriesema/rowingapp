package org.vriesema.novi.rowingapp.controllers.dtos;

import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.model.rowingclub.Result;

import java.io.Serializable;
import java.time.LocalDate;

public class ResultDto implements Serializable {
    private long resultId;
    private LocalDate resultDate;
    private String description;
    private int distance;
    private int timeInSeconds;
    private Crew crew;

    public static ResultDto fromResult(Result result) {
        if (result == null) return null;

        ResultDto resultDto = new ResultDto();

        resultDto.resultId = result.getResultId();
        resultDto.resultDate = result.getResultDate();
        resultDto.description = result.getDescription();
        resultDto.distance = result.getDistance();
        resultDto.timeInSeconds = result.getTimeInSeconds();
        resultDto.crew = result.getCrew();

        return resultDto;
    }

    public Result toResult() {
        Result result = new Result();

        result.setResultId(resultId);
        result.setResultDate(resultDate);
        result.setDescription(description);
        result.setDistance(distance);
        result.setTimeInSeconds(timeInSeconds);
        result.setCrew(crew);

        return result;
    }

    public long getResultId() {
        return resultId;
    }

    public void setResultId(long resultId) {
        this.resultId = resultId;
    }

    public LocalDate getResultDate() {
        return resultDate;
    }

    public void setResultDate(LocalDate resultDate) {
        this.resultDate = resultDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }
}
