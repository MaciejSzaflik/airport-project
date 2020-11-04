package com.nothing.airport.airportpl.parser;

import com.nothing.airport.airportpl.Airport;

public class ParserFactory {
  public static Parser getParser(Airport airport)
  {
    if(airport.getName().equalsIgnoreCase("wroclaw"))
      return new WroclawParser();
    if(airport.getName().equalsIgnoreCase("katowice"))
      return new KatowiceParser();
    return null;
  }
}
