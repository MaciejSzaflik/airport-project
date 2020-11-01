package com.nothing.airport.airportpl.parser;

import java.util.List;

import com.nothing.airport.airportpl.flight.Arrival;
import com.nothing.airport.airportpl.flight.Departure;

public interface Parser {
  public List<Arrival> parserArrivals(String value);
  public List<Departure> parserDepartures(String value);
}
