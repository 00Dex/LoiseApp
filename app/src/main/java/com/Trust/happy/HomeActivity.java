package com.Trust.happy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
{

    private TextView disp;
    private Button btAdd;
    private ArrayList<String> facts;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        disp = (TextView)findViewById(R.id.tvDisplay);
        facts = new ArrayList<>();
        facts.add("She loves flowers!");
        facts.add("Get her a kitkat!");
        facts.add("Let's get something to eat.");
        facts.add("Fill up her tank.");
        btAdd = (Button)findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,AddHappyActivity.class));
                //Get the string from the Add Activity and add it to the list.
                //String newFact =
                //facts.add(newFact);
            }
        });

        disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count <= facts.size())
                {
                    count++;
                    disp.setText(facts.get(count));
                }else count =0; disp.setText(facts.get(count));

            }
        });
    }

}
