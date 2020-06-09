package com.Trust.happy;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{
    private EditText tvuName;
    private EditText tvPassword;
    private Button btLogin;
    private TextView tvRegister;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        tvuName = findViewById(R.id.tvUsername);
        tvPassword = findViewById(R.id.tvPassword);
        btLogin = findViewById(R.id.btLogin);
        tvRegister = findViewById(R.id.tvRegister);
        db = new DatabaseHelper(this);

        btLogin.setOnClickListener(
                new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
              String uName = tvuName.getText().toString();
              String uPsw = tvPassword.getText().toString();
              if(isValid(uName,uPsw))
              {
                Boolean chkEmail = db.emailPassword(uName,uPsw);
                if(chkEmail == true)
                {
                    Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                }else Toast.makeText(getApplicationContext(),"Check email and password and please try again!",Toast.LENGTH_SHORT).show();


              }

            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
             startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
            }
        });
    }
    private Boolean isValid(String userName,String psswd)
    {
        Boolean res = false;
        if(userName.isEmpty() && psswd.isEmpty())
        {
            Toast.makeText(MainActivity.this, "Please ensure all fields are filled.", Toast.LENGTH_SHORT).show();
            return res;
        }else
            return true;
    }




}
