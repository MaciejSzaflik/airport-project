package com.nothing.airport.airportpl.parser;

import com.nothing.airport.airportpl.Airport;

public interface AirportRequester {
  public String getDepartures(Airport airport);
  public String getArrivals(Airport airport);
}
