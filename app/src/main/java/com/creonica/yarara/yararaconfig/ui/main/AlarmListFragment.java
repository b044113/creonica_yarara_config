package com.creonica.yarara.yararaconfig.ui.main;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.creonica.yarara.yararaconfig.R;
import com.creonica.yarara.yararaconfig.model.Alarm;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlarmListFragment extends ListFragment {

    private AlarmListAdapter mAlarmListAdapter;
    private ArrayList<Alarm> alarms;
    private ListView mListView;

    public AlarmListFragment() {
        // Required empty public constructor
    }

    /**
     * Create fragment and pass bundle with data as it's arguments
     * Right now there are not arguments...but eventually there will be.
     */
    public static AlarmListFragment newInstance(String dummyVal) {
        AlarmListFragment fragment = new AlarmListFragment();
        Bundle args = new Bundle();
        args.putString("DUMMY", dummyVal);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);

        //NotebookDbAdapter dbAdapter = new NotebookDbAdapter(getActivity().getBaseContext());
        //dbAdapter.open();

        alarms = getAllAlarms();  //dbAdapter.getAllNotes();

        //dbAdapter.close();

        mAlarmListAdapter = new AlarmListAdapter(getActivity(),alarms);
        setListAdapter(mAlarmListAdapter);

        registerForContextMenu(getListView());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        launchAlarmDetailActivity(MainActivity.FragmentToLaunch.VIEW, position);
    }

 /*   @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(contextMenu, v, menuInfo);

        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.long_press_menu, contextMenu);
    }
*/

 /*   @Override
    public boolean onContextItemSelected(MenuItem item ) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int rowPosition = info.position;
        Alarm alarm = (Alarm) getListAdapter().getItem(rowPosition);

        switch (item.getItemId()){
            case R.id.edit:
                //do something
                launchAlarmDetailActivity(MainActivity.FragmentToLaunch.EDIT,  rowPosition);
                return true;
            case R.id.delete:
                //do something
                //NotebookDbAdapter dbAdapter = new NotebookDbAdapter(getActivity().getBaseContext());
                //dbAdapter.open();
                //dbAdapter.deleteNote(note.getNoteId());

                alarms.clear();
                alarms.addAll(getAllAlarms()); //  (dbAdapter.getAllNotes());
                mAlarmListAdapter.notifyDataSetChanged();

                //dbAdapter.close();
                return true;
        }

        return super.onContextItemSelected(item);
    }
*/
    private void launchAlarmDetailActivity(MainActivity.FragmentToLaunch ftl,  int position) {
        Alarm alarm = (Alarm) getListAdapter().getItem(position);

        Intent intent = new Intent(getActivity(), AlarmDetailActivity.class);

        intent.putExtra(MainActivity.ALARM_ID_EXTRA, Integer.toString(alarm.getID()));
        intent.putExtra(MainActivity.ALARM_DESC_EXTRA, alarm.getDescription());

        switch (ftl) {
            case VIEW:
                intent.putExtra(MainActivity.ALARM_FRAGMENT_TO_LOAD_EXTRA, MainActivity.FragmentToLaunch.VIEW);
                break;
            case EDIT:
                intent.putExtra(MainActivity.ALARM_FRAGMENT_TO_LOAD_EXTRA, MainActivity.FragmentToLaunch.EDIT);
                break;
        }
        startActivity(intent);
    }

    private ArrayList<Alarm>getAllAlarms() {
        ArrayList<Alarm> alarms = new ArrayList<Alarm>();

        alarms.add(new Alarm(1000, "Alarma 1"));
        alarms.add(new Alarm(1001, "Alarma 2"));
        alarms.add(new Alarm(1002, "Alarma 3"));
        alarms.add(new Alarm(1003, "Alarma 4"));

        return alarms;
    }
}
