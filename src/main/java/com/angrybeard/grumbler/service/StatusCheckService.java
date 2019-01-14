package com.angrybeard.grumbler.service;

import java.io.IOException;

public interface StatusCheckService {
    String getStatusCheckResult() throws IOException;
}
