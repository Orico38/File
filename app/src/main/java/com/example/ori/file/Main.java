package com.example.ori.file;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main extends AppCompatActivity {
    EditText et;
    String string;
    FileOutputStream fos;
    OutputStreamWriter osw;
    BufferedWriter bw;
    TextView tv;
    InputStream is;
    InputStreamReader tmp;
    BufferedReader reader;
    String str;
    StringBuffer buffer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)(findViewById(R.id.textView));
        et= (EditText)(findViewById(R.id.ed));

    }

    public void write(View view) {

        string = et.getText().toString();
        try {
            fos = openFileOutput(string, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        osw = new OutputStreamWriter(fos);
        bw = new BufferedWriter(osw);
        try {
            bw.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(View view) {

        try {
            is = openFileInput(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        tmp = new InputStreamReader(is);
        reader = new BufferedReader(tmp);
        buffer = new StringBuffer();
        try {
            while ((str = reader.readLine()) != null) {
                buffer.append(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv.setText(buffer);
    }


}
