package com.zzptc.sky.netnews.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.zzptc.sky.netnews.NewsApplication;

/**
 * Created by Hu Zhilin on 2016/10/27.
 */

public class NetUtil {

    /**
     * 判断网络是否可用
     * @return
     */
    public static boolean isNetworkAvailable(){
        ConnectivityManager connectivityManager = (ConnectivityManager) NewsApplication.getAppContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            return true;
        }
        return false;
    }

    /**
     * 网络异常显示信息
     * @return
     */
    public static boolean isNetworkErrorThenShowMsg(){
        if(!isNetworkAvailable()){
            Toast.makeText(NewsApplication.getAppContext(), "网络异常,请检查网络设置", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}
