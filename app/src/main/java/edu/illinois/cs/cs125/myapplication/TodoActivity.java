package edu.illinois.cs.cs125.myapplication;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;


public class TodoActivity extends AppCompatActivity {
    DbHelper dbHelper;
    ArrayAdapter<String> adapter;
    ListView listItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        dbHelper = new DbHelper(this);
        listItems = (ListView) findViewById(R.id.listItems);

        showItemList();
    }

    private void showItemList() {
        ArrayList<String> itemList = dbHelper.getTodoList();
        if(adapter==null) {
            adapter = new ArrayAdapter<String>(this, R.layout.rowtodo, R.id.itemTitle, itemList);
            listItems.setAdapter(adapter);
        } else {
            adapter.clear();
            adapter.addAll(itemList);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        Drawable icon = menu.getItem(0).getIcon();
        icon.mutate();
        if (Build.VERSION.SDK_INT >= M) {
            icon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        }
        return super.onCreateOptionsMenu(menu);
    }

}
