package net.mcamigos.petfinder.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class ShowHideProgressBar {

        public static ProgressDialog progressBar = null;

    public static void show(Boolean show, Context context,String message ){

        if(show){
            progressBar = new ProgressDialog(context);
            progressBar.setCancelable(true);
            progressBar.setMessage(message);
            progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressBar.setProgress(0);
            progressBar.setMax(100);
            progressBar.show();

        }else{
            if(progressBar.isShowing()){
                progressBar.dismiss();
            }
        }

    }

}
