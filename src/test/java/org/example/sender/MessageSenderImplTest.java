package org.example.sender;

import org.example.entity.Country;
import org.example.entity.Location;
import org.example.geo.GeoService;
import org.example.i18n.LocalizationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {
    GeoService geoService;
    LocalizationService localizationService;
    MessageSender messageSender;
    Map<String, String> headers;

    @BeforeEach
    public void init(){
        geoService = Mockito.mock(GeoService.class);
        localizationService = Mockito.mock(LocalizationService.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
        headers = new HashMap<String, String>();
    }

    @Test
    void sendRussia(){
        Mockito.when(geoService.byIp("172. "))
                .thenReturn(new Location(null, Country.RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");
        
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172. ");
        
        String actual  = messageSender.send(headers);
        String expected = localizationService.locale(Country.RUSSIA);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void sendUSA(){
        Mockito.when(geoService.byIp("96. "))
                .thenReturn(new Location(null, Country.USA, null, 0));
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96. ");

        String actual  = messageSender.send(headers);
        String expected = localizationService.locale(Country.USA);

        Assertions.assertEquals(actual, expected);
    }
}