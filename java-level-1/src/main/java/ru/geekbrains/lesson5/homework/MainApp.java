package ru.geekbrains.lesson5.homework;

public class MainApp {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов Иван Иванович", "Инженер", 30, 30000, "ivivan@mail.ru", "892312312");
        employees[1] = new Employee("Александров Александр Александрович", "Специалист", 28, 28000, "alexandrov@mail.ru", "892312323");
        employees[2] = new Employee("Сергеев Сергей Сергеевич", "Администратор", 45, 33000, "sergeev@mail.ru", "892312334");
        employees[3] = new Employee("Алексеев Алексей Алексеевич", "Стоматолог", 41, 45000, "alexeev@mail.ru", "892312345");
        employees[4] = new Employee("Васильев Василий Васильевич", "Водитель", 35, 40000, "vasilev@mail.ru", "892312356");

        for (int i = 0; i < 5; i++) {
            if (employees[i].getAge() > 40) employees[i].info();
        }
    }
}
