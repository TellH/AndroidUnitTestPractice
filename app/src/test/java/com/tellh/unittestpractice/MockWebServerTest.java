package com.tellh.unittestpractice;

import java.io.IOException;

import okhttp3.mockwebserver.MockWebServer;

/**
 * Created by tlh on 2017/4/22 :)
 */

public class MockWebServerTest {
    public void testMockWebServer() throws IOException {
        MockWebServer server = new MockWebServer();
        server.start();
    }
}
