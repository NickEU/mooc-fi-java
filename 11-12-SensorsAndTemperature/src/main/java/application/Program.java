package application;

public class Program {

    public static void main(String[] args) {
        AverageSensor sensors = new AverageSensor();
        for (int i = 0; i < 10; i++) {
            sensors.addSensor(new TemperatureSensor());
        }
        sensors.setOn();
        for (int i = 0; i < 5; i++) {
            System.out.println(sensors.read());
        }
        System.out.println(sensors.readings());
    }

}
