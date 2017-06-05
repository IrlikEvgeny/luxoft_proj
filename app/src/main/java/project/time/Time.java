package project.time;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

@SuppressLint("NewApi")
@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class Time extends AppCompatActivity {
    Setting setting = new Setting();

    Button btnStartWork, startRelax, back;
    TextView textViewTime;
    TextView otherTime;
    //Данилу передаю
    protected int countOtherTime = 0;
    protected long countWorkTime = 0;
    protected long countRestTime = 0;

    private long timeWork = setting.getSeekBarWork() * 1000;
    private long timeRelax = setting.getSeekBarRest() * 1000;
    private int clickWork = 0;
    private int clickRest = 0;
    private int seekBarWork = setting.getSeekBarWork();
    private int seekBarRest = setting.getSeekBarRest();

    private boolean statusWork = false;
    private boolean statusRest = false;
    CounterOtherTime counterOtherTime = new CounterOtherTime();
    private SoundPool soundPool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        back = (Button) findViewById(R.id.kek);
        btnStartWork = (Button) findViewById(R.id.btnStart);
        startRelax = (Button) findViewById(R.id.btnRelax);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        otherTime = (TextView) findViewById(R.id.otherTime);

        /*soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener((SoundPool.OnLoadCompleteListener) this);*/

        final CounterClass timer = new CounterClass(timeWork, 1000);
        btnStartWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickWork++;
                countWorkTime = clickWork * seekBarWork;
                System.out.println(countWorkTime);
                statusWork = false;
                statusRest = false;
                timer.start();
            }
        });

        final CounterRestTime timerRelax = new CounterRestTime(timeRelax, 1000);
        startRelax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickRest++;
                countRestTime = clickRest * seekBarRest;
                System.out.println(countRestTime);
                statusRest = false;
                statusWork = false;
                timerRelax.start();
            }
        });
        counterOtherTime.runTimer();

    }

    @SuppressLint("NewApi")
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            textViewTime.setText(hms);
        }

        @Override
        public void onFinish() {
            textViewTime.setText("Go to rest");
            statusWork = true;
            statusRest = false;
        }
    }

    @SuppressLint("NewApi")
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)

    public class CounterRestTime extends CountDownTimer {
        public CounterRestTime(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            textViewTime.setText(hms);
        }

        @Override
        public void onFinish() {
            textViewTime.setText("Go to Work");
            statusRest = true;
            statusWork = false;
        }
    }

    public class CounterOtherTime {
        public void runTimer() {
            final Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    int minutes = (countOtherTime % 3600) / 60;
                    int seconds = countOtherTime % 60;

                    String timeOther = String.format("%02d:%02d", minutes, seconds);
                    otherTime.setText(timeOther);
                    if (statusRest || statusWork) {
                        countOtherTime++;
                    }
                    handler.postDelayed(this, 1000);
                }
            });
        }
    }


}
