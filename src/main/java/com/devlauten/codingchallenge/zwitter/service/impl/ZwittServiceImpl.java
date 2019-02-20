package com.devlauten.codingchallenge.zwitter.service.impl;

import com.devlauten.codingchallenge.zwitter.exception.BusinessException;
import com.devlauten.codingchallenge.zwitter.repository.ZwittRepository;
import com.devlauten.codingchallenge.zwitter.service.ZwittService;
import com.devlauten.codingchallenge.zwitter.service.ZwitterUserService;
import com.devlauten.codingchallenge.zwitter.vo.Zwitt;
import com.devlauten.codingchallenge.zwitter.vo.ZwitterUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ZwittServiceImpl implements ZwittService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZwittServiceImpl.class);

    @Autowired
    private ZwittRepository repository;

    @Autowired
    private ZwitterUserService zwitterUserService;

    @Override
    @Transactional
    public Long createZwitt(String handle, String text) throws BusinessException {
        ZwitterUser zwitter = zwitterUserService.getUser(handle); // This already throws if not found

        if (text == null || text.equals("")) {
            throw new BusinessException("The Zwitt has no message.");
        }
        if (text.length() > 140) {
            throw new BusinessException("The Zwitt message length exceeds 140 chars.");
        }

        Zwitt newZwitt = new Zwitt(zwitter, text);
        repository.save(newZwitt);

        return newZwitt.getId();
    }
}
