package com.nothing.airport.airportpl;

class AirportNotFoundException extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 6410889944355776077L;

  AirportNotFoundException(Long id) {
    super("Could not find airport " + id);
  }
}