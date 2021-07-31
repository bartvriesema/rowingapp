package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;

public interface CrewRepository extends JpaRepository<Crew, Long> {

}
