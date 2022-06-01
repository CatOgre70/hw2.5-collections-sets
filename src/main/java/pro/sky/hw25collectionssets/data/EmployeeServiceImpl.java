package pro.sky.hw25collectionssets.data;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final List<Employee> employees;
    private final String[] errors = { "Employee was not found in the database",
                                      "Wrong index argument in EmployeeService.removeEmployee() method",
                                      "Null pointer argument in EmployeeService.removeEmployee() method",
                                      "Employee is already in the database"
                                     };


    public EmployeeServiceImpl(){
        employees = new ArrayList<>(Arrays.asList(new Employee("Ivan", "Ivanov"), new Employee("Petr","Petrov"),
                                                  new Employee("Sidor", "Sidorov"), new Employee("Afanasii", "Ukupnikov"),
                                                  new Employee("Maria", "Mariaskina"), new Employee("Elena", "Fedotova"),
                                                  new Employee("Afanasii", "Morozov"), new Employee("Vasily", "Alibabaev"),
                                                  new Employee("Semen", "Gorbunkov"), new Employee("Svetlana", "Fedotova")
                                                 ));
    }

    public Employee addEmployee(String firstName, String lastName){
        Employee e = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if(employee.equals(e))
                throw new EmployeeAlreadyAddedException(errors[3]);
        }
        employees.add(e);
        return e;
    }

    public Employee removeEmployee(String firstName, String lastName){
        if(firstName == null || lastName == null)
            throw new NullPointerException(errors[2]);
        Employee e = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if(employee.equals(e)) {
                employees.remove(e);
                return e;
            }
        }
        throw new EmployeeNotFoundException(errors[0]);
    }

    public Employee findEmployee(String firstName, String lastName){
        Employee e = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).equals(e))
                return employees.get(i);
        }
        throw new EmployeeNotFoundException(errors[0]);
    }

    public String allEmployeeList(){
        StringBuilder str = new StringBuilder();
        for (Employee e : employees) {
            str.append(e.toString());
            str.append("<br>");
        }
        return str.toString();
    }

}
