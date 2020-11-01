package com.nothing.airport.airportpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(AirportRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(
        new Airport(
          "Wroclaw", 
          "http://airport.wroclaw.pl/admin/admin-ajax.php?lang=en&action=odloty",
          "http://airport.wroclaw.pl/admin/admin-ajax.php?lang=en&action=przyloty")));
    };
  }
}