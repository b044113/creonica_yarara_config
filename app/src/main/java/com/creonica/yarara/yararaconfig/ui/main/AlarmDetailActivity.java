package com.creonica.yarara.yararaconfig.ui.main;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.creonica.yarara.yararaconfig.R;
import com.creonica.yarara.yararaconfig.model.Alarm;

public class AlarmDetailActivity extends AppCompatActivity {

    public static final String NEW_NOTE_EXTRA = "New Note";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_detail);

        createAndAddFragment();
    }

    private void createAndAddFragment() {

        Intent intent = getIntent();
        MainActivity.FragmentToLaunch fragmentToLaunch =
                (MainActivity.FragmentToLaunch) intent.getSerializableExtra(MainActivity.ALARM_FRAGMENT_TO_LOAD_EXTRA);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (fragmentToLaunch) {
            case EDIT:
                //NoteEditFragment noteEditFragment = new NoteEditFragment();
                //setTitle(R.string.editFragmentTitle);
                //fragmentTransaction.add(R.id.note_container, noteEditFragment, "NOTE_EDIT_FRAGMENT");
                break;
            case VIEW:
                AlarmDetailViewFragment alarmViewFragment = new AlarmDetailViewFragment();
                setTitle(R.string.viewFragmentTitle);
                fragmentTransaction.add(R.id.note_container, alarmViewFragment, "ALARM_VIEW_FRAGMENT");
                break;
            case CREATE:
                //NoteEditFragment noteCreateFragment = new NoteEditFragment();
                //setTitle(R.string.createFragmentTitle);

                //Bundle bundle = new Bundle();
                //bundle.putBoolean(NEW_NOTE_EXTRA, true );
                //noteCreateFragment.setArguments(bundle);

                //fragmentTransaction.add(R.id.note_container, noteCreateFragment, "NOTE_CREATE_FRAGMENT");
                break;
        }

        fragmentTransaction.commit();
    }
}
