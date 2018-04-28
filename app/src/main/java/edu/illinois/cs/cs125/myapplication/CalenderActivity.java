package edu.illinois.cs.cs125.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class CalenderActivity extends AppCompatActivity {
    CalendarView calendarView;
    Button reminder;
    Button toDo;
    Button kookyMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        reminder = (Button) findViewById(R.id.reminder);
        toDo = (Button) findViewById(R.id.toDo);
        kookyMode = (Button) findViewById(R.id.kookyMode);
//
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()) {
//            @Override
//            public void onSelectDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
//                String date = (i1 + 1) + "/" + i2 + "/" + i;
//            }
//        });
//
//    }
    }
}


