package com.tellh.unittestpractice.okhttp;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by tlh on 2017/4/22 :)
 */
public class MockResponseHandlerTest {
    @Test
    public void canHandle() throws Exception {
        MockResponseHandler handler = new MockResponseHandler("https://baidu.com/.*");
        Assert.assertTrue(handler.canHandle("https://baidu.com/djfnafld/1212"));
    }

    @Test
    public void setJsonResponse() throws Exception {
        MockResponseHandler handler = new MockResponseHandler("https://baidu.com/.*");
        handler.setJsonResponse(new FileInputStream("C:\\Users\\tlh\\AndroidStudioProjects\\UnitTestPractice\\app\\src\\test\\java\\com\\tellh\\unittestpractice\\okhttp\\response.json"));
        MockDataInterceptor mockDataInterceptor = new MockDataInterceptor();
        MockDataInterceptor.hacking = true;
        mockDataInterceptor.addHandler(handler);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(mockDataInterceptor).build();
        String respStr = client.newCall(new Request.Builder().get().url("https://baidu.com/djfnafld/1212")
                .build())
                .execute().body().string();
        Assert.assertNotNull(respStr);
        System.out.println(respStr);
    }
}