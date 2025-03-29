package com.example.test_login;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilEmail, tilPassword;
    private TextInputEditText etEmail, etPassword;
    private MaterialButton btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar vistas
        initViews();

        // Configurar listeners
        setupListeners();
    }

    private void initViews() {
        tilEmail = findViewById(R.id.til_email);
        tilPassword = findViewById(R.id.til_password);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
    }

    private void setupListeners() {
        btnLogin.setOnClickListener(v -> {
            if (validateInputs()) {
                // Aquí implementarías la lógica de inicio de sesión
                Toast.makeText(MainActivity.this, "Iniciando sesión...", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(v -> {
            // Aquí navegarías a la pantalla de registro
            Toast.makeText(MainActivity.this, "Ir a pantalla de registro", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.tv_forgot_password).setOnClickListener(v -> {
            // Aquí navegarías a la pantalla de recuperación de contraseña
            Toast.makeText(MainActivity.this, "Recuperar contraseña", Toast.LENGTH_SHORT).show();
        });
    }

    private boolean validateInputs() {
        boolean isValid = true;

        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Validar email
        if (email.isEmpty()) {
            tilEmail.setError("Ingresa tu correo electrónico");
            isValid = false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.setError("Ingresa un correo electrónico válido");
            isValid = false;
        } else {
            tilEmail.setError(null);
        }

        // Validar contraseña
        if (password.isEmpty()) {
            tilPassword.setError("Ingresa tu contraseña");
            isValid = false;
        } else if (password.length() < 6) {
            tilPassword.setError("La contraseña debe tener al menos 6 caracteres");
            isValid = false;
        } else {
            tilPassword.setError(null);
        }

        return isValid;
    }
}