package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.Result;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findResultByCrew_Id(long crewId);
}