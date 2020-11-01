package com.nothing.airport.airportpl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class AirportModelAssembler implements RepresentationModelAssembler<Airport, EntityModel<Airport>> {

  @Override
  public EntityModel<Airport> toModel(Airport employee) {

    return EntityModel.of(employee, //
        linkTo(methodOn(AirportController.class).one(employee.getId())).withSelfRel(),
        linkTo(methodOn(AirportController.class).all()).withRel("airports"));
  }
}