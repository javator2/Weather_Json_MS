package com.sda.weather;

import com.sda.model.Weather;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

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
        return weather;
    }

}
