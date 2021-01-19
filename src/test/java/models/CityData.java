package models;

public class CityData {
    private String cityFrom;
    private String cityTo;

    public String getCityFrom() {
        return cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public CityData setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
        return this;
    }

    public CityData setCityTo(String cityTo) {
        this.cityTo = cityTo;
        return this;
    }


}
