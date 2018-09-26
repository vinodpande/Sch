package expertgs.com.model;

public class Universities {
    // `university_master`(`UNIVERSITY_ID`, `UNIVERSITY_CODE`, `UNIVERSITY_NAME`, `UNIVERSITY_CONTACT`, `UNIVERSITY_ADDRESS`)
    int universityId;
    String universityCode;
    String universityName;
    String universityContact;
    String universityAddress;

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public String getUniversityCode() {
        return universityCode;
    }

    public void setUniversityCode(String universityCode) {
        this.universityCode = universityCode;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityContact() {
        return universityContact;
    }

    public void setUniversityContact(String universityContact) {
        this.universityContact = universityContact;
    }

    public String getUniversityAddress() {
        return universityAddress;
    }

    public void setUniversityAddress(String universityAddress) {
        this.universityAddress = universityAddress;
    }
}
