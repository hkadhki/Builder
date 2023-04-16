import java.util.OptionalInt;

public class PersonBuilder  {
    protected Person person;
    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalArgumentException,IllegalStateException{

        if (name == null || surname == null) {
            throw new IllegalStateException("нет имени или фамилии");
        }
        if (age.isPresent()) {
            if (age.getAsInt() < 0) {
                throw new IllegalArgumentException("Возраст введен неправильно");
            }
            if (address.isEmpty()) {
                return new Person(name, surname, age.getAsInt());
            }
            return new Person(name, surname, age.getAsInt(), address);
        } else {
            if (address.isEmpty()) {
                return new Person(name, surname);
            }
            return new Person(name, surname, address);
        }
    }
}
