package utils;

import models.Employee;

import java.util.List;

public class EmployeesPrintUtils {

    public static int checkLimit(int limit, int size) {
        if (limit > size) {
            System.out.println("Limit should not be bigger than size.");
            limit = size;
        }
        return limit;
    }

    public static void printListTotalSalaryTitle(List<Employee> employees, int limit) {
        limit = checkLimit(limit, employees.size());
        for (int i = 0; i < limit; i++) {
            Employee employee = employees.get(i);
            System.out.println(employee.toStringTotalSalaryTitle());
        }
    }

    public static void printListCurrentSalaryTitle(List<Employee> employees, int limit) {
        limit = checkLimit(limit, employees.size());
        for (int i = 0; i < limit; i++) {
            Employee employee = employees.get(i);
            System.out.println(employee.toStringCurrentSalaryTitle());
        }
    }

    public static void printListDeptHiredSpecifiedYear(List<Employee> employees, int limit) {
        limit = checkLimit(limit, employees.size());
        for (int i = 0; i < limit; i++) {
            Employee employee = employees.get(i);
            System.out.println(employee.toStringHireDateDept());
        }
    }

}
