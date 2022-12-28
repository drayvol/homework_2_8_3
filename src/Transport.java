import java.util.*;

import static validate.Validate.validateString;

public abstract class Transport {
    private final String brand;
    private final String model;
    private Double engineVolume;

    private final Set <Sponsor> sponsors;

    public Transport(String brand, String model, Double engineVolume) {
        this.brand = validateCarParameters(brand);
        this.model = validateCarParameters(model);
        if (engineVolume == null) this.engineVolume=1.5;
        else this.engineVolume = engineVolume;
        this.sponsors = new HashSet<>();

    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }
    public static String validateCarParameters(String value){return validateString(value,"не указано");}
    abstract void start();
    abstract void finish();
    abstract void printBodyType();
    abstract boolean service();

    public void addSponsor(Sponsor...sponsors){
        this.sponsors.addAll(Arrays.asList(sponsors));
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }
    public abstract Set<?> mechanics();

    public String mechanicsInfo() {
        List<?> mechanics = new ArrayList<>(mechanics());
        StringBuilder result = new StringBuilder();
        if (!mechanics.isEmpty()) {
            result.append("Механики: ");
        }
        for (int i = 0; i < mechanics.size(); i++) {
            result.append(mechanics.get(i));
            if (i != mechanics.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }
            @Override
            public String toString() {
                StringBuilder result = new StringBuilder();
                List<Sponsor> sponsorList = new ArrayList<>(sponsors);
                if (!sponsorList.isEmpty()) {
                    result.append("Спонсоры: ");
                }
                for (int i = 0; i < sponsorList.size(); i++) {
                    result.append(sponsorList.get(i));
                    if (i != sponsorList.size() - 1) {
                        result.append(", ");
                    }
                }
                return result.append("\n").append(mechanicsInfo()).toString();
            }
    abstract boolean repair();
}
