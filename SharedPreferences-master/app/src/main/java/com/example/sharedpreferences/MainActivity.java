package com.example.sharedpreferences;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import static android.graphics.Color.parseColor;


public class MainActivity extends AppCompatActivity {
    private Preferences preferences;

    private ViewHolder mViewHolder = new ViewHolder();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.preferences = new Preferences(this);

        mViewHolder.view = findViewById(R.id.view_color);
        mViewHolder.bar = getSupportActionBar();

        if (preferences.getcolor("barcolor") == "Default") {
            mViewHolder.view.setBackgroundColor(parseColor("#ffffff"));
        } else {
            mViewHolder.view.setBackgroundColor(parseColor(preferences.getcolor("backgroundcolor")));
            mViewHolder.bar.setBackgroundDrawable(new ColorDrawable(parseColor(preferences.getcolor("barcolor"))));
            getWindow().setStatusBarColor(parseColor(preferences.getcolor("statuscolor")));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layout_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.ciano_color:
                preferences.storageColor("backgroundcolor", "#B0F6FF");
                preferences.storageColor("barcolor", "#2EB6FF");
                preferences.storageColor("statuscolor", "#2EB6FF");
                theme();
                break;
            case R.id.roxo_color:
                preferences.storageColor("backgroundcolor", "#E7B0FF");
                preferences.storageColor("barcolor", "#6200EE");
                preferences.storageColor("statuscolor", "#6200EE");
                theme();
                break;
            case R.id.hallo_color:
                preferences.storageColor("backgroundcolor", "#b0b0b0");
                preferences.storageColor("barcolor", "#313131");
                preferences.storageColor("statuscolor", "#C87941");
                theme();
                break;
            case R.id.rosa_color:
                preferences.storageColor("backgroundcolor", "#EEA5F6");
                preferences.storageColor("barcolor", "#0C093C");
                preferences.storageColor("statuscolor", "#DF42D1");
                theme();
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void theme() {
        mViewHolder.view.setBackgroundColor(parseColor(preferences.getcolor("backgroundcolor")));
        mViewHolder.bar.setBackgroundDrawable(new ColorDrawable(parseColor(preferences.getcolor("barcolor"))));
        getWindow().setStatusBarColor(parseColor(preferences.getcolor("statuscolor")));
    }

    private static class ViewHolder {
        ActionBar bar;
        View view;
    }
}