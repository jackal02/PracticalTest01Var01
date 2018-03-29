import android.content.Context;
import android.content.Intent;
import android.util.Log;

import ro.pub.cs.systems.eim.lab05.startedservice.general.Constants;

public class ProcessingThread extends Thread {

    private Context context;

    public ProcessingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {

       sleep(5000);
       sendMessage();
    }

    private void sendMessage() {
        Intent intent = new Intent();

        intent.setAction("myaction");
        intent.putExtra("clicks", context.);

        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException interruptedException) {
            Log.e(Constants.TAG, interruptedException.getMessage());
            interruptedException.printStackTrace();
        }
    }

}