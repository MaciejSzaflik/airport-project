package com.nothing.airport.airportpl;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import com.nothing.airport.airportpl.parser.*;

class AirportplApplicationTests {

  @Test
  void contextLoads() {
  }

  @Test
  void testWroclawParse() throws FileNotFoundException
  {
    Airport air = new Airport("Wroclaw", 
    "http://airport.wroclaw.pl/admin/admin-ajax.php?lang=en&action=odloty",
    "http://airport.wroclaw.pl/admin/admin-ajax.php?lang=en&action=przyloty");
    Parser parser = ParserFactory.getParser(air);
    AirportRequester requester = RequesterFactory.getRequester(air);

    parser.parserDepartures(requester.getDepartures(air));
    parser.parserArrivals(requester.getArrivals(air));
  }

}
