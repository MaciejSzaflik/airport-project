package com.nothing.airport.airportpl.parser;

import com.nothing.airport.airportpl.Airport;

public class RequesterFactory {
  public static AirportRequester getRequester(Airport airport)
  {
    if(airport.getName().equalsIgnoreCase("wroclaw"))
      return new SimpleHttpRequester();
    return new SimpleHttpRequester();
  }
}
