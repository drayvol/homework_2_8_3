import static validate.Validate.*;
public abstract class Driver {

    private final String name;
    private final Boolean hasLicense;
    private final Integer experience;


    public Driver(String name, Boolean hasLicense, Integer experience) {
        this.name = validateString(name, "no name");
        this.hasLicense = validateBoolean(hasLicense);
        this.experience = validateInteger(experience, 1);
    }

        public String getName() { return name; }

        public Boolean getHasLicense() { return hasLicense; }

        public Integer getExperience() { return experience; }

        abstract String start();

        abstract String stop();

        abstract String refuel();
        public static Boolean validateLicence(Boolean value) throws NoLicenceException{
            if (value == null || !value){
                throw new NoLicenceException("Нет действующей лицензии");
            }
            return value;
        }

    @Override
    public String toString() {
        return  name;
    }
}
