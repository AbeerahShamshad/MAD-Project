package com.example.banksystem.ui.BillQr;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Constraints;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banksystem.Constant;
import com.example.banksystem.Customer;
import com.example.banksystem.R;
import com.example.banksystem.RequestHandler;
import com.example.banksystem.Until_li;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShareFragment extends Fragment {


    private RecyclerView rvsc;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Transfer_detail> dataSource;
    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        context=getActivity();
        View root = inflater.inflate(R.layout.fragment_share, container, false);


   //     textView.setText("History");

        rvsc=root.findViewById(R.id.rec_view);

        Intent iko = getActivity().getIntent();
        final Customer us_obj = (Customer) iko.getSerializableExtra("Serail");
        new DataDC().execute(us_obj.getAccount_No());

        //Data_run.execute(us_obj.getId());
        //Data_run
        //dataSource=pro;


        //My Adapter
        //  adapter=new MyAdapter(this,dataSource);

//        // product Adapter
//        adapter=new MyAdapter(getActivity(),dataSource);
//
//        // Recycle view and List View Display on Activity
//        //    layoutManager=new GridLayoutManager(this,2);
//        // layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
//        layoutManager=new LinearLayoutManager(getActivity());
//
//
//        rvsc.setLayoutManager(layoutManager);
//        rvsc.setAdapter(adapter);



        return root;
    }

//    private List<Transfer_detail> getDataSource() {
////        List<Transfer_detail> pro = new ArrayList<>();
////Data Fetch on DB
//
//        return pro;
//    }

    public  class DataDC extends AsyncTask<String,Void,String>{

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
                    JSONObject jsonObject = new JSONObject();       //transf_find
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
//                    Until_li.showToast(context,obj.getString("2")+"  "+obj.getString("3"));
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