package com.nothing.airport.airportpl.parser;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.nothing.airport.airportpl.flight.Arrival;
import com.nothing.airport.airportpl.flight.Departure;

public class KatowiceParser implements Parser {

  class KatowiceResponse {
    public List<KatowiceFlight> data;
    public Status status;

    public KatowiceResponse()
    {

    }
  }

  class KatowiceFlight {
    public int id;
    public String direction;
    public String scheduled_time;
    public String airport;
    public String airline_logo;
    public String airline_name;
    public String flight_number;
    public String status;
    public String checkin_location;
    public String checkin_time;
    public String boarding_gate;
    public String boarding_time;
    public String weather_temperature;
    public String show_notify;

    public KatowiceFlight()
    {
      
    }

    public Arrival toArrival()
    {
      Arrival arrival = new Arrival();
      arrival.id = id;
      arrival.time = scheduled_time;
      arrival.direction = airport;
      arrival.flightNumber = flight_number;
      arrival.airline = airline_name;
      arrival.status = status;
      return arrival;
    }

    public Departure toDeparture()
    {
      Departure departure = new Departure();
      departure.id = id;
      departure.time = scheduled_time;
      departure.direction = airport;
      departure.flightNumber = flight_number;
      departure.airline = airline_name;
      departure.status = status;
      departure.checkIn = checkin_location;
      departure.gate = boarding_gate;
      return departure;
    }

  }

  class Status {

    public String code;
    public String message;

    public Status()
    {
      
    }
  }

  @Override
  public List<Arrival> parserArrivals(String value) {

    KatowiceResponse response = new Gson().fromJson(value, KatowiceResponse.class);
    return response.data.stream().map(KatowiceFlight::toArrival).collect(Collectors.toList());
  }

  @Override
  public List<Departure> parserDepartures(String value) {

    KatowiceResponse response = new Gson().fromJson(value, KatowiceResponse.class);
    return response.data.stream().map(KatowiceFlight::toDeparture).collect(Collectors.toList());

  }
  
}
