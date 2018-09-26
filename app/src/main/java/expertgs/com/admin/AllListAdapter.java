package expertgs.com.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Enumeration;

import expertgs.com.constant.Constant;
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
        return convertView;
    }


}
