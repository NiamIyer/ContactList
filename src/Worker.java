public class Worker extends Person{
    // Instance variable
    private String job;
    // Constructor
    public Worker(String first, String last, String number, String job) {
        // Calls super for person variables
        super(first,last,number);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return super.toString() + " job: " + job;
    }
}
