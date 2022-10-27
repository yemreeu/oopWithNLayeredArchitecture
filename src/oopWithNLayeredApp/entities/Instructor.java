package oopWithNLayeredApp.entities;

public class Instructor {
    private String tcNo;
    private String instructorName;

    public Instructor() {
    }

    public Instructor(String tcNo, String instructorName) {
        this.tcNo = tcNo;
        this.instructorName = instructorName;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}
