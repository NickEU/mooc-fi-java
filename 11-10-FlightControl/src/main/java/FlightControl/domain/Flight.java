package FlightControl.domain;

import java.util.Objects;

public class Flight {
  private final Airplane airplane;
  private final Airport airportDeparture;
  private final Airport airportTarget;

  public Flight(Airplane airplane, Airport airportDeparture, Airport airportTarget) {
    this.airplane = airplane;
    this.airportDeparture = airportDeparture;
    this.airportTarget = airportTarget;
  }

  public Airplane getAirplane() {
    return this.airplane;
  }

  public Airport getAirportDeparture() {
    return this.airportDeparture;
  }

  public Airport getAirportTarget() {
    return this.airportTarget;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Flight flight = (Flight) o;
    return this.getAirplane().equals(flight.getAirplane())
        && this.getAirportDeparture().equals(flight.getAirportDeparture())
        && this.getAirportTarget().equals(flight.getAirportTarget());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAirplane(), getAirportDeparture(), getAirportTarget());
  }

  @Override
  public String toString() {
    return this.getAirplane()
        + " ("
        + this.getAirportDeparture()
        + '-'
        + this.getAirportTarget()
        + ')';
  }
}
