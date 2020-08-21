/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at
         http://aws.amazon.com/apache2.0/
     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.amazon.ask.kair.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.IntentRequestHandler;
import com.amazon.ask.kair.airQuality.ProcessDataWaqi;
import com.amazon.ask.kair.share.Constants;
import com.amazon.ask.kair.share.FactoryAirQualityIntentMessage;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.RequestHelper;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class AirQualityIntentHandlerMx implements IntentRequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput, IntentRequest intentRequest) {
        return handlerInput.matches(intentName("AirQualityIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput, IntentRequest intentRequest) {
        String localeDevice = handlerInput.getRequestEnvelope().getRequest().getLocale();
        RequestHelper requestHelper = RequestHelper.forHandlerInput(handlerInput);
        Optional<String> cityFeed = requestHelper.getSlotValue("city");
        String cityFeedValue = cityFeed.map(city -> city)
                .orElse("City Not found");
        int aqiLevel = ProcessDataWaqi.create().getAqiLevel(cityFeedValue);
        String speechText = FactoryAirQualityIntentMessage.getMessage(localeDevice, aqiLevel);


        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard(Constants.CARD_TITLE, speechText)
                .withReprompt(Constants.CARD_TITLE)
                .build();
    }
}
