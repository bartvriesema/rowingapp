package org.vriesema.novi.rowingapp.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.repository.ResultRepository;
import org.vriesema.novi.rowingapp.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService {
    private final ResultRepository resultRepository;

    @Autowired
    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public Object getResults() {
        return resultRepository.findAll();
    }
}
