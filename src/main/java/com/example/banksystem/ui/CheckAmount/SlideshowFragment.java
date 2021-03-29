package com.example.banksystem.ui.CheckAmount;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.banksystem.Customer;
import com.example.banksystem.R;

public class SlideshowFragment extends Fragment {


private TextView txt_acc,txt_NO;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
          textView.setText("Check Your Amount");
          txt_acc=root.findViewById(R.id.text_Accmt);
        txt_NO=root.findViewById(R.id.text_AccNo);
        Intent iko = getActivity().getIntent();
        Customer us_obj = (Customer) iko.getSerializableExtra("Serail");
        //    String User_id = edt_Uid.getText().toString().trim();
      //  String Ammount = edt_Amm.getText().toString().trim();
          txt_acc.setText("Amount is ::"+us_obj.getAmmt()+"Rs");
          txt_NO.setText("Account No ::"+us_obj.getAccount_No());


        return root;
    }
}