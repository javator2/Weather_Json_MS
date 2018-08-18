package com.sda.model;

public class Weather {
    private String city;
    private String iconUrl;
    private double temperature;
    private double feelslikeC;
    private String conditionText;

    public Weather() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeelslikeC() {
        return feelslikeC;
    }

    public void setFeelslikeC(double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public String getConditionText() {
        return conditionText;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", temperature=" + temperature +
                ", feelslikeC=" + feelslikeC +
                ", conditionText='" + conditionText + '\'' +
                '}';
    }

    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }
}
