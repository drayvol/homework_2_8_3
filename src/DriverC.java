public class DriverC<T extends Truck> extends Driver{
    public DriverC(String name, Boolean hasLicense, Integer experience) { super(name, hasLicense, experience); }

    @Override
    public String start() { return "грузовик стартовал"; }
    @Override
    public String stop() { return "грузовик остноавился"; }
    @Override
    public String refuel() { return "грузови заправляется"; }
    public String getCarMessage(T truck) {
        return "Водила " + getName() + " управляет машиной " + truck.getBrand() + " " + truck.getModel() + " и будет участвовать в заезде";
    }
}
