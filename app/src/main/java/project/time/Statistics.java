package project.time;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Statistics extends AppCompatActivity implements View.OnClickListener {

    Button kek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        kek = (Button) findViewById(R.id.kek);
        kek.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kek:
                Intent intent = new Intent(this, Menu.class);  // ссылку на какой класс будет переходить по кнопке
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
