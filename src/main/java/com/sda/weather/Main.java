package com.sda.weather;

public class Main {
    public static void main(String[] args) {
WeatherService weatherService =new WeatherService("http://api.apixu.com/v1/current.json","c584267e006c494381b73024181808");

        System.out.println(weatherService.getCityWeather("Poznan"));

    }
}
