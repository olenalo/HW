package utils;

import models.Employee;

import java.util.List;

public class EmployeesPrintUtils {

    public static void printListSalaryTitle(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toStringSalaryTitle());
        }
    }

    public static void printListDeptHiredSpecifiedYear(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toStringHireDateDept());
        }
    }

}
