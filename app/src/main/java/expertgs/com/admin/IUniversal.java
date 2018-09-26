package expertgs.com.admin;

import java.util.ArrayList;
import java.util.List;

import expertgs.com.model.College_Staff_Subject_Details;
import expertgs.com.model.Colleges;
import expertgs.com.model.Colleges_Staff;
import expertgs.com.model.Divisions;
import expertgs.com.model.Semisters;
import expertgs.com.model.Streams;
import expertgs.com.model.Students;
import expertgs.com.model.Subject;
import expertgs.com.model.Universities;

public interface IUniversal {
    void changeListUniversal(ArrayList list);
    void onUniversalMessage(String message);
    /*void changeUniversity(Universities  universities);
    void changeColleges(Colleges colleges);
    void changeCollegeStaffSubjectDetails(College_Staff_Subject_Details college_staff_subject_details);
    void changeDivision(Divisions divisions);
    void changeSemister(Semisters semisters);
    void changeStream(Streams streams);
    void changeSubject(Subject subject);
    void changeStudent(Students students);
    void changeCollegeStaff(Colleges_Staff colleges_staff);*/
}
