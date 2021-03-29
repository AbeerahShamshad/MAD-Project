package com.example.banksystem.ui.tools;

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

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.banksystem.Constant;
import com.example.banksystem.Customer;
import com.example.banksystem.R;
import com.example.banksystem.RequestHandler;
import com.example.banksystem.Until_li;

import org.json.JSONException;
import org.json.JSONObject;

public class ToolsFragment extends Fragment {

    public Button btn;
    public EditText edt_curPass,edt_newPass,edt_confpass;

private Context context;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        ///textView.setText("Setting");
        context=getActivity();
        edt_curPass=root.findViewById(R.id.editCurentPass);
        edt_newPass=root.findViewById(R.id.newPass);
        edt_confpass=root.findViewById(R.id.ConfrimPass);
        btn=root.findViewById(R.id.btn_ver);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iko = getActivity().getIntent();
                final Customer us_obj = (Customer) iko.getSerializableExtra("Serail");
                if(us_obj.getPassword().equals(edt_curPass.getText().toString())){

                    if(edt_newPass.getText().toString().equals(edt_confpass.getText().toString())){

                        new pass_change().execute(us_obj.getId(),edt_newPass.getText().toString());

                        edt_confpass.setText("");
                        edt_curPass.setText("");
                        edt_newPass.setText("");
                    }else{
                        edt_confpass.setText("");
                        edt_curPass.setText("");
                        edt_newPass.setText("");
                        edt_confpass.setError("Not Match");

                    }

                }else{

                    edt_curPass.setError("Your Password is Wrong");
                    edt_confpass.setText("");
                    edt_curPass.setText("");
                    edt_newPass.setText("");
                }
            }
        });

        return root;
    }
public class pass_change extends AsyncTask<String,Void,String>{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... param) {



        try {
            if(param[0]!=null) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(Constant.KEY_REQUEST_TYPE, "update_Pass");
                jsonObject.put("id", param[0]);
                jsonObject.put("password", param[1]);
                RequestHandler handler = new RequestHandler();
                return handler.makeHTTPRequest(jsonObject);
            }else{
                //unit.showToast(context, "Value is Empty");

                Until_li.showToast(context,"Empty Data");
            }
        } catch (JSONException e) {
            e.printStackTrace();


        }
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Until_li.showToast(context,"Your Password has beeen change ::");
    }
}

}