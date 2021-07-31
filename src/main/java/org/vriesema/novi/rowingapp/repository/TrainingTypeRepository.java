package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingType;

public interface TrainingTypeRepository extends JpaRepository<TrainingType, Long> {

}
