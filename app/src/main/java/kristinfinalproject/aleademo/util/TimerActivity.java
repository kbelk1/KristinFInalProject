package kristinfinalproject.aleademo.util;

import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kristinfinalproject.aleademo.BaseActivity;
import kristinfinalproject.aleademo.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TimerActivity extends BaseActivity {

    private int time;

    @BindView(R.id.timer_et)
    EditText editText;

    @BindView(R.id.timer_bt)
    Button timerButton;

    Handler mHandler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            if (time > 0) {
                editText.setText(String.valueOf(time));
                //public final boolean postDelayed(Runnable r, long delayMillis)
                mHandler.postDelayed(runnable, 1000);
                //mHandler.post(this);
            }
        }
    };


    final View.OnClickListener start = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editText.setEnabled(false);
            time = Integer.valueOf(editText.getText().toString());
            timerButton.setText("Stop");
            timerButton.setOnClickListener(stop);
            mHandler.postDelayed(runnable, 1000);
        }
    };

    final View.OnClickListener stop = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            timerButton.setText("Reset");
            timerButton.setOnClickListener(reset);
            mHandler.removeCallbacks(runnable); //change to postDelay to pause the
        }
    };

    final View.OnClickListener reset = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editText.setEnabled(true);
            timerButton.setText("Start");
            timerButton.setOnClickListener(start); //need to change the options for reset ot work
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        ButterKnife.bind(this);
        timerButton.setOnClickListener(start);
    }
}
