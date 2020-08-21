package com.amazon.ask.kair.share;

import com.amazon.ask.kair.share.translations.SpanishMXMessages;

import java.util.*;
import java.util.function.Function;

public class FactoryAqiLevelMessage implements AirQualityLevel {
    private static Map<Function<Integer, Boolean>, String> messagesMap = new HashMap<Function<Integer, Boolean>, String>();
    static {
        messagesMap.put(
                level-> { return level >= 0 && level <= 50 ? true : false; },
                SpanishMXMessages.AQI_LEVEL_GOOD
        );
        messagesMap.put(
                level -> { return level >= 51 && level <= 100 ? true : false; },
                SpanishMXMessages.AQI_LEVEL_MODERATE);
        messagesMap.put(
                level -> { return level >= 101 && level <= 150 ? true : false; },
                SpanishMXMessages.AQI_LEVEL_UNHEALTHY_SENSITIVE_GROUPS);
        messagesMap.put(
                level -> { return level >= 151 && level <= 200 ? true : false; },
                SpanishMXMessages.AQI_LEVEL_UNHEALTHY);
        messagesMap.put(
                level -> { return level >= 200 && level <= 300 ? true : false; },
                SpanishMXMessages.AQI_LEVEL_VERY_UNHEALTHY);
        messagesMap.put(
                level -> { return level >= 300 && level <= 500 ? true : false; },
                SpanishMXMessages.AQI_LEVEL_HAZARDOUS);
        messagesMap.put(
                level -> { return level < 0 ? true : false; },
                SpanishMXMessages.AQI_LEVEL_DEFAULT);
    }
    public static FactoryAqiLevelMessage create() {
        return new FactoryAqiLevelMessage();
    }
    @Override
    public String getAqiLevelMessage(Integer aqiLevel) {
        for (Map.Entry<Function<Integer, Boolean>, String> message : messagesMap.entrySet()) {
            if (message.getKey().apply(aqiLevel)) {
                return String.format(message.getValue(), aqiLevel.toString());
            }
        }

        return SpanishMXMessages.AQI_LEVEL_DEFAULT;
    }
}
