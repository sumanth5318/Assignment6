package com.example.assignment6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText number;
    ListView simplelist;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.no_et);
        simplelist = findViewById(R.id.listview);
        add = findViewById(R.id.addname);
        add.setOnClickListener(view -> {
//                String Name = number.getText().toString();
                ArrayList<String> listname=new ArrayList<>();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listname);
                simplelist.setAdapter(adapter);
                int num = Integer.parseInt(number.getText().toString());
                for(int i = 1;i<=10;i++) {
                    listname.add(""+(num*i));
                }
                adapter.notifyDataSetChanged();
                number.setText("");
            simplelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this, listname.get(position), Toast.LENGTH_SHORT).show();
                    listname.remove(position);
                    adapter.notifyDataSetChanged();
                }
            });
        });
    }
}