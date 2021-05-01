package sg.edu.rp.c346.id19023702.week2lp1;

import android.content.Context;
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

        return rowView;
    }
}
