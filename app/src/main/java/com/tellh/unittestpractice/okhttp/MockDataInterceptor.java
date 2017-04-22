package com.tellh.unittestpractice.okhttp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by tlh on 2017/4/22 :)
 */

public class MockDataInterceptor implements Interceptor {
    public static boolean hacking = false;
    private List<MockResponseHandler> handlers = new ArrayList<>();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = null;
        if (/*BuildConfig.DEBUG &&*/ hacking) {
            String path = chain.request().url().toString();
            for (MockResponseHandler handler : handlers) {
                if (!handler.canHandle(path)) continue;
                response = handler.build(chain.request());
                break;
            }
        }
        if (response == null)
            response = chain.proceed(chain.request());
        return response;
    }

    public void addHandler(MockResponseHandler handler) {
        handlers.add(handler);
    }

}
