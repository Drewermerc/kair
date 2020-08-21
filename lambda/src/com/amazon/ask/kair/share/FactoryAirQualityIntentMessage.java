package com.amazon.ask.kair.share;

import java.util.HashMap;
import java.util.Map;

public class FactoryAirQualityIntentMessage {
    private static Map<String, AirQualityLevel> messagesMap = new HashMap<String, AirQualityLevel>();
    static {
        messagesMap.put(null, FactoryAqiLevelMessage.create());
        messagesMap.put("es-MX", FactoryAqiLevelMessage.create());
    }
    public static String getMessage(String language, Integer aqiLevel) {
        return messagesMap.get(language).getAqiLevelMessage(aqiLevel);
    }
}
