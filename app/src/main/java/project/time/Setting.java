package project.time;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class Setting extends AppCompatActivity {
    private int seekBarWork = 25;
    private int seekBarRest = 5;

    TextView textView1;
    SeekBar seekBar1;
    TextView textView2;
    SeekBar seekBar2;
    Switch switch1;
    Switch switch2;

    public int getSeekBarWork() {
        return seekBarWork;
    }

    public int getSeekBarRest() {
        return seekBarRest;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        switch1 = (Switch) findViewById(R.id.switch1);
        switch2 = (Switch) findViewById(R.id.switch2);

        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        textView1 = (TextView) findViewById(R.id.txtView1);
        textView1.setText(String.valueOf("25"));

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarWork = progress;
                textView1.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        textView2 = (TextView) findViewById(R.id.txtView2);
        textView2.setText(String.valueOf("5"));
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarRest = progress;
                textView2.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}

