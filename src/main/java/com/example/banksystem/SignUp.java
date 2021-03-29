package com.example.banksystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class SignUp extends AppCompatActivity {

    private EditText edFn,edLn,edEmail,edPass,edAcc,edtAmm,edtPhone;
    private Button btnSubmit;
    private Context context;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        context = this;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        initializeViews();
    }
    private void initializeViews(){
        edFn = findViewById(R.id.ed_fname);
        edLn = findViewById(R.id.ed_lname);
        edEmail = findViewById(R.id.ed_email);
        edPass = findViewById(R.id.ed_pass);
        edAcc = findViewById(R.id.ed_Account);
        edtAmm=findViewById(R.id.ed_Ammt);
        edtPhone=findViewById(R.id.ed_phn);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRegistration();
            }
        });
    }
void makeRegistration(){
    final String fName= Until_li.getText(edFn);
    final String lName= Until_li.getText(edLn);
    final String email= Until_li.getText(edEmail);
    final String password= Until_li.getText(edPass);
    final String accN= Until_li.getText(edAcc);
    final String amm= Until_li.getText(edtAmm);
    final String phone= Until_li.getText(edtPhone);

    if(Until_li.isValidated(fName,lName,email,password,accN)){
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                final FirebaseUser user = firebaseAuth.getCurrentUser();
                                user.getUid();
                                //Profile Create
                                FirebaseInstanceId.getInstance().getInstanceId()
                                        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                                Cus_2 u1 = new Cus_2(user.getUid(),lName,password,phone,email,accN,amm);
                                                if (!task.isSuccessful()) {
                                                    u1.token = null;
                                                }
                                                u1.token = task.getResult().getToken();
                                                databaseReference.child("Customer").child(user.getUid()).setValue(u1);
                                                Intent intent = new Intent(context,Dashboard_1.class);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                startActivity(intent);
                                                finish();
                                            }
                                        });
                            } else {
                                Until_li.showMessage(context,"Email Already Registered");
                            }
                        }
                    });

    }
    else{
        Until_li.showMessage(context,"Please fill the form");
    }

}
}
