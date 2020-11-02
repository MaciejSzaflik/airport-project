package com.nothing.airport.airportpl;

import java.util.List;
import java.util.stream.Collectors;

import com.nothing.airport.airportpl.flight.*;
import com.nothing.airport.airportpl.parser.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AirportController {

  private final AirportRepository repository;
  private final AirportModelAssembler assembler;

  AirportController(AirportRepository repository, AirportModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  // Aggregate root

  @CrossOrigin
  @GetMapping("/airports")
  CollectionModel<EntityModel<Airport>> all() {

    List<EntityModel<Airport>> airports = repository.findAll().stream().map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(airports, linkTo(methodOn(AirportController.class).all()).withSelfRel());
  }

  @PostMapping("/airports")
  Airport newAirport(@RequestBody Airport newAirport) {
    return repository.save(newAirport);
  }

  // Single item

  @CrossOrigin
  @GetMapping("/airports/{id}")
  EntityModel<Airport> one(@PathVariable Long id) {

    Airport airport = repository.findById(id) //
        .orElseThrow(() -> new AirportNotFoundException(id));

    return assembler.toModel(airport);
  }

  @CrossOrigin
  @GetMapping("/airports/departures/{id}")
  List<Departure> getDepartures(@PathVariable Long id) {
    Airport airport = repository.findById(id) //
        .orElseThrow(() -> new AirportNotFoundException(id));
    
    Parser parser = ParserFactory.getParser(airport);
    AirportRequester requester = RequesterFactory.getRequester(airport);

    return parser.parserDepartures(requester.getDepartures(airport));
  }

  @CrossOrigin
  @GetMapping("/airports/arrivals/{id}")
  List<Arrival> getArrivals(@PathVariable Long id) {
    Airport airport = repository.findById(id) //
        .orElseThrow(() -> new AirportNotFoundException(id));
    
    Parser parser = ParserFactory.getParser(airport);
    AirportRequester requester = RequesterFactory.getRequester(airport);

    return parser.parserArrivals(requester.getArrivals(airport));
  }

  @PutMapping("/airports/{id}")
  Airport replaceAirport(@RequestBody Airport newAirport, @PathVariable Long id) {

    return repository.findById(id)
      .map(airport -> {
        airport.setName(newAirport.getName());
        return repository.save(airport);
      })
      .orElseGet(() -> {
        newAirport.setId(id);
        return repository.save(newAirport);
      });
  }

  @DeleteMapping("/airports/{id}")
  void deleteAirport(@PathVariable Long id) {
    repository.deleteById(id);
  }
}