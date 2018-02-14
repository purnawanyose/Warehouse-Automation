package com.semenindonesia.sisi.warehouseautomation;

import android.app.Activity;

/**
 * Created by muham on 2/12/2018.
 */

public class ForceCloseDebugger {

    public static void handle(Activity context){
        if (!BuildConfig.BUILD_TYPE.equalsIgnoreCase("debug")) {
            Thread.setDefaultUncaughtExceptionHandler(new ForceCloseException(context));
            String errorCaused  = context.getIntent().getStringExtra("bugs");
            System.out.println("FORCE CLOSE CAUSED BY : " + errorCaused);
        }else{
            Thread.setDefaultUncaughtExceptionHandler(new ForceCloseException(context));
            String errorCaused  = context.getIntent().getStringExtra("bugs");
            System.out.println("FORCE CLOSE CAUSED BY  : " + errorCaused);
        }
    }
}
