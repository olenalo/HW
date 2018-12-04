package utils;

import models.Employee;

import java.util.List;

public class EmployeesPrintUtils {

    public static void printListToStringSalaryTitle(List<Employee> employees) {
        System.out.println("#1. All employees with total salary and title: ");
        for (Employee employee : employees) {
            System.out.println(employee.toStringSalaryTitle());
        }
    }
}
