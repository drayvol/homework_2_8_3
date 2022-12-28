public class Main {
    public static void main(String[] args) throws NoLicenceException {
        DriverB<Car> driver = new DriverB<>("Петя",true, 20);
        DriverD<Bus> sanya = new DriverD<>("Саша", true, 8);
        DriverC<Truck> truckDriverC = new DriverC<>("Кирилл", true, 10);

        Mechanic<Car> petr = new Mechanic<>("Петр",  "apple");
        Mechanic<Truck> vova = new Mechanic<>("Вова","помойка");
        Mechanic<Bus> igor = new Mechanic<>("Игорь","мусорка");

        Car tesla = new Car("Tesla", "1", 1.8, 10, 23, 33,Car.BodyType.VAN, driver, petr);
        Bus bus = new Bus("Автобус", "1", 2.8, 10, 23, 33, Bus.Capacity.EXTRA_LARGE, sanya,igor);
        Truck truck = new Truck("Фургон", "df1", 1.8, 10, 23, 33, Truck.Weight.N1,truckDriverC,vova);



        Sponsor lukoil = new Sponsor("Лукойл", 2000);
        Sponsor apple = new Sponsor("ЭПЛ", 1);

        tesla.addSponsor(lukoil, apple);
        truck.addSponsor(lukoil);
        bus.addSponsor(lukoil,apple);
        System.out.println(tesla);
        System.out.println();
        System.out.println(truck);
        System.out.println();
        System.out.println(bus);





    }

    private static void checkTransports(Transport...transports){
        int count = 0;
        for (Transport transport: transports) {
            if(!transport.service()){
                try{
                    throw new RuntimeException(transport.getBrand() +transport.getModel() +" не прошел проверку");
                }
                catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }

            }
            else count++;
            
        }
        System.out.println("Диагностику прошли " + count);
    }
}