import java.util.*;

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String department = sc.next();
            double salary = sc.nextDouble();

            employees.add(new Employee(name, department, salary));
        }

        // Sorting using Comparator
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {

                // Department alphabetically
                int deptCompare = e1.department.compareTo(e2.department);

                if (deptCompare != 0) {
                    return deptCompare;
                }

                // Same department: salary descending
                return Double.compare(e2.salary, e1.salary);
            }
        });

        // Print result
        for (Employee e : employees) {
            System.out.printf("%s - %s - %.1f%n",
                    e.name, e.department, e.salary);
        }

        sc.close();
    }
}
