package expertgs.com.admin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import expertgs.com.constant.AdminListLayout;
import expertgs.com.constant.Constant;
import expertgs.com.model.Classes;
import expertgs.com.model.College_Staff_Subject_Details;
import expertgs.com.model.Colleges;
import expertgs.com.model.Colleges_Staff;
import expertgs.com.model.Divisions;
import expertgs.com.model.Semisters;
import expertgs.com.model.Streams;
import expertgs.com.model.Students;
import expertgs.com.model.Subject;
import expertgs.com.model.Universities;
import expertgs.com.sch.R;
import expertgs.com.webservices.WebSchoolAttendanceAPI;

public class AdminActivity extends AppCompatActivity implements IUniversal {
    ArrayList<AdminListLayout> LAYOUT_CONTAINER;
    AdminListLayout adminListLayout;
    EditText EDIT_UNIVERSITY_NAME;
    EditText EDIT_UNIVERSITY_CODE;
    EditText EDIT_UNIVERSITY_CONTACT;
    EditText EDIT_UNIVERSITY_ADDRESS;
    ListView LIST_VIEW_ALL;
    AllListAdapter allListAdapter;
    AllListAdapter allListAdapterSpinners;

    Spinner SPIN_UNIVERSITY_NAME;
    EditText EDIT_COLLEGE_NAME;
    EditText EDIT_COLLEGE_CODE;
    EditText EDIT_COLLEGE_CONTACT;
    EditText EDIT_COLLEGE_ADDRESS;

    Spinner SPIN_COLLEGE_NAME;
    EditText EDIT_COLLEGE_STAFF_NAME;
    EditText EDIT_COLLEGE_STAFF_CONTACT;
    EditText EDIT_COLLEGE_STAFF_EMAIL_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        LIST_VIEW_ALL = findViewById(R.id.list_view_all);
        initUIComponent();
        initContainer();
        setListView(new ArrayList());
    }

    void initContainer() {
        LAYOUT_CONTAINER = new ArrayList();
        adminListLayout = new AdminListLayout();
        adminListLayout.setId(R.id.buttonUniversityContainer);
        adminListLayout.setView(findViewById(R.id.layoutUniversityContainer));
        adminListLayout.setMainView(findViewById(R.id.layoutUniversityMainContainer));
        LAYOUT_CONTAINER.add(adminListLayout);

        adminListLayout = new AdminListLayout();
        adminListLayout.setId(R.id.buttonCollegeContainer);
        adminListLayout.setView(findViewById(R.id.layoutCollegeContainer));
        adminListLayout.setMainView(findViewById(R.id.layoutCollegeMainContainer));
        LAYOUT_CONTAINER.add(adminListLayout);

        adminListLayout = new AdminListLayout();
        adminListLayout.setId(R.id.buttonCollegeStaffContainer);
        adminListLayout.setView(findViewById(R.id.layoutCollegeStaffContainer));
        adminListLayout.setMainView(findViewById(R.id.layoutCollegeStaffMainContainer));
        LAYOUT_CONTAINER.add(adminListLayout);

        adminListLayout = new AdminListLayout();
        adminListLayout.setId(R.id.buttonClassContainer);
        adminListLayout.setView(findViewById(R.id.layoutClassContainer));
        adminListLayout.setMainView(findViewById(R.id.layoutClassMainContainer));
        LAYOUT_CONTAINER.add(adminListLayout);

        adminListLayout = new AdminListLayout();
        adminListLayout.setId(R.id.buttonStreamContainer);
        adminListLayout.setView(findViewById(R.id.layoutStreamContainer));
        adminListLayout.setMainView(findViewById(R.id.layoutStreamMainContainer));
        LAYOUT_CONTAINER.add(adminListLayout);

        adminListLayout = new AdminListLayout();
        adminListLayout.setId(R.id.buttonSemisterContainer);
        adminListLayout.setView(findViewById(R.id.layoutSemisterContainer));
        adminListLayout.setMainView(findViewById(R.id.layoutSemisterMainContainer));
        LAYOUT_CONTAINER.add(adminListLayout);

        adminListLayout = new AdminListLayout();
        adminListLayout.setId(R.id.buttonDivisionContainer);
        adminListLayout.setView(findViewById(R.id.layoutDivisionContainer));
        adminListLayout.setMainView(findViewById(R.id.layoutDivisionMainContainer));
        LAYOUT_CONTAINER.add(adminListLayout);

        adminListLayout = new AdminListLayout();
        adminListLayout.setId(R.id.buttonSubjectContainer);
        adminListLayout.setView(findViewById(R.id.layoutSubjectContainer));
        adminListLayout.setMainView(findViewById(R.id.layoutSubjectMainContainer));
        LAYOUT_CONTAINER.add(adminListLayout);

        adminListLayout = new AdminListLayout();
        adminListLayout.setId(R.id.buttonCollegeStaffSubjectContainer);
        adminListLayout.setView(findViewById(R.id.layoutCollegeStaffSubjectContainer));
        adminListLayout.setMainView(findViewById(R.id.layoutCollegeStaffSubjectMainContainer));
        LAYOUT_CONTAINER.add(adminListLayout);

        adminListLayout = new AdminListLayout();
        adminListLayout.setId(R.id.buttonStudentContainer);
        adminListLayout.setView(findViewById(R.id.layoutStudentContainer));
        adminListLayout.setMainView(findViewById(R.id.layoutStudentMainContainer));
        LAYOUT_CONTAINER.add(adminListLayout);
    }

    public void collabsConatiner(View view) {
        if (LAYOUT_CONTAINER.size() > 0) {
            for (int i = 0; i < LAYOUT_CONTAINER.size(); i++) {
                AdminListLayout list = LAYOUT_CONTAINER.get(i);
                if (view.getId() == list.getId()) {
                    if (list.getView().getVisibility() == View.VISIBLE) {
                        list.getView().setVisibility(View.GONE);
                        LIST_VIEW_ALL.setVisibility(View.GONE);
                        for (int j = 0; j < LAYOUT_CONTAINER.size(); j++) {
                            AdminListLayout sublist = LAYOUT_CONTAINER.get(j);
                            if (view.getId() == sublist.getId()) {
                                sublist.getMainView().setVisibility(View.VISIBLE);
                            } else {
                                sublist.getMainView().setVisibility(View.VISIBLE);
                            }
                        }
                    } else {
                        list.getView().setVisibility(View.VISIBLE);
                        LIST_VIEW_ALL.setVisibility(View.VISIBLE);
                        //call get data when view is visible
                        clearDataSetList();
                        getDataFromService(view.getId());
                        setSpinners(view.getId());
                        for (int j = 0; j < LAYOUT_CONTAINER.size(); j++) {
                            AdminListLayout sublist = LAYOUT_CONTAINER.get(j);
                            if (view.getId() == sublist.getId()) {
                                sublist.getMainView().setVisibility(View.VISIBLE);
                            } else {
                                sublist.getMainView().setVisibility(View.GONE);
                            }
                        }

                    }
                    // open
                } else {
                    list.getView().setVisibility(View.GONE);

                    // close
                }

            }
        }
    }

    void initUIComponent() {

        EDIT_UNIVERSITY_NAME = findViewById(R.id.editUniversityName);
        EDIT_UNIVERSITY_CODE = findViewById(R.id.editUniversityCode);
        EDIT_UNIVERSITY_CONTACT = findViewById(R.id.editUniversityContact);
        EDIT_UNIVERSITY_ADDRESS = findViewById(R.id.editUniversityAddress);

        SPIN_UNIVERSITY_NAME = findViewById(R.id.spinnerUniversityName);
        EDIT_COLLEGE_NAME = findViewById(R.id.editCollegeName);
        EDIT_COLLEGE_CODE = findViewById(R.id.editCollegeCode);
        EDIT_COLLEGE_CONTACT = findViewById(R.id.editCollegeContact);
        EDIT_COLLEGE_ADDRESS = findViewById(R.id.editCollegeAddress);

        SPIN_COLLEGE_NAME = findViewById(R.id.spinnerCollegeName);
        EDIT_COLLEGE_STAFF_NAME = findViewById(R.id.editCollegeStaffName);
        EDIT_COLLEGE_STAFF_CONTACT = findViewById(R.id.editCollegeStaffContact);
        EDIT_COLLEGE_STAFF_EMAIL_ID = findViewById(R.id.editCollegeStaffEmilID);

    }


    Universities setUniversity() {
        Universities universities = new Universities();
        if (!TextUtils.isEmpty(EDIT_UNIVERSITY_NAME.getText()) && !TextUtils.isEmpty(EDIT_UNIVERSITY_CODE.getText()) && !TextUtils.isEmpty(EDIT_UNIVERSITY_CONTACT.getText()) && !TextUtils.isEmpty(EDIT_UNIVERSITY_ADDRESS.getText())) {
            universities.setUniversityName(EDIT_UNIVERSITY_NAME.getText().toString());
            universities.setUniversityCode(EDIT_UNIVERSITY_CODE.getText().toString());
            universities.setUniversityContact(EDIT_UNIVERSITY_CONTACT.getText().toString());
            universities.setUniversityAddress(EDIT_UNIVERSITY_ADDRESS.getText().toString());
        } else {
            Toast.makeText(this, "Enter All Values", Toast.LENGTH_LONG).show();
        }
        return universities;
    }


    public void saveUniversity(View view) {
        WebSchoolAttendanceAPI.setUniversites(this, this, setUniversity());
    }

    public void clearUniversity(View view) {
        EDIT_UNIVERSITY_NAME.setText(null);
        EDIT_UNIVERSITY_CODE.setText(null);
        EDIT_UNIVERSITY_CONTACT.setText(null);
        EDIT_UNIVERSITY_ADDRESS.setText(null);
    }

    void setListView(ArrayList list) {
        allListAdapter = new AllListAdapter(this, list);
        LIST_VIEW_ALL.setAdapter(allListAdapter);

    }


    void clearDataSetList() {
        allListAdapter.list.clear();
        allListAdapter.notifyDataSetChanged();
    }

    void setSpinners(int id) {
        switch (id) {
            case R.id.buttonUniversityContainer:

                break;
            case R.id.buttonCollegeContainer:
                SPIN_UNIVERSITY_NAME.setAdapter(genrateArrayAdaper(Constant.LIST_UNIVERSITIES));
                break;
            case R.id.buttonCollegeStaffContainer:
                SPIN_COLLEGE_NAME.setAdapter(genrateArrayAdaper(Constant.LIST_COLLEGES));
                break;
            case R.id.buttonClassContainer:

                break;
            case R.id.buttonStreamContainer:

                break;
            case R.id.buttonSemisterContainer:

                break;
            case R.id.buttonDivisionContainer:

                break;
            case R.id.buttonSubjectContainer:

                break;
            case R.id.buttonCollegeStaffSubjectContainer:

                break;
            case R.id.buttonStudentContainer:

                break;
        }
    }

    void getDataFromService(int id) {
        switch (id) {
            case R.id.buttonUniversityContainer:
                WebSchoolAttendanceAPI.getUniversites(this, this);
                break;
            case R.id.buttonCollegeContainer:
                WebSchoolAttendanceAPI.getColleges(this, this);
                break;
            case R.id.buttonCollegeStaffContainer:
                WebSchoolAttendanceAPI.getCollegeStaffs(this, this);
                break;
            case R.id.buttonClassContainer:
                WebSchoolAttendanceAPI.getClasses(this, this);
                break;
            case R.id.buttonStreamContainer:
                WebSchoolAttendanceAPI.getStreams(this, this);
                break;
            case R.id.buttonSemisterContainer:
                WebSchoolAttendanceAPI.getSemisters(this, this);
                break;
            case R.id.buttonDivisionContainer:
                WebSchoolAttendanceAPI.getDivisions(this, this);
                break;
            case R.id.buttonSubjectContainer:
                WebSchoolAttendanceAPI.getSubject(this, this);
                break;
            case R.id.buttonCollegeStaffSubjectContainer:
                WebSchoolAttendanceAPI.getCollegeStaffSubject(this, this);
                break;
            case R.id.buttonStudentContainer:
                WebSchoolAttendanceAPI.getStudents(this, this);
                break;
        }
    }

    ArrayAdapter genrateArrayAdaper(List list) {
        Object obj = list.get(0);
        ArrayList arrayList=new ArrayList();
        if (obj instanceof Universities) {
            arrayList.clear();
            for (int i = 0; i < list.size(); i++) {
                Universities universities= (Universities) list.get(i);
                arrayList.add(universities.getUniversityName());
            }
        }
        if (obj instanceof Colleges) {
            arrayList.clear();
            for (int i = 0; i < list.size(); i++) {
                Colleges colleges= (Colleges) list.get(i);
                arrayList.add(colleges.getCollegeName());
            }
        }
        if (obj instanceof Colleges_Staff) {
            arrayList.clear();
            for (int i = 0; i < list.size(); i++) {
                Colleges_Staff collegesStaff = (Colleges_Staff) list.get(i);
                arrayList.add(collegesStaff.getCollegeStaffName());
            }
        }
        if (obj instanceof College_Staff_Subject_Details) {

            // Name Not available
        }
        if (obj instanceof Subject) {
            arrayList.clear();
            for (int i = 0; i < list.size(); i++) {
                Subject subject = (Subject) list.get(i);
                arrayList.add(subject.getSubjectName());
            }
        }
        if (obj instanceof Semisters) {

            arrayList.clear();
            for (int i = 0; i < list.size(); i++) {
                Semisters semisters = (Semisters) list.get(i);
                arrayList.add(semisters.getSemisterName());
            }
        }
        if (obj instanceof Classes) {

            arrayList.clear();
            for (int i = 0; i < list.size(); i++) {
                Classes classes = (Classes) list.get(i);
                arrayList.add(classes.getClassName());
            }
        }
        if (obj instanceof Streams) {
            arrayList.clear();
            for (int i = 0; i < list.size(); i++) {
                Streams streams = (Streams) list.get(i);
                arrayList.add(streams.getStreamName());
            }
        }
        if (obj instanceof Divisions) {

            arrayList.clear();
            for (int i = 0; i < list.size(); i++) {
                Divisions divisions = (Divisions) list.get(i);
                arrayList.add(divisions.getDivisionName());
            }
        }
        if (obj instanceof Students) {
            arrayList.clear();
            for (int i = 0; i < list.size(); i++) {
                Students students = (Students) list.get(i);
                arrayList.add(students.getStudentName());
            }
        }

        return new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
    }

    @Override
    public void changeListUniversal(ArrayList list) {
        if (list.size() > 0) {
            if (allListAdapter.list != null) {
                allListAdapter.list.clear();
                allListAdapter.list.addAll(list);
                allListAdapter.notifyDataSetChanged();
                LIST_VIEW_ALL.invalidate();
            }
        }
    }

    @Override
    public void onUniversalMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
