package com.example.banksystem.ui.BillQr;

public class Transfer_detail {

    private String Trans_type ,  Ammount ,  Account_Send ,  Account_Rec ;
    public Transfer_detail(){

    }

    public void setTrans_type(String trans_type) {
        Trans_type = trans_type;
    }

    public void setAmmount(String ammount) {
        Ammount = ammount;
    }

    public void setAccount_Send(String account_Send) {
        Account_Send = account_Send;
    }

    public void setAccount_Rec(String account_Rec) {
        Account_Rec = account_Rec;
    }

    public String getTrans_type() {
        return Trans_type;
    }

    public String getAmmount() {
        return Ammount;
    }

    public String getAccount_Send() {
        return Account_Send;
    }

    public String getAccount_Rec() {
        return Account_Rec;
    }

    public Transfer_detail(String trans_type, String ammount, String account_Send, String account_Rec) {
        Trans_type = trans_type;
        Ammount = ammount;
        Account_Send = account_Send;
        Account_Rec = account_Rec;
    }


}
