package com.example.lesson32;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private EditText edUserName, edUserPassword;
    private TextView tvResult;
    private Button btnSave, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFindUI();

        sharedPreferences = getSharedPreferences("byteland",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btnSave.setOnClickListener(view -> {
            String userName = edUserName.getText().toString();
            String userPassword = edUserPassword.getText().toString();

            editor.putString("key_1",userName);
            editor.putString("key_2",userPassword);
            editor.commit();

        });

        btnShow.setOnClickListener(view -> {

                String getUserName = sharedPreferences.getString("key_1","");
                String getUserPassword = sharedPreferences.getString("key_2","");

                if (getUserName.equals("") || getUserPassword.equals("")){
                    tvResult.setText("empty");
                } else  {
                    tvResult.setText(getUserName + " " + getUserPassword);
                }

        });


    }

    private void loadFindUI() {
        edUserName = findViewById(R.id.edUserName);
        edUserPassword = findViewById(R.id.edUserPassword);
        btnSave = findViewById(R.id.btnSave);
        tvResult = findViewById(R.id.tvResult);
        btnShow = findViewById(R.id.btnShow);
    }


}