package com.angrybeard.grumbler.controller;

import com.angrybeard.grumbler.model.SlackSlashCommand;
import com.angrybeard.grumbler.service.SlackResponseService;
import com.angrybeard.grumbler.service.StatusCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class SlackController {

    private static final Logger log = LoggerFactory.getLogger(SlackController.class);

    @Autowired
    StatusCheckService statusCheckService;

    @Autowired
    SlackResponseService slackResponseService;

    @RequestMapping(
            value = "/slack", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody
    Map<String, Object> slack(@RequestBody SlackSlashCommand slackSlashCommand) throws IOException {

        return slackResponseService.getInChannelResponseStatus();
    }
}