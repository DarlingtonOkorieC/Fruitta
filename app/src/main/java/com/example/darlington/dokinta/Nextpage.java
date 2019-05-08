package com.example.darlington.dokinta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.darlington.dokinta.Model.User;

public class Nextpage extends AppCompatActivity {
    Button signUp, logIn;
    TextView textSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextpage);

        signUp = (Button) findViewById(R.id.btnsignUp);
        logIn = (Button) findViewById(R.id.btnlogIn);
        textSlogan = (TextView) findViewById(R.id.livehealthy);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Nextpage.this, SignUpActivity.class));

            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Nextpage.this, LoginActivity.class));

            }
        });
    }
}
