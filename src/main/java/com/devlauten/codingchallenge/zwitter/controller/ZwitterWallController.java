package com.devlauten.codingchallenge.zwitter.controller;

import com.devlauten.codingchallenge.zwitter.exception.BusinessException;
import com.devlauten.codingchallenge.zwitter.service.ZwitterUserService;
import com.devlauten.codingchallenge.zwitter.vo.Zwitt;
import com.devlauten.codingchallenge.zwitter.vo.ZwitterUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("")
public class ZwitterWallController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZwitterWallController.class);

    @Autowired
    private ZwitterUserService zwitterUserService;

    @RequestMapping(value = "/{zwitter}/wall", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Zwitt> getZwitterWall(@PathVariable("zwitter") final String zwitter) throws BusinessException {
        LOGGER.debug("Retrieving wall for zwitter user " + zwitter);

            ZwitterUser user = zwitterUserService.getUserWithZwitts(zwitter);

        List<Zwitt> zwitts = user.getZwitts();
        zwitts.sort(Comparator.comparing((Zwitt::getCreatedOn)).reversed());

        return zwitts;
    }
}
