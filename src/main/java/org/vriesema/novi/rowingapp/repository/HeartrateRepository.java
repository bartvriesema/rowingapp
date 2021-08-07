package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.Heartrate;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;

import java.util.List;

public interface HeartrateRepository extends JpaRepository<Heartrate, Long> {

    List<Heartrate> findByRower(Rower rower);
}