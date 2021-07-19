package com.developer.screen_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     private Button mbtnLogin;

     EditText editText_PersonName, editText_LastName, editText_Email, editText_Phone;
     Button button_mbtnLogin;
     SharedPreferences sharedPreferences;

     private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_PERSONNAME = "firstname";
    private static final String KEY_LASTNAME = "lastname";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_PersonName = findViewById(R.id.edit_PersonName);
        editText_LastName = findViewById(R.id.edit_LastName);
        editText_Phone = findViewById(R.id.edit_Phone);
        editText_Email = findViewById(R.id.edit_Email);
        button_mbtnLogin = findViewById(R.id.mbtnLogin);

        SharedPreferences sharedPreferences = getSharedPreferences( SHARED_PREF_NAME, MODE_PRIVATE);
        /*if(personname!=null || lastname!=null || email!=null || phone!=null){
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }*/
                mbtnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(KEY_PERSONNAME, editText_PersonName.getText().toString());
                        editor.putString(KEY_LASTNAME, editText_LastName.getText().toString());
                        editor.putString(KEY_EMAIL, editText_Email.getText().toString());
                        editor.putString(KEY_PHONE, editText_Phone.getText().toString());
                        editor.apply();
                        Intent intent = new Intent(MainActivity.this, Page2.class);
                        startActivity(intent);

                        Toast.makeText(MainActivity.this, "Detail Entered Success", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}

