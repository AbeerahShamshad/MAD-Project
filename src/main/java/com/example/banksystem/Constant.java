package com.example.banksystem;

public class Constant {
    public final static  String userRemember="userName";
    public final static  String PasswordRemember="password";
    public  final static  String Remember="Remember";
    public  final static  String PREF_NAME="PREF_NAME";
    public  final static  String  Key_Reason="PREF";

    //http://localhost:8080/MyAppServer/http://192.168.56.1/bank_system/

    public static  final String SERVER_URL = "http://192.168.56.1/bank_system/service.php";
    //Request Keys  request_type
    public static  final String KEY_REQUEST_TYPE = "request_type";
    //Customer dir
    public static  final String cus_id="id";
    public static  final String cus_pass="password";
    public static final String cus_Account="account_number";
    public static final String Transfer="transf_find";
    public static final String AccSend="Account_Send";
    public static final String cuss_Amount="amount_acc";

    //Actions  get_customer_Find
    public static  final String ACTION_Find = "get_customer_Find";
    public static  final String ACTION_UpdateUser = "update_customer_Acount";
    public static  final String ACTION_UpdateTrans = "update_customer_Amm";
    public static  final String ACTION_Rec_value="get_customer_Gain";
    //get_customer_Gain



    ///////////////
    public static  final String ACTION_ADD = "add_product";

    public static  final String ACTION_VIEW = "get_customer_detail";
    public static  final String ACTION_UPDATE = "update_product";
    public static  final String ACTION_DELETE = "delete_product";
}
