package controllers;
import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import java.util.ArrayList;
import java.util.List;



public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = Station.findAll();
    render ("dashboard.html", stations);
  }
  public static void addStation (String name, float longitude, float latitude)
  {
    Station station = new Station (name, longitude, latitude);
    Member member = Accounts.getLoggedInMember();
    Logger.info ("Adding a new station called " + name);
    station.save();
    redirect ("/dashboard");
  }
  public static void deleteStation (Long id)
  {
    Logger.info("Deleting a Station");
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect ("/dashboard");
  }
}


