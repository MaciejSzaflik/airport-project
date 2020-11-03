package com.nothing.airport.airportpl;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Airport {

  private @Id @GeneratedValue Long id;
  private String name;
  private String departuresUrl;
  private String arrivalsUrl;
  private String departuresUrlApi;
  private String arrivalsUrlApi;

  Airport() {}

  Airport(String name, String departuresUrl, String arrivalsUrl) {

    this.name = name;
    this.departuresUrl = departuresUrl;
    this.arrivalsUrl = arrivalsUrl;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
  
  public String getDeparturesUrl() {
    return this.departuresUrl;
  }

  public String getArrivalsUrl() {
    return this.arrivalsUrl;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDeparturesUrl(String departuresUrl) {
    this.departuresUrl = departuresUrl;
  }

  public void setArrivalsUrl(String arrivalsUrl) {
    this.arrivalsUrl = arrivalsUrl;
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