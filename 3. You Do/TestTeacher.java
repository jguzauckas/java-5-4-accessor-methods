public class TestTeacher {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Mr.", "Guzauckas", "Computer Science", 9, 12);

        System.out.println(teacher1.getTitle());
        System.out.println(teacher1.getLastName());
        System.out.println(teacher1.getSubject());
        System.out.println(teacher1.getMinGradeLevel());
        System.out.println(teacher1.getMaxGradeLevel());
    }
}
