package kristinfinalproject.aleademo.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import kristinfinalproject.aleademo.util.UtilLog;

import static kristinfinalproject.aleademo.controller.TestAudioController.PAUSE;
import static kristinfinalproject.aleademo.controller.TestAudioController.PLAY;



public class TestService extends Service {
    private Timer timer = new Timer();
    private MediaPlayer mediaPlayer;
    private int update = 0;

    public static final String UPDATE = "update";
    public static final String ACTION = "TestAction";
    public static final String AUDIO = "AUDIO";

    private String url = "";

    public static final String LOADING = "LOADING";
    public static final String PLAYING = "PLAYING";
    public static final String PAUSED = "PAUSED";


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        if (intent.getAction().equals("AUDIO")) {
            if (intent.getIntExtra("CMD", 0) == PLAY) {
                String urlMsg = intent.getStringExtra("URL");
                if (url.equals(urlMsg)) {
                    mediaPlayer.start();
                    sendPlaying();
                } else {
                    try {
                        url = urlMsg;
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(url);
                        mediaPlayer.prepareAsync();
                        sendLoading();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                String url = intent.getStringExtra("URL");
            } else if (intent.getIntExtra("CMD", 0) == PAUSE){
                mediaPlayer.pause();
                sendPaused();
            }

            String value = intent.getStringExtra("Service");
            if (value.equals("Start")) {
                timer.schedule(new updateTask(), 0, 2000);
            } else if (value.equals("Stop")) {
                timer.cancel();
            }

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                    sendPlaying();
                }
            });
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void sendPlaying() {
        Intent intent = new Intent();
        intent.setAction(AUDIO);//Necessary
        intent.putExtra("MSG", PLAYING);
        sendBroadcast(intent);
    }

    private void sendLoading(){
        Intent intent = new Intent();
        intent.setAction(AUDIO);
        intent.putExtra("MSG", LOADING);
        sendBroadcast(intent);

    }

    private void sendPaused(){
        Intent intent = new Intent();
        intent.setAction(AUDIO);
        intent.putExtra("MSG", PAUSED);
        sendBroadcast(intent);

    }

//   public int onStopCommand(Intent intent, int flags, int startId){
//        String value = intent.getStringExtra("Service");
//        timer.cancel();
//        return  super.onStopCommand(intent, flags, startId);
//
//    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class updateTask extends TimerTask{
        public void run(){
            Intent intent = new Intent();
            intent.setAction(ACTION);//Necessary
            intent.putExtra(UPDATE,++update);
            sendBroadcast(intent);
            UtilLog.logD("Service",update+"");

        }
    }
}
