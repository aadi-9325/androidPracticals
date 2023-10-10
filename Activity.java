package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et_name,et_email,et_mo;
Button save_btn;
public static final String MyPREFERENCES = "MyPrefs";
    public static final String Email = "EmailKey";
    public static final String Phone = "PhoneKey";
    public static final String Name = "NameKey";

    SharedPreferences sp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name =(EditText) findViewById(R.id.et_name);
        et_email =(EditText) findViewById(R.id.et_email);
        et_mo = (EditText) findViewById(R.id.mo_no);
        save_btn = (Button) findViewById(R.id.btn_save);
        sp = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = et_name.getText().toString();
                String ph = et_mo.getText().toString();
                String email =et_email.getText().toString();

            SharedPreferences.Editor editor = sp.edit();
            editor.putString(Name,n);
                editor.putString(Email,email);
                editor.putString(Phone,ph);
                editor.apply();
                Toast.makeText(MainActivity.this, "Details Saved SuccesFully", Toast.LENGTH_LONG).show();
            }
        });
    }
}
