package com.creonica.yarara.yararaconfig.ui.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.creonica.yarara.yararaconfig.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlarmDetailViewFragment extends Fragment {


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

        //LLenar los campos con la información de la alarma seleccionada
        Intent intent = getActivity().getIntent();
        alarmID.setText(intent.getExtras().getString(MainActivity.ALARM_ID_EXTRA));
        alarmDesc.setText(intent.getExtras().getString(MainActivity.ALARM_DESC_EXTRA));

        return fragmentLayout;
    }

}
