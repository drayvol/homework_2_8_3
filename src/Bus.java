import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Bus extends Transport implements Competing {
    public enum Capacity{
        EXTRA_SMALL(0,10),
        SMALL(10,25),
        MID(40,50),
        LARGE(60,80),
        EXTRA_LARGE(100,120);
        private Integer from;
        private Integer to;
        Capacity(Integer from, Integer to){
            this.from=from;
            this.to=to;
        }
    }
    private DriverD driver;
    private final Set<Mechanic<Bus>> mechanics;
    private Capacity capacity;
    private final Integer pitStopTime;
    private final Integer bestLapTime;
    private final Integer maxSpeed;
    public Bus(String brand, String model, Double engineVolume,
               Integer pitStopTime, Integer bestLapTime, Integer maxSpeed, Capacity capacity,
               DriverD driver, Mechanic<Bus> mechanics) {
        super(brand, model, engineVolume);
        this.pitStopTime = pitStopTime;
        this.bestLapTime = bestLapTime;
        this.maxSpeed = maxSpeed;
        this.capacity = capacity;
        this.driver=driver;
        this.mechanics = new HashSet<>(Arrays.asList(mechanics));
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public DriverD getDriver() {
        return driver;
    }

    public void setDriver(DriverD driver) {
        this.driver = driver;
    }

    public Integer getPitStopTime() {
        return pitStopTime;
    }

    @Override
    void start() {System.out.println("Автобус поехал");}
    @Override
    void finish() {System.out.println("Автобус приехал");}

    @Override
    public void getPitStop() {
        System.out.println("Пит стоп" +pitStopTime);
    }

    @Override
    public void getBestLapTime() {
        System.out.println("Лучшее время круга"+bestLapTime);
    }

    @Override
    public void getMaxSpeed() {
        System.out.println("Максимальная скорость" + maxSpeed);
    }
    public void printBodyType(){
        if(capacity == null) System.out.println("Неверно введеные данные");
        else System.out.println( "вместимость авто с " + getCapacity().from +"до "+ getCapacity().to);
    }
    @Override
    public boolean service(){
        System.out.println("Автобус не нужндается в проверке");
        return true;
    }
    public boolean repair(){
        System.out.println("Автобус "+ getBrand()+ " " + getModel()+" починен");
        return true;
    }

    public Set<Mechanic<Bus>> getMechanics() {
        return mechanics;
    }

    @Override
    public Set<?> mechanics(){
        return getMechanics();
    };
    public String toString() {
        return "Автобус с водителем " + driver + "\n"+ super.toString();
    }
}
