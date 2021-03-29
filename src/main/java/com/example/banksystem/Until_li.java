package com.example.banksystem;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;

public class Until_li {
    public static String getText(EditText editText) {

        return editText.getText().toString().trim();
    }

    public static boolean isValidated(String... params) {
        for (String Val : params) {
            if(Val.contentEquals(""))
                return  false;
        }
        return true;
    }
    public static void showToast(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
    public static void showMessage(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }



    public static void resetValue(EditText ed){
        ed.setText("");

    }
    public static void ShowValue(EditText ed,String Value){
        ed.setText(Value);

    }
    public static  void Message_Box(Context con,String Msg) {
AlertDialog alert;
        alert= new AlertDialog.Builder(con).create();
        alert.setTitle("Login Status");
        alert.setMessage(Msg);
                //alert.setButton("0","ok","mess");

        alert.show();

    }
}
