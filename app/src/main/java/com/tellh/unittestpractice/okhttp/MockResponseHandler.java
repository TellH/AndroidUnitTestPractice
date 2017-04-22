package com.tellh.unittestpractice.okhttp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by tlh on 2017/4/22 :)
 */

public class MockResponseHandler {
    private final String url;
    private final Pattern pattern;
    private Response.Builder responseBuilder;

    public MockResponseHandler(String url) {
        this.url = url;
        pattern = Pattern.compile(url);
        responseBuilder = new Response.Builder();
    }

    public void setResponseBuilder(Response.Builder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }

    public void setJsonResponse(InputStream is) throws Exception {
        String msg = convertStreamToString(is);
        responseBuilder = new Response.Builder()
                .code(200)
                .message(msg)
                .protocol(Protocol.HTTP_1_1)
                .body(ResponseBody.create(MediaType.parse("application/json"), msg.getBytes()))
                .addHeader("content-type", "application/json");
    }

    public Response build(Request request) {
        return responseBuilder.request(request).build();
    }

    public boolean canHandle(String url_) {
        return responseBuilder != null && pattern.matcher(url_).matches();
    }

//    public static String getStringFromFile(Context context, String filePath) throws Exception {
//        final InputStream stream = context.getResources().getAssets().open(filePath);
//        String ret = convertStreamToString(stream);
//        stream.close();
//        return ret;
//    }

    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }
}
