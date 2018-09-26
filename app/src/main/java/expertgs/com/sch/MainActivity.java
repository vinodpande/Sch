package expertgs.com.sch;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import expertgs.com.admin.AdminActivity;
import expertgs.com.webservices.WebSchoolAttendanceAPI;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this,AdminActivity.class));
    }
}
