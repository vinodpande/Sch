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

import expertgs.com.admin.IUniversal;
import expertgs.com.constant.Constant;
import expertgs.com.model.Colleges;
import expertgs.com.model.Colleges_Staff;
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
    public static void setUniversites(Context context, final IUniversal iUniversal,Universities universities) {
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
                    JSONObject message=new JSONObject(content);
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
                            colleges.setCollegeId(jsonObject.getInt("UNIVERSITY_ID"));
                            colleges.setCollegeName(jsonObject.getString("UNIVERSITY_CODE"));
                            colleges.setCollegeCode(jsonObject.getString("UNIVERSITY_NAME"));
                            colleges.setCollegeContact(jsonObject.getString("UNIVERSITY_CONTACT"));
                            colleges.setCollegeAddress(jsonObject.getString("UNIVERSITY_ADDRESS"));
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
                            collegesStaff.setCollegeStaffId(jsonObject.getInt("UNIVERSITY_ID"));
                            collegesStaff.setCollegeStaffName(jsonObject.getString("UNIVERSITY_CODE"));
                            collegesStaff.setCollegeStaffContact(jsonObject.getString("UNIVERSITY_NAME"));
                            collegesStaff.setCollegeStaffEmail(jsonObject.getString("UNIVERSITY_CONTACT"));
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
        params.add("method", GET_UNIVERSITIES);
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
    public static void getStreams(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_UNIVERSITIES);
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
    public static void getDivisions(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_UNIVERSITIES);
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
    public static void getSubject(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_UNIVERSITIES);
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
    public static void getCollegeStaffSubject(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_UNIVERSITIES);
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
    public static void getCollegeStudent(Context context, final IUniversal iUniversal) {
        RequestParams params = new RequestParams();
        params.add("method", GET_UNIVERSITIES);
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
}
