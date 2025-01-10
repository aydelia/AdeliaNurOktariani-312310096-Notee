package com.example.notee;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText etLoginUsername, etLoginPassword;
    private Button btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeViews();
        setupListeners();
    }

    private void initializeViews() {
        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnMasuk = findViewById(R.id.btnMasuk);
    }

    private void setupListeners() {
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    Intent intent = new Intent(LoginActivity.this, NotesActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean validateInputs() {
        String username = etLoginUsername.getText().toString().trim();
        String password = etLoginPassword.getText().toString().trim();

        if (username.isEmpty()) {
            etLoginUsername.setError("Username tidak boleh kosong");
            return false;
        }

        if (password.isEmpty()) {
            etLoginPassword.setError("Password tidak boleh kosong");
            return false;
        }

        return true;
    }
}
