package org.example.geo;

import org.example.entity.Country;
import org.example.entity.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    @Test
    public void byIpRussia() {
        GeoService geoService = new GeoServiceImpl();
        Country actual = geoService.byIp("172.").getCountry();
        Country expented = new Location(null, Country.RUSSIA, null, 0).getCountry();

        Assertions.assertEquals(actual, expented);
    }

    @Test
    public void byIpUSA() {
        GeoService geoService = new GeoServiceImpl();
        Country actual = geoService.byIp("96.").getCountry();
        Country expented = new Location(null, Country.USA, null, 0).getCountry();

        Assertions.assertEquals(actual, expented);
    }
}