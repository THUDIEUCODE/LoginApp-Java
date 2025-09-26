package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button; // Cần import
import android.widget.EditText; // Cần import
import android.widget.TextView;
import android.widget.Toast; // Cần import

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến thành phần giao diện
    private EditText etEmail;
    private EditText etPassword;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Ánh xạ các thành phần giao diện (Find Views by ID)
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnSignIn = findViewById(R.id.btn_sign_in);
        TextView createAccountTv = findViewById(R.id.tv_create_account);

        // 2. Xử lý sự kiện khi nhấn nút SIGN IN
        btnSignIn.setOnClickListener(v -> {
            // Lấy giá trị từ EditTexts
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Logic kiểm tra rỗng cơ bản
            if (email.isEmpty() || password.isEmpty()) {
                // Hiển thị thông báo nếu thiếu dữ liệu
                Toast.makeText(this, "Vui lòng nhập đầy đủ Email và Mật khẩu!", Toast.LENGTH_SHORT).show();
            } else {
                // Nếu đủ, hiển thị thông báo "Đang đăng nhập..."
                Toast.makeText(this, "Đang đăng nhập với Email: " + email, Toast.LENGTH_LONG).show();

                // Ở project thực tế, bạn sẽ gọi API đăng nhập tại đây.
                // Ở đây, chúng ta chỉ dừng lại ở thông báo Toast.
            }
        });

        // 3. Xử lý sự kiện chuyển sang màn hình Register (đã có)
        createAccountTv.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}