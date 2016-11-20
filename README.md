
##需求背景：
要对apk进行管理，但是在不安装的情况下，我们需要拿到这个apk应用的名称，也就是安装好后，现实在Launcher里的名称。

##怎么获取未安装应apk的名字呢（label）
主要的代码如下：

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
   


![](https://github.com/TrillGates/GetApkLabelName/blob/master/screenshot.jpg)

手机上的apk路径是演示的路径，那么我们把程序跑起来以后呢，就可以看得到这样的结果啦：

        I/System.out: appName ==== 滴答表盘
        
然而我并没有安装这个apk，但是小手一抖，还是拿到了，对吧！
你也试试吧，你一定可以的！
