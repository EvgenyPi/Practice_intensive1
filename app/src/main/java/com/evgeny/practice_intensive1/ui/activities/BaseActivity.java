package com.evgeny.practice_intensive1.ui.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.evgeny.practice_intensive1.R;
import com.evgeny.practice_intensive1.utils.ConstantManager;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = ConstantManager.TAG_PREFIX+"Base Activity";
    private ProgressDialog mProgressDialog;


    public void showProgress() {
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this, Color.TRANSPARENT);
            mProgressDialog.setCancelable(false);
            mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.progress_splash);
        } else {
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.progress_splash);
        }
    }

    public void hideProgress() {
        if (mProgressDialog != null) {
            if (mProgressDialog.isShowing()) {
                mProgressDialog.hide();
            }
        }
    }

    public void showError(String message, Exception Error) {
        Log.d(TAG,message,Error);
    }

    public void showToast(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
