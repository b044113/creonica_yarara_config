package com.creonica.yarara.yararaconfig.ui.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.creonica.yarara.yararaconfig.R;
import com.creonica.yarara.yararaconfig.model.Sensor;
import com.creonica.yarara.yararaconfig.model.User;
import com.creonica.yarara.yararaconfig.utils.AlarmFactory;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends ListFragment {

    private UserListAdapter mUserListAdapter;
    private ArrayList<User> users;
    private ListView mListView;

    public UserListFragment() {
        // Required empty public constructor
    }

    public static UserListFragment newInstance(String dummyVal) {
        UserListFragment fragment = new UserListFragment();
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

        Intent intent = getActivity().getIntent();
        Integer id = Integer.valueOf(intent.getExtras().getString(MainActivity.ALARM_ID_EXTRA));
        users = new ArrayList<User>(AlarmFactory.getAlarmFactory(getActivity())
                .getAlarm(id)
                .getUsers().values());  //getAllSensors();  //dbAdapter.getAllNotes();


        //dbAdapter.close();

        mUserListAdapter = new UserListAdapter(getActivity(),users);
        setListAdapter(mUserListAdapter);

        registerForContextMenu(getListView());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //TO DO: DIAPARAR EL CUADRO DE DIALOGO PARA SETEAR NOMBRE DE SENSOR Y ESTADO
        //launchAlarmDetailActivity(MainActivity.FragmentToLaunch.VIEW, position);
    }

    private ArrayList<User>getAllUsers() {
        ArrayList<User> users = new ArrayList<User>();

        return users;
    }

}
