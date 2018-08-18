package com.sda.weather;

import com.sda.model.Weather;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WeatherService {
    private String finalUrl;

    public WeatherService(String url, String apiKey) {
        finalUrl = url + "?key=" + apiKey;
    }

    public Weather getCityWeather(String city) {
        Weather weather = new Weather();
        String reqUrl = finalUrl + "&q=" + city;
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(IOUtils.toString(new URL(reqUrl), Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        weather.setCity(jsonObject.getJSONObject("location").getString("name"));
        weather.setConditionText(jsonObject.getJSONObject("current").getJSONObject("condition").getString("text"));
        weather.setTemperature(jsonObject.getJSONObject("current").getDouble("temp_c"));
        weather.setFeelslikeC(jsonObject.getJSONObject("current").getDouble("feelslike_c"));
        weather.setIconUrl(jsonObject.getJSONObject("current").getJSONObject("condition").getString("icon"));
        weather.setLat(jsonObject.getJSONObject("location").getDouble("lat"));
        weather.setLon(jsonObject.getJSONObject("location").getDouble("lon"));

        String url = "http://maps.googleapis.com/maps/api/staticmap?center="+weather.getLat()+","+weather.getLon()+"&size=400x400&zoom=12";
        try {
            InputStream input = new URL(url).openStream();
            Files.deleteIfExists( Paths.get(city+".jpg"));
            Files.copy(input, Paths.get(city+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return weather;
    }


}
