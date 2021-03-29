package com.example.banksystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Dashboard_1 extends AppCompatActivity {
    private EditText edEmail,edPass;
    private Button btnSubmit;
    private Context context;
private TextView txt_ed;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_1);
        context = this;

        firebaseAuth = FirebaseAuth.getInstance();
        initializeViews();
        //final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("customer");
//myRef.addValueEventListener(new ValueEventListener() {
//    @Override
//    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//        String value=dataSnapshot.getValue(String.class);
//        Until_li.showToast(context,value);
//        edEmail.setText(""+value);
//    }
//
//    @Override
//    public void onCancelled(@NonNull DatabaseError databaseError) {
//        Log.w( "Failed to read value.", databaseError.toException());
//    }
//});

    }
    private void initializeViews(){
        edEmail = findViewById(R.id.ed_email);
        edPass = findViewById(R.id.ed_pass);
        txt_ed=findViewById(R.id.txt_ed);
        btnSubmit = findViewById(R.id.btn_submit);

        txt_ed.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          startActivity(new Intent(getApplicationContext(),SignUp.class));
                                      }
                                  });
                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        login();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        FirebaseUser currentUser = FirebaseAuth.getCurrentUser(); //.getCurrentUser();
//      //  updateUI(currentUser);
    }

    private void login(){
        String email= Until_li.getText(edEmail);
        String password= Until_li.getText(edPass);

        if(Until_li.isValidated(email,password)){
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                Intent intent = new Intent(context,MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }else {
                                Until_li.showMessage(context,"Your Account Sepend ...::");
                            }
                        }

                    });
        }
        else{
            Until_li.showMessage(context,"Please enter your credentials");
        }
    }

}

