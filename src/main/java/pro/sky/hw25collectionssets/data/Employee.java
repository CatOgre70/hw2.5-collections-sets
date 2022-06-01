package pro.sky.hw25collectionssets.data;

import java.util.Formatter;
import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {

        if(firstName == null || lastName == null){
            throw new IllegalArgumentException("Wrong argument(s) in Employee class constructor");
        }

        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString(){
        return "{ \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\" }";
    }

    @Override
    public boolean equals(Object obj) {

        if(obj.getClass() != this.getClass())
            return false;
        Employee e = (Employee) obj;
        if( !e.getFirstName().equals(this.firstName) || !e.getLastName().equals(this.lastName))
            return false;
        else
            return true;

    }

    public int hashCode(){
        return Objects.hashCode(this.toString());
    }
}
