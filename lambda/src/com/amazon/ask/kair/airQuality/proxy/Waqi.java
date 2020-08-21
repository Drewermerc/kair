package com.amazon.ask.kair.airQuality.proxy;

import com.amazon.ask.kair.share.Constants;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Waqi {
    private final String API_DOMAIN = "https://api.waqi.info";
    private HttpClient client = HttpClientBuilder.create().build();

    private Waqi() {
    }

    public static Waqi create() {
        return new Waqi();
    }

    public InputStream getCityFeed(String city) throws IOException {
        StringBuffer url = new StringBuffer(API_DOMAIN);
        url.append("/feed/");
        url.append(city);
        url.append("/?token=");
        url.append(Constants.WAQI_TOKEN);

        HttpGet request = new HttpGet(url.toString());
        request.addHeader("content-type", "application/json");
        request.addHeader("User-Agent", "Java - Drewermerc.AirQuality");
        HttpResponse response = client.execute(request);

        return response.getEntity().getContent();
    }
}
