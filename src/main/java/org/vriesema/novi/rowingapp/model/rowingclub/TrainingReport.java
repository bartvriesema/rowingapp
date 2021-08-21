package org.vriesema.novi.rowingapp.model.rowingclub;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class TrainingReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingReportId;

    @Column(columnDefinition = "TEXT")
    private String trainingReportText;

    @Lob
    private byte[] trainingReportFile;

    @ManyToOne
    @JsonBackReference(value = "session")
    private TrainingSession trainingSession;

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

    @JsonIgnore
    public TrainingSession getTrainingSession() {
        return trainingSession;
    }

    public void setTrainingSession(TrainingSession trainingSession) {
        this.trainingSession = trainingSession;
    }
}
