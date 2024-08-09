package com.forrestgump.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateTaskActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextDescription;
    private Button buttonSave;
    private AppDatabase db;
    private ExecutorService executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        db = AppDatabase.getInstance(this);
        executor = Executors.newSingleThreadExecutor();

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(v -> {
            String title = editTextTitle.getText().toString();
            String description = editTextDescription.getText().toString();

            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
                Toast.makeText(CreateTaskActivity.this, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
                return;
            }

            Task task = new Task(title, description);

            executor.execute(() -> {
                db.taskDao().insert(task);
                runOnUiThread(() -> {
                    Toast.makeText(CreateTaskActivity.this, "Tarefa adicionada", Toast.LENGTH_SHORT).show();
                    finish();
                });
            });
        });
    }
}
