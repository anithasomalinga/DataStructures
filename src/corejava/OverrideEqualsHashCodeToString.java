package corejava;

public class OverrideEqualsHashCodeToString {
    private final int age;
    private final String name;

    OverrideEqualsHashCodeToString(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // Override equals when you want to define logical equality between 2 objs instead of ref equality
    // verify if 2 objs have content/values
    @Override
    public boolean equals (Object other) {
        if (this == other) return true;
        if(!(other instanceof OverrideEqualsHashCodeToString otherObj)) return false; // pattern matching for instanceOf > Java 15
        return (otherObj.age == this.age && otherObj.name.equals(this.name));
        // return (otherObj.age == age && Objects.equals(otherObj.name,name)); latest equality
    }

    // You override hashCode whenever you override equals
    // bcoz collections like hashmap and hashset use both equals and hashcode
    // hashCode() to decide which bucket an obj goes into
    // equals() to check for equality inside the bucket
    // if a.equals(b) is true, then a.hashCode() == b.hashCode() must also be true
    // But if a.equals(b) is false, a.hashCode() may still collide (though fewer collisions = better performance)
    @Override
    public int hashCode() {
        return 31 * this.name.hashCode() + age;
        // latest
        // return Objects.hash(name, age);
    }

    //Override toString for good readable object values
    // With latest Java 16, records auto-generate a good toString()
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

}
