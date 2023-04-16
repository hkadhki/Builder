import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = address;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    @Override
    public String toString() {

        if (age.isPresent()) {
            if (address.isEmpty()) {
                return name + " " +surname + " " + age.getAsInt() + " лет ";
            }
            return name + " " +surname + " " + age.getAsInt() + " лет "+address;
        } else {
            if (address.isEmpty()) {
                return name + " " +surname;
            }
            return name + " " +surname + " " +address;
        }
    }

    @Override
    public int hashCode() {
        int hCode;
        hCode = name.hashCode();
        hCode = hCode +surname.hashCode();
        if(age.isPresent()){
            hCode = hCode + age.getAsInt();
        }
        if(!address.isEmpty()){
            hCode = hCode + address.hashCode();
        }
        return hCode;
    }

    public void happyBirthday() {
        if (age.isPresent()){
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public PersonBuilder newChildBuilder(){
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(surname);
        personBuilder.setAddress(address);
        personBuilder.setAge(0);
        return personBuilder;
    }
}
