package immutable;

public class Person {
    public final String name;
    private final int age;
    private final String city;

    Person(String name, int age, String city){
        this.name = name;
        this.age = age;
        this.city = city;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

}
