package com.faz.idb.service;

import com.faz.idb.models.Adviser;
import com.faz.idb.repositories.AdviserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdviserServiceImpl extends AbstractUserServiceImpl<Adviser> implements IAdviserService {

    public AdviserServiceImpl(AdviserRepository adviserRepository) {
        super(adviserRepository);
    }
}
