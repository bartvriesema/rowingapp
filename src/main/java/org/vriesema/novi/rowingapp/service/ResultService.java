package org.vriesema.novi.rowingapp.service;


import org.vriesema.novi.rowingapp.model.rowingclub.Result;

public interface ResultService {
    Object getResults();

    Object getResultByCrewId(long crewId);

    void addResult(Result result);
}
