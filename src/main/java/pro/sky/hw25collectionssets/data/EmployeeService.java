package pro.sky.hw25collectionssets.data;

public interface EmployeeService {

    public Employee addEmployee(String firstName, String lastName);
    public Employee removeEmployee(String firstName, String lastName);
    public Employee findEmployee(String firstName, String lastName);
    public String allEmployeeList();

}
