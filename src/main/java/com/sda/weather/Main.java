package com.sda.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json", "c584267e006c494381b73024181808");

        System.out.println(weatherService.getCityWeather("Gdynia"));
        System.out.println(weatherService.getCityWeather("Chicago"));
        System.out.println(weatherService.getCityWeather("Tokyo"));
        System.out.println(weatherService.getCityWeather("Tokio"));
        System.out.println(weatherService.getCityWeather("Trojany"));


    }
}
