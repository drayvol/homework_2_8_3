public class DriverD<T extends Bus> extends Driver{
    public DriverD(String name, Boolean hasLicense, Integer experience) { super(name, hasLicense, experience); }

    @Override
    public String start() { return "автобус стартовал"; }
    @Override
    public String stop() { return "Автобус остноавился"; }
    @Override
    public String refuel() { return "автобус заправляется"; }
    public String getCarMessage(T bus) {
        return "Водила " + getName() + " управляет машиной " + bus.getBrand() + " " + bus.getModel() + " и будет участвовать в заезде";
    }
}
