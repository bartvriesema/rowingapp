package org.vriesema.novi.rowingapp.controllers.dtos;

import org.vriesema.novi.rowingapp.model.rowingclub.TrainingReport;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;

import java.io.Serializable;

public class TrainingReportDto implements Serializable {
    private Long trainingReportId;
    private String trainingReportText;
    private byte[] trainingReportFile;
    private TrainingSession trainingSession;

    private static TrainingReportDto fromTrainingReport(TrainingReport trainingReport) {
        if (trainingReport == null) return null;

        TrainingReportDto trainingReportDto = new TrainingReportDto();

        trainingReportDto.trainingReportId = trainingReport.getTrainingReportId();
        trainingReportDto.trainingReportText = trainingReport.getTrainingReportText();
        trainingReportDto.trainingReportFile = trainingReport.getTrainingReportFile();
        trainingReportDto.trainingSession = trainingReport.getTrainingSession();

        return trainingReportDto;

    }

    public TrainingReport toTrainingReport() {
        TrainingReport trainingReport = new TrainingReport();

        trainingReport.setTrainingReportId(trainingReportId);
        trainingReport.setTrainingReportText(trainingReportText);
        trainingReport.setTrainingReportFile(trainingReportFile);
        trainingReport.setTrainingSession(trainingSession);

        return trainingReport;
    }

    public Long getTrainingReportId() {
        return trainingReportId;
    }

    public void setTrainingReportId(Long trainingReportId) {
        this.trainingReportId = trainingReportId;
    }

    public String getTrainingReportText() {
        return trainingReportText;
    }

    public void setTrainingReportText(String trainingReportText) {
        this.trainingReportText = trainingReportText;
    }

    public byte[] getTrainingReportFile() {
        return trainingReportFile;
    }

    public void setTrainingReportFile(byte[] trainingReportFile) {
        this.trainingReportFile = trainingReportFile;
    }

    public TrainingSession getTrainingSession() {
        return trainingSession;
    }

    public void setTrainingSession(TrainingSession trainingSession) {
        this.trainingSession = trainingSession;
    }
}
