package com.example.rawda.database_apps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Internal_Storage extends AppCompatActivity implements View.OnClickListener {
    private EditText fileName, data;
    private Button save, read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        fileName = findViewById(R.id.file_name_editText);
        data = findViewById(R.id.data_editText);
        save = findViewById(R.id.save);
        read = findViewById(R.id.read);
        save.setOnClickListener(this);
        read.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.save:
                saveData();
                Toast.makeText(this, "File saved ...", Toast.LENGTH_LONG).show();
                break;
            case R.id.read:
                String txt = readData();
                Toast.makeText(this, txt, Toast.LENGTH_LONG).show();
                break;
        }
    }

    private String readData() {
        StringBuffer stringBuffer = new StringBuffer();
        String _fileName = fileName.getText().toString();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput(_fileName)));
            String dataString = "";
            while ((dataString = bufferedReader.readLine()) != null){
                stringBuffer.append(dataString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private void saveData() {
        String _fileName = fileName.getText().toString();
        String _data = data.getText().toString();
        try {
            FileOutputStream fos = openFileOutput(_fileName, MODE_PRIVATE);
            fos.write(_data.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            Log.d(Internal_Storage.class.getSimpleName(), "Input Output Exception");
            e.printStackTrace();
        }
    }
}

