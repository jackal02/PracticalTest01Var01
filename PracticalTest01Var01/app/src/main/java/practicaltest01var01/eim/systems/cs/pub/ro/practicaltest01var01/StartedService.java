package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import ro.pub.cs.systems.eim.lab05.startedservice.general.Constants;

public class StartedService extends Service {

    Intent intent;
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {

        return true;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(Constants.TAG, "onRebind() method was invoked");
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ProcessingThread processingThread = new ProcessingThread(this);
        processingThread.start();
        return START_REDELIVER_INTENT;
    }

}
}
