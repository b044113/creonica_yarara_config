package com.creonica.yarara.yararaconfig.ui.main;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import com.creonica.yarara.yararaconfig.R;
import com.creonica.yarara.yararaconfig.model.Alarm;
import com.creonica.yarara.yararaconfig.model.Sensor;
import com.creonica.yarara.yararaconfig.utils.AlarmFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddSensorDialogFragment extends DialogFragment {

    EditText mEditTextSensorDesc;

    public AddSensorDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Public static constructor that creates fragment and
     * passes a bundle with data into it when adapter is created
     */
    public static AddSensorDialogFragment newInstance(String encodedEmail) {
        AddSensorDialogFragment addSensorDialogFragment = new AddSensorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("dummy", encodedEmail);
        addSensorDialogFragment.setArguments(bundle);
        return addSensorDialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mEncodedEmail = getArguments().getString(Constants.KEY_ENCODED_EMAIL);
    }

    /**
     * Open the keyboard automatically when the dialog fragment is opened
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle(R.string.addSensorDialogTitle);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_sensor_dialog, container, false);

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Obtener el inflater de layout y pasarle la referencia al layout del fragmento
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.fragment_add_sensor_dialog, null);

        mEditTextSensorDesc = (EditText) rootView.findViewById(R.id.sensorDesc_editText);

        /* Inflate and set the layout for the dialog */
        /* Se definen las acciones de los botones de guardar y cancelar */
        builder.setView(rootView)
                .setTitle(R.string.addSensorDialogTitle)
                /* Add action buttons */
                .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        addSensor();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        AddSensorDialogFragment.this.getDialog().cancel();
                    }
                });

        return builder.create();
    }

    /**
     * Add new active list
     */
    public void addSensor() {
        String sensorDesc = mEditTextSensorDesc.getText().toString();

        Intent intent = getActivity().getIntent();
        String alarmID = intent.getExtras().getString(MainActivity.ALARM_ID_EXTRA);
        Alarm alarm = AlarmFactory.getAlarmFactory(getContext()).getAlarm(Integer.parseInt(alarmID));

        //Crea el nuevo ID para el sensor a partir del tamaño de sensores
        String newSensorID = alarmID + String.valueOf(alarm.getSensors().size() + 1);

        AlarmFactory.getAlarmFactory(getContext()).getAlarm(Integer.parseInt(alarmID))
                .getSensors().put(newSensorID,
                                    new Sensor(Integer.parseInt(newSensorID),
                                                sensorDesc,
                                                Sensor.SensorStatus.ENABLED));

        AddSensorDialogFragment.this.getDialog().cancel();
    }
}
