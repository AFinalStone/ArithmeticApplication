package com.shi.androidstudy.arithmetic;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText_md5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_md5 = (EditText) findViewById(R.id.editText_md5);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_md5Text:
                md5Text();
                break;
            case R.id.btn_md5File:
                md5File();
                break;
        }
    }

    private void md5Text() {
        String resultMd5 = editText_md5.getText().toString().trim();
        Toast.makeText(this,"MD5文字加密结果:\n"+Md5Util.getMd5ByText(resultMd5),Toast.LENGTH_SHORT).show();
    }

    private void md5File() {
        AssetManager am = getAssets();
        File file = null;
        try {
            InputStream inputStream =  am.open("md5.jpg");
            OutputStream  outputStream = new FileOutputStream(file);

            int bytesWritten = 0;
            int byteCount = 0;

            byte[] bytes = new byte[1024];

            while ((byteCount = inputStream.read(bytes)) != -1)
            {
                outputStream.write(bytes, bytesWritten, byteCount);
                bytesWritten += byteCount;
            }
            inputStream.close();
            outputStream.close();
            Toast.makeText(this,"MD5文字加密结果:\n"+Md5Util.getMd5ByText(Md5Util.getMd5ByFile(file)),Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }




}
