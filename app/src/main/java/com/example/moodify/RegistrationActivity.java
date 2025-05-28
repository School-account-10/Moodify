package com.example.moodify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {


    private EditText email_signin;
    private EditText pw_signin;
    private EditText confirm_pw;
    private Button create_acc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.registration);

        email_signin = findViewById(R.id.email_signin);
        pw_signin = findViewById(R.id.pw_signin);
        confirm_pw = findViewById(R.id.confirm_pw);
        create_acc = findViewById(R.id.create_acc);

        create_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usr_email = email_signin.getText().toString().trim();
                String usr_pw = pw_signin.getText().toString().trim();
                String pw_con = confirm_pw.getText().toString().trim();

                if (usr_email.isEmpty() || usr_pw.isEmpty() || pw_con.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!usr_pw.equals(pw_con)) {
                    Toast.makeText(RegistrationActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences prefs = getSharedPreferences("Moodify", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("email", usr_email);
                editor.putString("password", usr_pw);
                editor.apply();
                Toast.makeText(RegistrationActivity.this, "Account created successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistrationActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

    }
}