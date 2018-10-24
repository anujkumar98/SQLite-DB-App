package com.example.anujkumar.mydbapp;


import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.anujkumar.mydbapp.database.MyDatabase;


public class MainActivity extends AppCompatActivity {

    MyDatabase ndb=new MyDatabase(this);
    Cursor cursor;
    SimpleCursorAdapter scu;
    ListView lv;
    EditText eName,eAddress,eSalary;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName=findViewById(R.id.name);
        eSalary=findViewById(R.id.salary);
        eAddress=findViewById(R.id.address);

        lv=findViewById(R.id.list);

        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=eName.getText().toString();
                String addr=eAddress.getText().toString();
                int sal=Integer.parseInt(eSalary.getText().toString());
                ContentValues cv = new ContentValues();
                cv.put("emp_name",name);
                cv.put("emp_location",addr);
                cv.put("emp_salary",sal);
                ndb.insertEmp(cv);
                eName.setText(null);
                eSalary.setText(null);
                eAddress.setText(null);
                cursor.requery();
            }
        });
        cursor=ndb.getEmp();

        String[] starr={"emp_name","emp_location","emp_salary"};
        int[] stint={R.id.tname,R.id.taddress,R.id.tsal};
        scu=new SimpleCursorAdapter(this,R.layout.row,cursor,starr,stint);

        lv.setAdapter(scu);
        scu.notifyDataSetChanged();
        cursor.requery();


    }
}
