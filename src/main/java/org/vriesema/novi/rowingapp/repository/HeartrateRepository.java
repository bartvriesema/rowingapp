package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.Heartrate;

public interface HeartrateRepository extends JpaRepository<Heartrate, Long> {
}