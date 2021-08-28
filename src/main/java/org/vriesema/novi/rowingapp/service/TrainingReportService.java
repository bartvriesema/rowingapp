package org.vriesema.novi.rowingapp.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TrainingReportService {
    void uploadFile(Long trainingSessionId, MultipartFile file) throws IOException;

    byte[] getFile(Long trainingReportId);
}
