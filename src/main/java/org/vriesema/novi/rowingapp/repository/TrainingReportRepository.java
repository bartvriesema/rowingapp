package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingReport;

public interface TrainingReportRepository extends JpaRepository<TrainingReport, Long> {


}
