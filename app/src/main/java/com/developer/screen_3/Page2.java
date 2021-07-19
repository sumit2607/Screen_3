package com.developer.screen_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Page2 extends AppCompatActivity {

    EditText editText_PersonName, editText_LastName, editText_Email, editText_Phone, editText_NoOfSeats, editText_Date;
    Button button_mbtnLogin2;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_PERSONNAME = "firstname";
    private static final String KEY_LASTNAME = "lastname";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_NoOfSeats = "noOfSeats";
    private static final String KEY_DATE = "date";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        editText_PersonName = findViewById(R.id.edit_PersonName);
        editText_LastName = findViewById(R.id.edit_LastName);
        editText_Phone = findViewById(R.id.edit_Phone);
        editText_Email = findViewById(R.id.edit_Email);
        editText_NoOfSeats = findViewById(R.id.edit_NoOfSeats);
        editText_Date = findViewById(R.id.edit_Date);
        button_mbtnLogin2 = findViewById(R.id.mbtnLogin2);

        sharedPreferences = getSharedPreferences( SHARED_PREF_NAME, MODE_PRIVATE);

        String personname = sharedPreferences.getString(KEY_PERSONNAME, null);
        String lastname = sharedPreferences.getString(KEY_LASTNAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);
        String phone = sharedPreferences.getString(KEY_PHONE, null);
        String noOfSeats = sharedPreferences.getString(KEY_NoOfSeats, null);
        String date = sharedPreferences.getString(KEY_DATE, null);


        button_mbtnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_PERSONNAME, editText_PersonName.getText().toString());
                editor.putString(KEY_LASTNAME, editText_LastName.getText().toString());
                editor.putString(KEY_EMAIL, editText_Email.getText().toString());
                editor.putString(KEY_PHONE, editText_Phone.getText().toString());
                editor.putString(KEY_NoOfSeats, editText_Phone.getText().toString());
                editor.putString(KEY_DATE, editText_Phone.getText().toString());

                editor.apply();
                Intent intent = new Intent(Page2.this, Page3.class);
                startActivity(intent);

                Toast.makeText(Page2.this, "Login Success", Toast.LENGTH_SHORT).show();

            }
        });

    }
}