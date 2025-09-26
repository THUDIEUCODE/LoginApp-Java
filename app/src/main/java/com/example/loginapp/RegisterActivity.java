package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Ánh xạ các trường nhập liệu (EditText) và nút Button
        EditText firstNameEt = findViewById(R.id.et_first_name);
        EditText lastNameEt = findViewById(R.id.et_last_name);
        EditText emailEt = findViewById(R.id.et_register_email);
        EditText passwordEt = findViewById(R.id.et_register_password);
        Button createAccountBtn = findViewById(R.id.btn_create_account_final);
        TextView signInTv = findViewById(R.id.tv_already_account);

        // 1. Xử lý sự kiện cho nút CREATE ACCOUNT
        createAccountBtn.setOnClickListener(v -> {
            String firstName = firstNameEt.getText().toString().trim();
            String lastName = lastNameEt.getText().toString().trim();
            String email = emailEt.getText().toString().trim();
            String password = passwordEt.getText().toString().trim();

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, R.string.msg_fill_all_fields, Toast.LENGTH_SHORT).show();
            } else if (password.length() < 6) {
                Toast.makeText(this, R.string.msg_password_length, Toast.LENGTH_SHORT).show();
            } else {
                // Đăng ký thành công và quay lại màn hình Login
                Toast.makeText(this, getString(R.string.msg_registration_success, email), Toast.LENGTH_LONG).show();
                finish();
            }
        });

        // 2. Xử lý sự kiện cho liên kết Sign In (quay lại Login)
        signInTv.setOnClickListener(v -> {
            finish();
        });
    }
}