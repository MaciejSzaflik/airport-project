package com.nothing.airport.airportpl;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Airport {

  private @Id @GeneratedValue Long id;
  private String name;

  Airport() {}

  Airport(String name) {

    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Airport))
      return false;
    Airport airport = (Airport) o;
    return Objects.equals(this.id, airport.id) && Objects.equals(this.name, airport.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "Airport{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
  }
}