package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StationCtrl extends Controller {
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info("Station id = " + id);
        render("station.html", station);
    }

    public static void addReading(Long id, String date, int code, double temperature, double windSpeed, int windDirection, int pressure)
    {
        Reading reading = new Reading(date, code, temperature, windSpeed, windDirection, pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }
    public static void deleteReading(Long id, Long readId) {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readId);
        Logger.info ("Deleting reading " + readId);
        station.readings.remove(reading);
        station.save();
            reading.delete();
        redirect ("/stations/" + id);
    }
}
