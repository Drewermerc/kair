package com.amazon.ask.kair.share;

import com.amazon.ask.kair.share.translations.SpanishMXMessages;

import java.util.HashMap;
import java.util.Map;

public class FactoryHelpMessage {
    private static Map<String, String> messagesMap = new HashMap<String, String>();
    static {
        messagesMap.put(null, "");
        messagesMap.put("es-MX", SpanishMXMessages.HELP);
    }
    public static String getMessage(String language) {
        return messagesMap.get(language);
    }
}
