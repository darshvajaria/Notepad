package com.example.darshvajaria.notepad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {
    Button btn;
    String h;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.exportbtn);
        result = (TextView) findViewById(R.id.resulttxt);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    h = DateFormat.format("MM-dd-yyyyy-hh:mm:ssaa", System.currentTimeMillis()).toString();
                    // this will create a new name everytime and unique
                    File root = new File(Environment.getExternalStorageDirectory(), "Notes");
                    // if external memory exists and folder with name Notes
                    if (!root.exists()) {
                        root.mkdirs(); // this will create folder.
                    }
                    File filepath = new File(root, h + ".txt");  // file path to save
                    FileWriter writer = new FileWriter(filepath);
                    //writer.append(ed.getText().toString());
                    //writer.flush();
                    //writer.close();
                    String m = "File generated with name " + h + ".txt";
                    result.setText(m);

                } catch (Exception e) {
                    e.printStackTrace();
                    result.setText(e.getMessage().toString());
                }

            }
        });
    }
}
