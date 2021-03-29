package com.example.banksystem.ui.Transfer;

import android.widget.Button;
import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {
    Button btn_st;
    EditText edt_txt1,edt_txt2;
    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Transfer Amount");
    }


    public LiveData<String> getText() {
        return mText;
    }
}