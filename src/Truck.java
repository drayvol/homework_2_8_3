import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Truck extends Transport implements Competing {
    public enum Weight{N1, N2, N3}
    private Weight weight;
    private final Integer pitStopTime;
    private final Integer bestLapTime;
    private final Integer maxSpeed;
    private DriverC driver;
    private final Set<Mechanic<Truck>> mechanics;


    public Truck(String brand, String model, Double engineVolume,
                 Integer pitStopTime, Integer bestLapTime, Integer maxSpeed, Weight weight,
                 DriverC driver, Mechanic<Truck> mechanics) {
        super(brand, model, engineVolume);
        this.pitStopTime = pitStopTime;
        this.bestLapTime = bestLapTime;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.driver = driver;
        this.mechanics = new HashSet<>(Arrays.asList(mechanics));
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Integer getPitStopTime() {
        return pitStopTime;
    }

    @Override
    void start() {System.out.println("Грузовик поехал");}

    @Override
    void finish() {System.out.println("Грузовик приехал");}
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
    public void printBodyType(){};
    @Override
    public boolean service(){
        return Math.random() >0.5;
    }
    public boolean repair(){
        System.out.println("Фургон "+ getBrand()+ " " + getModel()+" починен");
        return true;
    }

    public DriverC getDriver() {
        return driver;
    }

    public Set<Mechanic<Truck>> getMechanics() {
        return mechanics;
    }

    @Override
    public Set<?> mechanics(){
        return getMechanics();
    };

    @Override
    public String toString() {
        return "Грузовик с водителем " + driver + "\n"+ super.toString();
    }
}
