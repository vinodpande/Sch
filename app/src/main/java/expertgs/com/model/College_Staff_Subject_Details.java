package expertgs.com.model;

public class College_Staff_Subject_Details {
    // `college_staff_subject_details`(`COLLEGE_STAFF_SUBJECT_ID`, `COLLEGE_STAFF_ID`, `SUBJECT_ID`)

    int collegeStaffSubjectId;
    int collegeStaffId;
    int SubjectId;

    public int getCollegeStaffSubjectId() {
        return collegeStaffSubjectId;
    }

    public void setCollegeStaffSubjectId(int collegeStaffSubjectId) {
        this.collegeStaffSubjectId = collegeStaffSubjectId;
    }

    public int getCollegeStaffId() {
        return collegeStaffId;
    }

    public void setCollegeStaffId(int collegeStaffId) {
        this.collegeStaffId = collegeStaffId;
    }

    public int getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(int subjectId) {
        SubjectId = subjectId;
    }
}
