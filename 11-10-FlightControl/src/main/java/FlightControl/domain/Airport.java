package FlightControl.domain;

public class Airport {
  private final String ID;

  public Airport(String ID) {
    this.ID = ID;
  }

  public String getID() {
    return ID;
  }

  @Override
  public String toString() {
    return this.getID();
  }
}
