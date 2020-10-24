package in.finertia.fisheries.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import in.finertia.fisheries.R;
import in.finertia.fisheries.databinding.ActivityTrainingCalBinding;

public class TrainingCalenderActivity extends AppCompatActivity {

    private ActivityTrainingCalBinding binding;
    private List<EventDay> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrainingCalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        events = new ArrayList<>();
        initCalender();
    }

    private void initCalender() {
        Calendar calendar = Calendar.getInstance();
        try {
            binding.calendarView.setDate(calendar);
        } catch (OutOfDateRangeException e) {
            e.printStackTrace();
        }
        events.add(new EventDay(calendar, R.drawable.ic_training_calendar));
        binding.calendarView.setEvents(events);
        binding.calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                if(Calendar.getInstance().get(Calendar.DATE)==eventDay.getCalendar().get(Calendar.DATE)){
//                    Toast.makeText(TrainingCalenderActivity.this, "success", Toast.LENGTH_SHORT).show();
                    showAlertDialog();
                }
//                Calendar clickedDayCalendar = eventDay.getCalendar();
//                showAlertDialog(clickedDayCalendar);
            }
        });
    }

    /*private void showAlertDialog(final Calendar clickedDayCalendar) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
        final LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.attendance_dialog_layout, null);
        Button btnOk = v.findViewById(R.id.btnMark);
        final RadioGroup radioButton = v.findViewById(R.id.rg_attendance);
        builder.setView(v);
        builder.create();
        final AlertDialog dialog = builder.show();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                if (radioButton.getCheckedRadioButtonId() == R.id.rb_open) {
                    events.add(new EventDay(clickedDayCalendar, R.drawable.present_icon));
                    binding.calendarView.setEvents(events);
                } else if (radioButton.getCheckedRadioButtonId() == R.id.rb_not_open) {
                    events.add(new EventDay(clickedDayCalendar, R.drawable.not_present_icon));
                    binding.calendarView.setEvents(events);
                } else if (radioButton.getCheckedRadioButtonId() == R.id.rb_holiday){
                    events.add(new EventDay(clickedDayCalendar, R.drawable.holiday_icon));
                    binding.calendarView.setEvents(events);
                }
            }
        });

    }*/
    private void showAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
        final LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_layout, null);
        TextView tvTitle = v.findViewById(R.id.tvTitle);
        TextView tvMsg = v.findViewById(R.id.tvMsg);
        Button btnOk = v.findViewById(R.id.btnPositive);
        tvTitle.setText("Training schedule");
        tvMsg.setText("Fish suppliers training will start from 9 AM to 13 PM");
        builder.setView(v);
        builder.create();
        builder.setCancelable(false);
        final AlertDialog dialog = builder.show();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }


}