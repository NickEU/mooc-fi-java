package application;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;

public class AverageSensor implements Sensor {
  private final List<Sensor> sensors;
  private final List<Integer> historyOfReadings;

  public AverageSensor() {
    this.sensors = new LinkedList<>();
    this.historyOfReadings = new LinkedList<>();
  }

  public void addSensor(Sensor toAdd) {
    this.sensors.add(toAdd);
  }

  @Override
  public boolean isOn() {
    return this.sensors.stream().allMatch(Sensor::isOn);
  }

  @Override
  public void setOn() {
    this.sensors.forEach(Sensor::setOn);
  }

  @Override
  public void setOff() {
    this.sensors.forEach(Sensor::setOff);
  }

  @Override
  public int read() {
    if (!this.isOn() || this.sensors.isEmpty()) {
      throw new IllegalStateException();
    }

    OptionalDouble avg = this.sensors.stream().mapToInt(Sensor::read).average();
    if (avg.isPresent()) {
      int newReading = (int) avg.getAsDouble();
      this.historyOfReadings.add(newReading);
      return newReading;
    }

    throw new IllegalStateException();
  }

  public List<Integer> readings() {
    return this.historyOfReadings;
  }
}
