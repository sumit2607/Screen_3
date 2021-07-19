package com.developer.screen_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Page3 extends AppCompatActivity {
    TextView TextView_FirstName, TextView_LastName, TextView_Email, TextView_Phone, TextView_NoOfSeats, TextView_Date;
    Button button_mbtnLogin3;
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
        setContentView(R.layout.activity_page3);
        TextView_FirstName = findViewById(R.id.firstname);
        TextView_LastName = findViewById(R.id.lastname);
        TextView_Phone = findViewById(R.id.email);
        TextView_Email = findViewById(R.id.phone);
        TextView_NoOfSeats = findViewById(R.id.seats);
        TextView_Date = findViewById(R.id.date);
        button_mbtnLogin3 = findViewById(R.id.mbtnLogin3);

        sharedPreferences = getSharedPreferences( SHARED_PREF_NAME, MODE_PRIVATE);

        String personname = sharedPreferences.getString(KEY_PERSONNAME, null);
        String lastname = sharedPreferences.getString(KEY_LASTNAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);
        String phone = sharedPreferences.getString(KEY_PHONE, null);
        String noOfSeats = sharedPreferences.getString(KEY_NoOfSeats, null);
        String date = sharedPreferences.getString(KEY_DATE, null);

        if(personname!=null || lastname!=null || email!=null || phone!=null || noOfSeats!=null || date!=null){
            TextView_FirstName.setText("First Name -"+personname);
            TextView_LastName.setText("Last Name -"+lastname);
            TextView_Email.setText("Email -"+email);
            TextView_Phone.setText("Phone Number -"+phone);
            TextView_NoOfSeats.setText("NoOfSeats -"+noOfSeats);
            TextView_Date.setText("DateOfShow -"+date);
        }

                button_mbtnLogin3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.commit();
                        finish();

                        Toast.makeText(Page3.this, "Login Success", Toast.LENGTH_SHORT).show();

                    }
                });


            }

}


