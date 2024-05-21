package com.example.mayorov_library;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BookAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.main_menu) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.library) {
            Intent intent = new Intent(this, BookStoreActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }

    public void add(View view) {
        EditText titleInput = findViewById(R.id.titleEditText);
        EditText authorInput = findViewById(R.id.authorEditText);
        EditText yearInput = findViewById(R.id.yearEditText);

        int year;
        try {
            year = Integer.parseInt(yearInput.getText().toString());
        } catch (Exception e) {
            return;
        }

        Intent intent = new Intent(this, LibraryActivity.class);
        intent.putExtra("title", titleInput.getText().toString());
        intent.putExtra("author", authorInput.getText().toString());
        intent.putExtra("year", year);

        startActivity(intent);
    }
}