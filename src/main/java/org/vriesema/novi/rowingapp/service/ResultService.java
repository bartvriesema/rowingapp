package org.vriesema.novi.rowingapp.service;


import org.vriesema.novi.rowingapp.model.rowingclub.Result;

import java.util.List;

public interface ResultService {
    List<Result> getResults();

    List<Result> getResultsByCrewId(long crewId);

    void addResult(Result result);
}
