package expertgs.com.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
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

public class AllListAdapter extends BaseAdapter {
    Context context;
    ArrayList list;

    public AllListAdapter(Context context,ArrayList list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.all_list_view_admin, parent, false);
        }
        Object obj=getItem(position);
        if(obj instanceof Universities){
            Universities universities= (Universities) list.get(position);
            TextView id=convertView.findViewById(R.id.item_view_id);
            id.setText(String.valueOf(universities.getUniversityId()));
            TextView name=convertView.findViewById(R.id.item_view_name);
            name.setText(universities.getUniversityName());
        }
        if(obj instanceof Colleges){
            Colleges colleges= (Colleges) list.get(position);
            TextView id=convertView.findViewById(R.id.item_view_id);
            id.setText(String.valueOf(colleges.getCollegeId()));
            TextView name=convertView.findViewById(R.id.item_view_name);
            name.setText(colleges.getCollegeName());
        }
        if(obj instanceof Colleges_Staff){
            Colleges_Staff collegesStaff= (Colleges_Staff) list.get(position);
            TextView id=convertView.findViewById(R.id.item_view_id);
            id.setText(String.valueOf(collegesStaff.getCollegeStaffId()));
            TextView name=convertView.findViewById(R.id.item_view_name);
            name.setText(collegesStaff.getCollegeStaffName());
        }
        if(obj instanceof College_Staff_Subject_Details){
            College_Staff_Subject_Details collegeStaffSubjectDetails= (College_Staff_Subject_Details) list.get(position);
            TextView id=convertView.findViewById(R.id.item_view_id);
            id.setText(String.valueOf(collegeStaffSubjectDetails.getCollegeStaffSubjectId()));
            TextView name=convertView.findViewById(R.id.item_view_name);
            name.setText(String.valueOf(collegeStaffSubjectDetails.getSubjectId()));
        }
        if(obj instanceof Subject){
            Subject subject= (Subject) list.get(position);
            TextView id=convertView.findViewById(R.id.item_view_id);
            id.setText(String.valueOf(subject.getSubjectId()));
            TextView name=convertView.findViewById(R.id.item_view_name);
            name.setText(subject.getSubjectName());
        }
        if(obj instanceof Semisters){
            Semisters semisters= (Semisters) list.get(position);
            TextView id=convertView.findViewById(R.id.item_view_id);
            id.setText(String.valueOf(semisters.getSemisterId()));
            TextView name=convertView.findViewById(R.id.item_view_name);
            name.setText(semisters.getSemisterName());
        }
        if(obj instanceof Classes){
            Classes classes= (Classes) list.get(position);
            TextView id=convertView.findViewById(R.id.item_view_id);
            id.setText(String.valueOf(classes.getClassId()));
            TextView name=convertView.findViewById(R.id.item_view_name);
            name.setText(classes.getClassName());
        }
        if(obj instanceof Streams){
            Streams streams= (Streams) list.get(position);
            TextView id=convertView.findViewById(R.id.item_view_id);
            id.setText(String.valueOf(streams.getStreamID()));
            TextView name=convertView.findViewById(R.id.item_view_name);
            name.setText(streams.getStreamName());
        }
        if(obj instanceof Divisions){
            Divisions divisions= (Divisions) list.get(position);
            TextView id=convertView.findViewById(R.id.item_view_id);
            id.setText(String.valueOf(divisions.getDivisionId()));
            TextView name=convertView.findViewById(R.id.item_view_name);
            name.setText(divisions.getDivisionName());
        }
        if(obj instanceof Students){
            Students students= (Students) list.get(position);
            TextView id=convertView.findViewById(R.id.item_view_id);
            id.setText(String.valueOf(students.getStudentId()));
            TextView name=convertView.findViewById(R.id.item_view_name);
            name.setText(students.getStudentName());
        }
        return convertView;
    }
}
