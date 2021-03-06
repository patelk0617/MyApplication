package edu.illinois.cs.cs125.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReminder();
            }
        });

        toDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTodo();
            }
        });

        kookyMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKookyMode();
            }
        });




    }
    public void openReminder() {
        Intent intent = new Intent(this, ReminderActivity.class);
        startActivity(intent);
    }

    public void openTodo() {
        Intent intent = new Intent(this, TodoActivity.class);
        startActivity(intent);
    }

    public void openKookyMode() {
        Intent intent = new Intent(this, KookyActivity.class);
        startActivity(intent);
    }

}


