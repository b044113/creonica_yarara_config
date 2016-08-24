package com.creonica.yarara.yararaconfig.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.creonica.yarara.yararaconfig.R;
import com.creonica.yarara.yararaconfig.model.Alarm;
import com.creonica.yarara.yararaconfig.model.Sensor;
import com.creonica.yarara.yararaconfig.utils.AlarmFactory;

import java.util.ArrayList;


public class SensorListFragment extends ListFragment {

    private SensorListAdapter mSensorListAdapter;
    private ArrayList<Sensor> sensors;
    private ListView mListView;

    public SensorListFragment() {
        // Required empty public constructor
    }

    public static SensorListFragment newInstance(String dummyVal) {
        SensorListFragment fragment = new SensorListFragment();
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
        sensors = new ArrayList<Sensor>(AlarmFactory.getAlarmFactory(getActivity())
                                                    .getAlarm(id)
                                                    .getSensors().values());  //getAllSensors();  //dbAdapter.getAllNotes();

        //dbAdapter.close();

        mSensorListAdapter = new SensorListAdapter(getActivity(),sensors);
        setListAdapter(mSensorListAdapter);

        //registerForContextMenu(getListView());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //TO DO: DIAPARAR EL CUADRO DE DIALOGO PARA SETEAR NOMBRE DE SENSOR Y ESTADO
        //launchAlarmDetailActivity(MainActivity.FragmentToLaunch.VIEW, position);
    }

    private ArrayList<Sensor>getAllSensors() {
        ArrayList<Sensor> sensors = new ArrayList<Sensor>();

        return sensors;
    }

}
