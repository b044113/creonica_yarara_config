package com.creonica.yarara.yararaconfig.ui.main;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import com.creonica.yarara.yararaconfig.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddAlarmDialogFragment extends Fragment {
    //String mEncodedEmail;
    EditText mEditTextListName;

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_alarm_dialog, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.fragment_add_alarm_dialog, null);
        //mEditTextListName = (EditText) rootView.findViewById(R.id.edit_text_list_name);

        /**
         * Call addShoppingList() when user taps "Done" keyboard action
         */
        mEditTextListName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE || keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    addShoppingList();
                }
                return true;
            }
        });

        /* Inflate and set the layout for the dialog */
        /* Pass null as the parent view because its going in the dialog layout*/
        builder.setView(rootView)
                /* Add action buttons */
                .setPositiveButton(R.string.positive_button_create, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        addShoppingList();
                    }
                });

        return builder.create();
    }

    /**
     * Add new active list
     */
    public void addShoppingList() {
        String userEnteredName = mEditTextListName.getText().toString();

        /**
         * If EditText input is not empty
         */
        if (!userEnteredName.equals("")) {

            /**
             * Create Firebase references
             */
            //Firebase userListsRef = new Firebase(Constants.FIREBASE_URL_USER_LISTS).
            //child(mEncodedEmail);
            //final Firebase firebaseRef = new Firebase(Constants.FIREBASE_URL);

            //Firebase newListRef = userListsRef.push();

            /* Save listsRef.push() to maintain same random Id */
            //final String listId = newListRef.getKey();

            /* HashMap for data to update */
            //HashMap<String, Object> updateShoppingListData = new HashMap<>();

            /**
             * Set raw version of date to the ServerValue.TIMESTAMP value and save into
             * timestampCreatedMap
             */
            //HashMap<String, Object> timestampCreated = new HashMap<>();
            //timestampCreated.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);

            /* Build the shopping list */
            //ShoppingList newShoppingList = new ShoppingList(userEnteredName, mEncodedEmail,
            //        timestampCreated);

            //HashMap<String, Object> shoppingListMap = (HashMap<String, Object>)
            //        new ObjectMapper().convertValue(newShoppingList, Map.class);

            //Utils.updateMapForAllWithValue(null, listId, mEncodedEmail,
             //       updateShoppingListData, "", shoppingListMap);

            //updateShoppingListData.put("/" + Constants.FIREBASE_LOCATION_OWNER_MAPPINGS + "/" + listId,
            //        mEncodedEmail);

            /* Do the update */
            firebaseRef.updateChildren(updateShoppingListData, new Firebase.CompletionListener() {
                @Override
                public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                    /* Now that we have the timestamp, update the reversed timestamp */
                    Utils.updateTimestampReversed(firebaseError, "AddList", listId,
                            null, mEncodedEmail);
                }
            });

            /* Close the dialog fragment */
            AddAlarmDialogFragment.this.getDialog().cancel();
        }
    }
}
