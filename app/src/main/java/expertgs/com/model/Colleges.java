package expertgs.com.model;

public class Colleges {
    //(`COLLEGE_ID`, `COLLEGE_CODE`, `COLLEGE_NAME`, `COLLEGE_ADDRESS`, `COLLEGE_CONTACT`, `UNIVERSITY_ID`)
    private int collegeId;
    private String collegeCode;
    private String collegeName;
    private String collegeAddress;
    private String collegeContact;
    private int universityId;

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeAddress() {
        return collegeAddress;
    }

    public void setCollegeAddress(String collegeAddress) {
        this.collegeAddress = collegeAddress;
    }

    public String getCollegeContact() {
        return collegeContact;
    }

    public void setCollegeContact(String collegeContact) {
        this.collegeContact = collegeContact;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }
}
