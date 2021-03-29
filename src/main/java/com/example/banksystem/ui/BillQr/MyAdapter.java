package com.example.banksystem.ui.BillQr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banksystem.Cus_2;
import com.example.banksystem.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    @NonNull
    private Context context;
    private String[] dataSource;
    private List<Transfer_detail> cus;
    public MyAdapter(Context context, List<Transfer_detail> Customer) {
        this.context = context;
        this.cus = Customer;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.trans_de,parent,false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Transfer_detail tr=cus.get(position);
        holder.txtAccR.setText("Reciver ::"+tr.getAccount_Rec());
        holder.txtAccS.setText("Sender  ::"+tr.getAccount_Send());
        holder.txtAmm.setText("Ammount  ::"+tr.getAmmount());
        holder.txttype.setText("Type    ::"+tr.getTrans_type());


    }

    @Override
    public int getItemCount() {
        return cus.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder{

        //public TextView txtProduct;
        public TextView txttype;
        public TextView txtAmm;
        public TextView txtAccR;
        public TextView txtAccS;

        public MyHolder(@NonNull View view) {

            super(view);
            this.txtAccR=view.findViewById(R.id.Acc_rec);
            this.txtAccS=view.findViewById(R.id.Acc_Sender);
            this.txttype=view.findViewById(R.id.Acc_Type);
            this.txtAmm=view.findViewById(R.id.Amm_Rt);
        }
    }
}

