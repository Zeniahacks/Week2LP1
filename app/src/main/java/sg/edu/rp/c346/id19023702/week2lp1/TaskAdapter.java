package sg.edu.rp.c346.id19023702.week2lp1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> tasks;
    private Context context;
    private TextView tvDesc, tvDate, tvItem;
    private Button btnShare;

    public TaskAdapter(@NonNull Context context, int resource, ArrayList<Task> tasks) {
        super(context, resource, tasks);

        this.tasks = tasks;

        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_task, parent, false);

        tvDesc = (TextView) rowView.findViewById(R.id.tvDesc);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        tvItem = (TextView) rowView.findViewById(R.id.tvItem);
        btnShare = (Button) rowView.findViewById(R.id.btnShare);

        Task task = tasks.get(position);

        String weekNumber = Integer.toString(position + 1);
        tvDesc.setText(task.getDesc());
        tvDate.setText(task.getDate());
        tvItem.setText("Week " + weekNumber);


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "A task is shared with you from 19023702");

                String contents = task.getDesc() + "\n" + task.getDate();
                email.putExtra(Intent.EXTRA_TEXT, contents);

                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                context.startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }});

        return rowView;
    }
}
