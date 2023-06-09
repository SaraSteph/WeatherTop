package models;
import javax.persistence.Entity;

import play.db.jpa.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Reading extends Model
{
    public String date;
    public int code;
    public double temperature;
    public double windSpeed;

    public int windDirection;
    public int pressure;


    public Reading(String date, int code, double temperature, double windSpeed, int windDirection, int pressure)
    {
        this.date = date;
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;

    }
    }

