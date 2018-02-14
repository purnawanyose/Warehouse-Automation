/*
package com.semenindonesia.sisi.warehouseautomation;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;

import java.io.PrintWriter;
import java.io.StringWriter;

*/
/**
 * Created by muham on 2/12/2018.
 *//*


public class ForceCloseException implements java.lang.Thread.UncaughtExceptionHandler {

    private final Activity myContext;

    public ForceCloseException(Activity context) {
        myContext = context;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable exception) {

        StringWriter stackTrace = new StringWriter();
        exception.printStackTrace(new PrintWriter(stackTrace));
        StringBuilder errorReport = new StringBuilder();

        System.out.println("*****CAUSE OF ERROR*****\n\n");
        System.out.println("FORCE CLOSE CAUSED : " + stackTrace.toString());

        System.out.println("**** DEVICE INFORMATION ***\n\n" +
                "Brand : " + Build.BRAND + "\n" +
                "Device : " + Build.DEVICE + "\n" +
                "Model : " + Build.MODEL + "\n" +
                "ID : " + Build.ID + "\n" +
                "Product : " + Build.PRODUCT + "\n" +
                "SDK : " + Build.VERSION.SDK + "\n" +
                "Release : " + Build.VERSION.RELEASE + "\n" +
                "Incremental : " + Build.VERSION.INCREMENTAL + "/n");

        Intent intent = new Intent(myContext, myContext.getClass());
        intent.putExtra("bugs", stackTrace.toString());
        myContext.startActivity(intent);
        myContext.finish();


        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);

    }
}
*/
