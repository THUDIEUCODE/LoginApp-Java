package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText; // Thêm
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        EditText emailEt = findViewById(R.id.et_email);
        EditText passwordEt = findViewById(R.id.et_password);
        Button signInBtn = findViewById(R.id.btn_sign_in);
        TextView createAccountTv = findViewById(R.id.tv_create_account);

        // 1. Xử lý sự kiện cho nút SIGN IN
        signInBtn.setOnClickListener(v -> {
            String email = emailEt.getText().toString().trim();
            String password = passwordEt.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, R.string.msg_fill_all_fields, Toast.LENGTH_SHORT).show();
            } else {
                // Logic đăng nhập đơn giản: chỉ thông báo và không kiểm tra
                Toast.makeText(this, R.string.msg_signing_in, Toast.LENGTH_SHORT).show();
                // TODO: Thêm logic chuyển sang HomeActivity ở đây
            }
        });

        // 2. Xử lý sự kiện cho TextView "Create Account"
        createAccountTv.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}