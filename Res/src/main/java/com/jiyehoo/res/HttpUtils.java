package com.jiyehoo.res;

import java.io.IOException;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * TODO feature
 *
 * @author aobing
 * @since 2022/2/26 11:27 下午
 */
public class HttpUtils {

    private static final String TAG = "###HttpUtils";

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");


    public static String post(String url, String json) throws IOException {

        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = new OkHttpClient().newCall(request).execute()) {
            if (response.body() == null) {
                MyLog.e(TAG, "[post] response.body is NULL");
            } else {
                return Objects.requireNonNull(response.body()).string();
            }
        }
        return "";
    }
}
