package com.amazon.ask.kair.share;

import com.amazon.ask.kair.share.translations.SpanishMXMessages;

import java.util.HashMap;
import java.util.Map;

public class FactoryCancelandStopMessage {
    private static Map<String, String> messagesMap = new HashMap<String, String>();
    static {
        messagesMap.put(null, "");
        messagesMap.put("es-MX", SpanishMXMessages.CANCEL_AND_STOP);
    }
    public static String getMessage(String language) {
        return messagesMap.get(language);
    }
}
