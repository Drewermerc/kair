package test.java;

import com.amazon.ask.kair.airQuality.ProcessDataWaqi;
import com.amazon.ask.kair.share.FactoryAirQualityIntentMessage;
import com.amazon.ask.kair.share.FactoryAqiLevelMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AirQualityHandlerTest {
    @Test
    public void getAqiValueWithCorrectCityFeed() {
        Integer aqiValue = ProcessDataWaqi.create().getAqiLevel("mexico");
        assertNotNull(aqiValue);
    }

    @Test
    public void getAqiValueWithWrongCityFeed() {
        Integer aqiValue = ProcessDataWaqi.create().getAqiLevel("dasda");
        assertEquals(aqiValue, -1);
    }
    @Test
    public void getMessageOfAqiLevel() {
        String aqiLevelMessage = FactoryAirQualityIntentMessage.getMessage("es-MX", 60);
        System.out.println(aqiLevelMessage);
        assertNotNull(aqiLevelMessage);
        assertEquals(aqiLevelMessage, FactoryAqiLevelMessage.create().getAqiLevelMessage(60));
    }
}
