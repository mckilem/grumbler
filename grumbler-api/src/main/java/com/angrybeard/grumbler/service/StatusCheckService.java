package com.angrybeard.grumbler.service;

import java.io.IOException;

public interface StatusCheckService {
    int getStatusCheckResult(String urlString) throws IOException;
}
