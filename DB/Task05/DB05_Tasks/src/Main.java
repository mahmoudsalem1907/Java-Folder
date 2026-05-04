import DB.Employee;
import DB.Language;
import DB.Phone;
import DB.Teacher;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Teacher();
        Employee();


    }

    private static void Employee() {
        Employee employee = new Employee(1,"NOUR",33);
        Phone phone = new Phone();
        employee.setPhone(phone);
        phone.setId(1);
        phone.setNumber("0125051245");

        employee.setPhone(phone);

        System.out.printf(
                "Employee -> ID: %d | Name: %s | Age: %d | Phone: %s%n",
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getPhone().getNumber()
        );
    }

    private static void Teacher() {
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setSalary(5000L);
        teacher.setName("Khaled");


        Language language = new Language();
        language.setId(1);
        language.setName("Math");

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);

        language.setTeachers(teachers);
        teacher.setLanguage(language);


        System.out.println(teacher.getSalary());
        System.out.println(teacher.getName());
        System.out.println(teacher.getLanguage().getName());
        System.out.println(language.getId());
        System.out.println(language.getName());


        String output = """
        ===== Teacher Info =====
        Name: %s
        Salary: %d
        Language: %s
        """.formatted(
                teacher.getName(),
                teacher.getSalary(),
                teacher.getLanguage().getName()
        );

        System.out.println(output);
    }
}