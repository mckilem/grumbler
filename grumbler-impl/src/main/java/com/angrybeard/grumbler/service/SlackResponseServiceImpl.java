package com.angrybeard.grumbler.service;

import com.angrybeard.grumbler.service.SlackResponseService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class SlackResponseServiceImpl implements SlackResponseService {

    @Override
    public Map<String, Object> getInChannelResponseStatus() {
        StatusCheckService st = new StatusCheckServiceImpl();
        int status = 0;
        try {
            status = st.getStatusCheckResult("http://178.128.138.179/ministerstvo/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> attachment = new HashMap<>();
        /*attachment.put("image_url", imageUrl);

        List<Map<String, Object>> attachments = new ArrayList<>();
        attachments.add(attachment);*/

        Map<String, Object> ret = new HashMap<>();
        ret.put("text", "it's " + status);
        ret.put("response_type", "in_channel");
        //ret.put("attachments", attachments);
        return ret;
    }
}