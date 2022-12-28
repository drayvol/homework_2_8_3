public class Sponsor {
    private final String name;
    private final int amount;

    public Sponsor(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
    public void toSponsorRide(){
        System.out.println("спонсор " + name + " проспонсировал заезд " + amount);
    }

    @Override
    public String toString() {
        return "Спонсор " + name + " сумма поддержки " + amount;
    }
}
