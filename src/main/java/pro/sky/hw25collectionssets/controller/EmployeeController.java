package pro.sky.hw25collectionssets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw25collectionssets.data.Employee;
import pro.sky.hw25collectionssets.data.EmployeeAlreadyAddedException;
import pro.sky.hw25collectionssets.data.EmployeeNotFoundException;
import pro.sky.hw25collectionssets.data.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName){
        Employee employee;
        try{
            employee = new Employee(firstName, lastName);
        } catch(IllegalArgumentException e) {
            return "Please input fist and Last names of employee in format \"?firstname=\'FIRSTNAME\'&lastname=\'LASTNAME\'\"";
        }
        try{
            employee = employeeService.addEmployee(firstName, lastName);
        } catch(EmployeeAlreadyAddedException e) {
            return "Employee " + employee + " already exists in the database";
        }
        return employee.toString();
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName){
        Employee employee;
        try {
            employee = new Employee(firstName, lastName);
        } catch(NullPointerException e) {
            return "Please input fist and Last names of employee in format \"?firstname=\'FIRSTNAME\'&lastname=\'LASTNAME\'\"";
        }
        try{
            employee = employeeService.removeEmployee(firstName, lastName);
        } catch(EmployeeNotFoundException e) {
            return "Employee " + employee + " not found in the database";
        }
        return employee.toString();
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName){
        Employee employee;
        try{
            employee = new Employee(firstName, lastName);
        } catch(IllegalArgumentException e) {
            return "Please input fist and Last names of employee in format \"?firstname=\'FIRSTNAME\'&lastname=\'LASTNAME\'\"";
        }
        try{
            employee = employeeService.findEmployee(firstName, lastName);
        } catch(EmployeeNotFoundException e) {
            return "Employee " + employee + " not found in the database";
        }
        return employee.toString();
    }

    @GetMapping("/list")
    public String employeeList(){
        return employeeService.allEmployeeList();
    }

}
