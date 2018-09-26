package expertgs.com.model;

public class Colleges_Staff {
    //`college_staff_master`(`COLLEGE_STAFF_ID`, `COLLEGE_STAFF_NAME`, `COLLEGE_STAFF_CONTACT`, `COLLEGE_STAFF_EMAIL`, `COLLEGE_ID`)
    private int collegeStaffId;
    private String collegeStaffName;
    private String collegeStaffContact;
    private String CollegeStaffEmail;
    private int collegeId;

    public int getCollegeStaffId() {
        return collegeStaffId;
    }

    public void setCollegeStaffId(int collegeStaffId) {
        this.collegeStaffId = collegeStaffId;
    }

    public String getCollegeStaffName() {
        return collegeStaffName;
    }

    public void setCollegeStaffName(String collegeStaffName) {
        this.collegeStaffName = collegeStaffName;
    }

    public String getCollegeStaffContact() {
        return collegeStaffContact;
    }

    public void setCollegeStaffContact(String collegeStaffContact) {
        this.collegeStaffContact = collegeStaffContact;
    }

    public String getCollegeStaffEmail() {
        return CollegeStaffEmail;
    }

    public void setCollegeStaffEmail(String collegeStaffEmail) {
        CollegeStaffEmail = collegeStaffEmail;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }
}
