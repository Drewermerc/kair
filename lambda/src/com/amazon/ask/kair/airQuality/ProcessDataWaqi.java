package com.amazon.ask.kair.airQuality;

import com.amazon.ask.kair.airQuality.proxy.Waqi;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class ProcessDataWaqi {

    private ProcessDataWaqi() {

    }

    public static ProcessDataWaqi create() {
        return new ProcessDataWaqi();
    }

    private Integer getAqi(InputStream waqiResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonMap = null;
        try {
            jsonMap = objectMapper.readTree(waqiResponse);
        }catch(IOException exception) {
            exception.printStackTrace();
        }

        String status = jsonMap.get("status").toString();

        if (status.equals("\"error\"")) {
            return -1;
        }

        JsonNode aqiData = jsonMap.get("data");
        JsonNode aqiValue = aqiData.get("aqi");

        return Integer.parseInt(aqiValue.toString());
    }

    public Integer getAqiLevel(String cityFeedValue) {
        InputStream waqiResponse = null;
        try {
            waqiResponse = Waqi.create().getCityFeed(cityFeedValue);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return this.getAqi(waqiResponse);
    }

}
