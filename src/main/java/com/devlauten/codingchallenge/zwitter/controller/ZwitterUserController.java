package com.devlauten.codingchallenge.zwitter.controller;

import com.devlauten.codingchallenge.zwitter.controller.events.ComposeZwittRequestEvent;
import com.devlauten.codingchallenge.zwitter.exception.BusinessException;
import com.devlauten.codingchallenge.zwitter.service.ZwittService;
import com.devlauten.codingchallenge.zwitter.service.ZwitterUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class ZwitterUserController {

    private static Logger LOGGER = LoggerFactory.getLogger(ZwitterUserController.class);

    @Autowired
    private ZwitterUserService zwitterService;
    @Autowired
    private ZwittService zwittService;

    @RequestMapping(value = "/{handle}/compose", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Long compose(@PathVariable("handle") final String handle, final ComposeZwittRequestEvent composedZwitt)
            throws BusinessException {

        LOGGER.debug(String.format("Composing new Tweet for user %s", handle));

        // Creates new Zwitter if not existing
        if (!zwitterService.isExistingUser(handle)) {
            zwitterService.createUser(handle);
        }

        // Creates the Zwitt
        Long zwittId = zwittService.createZwitt(handle, composedZwitt.getPayload());

        return zwittId;
    }
}
