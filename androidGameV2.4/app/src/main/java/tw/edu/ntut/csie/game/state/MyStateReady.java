package tw.edu.ntut.csie.game.state;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.R;

/**
 * Created by snow on 2018/3/18.
 */

public class MyStateReady extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent();
                intent.setClass(MyStateReady.this, Game.class);
                startActivity(intent);
                Toast.makeText(MyStateReady.this, "123", Toast.LENGTH_SHORT).show();
                finish();
            }
        }, 1000);

    }
}
