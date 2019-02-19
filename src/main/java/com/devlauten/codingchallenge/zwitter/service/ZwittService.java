package com.devlauten.codingchallenge.zwitter.service;

import com.devlauten.codingchallenge.zwitter.exception.BusinessException;

public interface ZwittService {

    /**
     * Creates a new Zwitt for the user with specified handle
     *
     * @param handle
     * @param text
     * @throws BusinessException
     */
    Long createZwitt(String handle, String text) throws BusinessException;
}
