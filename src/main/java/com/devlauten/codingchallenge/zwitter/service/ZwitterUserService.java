package com.devlauten.codingchallenge.zwitter.service;

import com.devlauten.codingchallenge.zwitter.exception.BusinessException;
import com.devlauten.codingchallenge.zwitter.vo.ZwitterUser;

public interface ZwitterUserService {

    boolean isExistingUser(String handle);

    void createUser(String handle) throws BusinessException;

    ZwitterUser getUser(String handle) throws BusinessException;

    ZwitterUser getUserWithZwitts(String handle) throws BusinessException;

    void follow(String followerHandle, String followedHandle) throws BusinessException;
}
