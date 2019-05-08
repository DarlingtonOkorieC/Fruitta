package com.example.darlington.dokinta;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.darlington.dokinta.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUpActivity extends AppCompatActivity {
    EditText edname, edphone, edpassword;
    Button btsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edname = (MaterialEditText) findViewById(R.id.editname);
        edphone = (MaterialEditText) findViewById(R.id.editphone);
        edpassword = (MaterialEditText) findViewById(R.id.editpassword);

        btsignup = (Button) findViewById(R.id.ssignUp);

        //init firebase

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = firebaseDatabase.getReference("User");

        btsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
                progressDialog.setMessage("please waiting");
                progressDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Check if already user esxists

                        if (dataSnapshot.child(edphone.getText().toString()).exists()){
                            progressDialog.dismiss();

                            Toast.makeText(SignUpActivity.this, "Phone already in existence", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            progressDialog.dismiss();
                            User user = new User(edname.getText().toString(), edpassword.getText().toString());
                            table_user.child(edphone.getText().toString()).setValue(user);
                            Toast.makeText(SignUpActivity.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
