package com.devlauten.codingchallenge.zwitter.controller;

import com.devlauten.codingchallenge.zwitter.exception.BusinessException;
import com.devlauten.codingchallenge.zwitter.service.ZwitterUserService;
import com.devlauten.codingchallenge.zwitter.vo.Zwitt;
import com.devlauten.codingchallenge.zwitter.vo.ZwitterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("")
public class ZwitterTimeline {

    @Autowired
    private ZwitterUserService userService;

    @GetMapping("/{user}/timeline")
    @ResponseStatus(HttpStatus.OK)
    public List<Zwitt> getTimeline(@PathVariable("user") final String user) throws BusinessException {
        Set<Zwitt> timelineSet = new LinkedHashSet<>();

        ZwitterUser currentUser = userService.getUser(user);

        for (ZwitterUser following : currentUser.getFollowing()) {
            timelineSet.addAll(following.getZwitts());
        }

        List<Zwitt> timeline = new ArrayList<>();
        timeline.addAll(timelineSet);
        timeline.sort(Comparator.comparing(Zwitt::getCreatedOn).reversed());

        return timeline;
    }
}
