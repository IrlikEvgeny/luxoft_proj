package project.time;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {


    Button menuTimer;

    Button menuApp;

    Button menuSettings;

    Button menuStat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuTimer = (Button) findViewById(R.id.menuTimer);
        assert menuTimer != null;
        menuTimer.setOnClickListener(this);

        menuStat = (Button) findViewById(R.id.menuStat);
        assert menuStat != null;
        menuStat.setOnClickListener(this);

        menuApp = (Button) findViewById(R.id.menuApp);
        assert menuApp != null;
        menuApp.setOnClickListener(this);

        menuSettings = (Button) findViewById(R.id.menuSettings);
        assert menuSettings != null;
        menuSettings.setOnClickListener(this);

        menuStat = (Button) findViewById(R.id.menuUS);
        assert menuStat != null;
        menuStat.setOnClickListener(this);


    }

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.menuTimer:
                intent = new Intent(this, Time.class);
                startActivity(intent);
                break;
            case R.id.menuSettings:
                intent = new Intent(this, Setting.class);
                startActivity(intent);
                break;
            case R.id.menuStat:
                intent = new Intent(this, Statistics.class);
                startActivity(intent);
            default:
                break;
        }
    }

}