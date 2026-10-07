package immutable;

public class Person {
    public  String name;
    private  int age;
    private  String city;

    Person(String name, int age, String city){
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person() {

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
