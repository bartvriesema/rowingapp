package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;

import java.util.List;

public interface RowerRepository extends JpaRepository<Rower, Long> {

    List<Rower> findRowerByCrewId(long crewId);

}
