package com.example.test_login;

    import android.os.Bundle;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.view.WindowCompat;

    import com.google.android.material.button.MaterialButton;
    import com.google.android.material.textfield.TextInputEditText;
    import com.google.android.material.textfield.TextInputLayout;
    import android.content.Intent;

    public class MainActivity extends AppCompatActivity {

        private TextInputLayout tilEmail, tilPassword;
        private TextInputEditText etEmail, etPassword;
        private MaterialButton btnLogin, btnRegister;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Configurar Edge-to-Edge display para Material Design 3
            WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

            setContentView(R.layout.activity_main);

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
                    // Implementar autenticación con animación de carga
                    btnLogin.setEnabled(false);
                    btnLogin.setText("Iniciando sesión...");

                    // Simular proceso de login - aquí implementarías tu lógica real
                    v.postDelayed(() -> {
                        // Iniciar la actividad de inicio después de un login exitoso
                        Intent intent = new Intent(MainActivity.this, InicioActivity.class);
                        startActivity(intent);

                        // Opcional: muestra un mensaje de éxito
                        Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                        // Restablecer el botón (aunque no se verá si navegas a otra actividad)
                        btnLogin.setEnabled(true);
                        btnLogin.setText("Iniciar sesión");

                        // Opcional: si quieres que MainActivity no quede en el historial de navegación
                        // finish();
                    }, 1500);
                }
            });

            btnRegister.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
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