package com.creative_developer.liveinternetcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class GamePlayActivity extends AppCompatActivity {


    WebView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);

        gameView = findViewById(R.id.gameView);

        gameView.getSettings().setJavaScriptEnabled(true);
        gameView.loadUrl("file:///android_asset/index.html");
        gameView.requestFocus(View.FOCUS_DOWN);

    }
}