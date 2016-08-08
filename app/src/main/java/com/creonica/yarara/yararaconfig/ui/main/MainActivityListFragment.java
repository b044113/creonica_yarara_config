package com.creonica.yarara.yararaconfig.ui.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.creonica.yarara.yararaconfig.R;
import com.creonica.yarara.yararaconfig.model.Alarm;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    private ArrayList<Alarm> alarms;
    private AlarmAdapter alarmAdapter;

    @Override
    public void onActivityCreated(Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);

        //NotebookDbAdapter dbAdapter = new NotebookDbAdapter(getActivity().getBaseContext());
        //CONEXION A FIREBASE

        //Obtener la lista de alarmas
        //alarms = dbAdapter.getAllNotes();

        alarmAdapter = new AlarmAdapter(getActivity(),alarms);
        setListAdapter(alarmAdapter);

        registerForContextMenu(getListView());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        launchNoteDetailActivity(MainActivity.FragmentToLaunch.VIEW, position);
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(contextMenu, v, menuInfo);

        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.long_press_menu, contextMenu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item ) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int rowPosition = info.position;
        Alarm alarm = (Alarm) getListAdapter().getItem(rowPosition);

        switch (item.getItemId()){
            case R.id.edit:
                //do something
                launchNoteDetailActivity(MainActivity.FragmentToLaunch.EDIT,  rowPosition);
                return true;
            case R.id.delete:
                //do something
                NotebookDbAdapter dbAdapter = new NotebookDbAdapter(getActivity().getBaseContext());
                dbAdapter.open();
                dbAdapter.deleteNote(note.getNoteId());

                alarms.clear();
                alarms.addAll(dbAdapter.getAllNotes());
                alarmAdapter.notifyDataSetChanged();

                return true;
        }

        return super.onContextItemSelected(item);
    }

    private void launchNoteDetailActivity(MainActivity.FragmentToLaunch ftl,  int position) {
        Alarm alarm = (Alarm) getListAdapter().getItem(position);

        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);

        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA, note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA, note.getText());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA, note.getCategory());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA, note.getNoteId());

        switch (ftl) {
            case VIEW:
                intent.putExtra(MainActivity.NOTE_FRAGMENT_TO_LOAD_EXTRA, MainActivity.FragmentToLaunch.VIEW);
                break;
            case EDIT:
                intent.putExtra(MainActivity.NOTE_FRAGMENT_TO_LOAD_EXTRA, MainActivity.FragmentToLaunch.EDIT);
                break;
        }
        startActivity(intent);
    }

}
