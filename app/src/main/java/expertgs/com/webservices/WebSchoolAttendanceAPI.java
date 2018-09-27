package expertgs.com.webservices;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.text.SimpleDateFormat;
import java.util.Date;

import expertgs.com.admin.IUniversal;
import expertgs.com.constant.Constant;
import expertgs.com.model.Attendance_Details;
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

public class WebSchoolAttendanceAPI {
    final static String SERVICE_URL = "http://college.vindroidtech.com/service.php";

    final static String GET_ALL_COUNT = "getallcount";
    final static String GET_ALL_UNIVERSITIES = "get_All_Universities";
    final static String GET_ALL_COLLEGES = "get_All_Colleges";
    final static String GET_ALL_COLLEGES_STAFF = "get_All_Colleges_Staff";
    final static String GET_ALL_CLASSES = "get_Classes";
    final static String GET_ALL_STREAMS = "get_Streams";
    final static String GET_ALL_SEMISTER = "get_Semisters";
    final static String GET_ALL_SUBJECTS = "get_Subjects";
    final static String GET_ALL_DIVISIONS = "get_Divisions";
    final static String GET_ALL_COLLEGE_STAFF_SUBJECT_DETAILS = "get_College_Staff_Subject_Details";
    final static String GET_All_STUDENT = "get_Students";
    final static String GET_ATTENDANCE_DETAILS = "get_Attendace_Details";
    final static String SET_UNIVERSITIES = "set_Universities";
    final static String SET_COLLEGES = "set_Colleges";
    final static String SET_COLLEGE_STAFF = "set_College_Staff";
    final static String SET_CLASS = "set_Class";
    final static String SET_STREAMS = "set_Streams";
    final static String SET_SEMISTERS = "set_Semisters";
    final static String SET_SUBJECT = "set_Subjects";
    final static String SET_DIVISIONS = "set_Divisions";
    final static String SET_COLLEGE_STAFF_SUBJECT_DETAILS = "set_College_Staff_Subject_Details";
    final static String SET_STUDENT = "set_Students";
    final static String SET_ATTENDANCE_DETAILS = "set_Attendance_Details";

    public static void getUniversites(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_ALL_UNIVERSITIES);
        Constant.LIST_UNIVERSITIES.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                Object json = null;
                Universities universities;
                try {
                    json = new JSONTokener(content).nextValue();
                    if (json instanceof JSONObject) {
                        universities = new Universities();
                        universities.setUniversityName(((JSONObject) json).getString("message"));
                        Constant.LIST_UNIVERSITIES.add(universities);
                    } else if (json instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) json;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            universities = new Universities();
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            //UNIVERSITY_ID,UNIVERSITY_CODE,UNIVERSITY_NAME,UNIVERSITY_CONTACT,UNIVERSITY_ADDRESS
                            universities.setUniversityId(jsonObject.getInt("UNIVERSITY_ID"));
                            universities.setUniversityCode(jsonObject.getString("UNIVERSITY_CODE"));
                            universities.setUniversityName(jsonObject.getString("UNIVERSITY_NAME"));
                            universities.setUniversityContact(jsonObject.getString("UNIVERSITY_CONTACT"));
                            universities.setUniversityAddress(jsonObject.getString("UNIVERSITY_ADDRESS"));
                            Constant.LIST_UNIVERSITIES.add(universities);
                        }
                    }
                    if (iUniversal != null) {
                        iUniversal.changeListUniversal(Constant.LIST_UNIVERSITIES);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void getColleges(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_ALL_COLLEGES);
        Constant.LIST_COLLEGES.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                Object json = null;
                Colleges colleges;
                try {
                    json = new JSONTokener(content).nextValue();
                    if (json instanceof JSONObject) {
                        colleges = new Colleges();
                        colleges.setCollegeName(((JSONObject) json).getString("message"));
                        Constant.LIST_COLLEGES.add(colleges);
                    } else if (json instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) json;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            colleges = new Colleges();
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            //COLLEGE_ID,COLLEGE_CODE,COLLEGE_NAME,COLLEGE_ADDRESS,COLLEGE_CONTACT,UNIVERSITY_ID
                            colleges.setCollegeId(jsonObject.getInt("COLLEGE_ID"));
                            colleges.setCollegeName(jsonObject.getString("COLLEGE_NAME"));
                            colleges.setCollegeCode(jsonObject.getString("COLLEGE_CODE"));
                            colleges.setCollegeContact(jsonObject.getString("COLLEGE_CONTACT"));
                            colleges.setCollegeAddress(jsonObject.getString("COLLEGE_ADDRESS"));
                            colleges.setUniversityId(jsonObject.getInt("UNIVERSITY_ID"));
                            Constant.LIST_COLLEGES.add(colleges);
                        }
                    }
                    if (iUniversal != null) {
                        iUniversal.changeListUniversal(Constant.LIST_COLLEGES);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void getCollegeStaffs(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_ALL_COLLEGES_STAFF);
        Constant.LIST_COLLEGES_STAFF.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                Object json = null;
                Colleges_Staff collegesStaff;
                try {
                    json = new JSONTokener(content).nextValue();
                    if (json instanceof JSONObject) {
                        collegesStaff = new Colleges_Staff();
                        collegesStaff.setCollegeStaffName(((JSONObject) json).getString("message"));
                        Constant.LIST_COLLEGES_STAFF.add(collegesStaff);
                    } else if (json instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) json;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            collegesStaff = new Colleges_Staff();
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            //COLLEGE_STAFF_ID,COLLEGE_STAFF_NAME,COLLEGE_STAFF_CONTACT,COLLEGE_STAFF_EMAIL,COLLEGE_ID
                            collegesStaff.setCollegeStaffId(jsonObject.getInt("COLLEGE_STAFF_ID"));
                            collegesStaff.setCollegeStaffName(jsonObject.getString("COLLEGE_STAFF_NAME"));
                            collegesStaff.setCollegeStaffContact(jsonObject.getString("COLLEGE_STAFF_CONTACT"));
                            collegesStaff.setCollegeStaffEmail(jsonObject.getString("COLLEGE_STAFF_EMAIL"));
                            collegesStaff.setCollegeId(jsonObject.getInt("COLLEGE_ID"));
                            Constant.LIST_COLLEGES_STAFF.add(collegesStaff);
                        }
                    }
                    if (iUniversal != null) {
                        iUniversal.changeListUniversal(Constant.LIST_COLLEGES_STAFF);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void getClasses(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_ALL_CLASSES);
        Constant.LIST_CLASSES.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                Object json = null;
                Classes classes;
                try {
                    json = new JSONTokener(content).nextValue();
                    if (json instanceof JSONObject) {
                        classes = new Classes();
                        classes.setClassName(((JSONObject) json).getString("message"));
                        Constant.LIST_CLASSES.add(classes);
                    } else if (json instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) json;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            classes = new Classes();
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            classes.setClassId(jsonObject.getInt("CLASS_ID"));
                            classes.setClassName(jsonObject.getString("CLASS_NAME"));
                            Constant.LIST_CLASSES.add(classes);
                        }
                    }
                    if (iUniversal != null) {
                        iUniversal.changeListUniversal(Constant.LIST_CLASSES);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void getSemisters(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_ALL_SEMISTER);
        Constant.LIST_SEMISTER.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                Object json = null;
                Semisters semisters;
                try {
                    json = new JSONTokener(content).nextValue();
                    if (json instanceof JSONObject) {
                        semisters = new Semisters();
                        semisters.setSemisterName(((JSONObject) json).getString("message"));
                        Constant.LIST_SEMISTER.add(semisters);
                    } else if (json instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) json;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            semisters = new Semisters();
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            //SEMISTER_ID,SEMISTER_NAME
                            semisters.setSemisterId(jsonObject.getInt("SEMISTER_ID"));
                            semisters.setSemisterName(jsonObject.getString("SEMISTER_NAME"));
                            Constant.LIST_SEMISTER.add(semisters);
                        }
                    }
                    if (iUniversal != null) {
                        iUniversal.changeListUniversal(Constant.LIST_SEMISTER);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void getStreams(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_ALL_STREAMS);
        Constant.LIST_STREAMS.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                Object json = null;
                Streams streams;
                try {
                    json = new JSONTokener(content).nextValue();
                    if (json instanceof JSONObject) {
                        streams = new Streams();
                        streams.setStreamName(((JSONObject) json).getString("message"));
                        Constant.LIST_STREAMS.add(streams);
                    } else if (json instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) json;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            streams = new Streams();
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            //STREAM_ID,STREAM_NAME
                            streams.setStreamID(jsonObject.getInt("STREAM_ID"));
                            streams.setStreamName(jsonObject.getString("STREAM_NAME"));

                            Constant.LIST_STREAMS.add(streams);
                        }
                    }
                    if (iUniversal != null) {
                        iUniversal.changeListUniversal(Constant.LIST_STREAMS);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void getDivisions(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_ALL_DIVISIONS);
        Constant.LIST_DIVISION.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                Object json = null;
                Divisions divisions;
                try {
                    json = new JSONTokener(content).nextValue();
                    if (json instanceof JSONObject) {
                        divisions = new Divisions();
                        divisions.setDivisionName(((JSONObject) json).getString("message"));
                        Constant.LIST_DIVISION.add(divisions);
                    } else if (json instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) json;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            divisions = new Divisions();
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            //DIVISION_ID,DIVISION_NAME
                            divisions.setDivisionId(jsonObject.getInt("DIVISION_ID"));
                            divisions.setDivisionName(jsonObject.getString("DIVISION_NAME"));
                            Constant.LIST_DIVISION.add(divisions);
                        }
                    }
                    if (iUniversal != null) {
                        iUniversal.changeListUniversal(Constant.LIST_DIVISION);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void getSubject(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_ALL_SUBJECTS);
        Constant.LIST_SUBJECTS.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                Object json = null;
                Subject subject;
                try {
                    json = new JSONTokener(content).nextValue();
                    if (json instanceof JSONObject) {
                        subject = new Subject();
                        subject.setSubjectName(((JSONObject) json).getString("message"));
                        Constant.LIST_SUBJECTS.add(subject);
                    } else if (json instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) json;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            subject = new Subject();
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            //SUBJECT_ID,SUBJECT_NAME,SEMISTER_ID,CLASS_ID,STREAM_ID
                            subject.setClassId(jsonObject.getInt("CLASS_ID"));
                            subject.setSemisterId(jsonObject.getInt("SEMISTER_ID"));
                            subject.setStreamId(jsonObject.getInt("STREAM_ID"));
                            subject.setSubjectId(jsonObject.getInt("SUBJECT_ID"));
                            subject.setSubjectName(jsonObject.getString("SUBJECT_NAME"));
                            Constant.LIST_SUBJECTS.add(subject);
                        }
                    }
                    if (iUniversal != null) {
                        iUniversal.changeListUniversal(Constant.LIST_SUBJECTS);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void getCollegeStaffSubject(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_ALL_COLLEGE_STAFF_SUBJECT_DETAILS);
        Constant.LIST_COLLEGE_STAFF_SUBJECTS.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                Object json = null;
                College_Staff_Subject_Details collegeStaffSubjectDetails;
                try {
                    json = new JSONTokener(content).nextValue();
                    if (json instanceof JSONObject) {
                        collegeStaffSubjectDetails = new College_Staff_Subject_Details();
                        //collegeStaffSubjectDetails.setSubjectId(((JSONObject) json).getString("message"));
                        collegeStaffSubjectDetails.setSubjectId(0);
                        Constant.LIST_COLLEGE_STAFF_SUBJECTS.add(collegeStaffSubjectDetails);
                    } else if (json instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) json;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            collegeStaffSubjectDetails = new College_Staff_Subject_Details();
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            //COLLEGE_STAFF_SUBJECT_ID,COLLEGE_STAFF_ID,SUBJECT_ID
                            collegeStaffSubjectDetails.setCollegeStaffId(jsonObject.getInt("COLLEGE_STAFF_SUBJECT_ID"));
                            collegeStaffSubjectDetails.setCollegeStaffSubjectId(jsonObject.getInt("COLLEGE_STAFF_ID"));
                            collegeStaffSubjectDetails.setSubjectId(jsonObject.getInt("SUBJECT_ID"));
                            Constant.LIST_COLLEGE_STAFF_SUBJECTS.add(collegeStaffSubjectDetails);
                        }
                    }
                    if (iUniversal != null) {
                        iUniversal.changeListUniversal(Constant.LIST_COLLEGE_STAFF_SUBJECTS);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void getStudents(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_All_STUDENT);
        Constant.LIST_STUDENT.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                Object json = null;
                Students students;
                try {
                    json = new JSONTokener(content).nextValue();
                    if (json instanceof JSONObject) {
                        students = new Students();
                        students.setStudentName(((JSONObject) json).getString("message"));
                        Constant.LIST_STUDENT.add(students);
                    } else if (json instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) json;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            students = new Students();
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            //STUDENT_ID,COLLEGE_ID,STUDENT_ROLL_NUMBER,STUDENT_NAME,STUDENT_CONTACT,STUDENT_EMAIL_ID,CLASS_ID,STREAM_ID,SEMISTER_ID,DIVISION_ID
                            students.setCollegeId(jsonObject.getInt("COLLEGE_ID"));
                            students.setClassId(jsonObject.getInt("CLASS_ID"));
                            students.setSemisterId(jsonObject.getInt("SEMISTER_ID"));
                            students.setStreamId(jsonObject.getInt("STREAM_ID"));
                            students.setDivisionId(jsonObject.getInt("DIVISION_ID"));
                            students.setStudentId(jsonObject.getInt("STUDENT_ID"));
                            students.setStudentName(jsonObject.getString("STUDENT_NAME"));
                            students.setStudentRollNumber(jsonObject.getString("STUDENT_ROLL_NUMBER"));
                            students.setStudentEmailId(jsonObject.getString("STUDENT_EMAIL_ID"));
                            students.setStudentContact(jsonObject.getString("STUDENT_CONTACT"));
                            Constant.LIST_STUDENT.add(students);
                        }
                    }
                    if (iUniversal != null) {
                        iUniversal.changeListUniversal(Constant.LIST_STUDENT);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void getAttendanceDetails(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_ATTENDANCE_DETAILS);
        Constant.LIST_ATTENDANCE_DETAILS.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                Object json = null;
                Attendance_Details attendanceDetails;
                try {
                    json = new JSONTokener(content).nextValue();
                    if (json instanceof JSONObject) {
                        attendanceDetails = new Attendance_Details();
                        //attendanceDetails.setStudentId(((JSONObject) json).getString("message"));
                        attendanceDetails.setStudentId(0);
                        Constant.LIST_ATTENDANCE_DETAILS.add(attendanceDetails);
                    } else if (json instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) json;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            attendanceDetails = new Attendance_Details();
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            SimpleDateFormat simpleDateForm = new SimpleDateFormat();
                            //SELECT `ATTENDANCE_ID`, `CREATED_DATETIME`, `COLLEGE_STAFF_ID`, `STUDENT_ID`, `SUBJECT_ID`, `ATTENDANCE_STATUS`, `REASONS`, `ATTENDANCE_DATETIME
                            attendanceDetails.setAttendanceId(jsonObject.getInt("ATTENDANCE_ID"));
                            attendanceDetails.setCreatedDateTime(new Date(jsonObject.getInt("CREATED_DATETIME")));
                            attendanceDetails.setCollegeStaffId(jsonObject.getInt("COLLEGE_STAFF_ID"));
                            attendanceDetails.setStudentId(jsonObject.getInt("STUDENT_ID"));
                            attendanceDetails.setSubjectId(jsonObject.getInt("SUBJECT_ID"));
                            attendanceDetails.setAttendanceStatus(jsonObject.getString("ATTENDANCE_STATUS"));
                            attendanceDetails.setReasons(jsonObject.getString("REASONS"));
                            attendanceDetails.setAttendanceDateTime(new Date(jsonObject.getString("ATTENDANCE_DATETIME")));
                            Constant.LIST_ATTENDANCE_DETAILS.add(attendanceDetails);
                        }
                    }
                    if (iUniversal != null) {
                        iUniversal.changeListUniversal(Constant.LIST_ATTENDANCE_DETAILS);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void setUniversites(Context context, final IUniversal iUniversal, Universities universities) {
        RequestParams params = new RequestParams();
        params.add("method", SET_UNIVERSITIES);
        params.add("univertsity_name", universities.getUniversityName());
        params.add("univertsity_code", universities.getUniversityCode());
        params.add("univertsity_contact", universities.getUniversityContact());
        params.add("univertsity_address", universities.getUniversityAddress());
        Constant.LIST_UNIVERSITIES.clear();
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                Object json = null;
                Universities universities;
                try {
                    JSONObject message = new JSONObject(content);
                    if (iUniversal != null) {
                        iUniversal.onUniversalMessage(message.getString("message"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void setColleges(Context context, final IUniversal iUniversal, Colleges colleges) {
        RequestParams params = new RequestParams();
        params.add("method", SET_COLLEGES);
        params.add("college_code", colleges.getCollegeCode());
        params.add("college_name", colleges.getCollegeName());
        params.add("college_address", colleges.getCollegeAddress());
        params.add("college_contact", colleges.getCollegeContact());
        params.add("univertsity_id", String.valueOf(colleges.getUniversityId()));
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                try {
                    JSONObject message = new JSONObject(content);
                    if (iUniversal != null) {
                        iUniversal.onUniversalMessage(message.getString("message"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void setCollegeStaff(Context context, final IUniversal iUniversal, Colleges_Staff collegesStaff) {
        RequestParams params = new RequestParams();
        params.add("method", SET_COLLEGE_STAFF);
        params.add("college_staff_name", collegesStaff.getCollegeStaffName());
        params.add("college_staff_contact", collegesStaff.getCollegeStaffContact());
        params.add("college_staff_email", collegesStaff.getCollegeStaffEmail());
        params.add("college_id", String.valueOf(collegesStaff.getCollegeId()));
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                try {
                    JSONObject message = new JSONObject(content);
                    if (iUniversal != null) {
                        iUniversal.onUniversalMessage(message.getString("message"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void setGetAllCollegeStaffSubjectDetails(Context context, final IUniversal iUniversal, College_Staff_Subject_Details collegeStaffSubjectDetails) {
        RequestParams params = new RequestParams();
        params.add("method", SET_COLLEGE_STAFF_SUBJECT_DETAILS);
        params.add("college_staff_id", String.valueOf(collegeStaffSubjectDetails.getCollegeStaffId()));
        params.add("subject_id", String.valueOf(collegeStaffSubjectDetails.getSubjectId()));
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                try {
                    JSONObject message = new JSONObject(content);
                    if (iUniversal != null) {
                        iUniversal.onUniversalMessage(message.getString("message"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void setStudents(Context context, final IUniversal iUniversal, Students students) {
        RequestParams params = new RequestParams();
        params.add("method", SET_STUDENT);
        // college_id , student_roll_number , student_name, student_contact, student_email_address, class_id, stream_id, semister_id ,division_id
        params.add("college_id", String.valueOf(students.getCollegeId()));
        params.add("student_roll_number", students.getStudentRollNumber());
        params.add("student_name", students.getStudentName());
        params.add("student_contact", students.getStudentContact());
        params.add("student_email_address", students.getStudentEmailId());
        params.add("class_id", String.valueOf(students.getClassId()));
        params.add("stream_id", String.valueOf(students.getStreamId()));
        params.add("semister_id", String.valueOf(students.getSemisterId()));
        params.add("division_id", String.valueOf(students.getDivisionId()));
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                try {
                    JSONObject message = new JSONObject(content);
                    if (iUniversal != null) {
                        iUniversal.onUniversalMessage(message.getString("message"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void setClasses(Context context, final IUniversal iUniversal, Classes classes) {
        RequestParams params = new RequestParams();
        params.add("method", SET_CLASS);
        params.add("class_name", classes.getClassName());
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                try {
                    JSONObject message = new JSONObject(content);
                    if (iUniversal != null) {
                        iUniversal.onUniversalMessage(message.getString("message"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void setSemister(Context context, final IUniversal iUniversal, Semisters semisters) {
        RequestParams params = new RequestParams();
        params.add("method", SET_SEMISTERS);
        params.add("semister_name", semisters.getSemisterName());
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                try {
                    JSONObject message = new JSONObject(content);
                    if (iUniversal != null) {
                        iUniversal.onUniversalMessage(message.getString("message"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void setStreams(Context context, final IUniversal iUniversal, Streams streams) {
        RequestParams params = new RequestParams();
        params.add("method", SET_STREAMS);
        params.add("stream_name", streams.getStreamName());
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                try {
                    JSONObject message = new JSONObject(content);
                    if (iUniversal != null) {
                        iUniversal.onUniversalMessage(message.getString("message"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void setDivisions(Context context, final IUniversal iUniversal, Divisions divisions) {
        RequestParams params = new RequestParams();
        params.add("method", SET_DIVISIONS);
        params.add("division_name", divisions.getDivisionName());
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                try {
                    JSONObject message = new JSONObject(content);
                    if (iUniversal != null) {
                        iUniversal.onUniversalMessage(message.getString("message"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void setSubjects(Context context, final IUniversal iUniversal, Subject subject) {
        RequestParams params = new RequestParams();
        params.add("method", SET_SUBJECT);
        //subject_name,semister_id,class_id,stream_id
        params.add("subject_name", subject.getSubjectName());
        params.add("semister_id", String.valueOf(subject.getSemisterId()));
        params.add("class_id", String.valueOf(subject.getClassId()));
        params.add("stream_id", String.valueOf(subject.getStreamId()));
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                try {
                    JSONObject message = new JSONObject(content);
                    if (iUniversal != null) {
                        iUniversal.onUniversalMessage(message.getString("message"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }

    public static void setAttendanceDetails(Context context, final IUniversal iUniversal, Attendance_Details attendanceDetails) {
        RequestParams params = new RequestParams();
        params.add("method", SET_ATTENDANCE_DETAILS);
        //college_staff_id
        //  student_id
        //  subject_id
        //  attendance_status
        //  reasons
        //  attendance_datetime
        params.add("college_staff_id", String.valueOf(attendanceDetails.getCollegeStaffId()));
        params.add("student_id", String.valueOf(attendanceDetails.getStudentId()));
        params.add("subject_id", String.valueOf(attendanceDetails.getSubjectId()));
        params.add("attendance_status", attendanceDetails.getAttendanceStatus());
        params.add("reasons", attendanceDetails.getReasons());
        params.add("attendance_datetime", String.valueOf(attendanceDetails.getAttendanceDateTime()));
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(context, SERVICE_URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.i("server Replay", content);
                try {
                    JSONObject message = new JSONObject(content);
                    if (iUniversal != null) {
                        iUniversal.onUniversalMessage(message.getString("message"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                Log.i("server Replay", content);
            }
        });
    }


}
