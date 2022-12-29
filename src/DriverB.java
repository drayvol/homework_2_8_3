public class DriverB<T extends Car> extends Driver{
    public DriverB(String name, Boolean hasLicense, Integer experience) { super(name, hasLicense, experience); }

    @Override
    public String start() { return "лешковшука стартовала"; }
    @Override
    public String stop() { return "легковушка остноавилась"; }
    @Override
    public String refuel() { return "легковушка заправляется"; }
    public String getCarMessage(T car) {
        return "Водила " + getName() + " управляет машиной " + car.getBrand() + " " + car.getModel() + " и будет участвовать в заезде " + "тип кузвоа " + car.getBodyType().body;

    }
}


