package com.Trust.happy;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Class to handle user registration
 */
public class RegistrationActivity extends AppCompatActivity
{
    private EditText ePassword,eMail;
    private Button btRegister;
    private TextView tvLogin;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //initialise
        ePassword = findViewById(R.id.etPassword);
        eMail = findViewById(R.id.etEmail);

        tvLogin = findViewById(R.id.tvLogin);
        btRegister = findViewById(R.id.btRegister);
        db = new DatabaseHelper(this);

        btRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String mail = eMail.getText().toString().trim();
                String ePass = ePassword.getText().toString().trim();
                if (Validate()) {
                    //Upload to database
                    Boolean chkemail = db.chkEmail(mail);
                    if (chkemail == true) {
                        Boolean insert = db.insert(mail, ePass);
                        if (insert == true) {
                            Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Email already exists!", Toast.LENGTH_SHORT).show();
                    }
                }


            }

        });
        tvLogin.setOnClickListener(
                new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
             startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
            }
        });
    }



    private Boolean Validate()
    {
        String name = eMail.getText().toString();
        String pass = ePassword.getText().toString();
         if(name.isEmpty() && pass.isEmpty())
         {
             Toast.makeText(this,"Please enter all details.",Toast.LENGTH_SHORT).show();
             return false;
         }else {
             return true;
         }

    }

}
