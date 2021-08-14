package org.vriesema.novi.rowingapp.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.model.rowingclub.Result;
import org.vriesema.novi.rowingapp.repository.ResultRepository;
import org.vriesema.novi.rowingapp.service.ResultService;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    private final ResultRepository resultRepository;

    @Autowired
    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<Result> getResults() {
        return resultRepository.findAll();
    }

    @Override
    public List<Result> getResultsByCrewId(long crewId) {
        return resultRepository.findResultByCrew_Id(crewId);
    }

    @Override
    public void addResult(Result result) {
        resultRepository.save(result);
    }
}
