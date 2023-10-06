package ru.otus.kva.oop.userapp;

import java.time.LocalDate;

public class UserApp {
    public static void main(String[] args) {
        User[] users = {
                new User("Петров", "Петр", "Петрович",
                        1980, "petro@mail.ru"),
                new User("Иванов", "Иван", "Иванович",
                        1996, "invan@mail.ru"),
                new User("Александров", "Александр", "Александрович",
                        2004, "alex@mail.ru"),
                new User("Сидоров", "Сидр", "Сидорович",
                        1960, "sidr@mail.ru"),
                new User("Михайлов", "Михаил", "Михайлович",
                        1983),
                new User("Романов", "Роман", "Романович",
                        2006, "roma@mail.ru"),
                new User("Осетров", "Осетр", "Осетрович",
                        1940, "osetr@mail.ru")
        };

        for (int i = 0; i < users.length; i++) {
            if (LocalDate.now().getYear() - users[i].getYearOfBirth() > 40) {
                users[i].printInfo();
                System.out.println();
            }
        }
    }
}
