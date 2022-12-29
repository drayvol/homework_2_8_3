public class Mechanic<T extends Transport> {
    private final String nameAndSurname;
    private final String company;

    public Mechanic(String nameAndSurname, String company){
        this.nameAndSurname = nameAndSurname;
        this.company = company;

    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public String getCompany() {
        return company;
    }


    public boolean checkTransport(T t){
        if(!t.service()) return t.repair();
        return t.service();
    }
    public void repair(T t){
        t.repair();
    }

    @Override
    public String toString() {
        return "Механик " + nameAndSurname + " из компании " +company ;
    }
}

