package sg.edu.rp.c346.id19023702.week2lp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Task> tasks;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) this.findViewById(R.id.infoList);
        btnShare = (Button) findViewById(R.id.btnShare);

        aa = new TaskAdapter(this, R.layout.row_task, tasks);

        // Create a few food objects in Food array
        tasks = new ArrayList<Task>(tasks);
        tasks.add(new Task("Desc: Group Submission", "Date: 1 May 2021"));
        tasks.add(new Task("Desc: Assignment Submission", "Date: 5 May 2021"));
        tasks.add(new Task("Desc: Online Course", "Date: 19 Jun 2021"));

        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aa = new TaskAdapter(this, R.layout.row_task, tasks);
        lv.setAdapter(aa);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});

                String contents = "A task is shared with you from 19023702 \n\n";
                for (int i = 0; i < tasks.size(); i++) {
                    contents += tasks.get(i).getDesc() + "\n" + tasks.get(i).getDate();
                }
                email.putExtra(Intent.EXTRA_TEXT, contents);

                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }});
    }
}