package kristinfinalproject.aleademo.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by brandellpetty on 7/5/17.
 */

public class TestAudioController {

    public final static int AudioPlaying = 111;
    public final static int AudioLoading = 222;
    public final static int AudioPaused = 333;

    public final static int PLAY = 55555;
    public final static int PAUSE = 66666;


    public static int STATUS = AudioPaused;

    private Context context;
    private TestAudioReceiver testAudioReceiver;
    private AudioListener listener;


    public TestAudioController(Context context, AudioListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public  void play(String url) {
        Intent intent = new Intent(context, kristinfinalproject.aleademo.service.TestService.class);
        intent.setAction("Audio");
        intent.putExtra("URL", url);
        context.startService(intent);
        initReceiver();
    }

    public void pause(String url) {
        Intent intent = new Intent(context,kristinfinalproject.aleademo.service.TestService.class);
        intent.setAction("Audio");
        intent.putExtra("URL", url);
        context.startService(intent);
    }

    private void initReceiver() {
        testAudioReceiver = new TestAudioReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(kristinfinalproject.aleademo.service.TestService.AUDIO);
        context.registerReceiver(testAudioReceiver, filter);
    }

    public  interface AudioListener{
        public void onPlaying();
        public void onLoading();
        public void onPaused();
    }

    public class TestAudioReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(kristinfinalproject.aleademo.service.TestService.AUDIO)){
                int msg = intent.getIntExtra("MSG", 0);
                switch (msg){
//                    case TestService.PLAYING:
//                        listener.onPlaying();
//                        STATUS = AudioPlaying;
//                        break;
//
//                    case TestService.LOADING:
//                        listener.onLoading();
//                        STATUS = AudioLoading;
//                        break;
//
//                    case TestService.PAUSED:
//                        STATUS = AudioPaused;
//                        listener.onPlaying();
//                        break;
                }
            }
        }
    }
}
