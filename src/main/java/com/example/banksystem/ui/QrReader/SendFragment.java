package com.example.banksystem.ui.QrReader;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.banksystem.R;
import com.example.banksystem.Until_li;
import com.google.zxing.Result;

import github.nisrulz.qreader.QRDataListener;
import github.nisrulz.qreader.QREader;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SendFragment extends Fragment implements ZXingScannerView.ResultHandler {
//    private SurfaceView mySurfaceView;
//    private QREader qrEader;

private ZXingScannerView scannerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scannerView=new ZXingScannerView(getActivity());
        View root = inflater.inflate(R.layout.fragment_send, container, false);

       final TextView textView = root.findViewById(R.id.text_send);
        textView.setText("QR Code Reader");
   //     mySurfaceView= root.findViewById(R.id.camera_view);
     //   mySurfaceView.autofill(scannerView);
//root.setContextView()
        //mySurfaceView = (SurfaceView) root.findViewById(R.id.camera_view);

        // Init QREader
        // ------------
       // qrEader = new QREader.Builder(getActivity(), mySurfaceView, new QRDataListener() {
//            @Override
//            public void onDetected(final String data) {
//           //     Log.d("QREader", "Value : " + data);
//                textView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText(data);
//                    }
//                });
//            }
//        }).facing(QREader.BACK_CAM)
//                .enableAutofocus(true)
//                .height(mySurfaceView.getHeight())
//                .width(mySurfaceView.getWidth())
//                .build();
//        boolean isCameraRunning = qrEader.isCameraRunning();


        return root;
    }

    @Override
    public void onPause() {
        super.onPause();
       // qrEader.releaseAndCleanup();
        scannerView.stopCamera();
    }
//    public void Scan(View view){
//        scannerView=new ZXingScannerView(getActivity());
//       setContentView(scannerView);
//    }

    @Override
    public void handleResult(Result result) {
        Until_li ni=new Until_li();
                ni.showToast(getActivity(),""+result);

    }

    @Override
    public void onResume() {
        super.onResume();
     //   qrEader.initAndStart(mySurfaceView);
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}