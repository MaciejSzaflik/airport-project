package com.nothing.airport.airportpl.parser;

import com.nothing.airport.airportpl.Airport;

public class ParserFactory {
  public static Parser getRequester(Airport airport)
  {
    if(airport.getName().equalsIgnoreCase("wroclaw"))
      return new WroclawParser();
    return null;
  }
}
