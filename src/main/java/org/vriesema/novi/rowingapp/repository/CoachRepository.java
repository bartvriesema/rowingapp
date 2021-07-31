package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.Coach;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach, Long> {

    List<Coach> findByClubCoachTrue();
}
