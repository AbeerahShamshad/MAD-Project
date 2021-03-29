package com.example.banksystem.ui.BillQr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.banksystem.Constant;
import com.example.banksystem.R;
import com.example.banksystem.RequestHandler;
import com.example.banksystem.Until_li;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Display_Show extends AppCompatActivity {

    private RecyclerView rvsc;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__show);

        rvsc=findViewById(R.id.rescv);
context=this;
        new DataDC().execute("AN-14020");
    }
    public  class DataDC extends AsyncTask<String,Void,String> {

        private List<Transfer_detail> pro;

        //private RecyclerView rvsc;
        private RecyclerView.Adapter adapter;
        private RecyclerView.LayoutManager layoutManager;
        // public// context=this;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... param) {

            try {
                //   if(param[0]!=null && param[1]!=null) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(Constant.KEY_REQUEST_TYPE, "transf_find");
                jsonObject.put("Account_Send", param[0]);
                //jsonObject.put(Constant.cuss_Amount, param[1]);
                RequestHandler handler = new RequestHandler();
                return handler.makeHTTPRequest(jsonObject);
//                }else{
//                    unit.showToast(context, "Value is Empty");
//                }
            } catch (JSONException e) {
                e.printStackTrace();


            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ArrayList<Transfer_detail> prot = new ArrayList<>();
            try {
                JSONObject jsonObj = new JSONObject(s);
                JSONArray jsonAry = jsonObj.getJSONArray("Transf_Acc");

                JSONObject obj;
                for(int i = 0 ; i <= jsonAry.length() ; i ++){

                    obj= jsonAry.getJSONObject(i);
                    prot.add(new Transfer_detail(obj.getString("1"),obj.getString("2"),obj.getString("3"),obj.getString("4")));
                    //Until_li.showToast(context,prot.toString());
                    Until_li.showToast(context,obj.getString("2")+"  "+obj.getString("3"));

                    adapter=new MyAdapter(context,prot);
                    layoutManager=new LinearLayoutManager(context);

                    rvsc.setLayoutManager(layoutManager);
                    rvsc.setAdapter(adapter);
                }



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
