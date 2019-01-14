package com.angrybeard.grumbler.service;

import java.util.Map;

public interface SlackResponseService {

    Map<String, Object> getInChannelResponseWithImage(String imageUrl);
}