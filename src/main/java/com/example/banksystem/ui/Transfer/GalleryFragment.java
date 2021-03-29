package com.example.banksystem.ui.Transfer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.banksystem.Constant;
import com.example.banksystem.Customer;
import com.example.banksystem.R;
import com.example.banksystem.RequestHandler;
import com.example.banksystem.Until_li;

import org.json.JSONException;
import org.json.JSONObject;

public class GalleryFragment extends Fragment {
    private Button btn_st;
    private EditText edt_Amm, edt_Acc, edt_Uid;

    private TextView tct;
    public Until_li unit;
    private AlertDialog alertDialog;
    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
    context=getActivity();

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        btn_st = root.findViewById(R.id.btnIsub);
        edt_Amm = root.findViewById(R.id.Edt_Amm);
        edt_Acc = root.findViewById(R.id.Edt_Acc);
        tct = root.findViewById(R.id.text_gallery);
        tct.setText("Transfer Amount");
        btn_st.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent iko = getActivity().getIntent();
                                          final Customer us_obj = (Customer) iko.getSerializableExtra("Serail");
                                          //    String User_id = edt_Uid.getText().toString().trim();
                                          String Ammount = edt_Amm.getText().toString().trim();

                                          String Acc = edt_Acc.getText().toString().trim();


                                          String user_Acc = us_obj.getId().trim();

                                          int ps;
                                          int rg = Integer.parseInt(Ammount);
                                          int pt = Integer.parseInt(us_obj.getAmmt());

                                          ps = pt;
                                          if (pt >= rg && us_obj.getAccount_No()!=Acc) {

                                              ps = pt - rg;
                                              String fix = String.valueOf(ps);

                                              us_obj.setAmmt(fix);

                                              new Rec_Dis().execute(Acc,Ammount);
                                              new Customer_Acc().execute(user_Acc,Ammount);
                                              new tranfser_insert().execute("Sender",Ammount,us_obj.getAccount_No(),Acc);

                                              edt_Amm.setText("");
                                              edt_Acc.setText("");
                                          } else {
                                              edt_Amm.setText("");
                                              edt_Acc.setText("");
                                              unit.showToast(context, "Your Account or Amount Not Valid");
                                          }



                                          //edt_Amm.setText("" + a);

                                      }
                                  }

        );

///Customer_Acc.execute("dasdas");
        return root;
    }
    public class tranfser_insert extends AsyncTask<String,Void,String>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... param) {
            try {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put(Constant.KEY_REQUEST_TYPE, "transfInsert");
                jsonObject.put("Trans_type", param[0]);
                jsonObject.put("Ammount", param[1]);
                jsonObject.put("Account_Send", param[2]);
                jsonObject.put("Account_Rec", param[3]);

                RequestHandler handler = new RequestHandler();
                return handler.makeHTTPRequest(jsonObject);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
                 Until_li.showToast(context,"Access No ");
        }
    }


    public class Customer_Acc extends AsyncTask<String, Void, String> {

        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... param) {
            // if(type.equals("login")){
            try {
                if(param[0]!=null && param[1]!=null) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put(Constant.KEY_REQUEST_TYPE, Constant.ACTION_UpdateUser);
                    jsonObject.put(Constant.cus_id, param[0]);
                    jsonObject.put(Constant.cuss_Amount, param[1]);
                    RequestHandler handler = new RequestHandler();
                    return handler.makeHTTPRequest(jsonObject);
                }else{
                unit.showToast(context, "Value is Empty");
                }
            } catch (JSONException e) {
                e.printStackTrace();


            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            unit.showToast(context, "Your Transtion Complisety");
//
//            alertDialog.setMessage(s);
//            alertDialog.show();

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
    public class Rec_Dis extends AsyncTask<String, Void, String> {

        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... param) {

            try {
                if(param[0]!=null) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put(Constant.KEY_REQUEST_TYPE, Constant.ACTION_UpdateTrans);
                    jsonObject.put(Constant.cus_Account, param[0]);
                    jsonObject.put(Constant.cuss_Amount, param[1]);
                    RequestHandler handler = new RequestHandler();
                    return handler.makeHTTPRequest(jsonObject);
                }else{
                    unit.showToast(context, "Value is Empty");
                }
            } catch (JSONException e) {
                e.printStackTrace();


            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            unit.showToast(context, "Your Transtion Complisety");

        }

    }
}

