package com.Trust.happy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class AddHappyActivity extends AppCompatActivity
{

    private Button btAdd;
    private EditText eText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_happy);
        eText = findViewById(R.id.tvArrayAdd);
        btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String newFact = eText.getText().toString().trim();
                if(newFact.isEmpty())
                {
                    eText.setError("Please enter something here");
                    eText.requestFocus();
                }else
                    {
                        Intent d = new Intent(AddHappyActivity.this,HomeActivity.class);
                        d.putExtra("Fact",newFact);
                        startActivity(d);
                    }
                }

        });


    }




}
