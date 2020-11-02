package com.nothing.airport.airportpl.parser;

import java.util.ArrayList;
import java.util.List;

import com.nothing.airport.airportpl.flight.Arrival;
import com.nothing.airport.airportpl.flight.Departure;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WroclawParser implements Parser {

  @Override
  public List<Arrival> parserArrivals(String value) {
    
    List<Arrival> flights = new ArrayList<Arrival>();
    Elements rows = getRows(value,"table-przyloty mobile");
    for (int i = 1; i < rows.size(); i++) { 
      Element row = rows.get(i);
      Elements cols = row.select("td");
      Arrival arr = arrivalFromElements(cols);
      if(arr != null)
        flights.add(arr);
    }
    return flights;
  }

  private Arrival arrivalFromElements(Elements cols)
  {
    Arrival flight = new Arrival();
      for (int j = 0; j < cols.size(); j++) {
        String txt = cols.get(j).text();
        switch(j) {
          case 0:
            flight.time = txt;
          case 2:
            flight.direction = txt;
          case 3:
            flight.flightNumber = txt;
          case 4:
            flight.airline = txt;
          case 5:
            flight.status = txt;
        }
      }

      if(flight.time.contains(">>"))
        return null;

      return flight;
  }

  private Departure departureFromElements(Elements cols)
  {
    Departure flight = new Departure();
    for (int j = 0; j < cols.size(); j++) {
      String txt = cols.get(j).text();
      switch(j) {
        case 0:
          flight.time = txt;
        case 2:
          flight.direction = txt;
        case 3:
          flight.flightNumber = txt;
        case 4:
          flight.airline = txt;
        case 5:
          flight.status = txt;
        case 6:
          flight.checkIn = txt;
        case 7:
          flight.gate = txt;
      }
    }

    if(flight.time.contains(">>"))
      return null;

    return flight;
  }

  @Override
  public List<Departure> parserDepartures(String value) {
    
    List<Departure> flights = new ArrayList<Departure>();
    Elements rows = getRows(value, "table-odloty mobile");
    for (int i = 1; i < rows.size(); i++) {
      Element row = rows.get(i);
      Elements cols = row.select("td");
      Departure dep = departureFromElements(cols);
      if(dep != null)
        flights.add(departureFromElements(cols));
    }
    return flights;
  }

  private Elements getRows(String value, String tableName)
  {
    Document doc = Jsoup.parse(value);
    Element element = doc.getElementsByClass(tableName).get(0);
    return element.select("tr");
  }

}
