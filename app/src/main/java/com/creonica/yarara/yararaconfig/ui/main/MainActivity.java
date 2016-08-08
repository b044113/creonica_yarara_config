package com.creonica.yarara.yararaconfig.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.creonica.yarara.yararaconfig.R;

public class MainActivity extends AppCompatActivity {

    public enum FragmentToLaunch {VIEW, EDIT, CREATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mUID = getIntent().getStringExtra("com.creonica.yarara.uid");
        TextView textViewUID = (TextView) findViewById(R.id.edit_text_uid);
        textViewUID.setText(mUID);
    }
}
