package com.Trust.happy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
{

    private TextView disp;
    private Button btAdd;
    private int size;
    private ArrayList<String> facts;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        disp = findViewById(R.id.tvDisplay);
        facts = new ArrayList<>();
        count=0;

        //Strings in future will be stored in database.
        facts.add("She loves flowers!");
        facts.add("Get her a kitkat!");
        facts.add("Let's get something to eat.");
        facts.add("Fill up her tank.");
        size = facts.size();
        disp.setText(facts.get(count));
        btAdd = findViewById(R.id.btAdd);

        //To add new fact to list
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,addFact.class));
                //Get the string from the Add Activity and add it to the list.
                String newFact = getIntent().getStringExtra("Fact");
                facts.add(newFact);
                disp.setText(newFact);
            }
        });

        //Switch from first fact to last
        disp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(count < size-1)
                {
                    disp.setText(facts.get(count));
                    count++;
                }else
                {
                    count = 0;
                }

            }
        });
    }

}
