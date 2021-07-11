package org.vriesema.novi.rowingapp.service.impl;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.vriesema.novi.rowingapp.model.rowingclub.Rower;
import org.vriesema.novi.rowingapp.repository.RowerRepository;
import org.vriesema.novi.rowingapp.service.RowerService;

import java.util.List;

@Service
public class RowerServiceImpl implements RowerService {
    private RowerRepository rowerRepository;

    @Autowired
    public RowerServiceImpl(RowerRepository repository) {
        this.rowerRepository = repository;
    }

    @Override
    public List<Rower> getRowers() {
        return null;
    }
}
