package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {
}