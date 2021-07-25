package org.vriesema.novi.rowingapp.repository;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;

public interface TrainingScheduleRepository extends JpaRepository<TrainingSchedule, Long> {

    Object findByCrewId(long crewId);
}
