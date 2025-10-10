package designpattern.creational.prototype.concreteprototype;

public class AuthorizedSignatory implements Cloneable {
    private String name;
    private String designation;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "[AuthorizedSignatory: Name - " + getName() + ", Designation - " + getDesignation() + "]";
    }
}
