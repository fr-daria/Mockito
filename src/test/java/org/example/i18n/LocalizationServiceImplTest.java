package org.example.i18n;

import org.example.entity.Country;
import org.example.geo.GeoService;
import org.example.geo.GeoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void localeRussia() {
        LocalizationServiceImpl locS= new LocalizationServiceImpl();
        String actual = locS.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";
    }

    @Test
    void localUSA() {
        LocalizationServiceImpl locS= new LocalizationServiceImpl();
        String actual = locS.locale(Country.USA);
        String expected = "Welcome";
    }
}