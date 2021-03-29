package com.example.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity  {

    private Button btn_Click;
    private EditText edt_user,edt_pass;
    private Context context;
    private CheckBox chk_clik;
    private String user,pass,type;
    private Boolean Rem;
    private AlertDialog alert;
    //private  RequestQueue mQuick;public  Customer cus;
    public String id,name,password,Account_No,email,Ammt,Phone;
    public DatabaseReference db_bank;
    public SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db_bank= FirebaseDatabase.getInstance().getReference().child("customer");
        preferences=getSharedPreferences(Constant.PREF_NAME,MODE_PRIVATE);

        Initialization();
    }
    public void Initialization(){
        btn_Click=findViewById(R.id.btn_sub);
        edt_user=findViewById(R.id.Edt_id);
        edt_pass=findViewById(R.id.Edt_pass);
        chk_clik=findViewById(R.id.ch_rember);
        context=this;
        if(Already_Acess()){
            Intent ink=new Intent(this,Main2Activity.class);
            ink.putExtra(Constant.Remember,true);

            startActivity(ink);
            finish();



        }
        btn_Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user= edt_user.getText().toString().trim();
                pass=edt_pass.getText().toString().trim();

                new Allow_Customer().execute(user,pass);


            }
        });
}
//(String na,String passt)
//
        public void Login(String id, String name, String pass, String account_No, String email, String ammt, String phone){

            String usert= edt_user.getText().toString().trim();
            String passd=edt_pass.getText().toString().trim();
          if(passd.length()>=6){
              edt_pass.setError("Password Must Be 6 Digit");
          }

         if(Until_li.isValidated(usert,pass)){
            Intent ink =new Intent(this,Main2Activity.class);

            if(usert.equals(id)&&passd.equals(pass)){
             //   ink.putExtra(,);
           Customer urCu=new Customer(id,name,pass,account_No,email,ammt,phone);
                ink.putExtra("Serail",urCu);

            //    db_bank.child("cus").push().setValue(urCu);

           //    bck.execute(type,user,pass);
                Rem=chk_clik.isChecked();
                if(Rem){
                    saveView(user,pass);
                    ink.putExtra(Constant.Remember,true);
                    ink.putExtra(Constant.userRemember,user);
                }else{

                    ink.putExtra(Constant.Remember,false);
                    ink.putExtra(Constant.userRemember,user);
                }
                startActivity(ink);
                finish();

            }else{
                Until_li.showToast(this,"Wrong Passward");
                Until_li.resetValue(edt_pass);
            }
        }else {

            Until_li.showToast(this,"please enter your credentials");
        }

    }


    public void saveView(String name,String Password){
        //preferences;
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(Constant.userRemember,name);
        editor.putString(Constant.PasswordRemember,Password);
        editor.commit();
    }
    private  boolean Already_Acess(){
        String user_name=null,pass_word=null;
        user_name=preferences.getString(Constant.userRemember,"");
        pass_word=preferences.getString(Constant.PasswordRemember,"");
        if(Until_li.isValidated(user_name,pass_word))
            return true;

        return false;

    }

    public class Allow_Customer extends AsyncTask<String,Void,String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            alert= new AlertDialog.Builder(context).create();
            alert.setTitle("Login Status");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put(Constant.KEY_REQUEST_TYPE, Constant.ACTION_Find);
                jsonObject.put(Constant.cus_id, strings[0]);
                jsonObject.put(Constant.cus_pass,strings[1]);
                RequestHandler handler = new RequestHandler();
                return handler.makeHTTPRequest(jsonObject);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            //
            return null;
        }


        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            try {
                JSONObject jsonObj = new JSONObject(s);
                JSONArray jsonAry = jsonObj.getJSONArray("Customer");
                for(int i = 0 ; i <= jsonAry.length() ; i ++){
                    JSONObject obj = jsonAry.getJSONObject(i);
                    id=obj.getString("2");
                   // password=obj.getString("4");
                    name = obj.getString("3");
                    password=obj.getString("4");
                    Account_No= obj.getString("7");
                    Phone=obj.getString("6");
                    email= obj.getString("5");
                    Ammt= obj.getString("8");
                    ///
                    Login(id,name,password,Account_No,email,Ammt,Phone);//alert.show();
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
//String na;
//            for(String sr:st){
//                sr
//
//            }

//            if(s!=null){
//                Log.i("RESPONSE",s+"");
//                //   Toast.makeText(,this)
//                //JSON PARSING
//            }
        }
    }
            //return null;




}
    //}

