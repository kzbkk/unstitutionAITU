package org.example;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Student s1 = new Student(1, "Kazybek", "Karabala", 17);
        Student s2 = new Student(2, "Ernar", "Umirgaliev", 19);
        dao.save(s1);
        dao.save(s2);
        System.out.println("All students from DB:");
        dao.findAll().forEach(System.out::println);
        dao.updateAge(1, 18);
        dao.delete(2);
    }
}
