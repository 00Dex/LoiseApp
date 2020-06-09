package com.Trust.happy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class addFact extends AppCompatActivity
{
   EditText EtNewFact;
   Button btnAddFact;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fact);

        EtNewFact = (EditText) findViewById(R.id.tvFact);
        btnAddFact  = (Button)findViewById(R.id.btnAddTo);

        btnAddFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newFact = EtNewFact.getText().toString().trim();
                if(newFact.isEmpty())
                {
                    EtNewFact.setError("Please enter something here");
                    EtNewFact.requestFocus();
                }else
                {
                    Intent d = new Intent(addFact.this,HomeActivity.class);
                    d.putExtra("Fact",newFact);
                    startActivity(d);
                }
            }
        });
    }
}
