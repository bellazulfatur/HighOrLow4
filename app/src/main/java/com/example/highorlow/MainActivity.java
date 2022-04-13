package com.example.highorlow;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import  com.google.android.material.snackbar.Snackbar;

import java.util.Random;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void setRandomNumberGenrator() {
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }

    public void onGuess(View view)
    {
        try {
            EditText isian;
            isian = findViewById(R.id.isian);
            int masukan = Integer.parseInt(isian.getText().toString());
            if (masukan < randomNumber && masukan <= 20)
            {
                Toast.makeText(this, "kelebihan", Toast.LENGTH_SHORT).show();
            } else if (masukan == randomNumber && masukan <= 20)
            {
              Toast.makeText(this, "Berhasil!, benar: "+randomNumber, Toast.LENGTH_SHORT).show();
              setRandomNumberGenrator();
            }else if(masukan > 20){
                isian.setError("tidak lebih dari 20");
            }

            }catch (Exception e)
        {
            EditText isian=findViewById(R.id.isian);
            isian.setError("harus angka");
        }

        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;    //limit upto 20 from 1
    }
}