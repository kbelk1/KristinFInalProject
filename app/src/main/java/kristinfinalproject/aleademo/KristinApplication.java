package kristinfinalproject.aleademo;

import android.app.Application;

import kristinfinalproject.aleademo.util.UtilLog;



public class KristinApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }
}

