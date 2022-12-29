import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Car extends Transport implements Competing {
    public enum BodyType{ SEDAN("СЕДАН"),
        HATCHBACK("ХЕТЧБЕК"),
        KUPE("КУПЕ"),
        VERSATILE("УНИВЕРСАЛЬНЫЙ"), OFFROAD("ВНЕДОРОЖНИК"),
        CROSSOVER("КРОССОВЕР"),
        PICKUP("ПИКАП"), VAN("ФУРГОН"), MINIVAN("МИНИВЕН");
        protected final String body;
        BodyType(String body){
            this.body=body;
        }
    }
    private BodyType bodyType;
    private final Integer pitStopTime;
    private final Integer bestLapTime;
    private final Integer maxSpeed;
    private DriverB driver;
    private final Set<Mechanic<Car>> mechanics;

    public Car(String brand, String model, Double engineVolume,
               Integer pitStopTime, Integer bestLapTime, Integer maxSpeed, BodyType bodyType,
               DriverB driver, Mechanic<Car>...mechanics) {
        super(brand, model, engineVolume);
        this.pitStopTime = pitStopTime;
        this.bestLapTime = bestLapTime;
        this.maxSpeed = maxSpeed;
        this.bodyType = bodyType;
        this.driver = driver;
        this.mechanics = new HashSet<>(Arrays.asList(mechanics));
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public Integer getPitStopTime() {
        return pitStopTime;
    }


    @Override
    void start() {System.out.println("Легковушка поехала");}
    @Override
    void finish() {System.out.println("Легковушка приехала");}
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
    @Override
    public void printBodyType(){
        if(bodyType == null) System.out.println("Неверно введены данные");
       else System.out.println("Тип кузова " + getBodyType().body);
    }
    @Override
    public boolean service(){
        return Math.random() >0.5;
    }
    @Override
    public boolean repair(){
        System.out.println("Машина "+ getBrand()+ " " + getModel()+" починена");
        return true;
    }

    public DriverB getDriver() {
        return driver;
    }

    public Set<Mechanic<Car>> getMechanics() {
        return mechanics;
    }

    @Override
    public Set<?> mechanics(){
        return getMechanics();
    };
    public String toString() {
        return "Машина с водителем " + driver + "\n"+ super.toString();
    }
}
