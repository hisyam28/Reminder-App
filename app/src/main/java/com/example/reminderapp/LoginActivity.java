package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

//    deklarasi class view
    EditText etUserName;
    EditText etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        insiasi view
        etUserName = findViewById(R.id.et_usernm);
        etPassword = findViewById(R.id.et_pass);
        btnLogin = findViewById(R.id.btn_login);

//        membuat btnlogin dapat diklik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                 deklarasi local variable
                String username;
                String password;
//                mengambil value dari edittext
                username = etUserName.getText().toString().trim();
                password = etPassword.getText().toString();
//                mengecek apabila username & password = admin
                if(username.equals("admin")&& password.equals("admin")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Username/password anda salah",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
