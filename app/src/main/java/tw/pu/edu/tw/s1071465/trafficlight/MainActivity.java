package tw.pu.edu.tw.s1071465.trafficlight;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //設定全螢幕顯示
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_main);
    }
    public void StartGame(View v){
        Intent it = new Intent();
        it.setClass(this, GameActivity.class);
        EditText GRE = (EditText) findViewById(R.id.GRE);
        it.putExtra("GRESEC", GRE.getText().toString());
        EditText YEL = (EditText) findViewById(R.id.YEL);
        it.putExtra("YELSEC", YEL.getText().toString());
        EditText RED = (EditText) findViewById(R.id.RED);
        it.putExtra("REDSEC", RED.getText().toString());
        if(GRE.getText().toString().matches("0")||YEL.getText().toString().matches("0")||RED.getText().toString().matches("0"))
        {
            Toast.makeText(this, "燈號的秒數不能為0",Toast.LENGTH_LONG).show();

        }
        else if(GRE.getText().toString().matches("")||YEL.getText().toString().matches("")||RED.getText().toString().matches("0"))
        {
            Toast.makeText(this, "燈號的秒數不能為空白",Toast.LENGTH_LONG)
                    .show();
        }
        else {
            startActivity(it);
            finish();
        }
    }

    public void EndApp(View v){
        finish();
    }

}
