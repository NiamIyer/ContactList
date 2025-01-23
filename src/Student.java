public class Student extends Person{
    // Instance variable
    private int grade;
    //Constructor
    public Student(String first, String last, String number, int grade) {
        // Calls super for person attributes
        super(first,last,number);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    @Override
    // Adds the grade to person's toString
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
