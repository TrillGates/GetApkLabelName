package com.sunofbeaches.getapklabelname;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Here is the main code

        //First we should get the dir of the apk.
        //By the way,please remember to add the uses-permission READ_EXTERNAL_STORAGE into the manifests file.
        String apkPath = "/storage/sdcard0/Download/test.apk";//Just an example,please replace it as yours.

        //We can get the label name by the path,but we need to get the packageManager first;
        PackageManager  pm = this.getPackageManager();

        //Get the packageInfo
        PackageInfo pi = pm.getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES);

        //Set the source and public source dir.
        pi.applicationInfo.sourceDir = apkPath;
        pi.applicationInfo.publicSourceDir = apkPath;

        //Now,we get the app name but we haven't install.
        String appName = (String) pi.applicationInfo.loadLabel(pm);

        //Out put the name
        System.out.println("appName ==== " + appName);

    }
}
