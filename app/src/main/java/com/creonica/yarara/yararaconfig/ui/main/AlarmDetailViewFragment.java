package com.creonica.yarara.yararaconfig.ui.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.creonica.yarara.yararaconfig.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlarmDetailViewFragment extends Fragment {

    TabHost mTbH;

    public AlarmDetailViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentLayout = inflater.inflate(R.layout.fragment_alarm_detail_view, container, false);

        TextView alarmID = (TextView) fragmentLayout.findViewById(R.id.alarmID_textView);
        TextView alarmDesc = (TextView) fragmentLayout.findViewById(R.id.alarmDesc_textView);
        TextView alarmPhone = (TextView) fragmentLayout.findViewById(R.id.alarmPhone_textView);

        //LLenar los campos con la información de la alarma seleccionada
        Intent intent = getActivity().getIntent();
        alarmID.setText(intent.getExtras().getString(MainActivity.ALARM_ID_EXTRA));
        alarmDesc.setText(intent.getExtras().getString(MainActivity.ALARM_DESC_EXTRA));
        alarmPhone.setText(intent.getExtras().getString(MainActivity.ALARM_PHONE_EXTRA));

        mTbH = (TabHost) fragmentLayout.findViewById(R.id.alarmDetailtabHost); //llamamos al Tabhost
        mTbH.setup();                                                         //lo activamos

        TabHost.TabSpec tab1 = mTbH.newTabSpec("tab1");  //aspectos de cada Tab (pestaña)
        TabHost.TabSpec tab2 = mTbH.newTabSpec("tab2");

        tab1.setIndicator("Sensores");    //qué queremos que aparezca en las pestañas
        tab1.setContent(R.id.linearLayoutSensor); //definimos el id de cada Tab (pestaña)

        tab2.setIndicator("Usuarios");
        tab2.setContent(R.id.linearLayoutUser);

        mTbH.addTab(tab1); //añadimos los tabs ya programados
        mTbH.addTab(tab2);

        return fragmentLayout;
    }

}
