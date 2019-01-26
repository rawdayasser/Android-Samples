package com.example.rawda.database_apps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class External_Storage extends AppCompatActivity implements View.OnClickListener {
    private Button read_button, save_button;
    private EditText fileName, data;
    private String filePath;
    private File file_dir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);
        read_button = findViewById(R.id.read);
        save_button = findViewById(R.id.save);
        fileName = findViewById(R.id.file_name_editText);
        data = findViewById(R.id.data_editText);
        make_dir();
        read_button.setOnClickListener(this);
        save_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.save:
                saveData();
                Toast.makeText(this, "Data Saved ...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.read:
                String data = readData();
                Toast.makeText(this, "data: " + data, Toast.LENGTH_LONG).show();
                break;
        }
    }
    private void make_dir()
    {
        file_dir = new File(String.valueOf(getFilesDir()));
        if (!file_dir.exists())
            file_dir.mkdir();
        filePath = file_dir.toString();

    }
    private void saveData() {

        File file = new File(filePath + fileName.getText().toString());
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.append(data.getText().toString());
            outputStreamWriter.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return String
     * data read from file
     */
    private String readData() {
       File file = new File(filePath + fileName.getText().toString());
        FileInputStream fileInputStream = null;
        String _data = "";
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader buffer = new BufferedReader(inputStreamReader);
            String bufferStr;
            while ((bufferStr = buffer.readLine())!= null){
                _data +=  "\n" + bufferStr;
            }
            fileInputStream.close();
            inputStreamReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return _data;
    }
}
