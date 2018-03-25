package com.example.android.afiframadhan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddTodo extends AppCompatActivity {

    private EditText editTextName, editTextDescription, editTextPriority;       // Inisialisasi variabel untuk objek EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        editTextName = (EditText)findViewById(R.id.etName);             // findViewById etName
        editTextDescription = (EditText)findViewById(R.id.etDesc);      // findViewById etDesc
        editTextPriority = (EditText)findViewById(R.id.etPriority);     // findViewById etPriority
    }

    public void addTodo(View view) {
        Intent intent = new Intent();       // Membuat Object Intent
        intent.putExtra("name", editTextName.getText().toString());          // Set Data dari getText yang diinput pada etNAme
        intent.putExtra("desc", editTextDescription.getText().toString());   // Set Data dari getText yang diinput pada etDesc
        intent.putExtra("priority", editTextPriority.getText().toString());     // Set Data dari getText yang diinput pada etPriority
        setResult(1,intent);        // Set Result = 1
        finish();           // Finishing activity
    }
}
