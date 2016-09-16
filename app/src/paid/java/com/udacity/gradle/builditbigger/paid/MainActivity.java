package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.udacity.gradle.builditbigger.JokeAsyncTask;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.jokedisplay.JokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void tellJoke(View view) {
        new JokeAsyncTask() {
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Intent intent = new Intent(MainActivity.this, JokeActivity.class);
                intent.putExtra(JokeActivity.JOKE_TAG, s);
                startActivity(intent);
            }
        }.execute();
    }

}
