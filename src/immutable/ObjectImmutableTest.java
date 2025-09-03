package immutable;

public class ObjectImmutableTest {
    public static void main(String[] args) {
        Person person = new Person("Anitha", 39, "Delta");
        System.out.printf("Person name: %s age: %s, city: %s%n", person.getName(), person.getAge(), person.getCity());
        modifyPerson(person);
        System.out.printf("Person name: %s age: %s, city: %s%n", person.getName(), person.getAge(), person.getCity());
    }

    private static void modifyPerson(Person person) {
//        person.setName("Madhan");
//        person.setAge(47);
//        person.setCity("Delta");
//        person.name = "nn";
//        person = new Person("Madhan", 47, "Delta");
        System.out.printf("Person name: %s age: %s, city: %s%n", person.getName(), person.getAge(), person.getCity());
    }
}
