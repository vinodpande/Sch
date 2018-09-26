package expertgs.com.model;

import java.util.Date;

public class Attendance_Details {
    //(COLLEGE_STAFF_ID,STUDENT_ID,SUBJECT_ID,ATTENDANCE_STATUS,REASONS,ATTENDANCE_DATETIME)
    private int attendanceId;
    private int collegeStaffId;
    private int studentId;
    private int subjectId;
    private String attendanceStatus;
    private String Reasons;
    private Date attendanceDateTime;

    public int getCollegeStaffId() {
        return collegeStaffId;
    }

    public void setCollegeStaffId(int collegeStaffId) {
        this.collegeStaffId = collegeStaffId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getReasons() {
        return Reasons;
    }

    public void setReasons(String reasons) {
        Reasons = reasons;
    }

    public Date getAttendanceDateTime() {
        return attendanceDateTime;
    }

    public void setAttendanceDateTime(Date attendanceDateTime) {
        this.attendanceDateTime = attendanceDateTime;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }
}
