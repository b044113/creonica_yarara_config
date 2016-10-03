package com.creonica.yarara.yararaconfig.ui.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.creonica.yarara.yararaconfig.R;

public class MainActivity extends AppCompatActivity {

    public static final String ALARM_ID_EXTRA = "com.creonica.yarara.yararaconfig.model.Alarm.ID";
    public static final String ALARM_DESC_EXTRA = "com.creonica.yarara.yararaconfig.model.Alarm.Description";
    public static final String ALARM_PHONE_EXTRA = "com.creonica.yarara.yararaconfig.model.Alarm.PhoneNumber";
    public static final String ALARM_FRAGMENT_TO_LOAD_EXTRA = "com.creonica.yarara.yararaconfig.Fragment_To_Load";


    public enum FragmentToLaunch {VIEW, EDIT, CREATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadPreferences();
        //String mUID = getIntent().getStringExtra("com.creonica.yarara.uid");
        //TextView textViewUID = (TextView) findViewById(R.id.edit_text_uid);
        //textViewUID.setText(mUID);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, AppPreferences.class);
            startActivity(intent);

            return true;
        } else if (id == R.id.action_add_alarm){
            showAddAlarmDialog();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showAddAlarmDialog() {
        /* Create an instance of the dialog fragment and show it */
        DialogFragment dialog = AddAlarmDialogFragment.newInstance("");
        dialog.show(getSupportFragmentManager(), "AddAlarmDialogFragment");
    }



    public void loadPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        /*boolean isBackgroundDark = sharedPreferences.getBoolean("background_color", false);
        if (isBackgroundDark) {
            LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainActivityLayout);
            mainLayout.setBackgroundColor(Color.parseColor("#3c3f41"));
        }

        String notebookTitle = sharedPreferences.getString("title", "Notebook");
        setTitle(notebookTitle);
        */
    }
}
