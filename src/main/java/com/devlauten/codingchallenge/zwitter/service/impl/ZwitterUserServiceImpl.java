package com.devlauten.codingchallenge.zwitter.service.impl;

import com.devlauten.codingchallenge.zwitter.exception.BusinessException;
import com.devlauten.codingchallenge.zwitter.repository.ZwitterUserRepository;
import com.devlauten.codingchallenge.zwitter.service.ZwitterUserService;
import com.devlauten.codingchallenge.zwitter.vo.ZwitterUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ZwitterUserServiceImpl implements ZwitterUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZwitterUserServiceImpl.class);

    @Autowired
    private ZwitterUserRepository repository;

    @Override
    public boolean isExistingUser(String handle) {
        Optional<ZwitterUser> result = repository.findByHandle(handle);

        return result.isPresent();
    }

    @Override
    public void createUser(String handle) throws BusinessException {
        if (this.isExistingUser(handle)) {
            throw new BusinessException(String.format("Zwitter user %s already exists!", handle));
        }

        ZwitterUser newUser = new ZwitterUser();
        newUser.setHandle(handle);

        repository.save(newUser);
    }

    @Override
    public ZwitterUser getUser(String handle) throws BusinessException {
        Optional<ZwitterUser> result = repository.findByHandle(handle);

        if (!result.isPresent()) {
            throw new BusinessException(String.format("Zwitter user %s doesn't exist!", handle));
        }
        return result.get();
    }
}
