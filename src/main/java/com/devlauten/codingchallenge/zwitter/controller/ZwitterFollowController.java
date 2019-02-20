package com.devlauten.codingchallenge.zwitter.controller;

import com.devlauten.codingchallenge.zwitter.exception.BusinessException;
import com.devlauten.codingchallenge.zwitter.service.ZwitterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow")
public class ZwitterFollowController {

    @Autowired
    private ZwitterUserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void follow(@RequestParam("by") String follower,@RequestParam("who") String followed)
            throws BusinessException {
        service.follow(follower, followed);
    }
}
