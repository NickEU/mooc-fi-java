package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Airport;
import FlightControl.domain.Flight;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FlightControl {
  private final HashMap<String, Airport> airports;
  private final Set<Flight> flights;
  private final HashMap<String, Airplane> airplanes;

  public FlightControl() {
    this.airports = new HashMap<>();
    this.airplanes = new HashMap<>();
    this.flights = new HashSet<>();
  }

  public boolean addAirplane(String planeId, int capacity) {
    Airplane newPlane = new Airplane(planeId, capacity);
    return this.airplanes.putIfAbsent(planeId, newPlane) == null;
  }

  public boolean addFlight(String planeId, String airportDepId, String airportTarId) {
    this.airports.putIfAbsent(airportDepId, new Airport(airportDepId));
    this.airports.putIfAbsent(airportTarId, new Airport(airportTarId));

    Airplane plane = this.airplanes.get(planeId);
    if (plane == null) {
      return false;
    }

    Airport airportDep = this.airports.get(airportDepId);
    Airport airportTar = this.airports.get(airportTarId);

    Flight newFlight = new Flight(plane, airportDep, airportTar);
    return this.flights.add(newFlight);
  }

  public Collection<Airplane> getListOfAirplanes() {
    return this.airplanes.values();
  }

  public Collection<Flight> getListOfFlights() {
    return this.flights;
  }

  public Airplane findPlaneById(String reqId) {
    return this.airplanes.get(reqId);
  }
}
