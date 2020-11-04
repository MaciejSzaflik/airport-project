package com.nothing.airport.airportpl;

import org.junit.jupiter.api.Test;

import com.nothing.airport.airportpl.parser.*;
class AirportplApplicationTests {

  @Test
  void contextLoads() {
  }

  @Test
  void testWroclawParse() {
    Airport air = new Airport("Wroclaw", 
    "http://airport.wroclaw.pl/admin/admin-ajax.php?lang=en&action=odloty",
    "http://airport.wroclaw.pl/admin/admin-ajax.php?lang=en&action=przyloty");
    Parser parser = ParserFactory.getParser(air);
    AirportRequester requester = RequesterFactory.getRequester(air);

    parser.parserDepartures(requester.getDepartures(air));
    parser.parserArrivals(requester.getArrivals(air));
  }

  @Test
  void testKatowiceParse(){
    Airport air = new Airport(
      "Katowice", 
      "https://www.katowice-airport.com/en/api/flight-board/list?direction=1",
      "https://www.katowice-airport.com/en/api/flight-board/list?direction=2"
    );
    Parser parser = ParserFactory.getParser(air);
    AirportRequester requester = RequesterFactory.getRequester(air);

    parser.parserArrivals(requester.getArrivals(air));
    parser.parserDepartures(requester.getDepartures(air));
  }

}
