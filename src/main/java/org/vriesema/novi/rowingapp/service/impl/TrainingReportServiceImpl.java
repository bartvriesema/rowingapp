package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.vriesema.novi.rowingapp.exceptions.RecordNotFoundException;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingReport;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;
import org.vriesema.novi.rowingapp.repository.TrainingReportRepository;
import org.vriesema.novi.rowingapp.repository.TrainingSessionRepository;
import org.vriesema.novi.rowingapp.service.TrainingReportService;

import java.io.IOException;
import java.util.Optional;

@Service
public class TrainingReportServiceImpl implements TrainingReportService {
    private final TrainingReportRepository trainingReportRepository;
    private final TrainingSessionRepository trainingSessionRepository;

    @Autowired
    public TrainingReportServiceImpl(TrainingReportRepository trainingReportRepository,
                                     TrainingSessionRepository trainingSessionRepository) {
        this.trainingReportRepository = trainingReportRepository;
        this.trainingSessionRepository = trainingSessionRepository;
    }

    @Override
    public void uploadFile(Long trainingSessionId, MultipartFile file) throws IOException {
        Optional<TrainingSession> optionalTrainingSession = trainingSessionRepository.findTrainingSessionByTrainingSessionId(trainingSessionId);
        if (optionalTrainingSession.isEmpty()) {
            throw new RecordNotFoundException();
        }

        TrainingReport trainingReport = new TrainingReport();
        trainingReport.setTrainingReportFile(file.getBytes());
        trainingReport.setTrainingSession(optionalTrainingSession.get());
        trainingReportRepository.save(trainingReport);

    }

    @Override
    public byte[] getFile(Long trainingReportId) {
        Optional<TrainingReport> optionalTrainingReport = trainingReportRepository.findById(trainingReportId);
        if (optionalTrainingReport.isEmpty()) {
            throw new RecordNotFoundException();
        }

        return optionalTrainingReport.get().getTrainingReportFile();
    }
}
