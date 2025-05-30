package com.example.moodify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {


    private EditText email_login;
    private EditText pw_login;
    private Button Login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.log_in);

        email_login = findViewById(R.id.email_login);
        pw_login = findViewById(R.id.pw_login);
        Login = findViewById(R.id.Login);
        register = findViewById(R.id.register);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_login.getText().toString().trim();
                String pw = pw_login.getText().toString().trim();

                if(email.isEmpty() || pw.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Enter email and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences prefs = getSharedPreferences("Moodify", MODE_PRIVATE);
                String savedEmail = prefs.getString("email", "");
                String savedPass = prefs.getString("password", "");
                if(email.equals(savedEmail) && pw.equals(savedPass)){
                    Toast.makeText(MainActivity2.this, "Login successful!", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(MainActivity2.this, "incorrect password or email", Toast.LENGTH_SHORT).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}