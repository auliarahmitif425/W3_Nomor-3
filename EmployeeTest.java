public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        // Naikkan gaji 5%
        for (int i = 0; i < staff.length; i++) {
            staff[i].raiseSalary(5);
        }

        System.out.println("=== Data sebelum sort ===");
        for (Employee e : staff) {
            e.print();
        }

        // compare
        System.out.println("\n=== Hasil compare antar karyawan ===");
        for (int i = 0; i < staff.length; i++) {
            for (int j = i + 1; j < staff.length; j++) {
                int result = staff[i].compare(staff[j]);
                if (result < 0) {
                    System.out.println(staff[i].getName() + " punya gaji lebih kecil dari " + staff[j].getName());
                } else if (result > 0) {
                    System.out.println(staff[i].getName() + " punya gaji lebih besar dari " + staff[j].getName());
                } else {
                    System.out.println(staff[i].getName() + " punya gaji sama dengan " + staff[j].getName());
                }
            }
        }

        // Urutkan array dengan shell_sort
        Sortable.shell_sort(staff);

        System.out.println("\n=== Data setelah sort ===");
        for (Employee e : staff) {
            e.print();
        }
    }
}


