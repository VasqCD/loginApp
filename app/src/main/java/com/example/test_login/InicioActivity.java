package com.example.test_login;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        // Configurar la barra de herramientas
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configurar el RecyclerView (puedes implementar esto más tarde)
        setupRecyclerView();

        // Configurar listeners de botones
        setupListeners();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Toast.makeText(this, "Búsqueda seleccionada", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_notifications) {
            Toast.makeText(this, "Notificaciones seleccionadas", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_settings) {
            Toast.makeText(this, "Configuración seleccionada", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_help) {
            Toast.makeText(this, "Ayuda seleccionada", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_about) {
            Toast.makeText(this, "Acerca de seleccionado", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupRecyclerView() {
        // Aquí implementarías el adaptador para el RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv_recent_activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Ejemplo: recyclerView.setAdapter(new ActivityAdapter(getActivities()));
    }

    private void setupListeners() {
        findViewById(R.id.btn_logout).setOnClickListener(v -> {
            // Implementar lógica de cierre de sesión
            Toast.makeText(this, "Cerrando sesión...", Toast.LENGTH_SHORT).show();
            finish();
        });

        findViewById(R.id.card_action1).setOnClickListener(v -> {
            Toast.makeText(this, "Mi Perfil", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.card_action2).setOnClickListener(v -> {
            Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.card_action3).setOnClickListener(v -> {
            Toast.makeText(this, "Notificaciones", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.card_action4).setOnClickListener(v -> {
            Toast.makeText(this, "Ayuda", Toast.LENGTH_SHORT).show();
        });
    }
}