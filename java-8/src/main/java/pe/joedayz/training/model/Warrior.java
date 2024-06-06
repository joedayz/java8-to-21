package pe.joedayz.training.model;

public class Warrior {

    private Person person;
    private String type;

    public Warrior(Person person) {
        this.person = person;
        this.type = "Warrior " + person.getAge();
    }

    public Person getPerson() {
        return person;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
