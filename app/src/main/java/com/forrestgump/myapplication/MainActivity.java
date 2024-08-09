package com.forrestgump.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private List<Task> taskList;
    private AppDatabase db;
    private ExecutorService executor;
    private Button buttonCreateTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInstance(this);
        executor = Executors.newSingleThreadExecutor();


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        taskList = new ArrayList<>();
        adapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(adapter);

        executor.execute(() -> {
            List<Task> tasks = db.taskDao().getAllTasks();
            taskList.addAll(tasks);
            runOnUiThread(() -> adapter.notifyDataSetChanged());
        });

        buttonCreateTask = findViewById(R.id.buttonCreateTask);
        buttonCreateTask.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateTaskActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        taskList.clear();
        executor.execute(() -> {
            List<Task> tasks = db.taskDao().getAllTasks();
            taskList.addAll(tasks);
            runOnUiThread(() -> adapter.notifyDataSetChanged());
        });
    }
}
