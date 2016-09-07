package com.creonica.yarara.yararaconfig.ui.main;


import android.app.Dialog;
import android.content.DialogInterface;
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
import com.creonica.yarara.yararaconfig.utils.AlarmFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddAlarmDialogFragment extends DialogFragment{
    //String mEncodedEmail;
    //EditText mEditTextListName;
    EditText mEditTextAlarmId;
    EditText mEditTextAlarmDesc;
    EditText mEditTextAlarmPhone;

    /**
     * Public static constructor that creates fragment and
     * passes a bundle with data into it when adapter is created
     */
    public static AddAlarmDialogFragment newInstance(String encodedEmail) {
        AddAlarmDialogFragment addListDialogFragment = new AddAlarmDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("dummy", encodedEmail);
        addListDialogFragment.setArguments(bundle);
        return addListDialogFragment;
    }

    public AddAlarmDialogFragment() {
        // Required empty public constructor
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
        getDialog().setTitle(R.string.ADD_ALARM_DIALOG_TITLE);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_alarm_dialog, container, false);

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Obtener el inflater de layout y pasarle la referencia al layout del fragmento
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.fragment_add_alarm_dialog, null);

        mEditTextAlarmId = (EditText) rootView.findViewById(R.id.alarmID_editText);
        mEditTextAlarmDesc = (EditText) rootView.findViewById(R.id.alarmDesc_editText);
        mEditTextAlarmPhone = (EditText) rootView.findViewById(R.id.alarmPhone_editText);

        /**
         * Call addShoppingList() when user taps "Done" keyboard action
         */
        /*mEditTextListName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE || keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    addShoppingList();
                }
                return true;
            }
        });
*/
        /* Inflate and set the layout for the dialog */
        /* Se definen las acciones de los botones de guardar y cancelar */
        builder.setView(rootView)
                .setTitle(R.string.ADD_ALARM_DIALOG_TITLE)
                /* Add action buttons */
                .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        addAlarm();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        AddAlarmDialogFragment.this.getDialog().cancel();
                    }
                });

        return builder.create();
    }

    /**
     * Add new active list
     */
    public void addAlarm() {
        String alarmId = mEditTextAlarmId.getText().toString();
        String alarmDesc = mEditTextAlarmDesc.getText().toString();
        String alarmPhone = mEditTextAlarmPhone.getText().toString();

        /**
         * If EditText input is not empty
         *
         */
        if (!alarmId.equals("") && !alarmPhone.equals("")) {
            //Esto hay que cambiarlo una vez que se implemente la BD
            AlarmFactory.getAlarmFactory(getContext())
                    .getAlarms().add(new Alarm(Integer.parseInt(alarmId) , alarmDesc, alarmPhone));

            AddAlarmDialogFragment.this.getDialog().cancel();
        }
    }
}
