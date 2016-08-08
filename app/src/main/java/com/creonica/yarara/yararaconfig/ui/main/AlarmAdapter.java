package com.creonica.yarara.yararaconfig.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.creonica.yarara.yararaconfig.R;
import com.creonica.yarara.yararaconfig.model.Alarm;

import java.util.ArrayList;

/**
 * Created by ak03 on 08/08/2016.
 */
public class AlarmAdapter extends ArrayAdapter<Alarm> {

    public AlarmAdapter(Context context, ArrayList<Alarm> alarms) {
        super(context, 0, alarms);
    }

    public static class ViewHolder {
        TextView textView_id;
        TextView textView_description;
        TextView textView_sensorsQty;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the data item for this position
        Alarm alarm = getItem(position);

        ViewHolder viewHolder;

        //Check if an existing View is being reused, otherwise inflate a new from custom row layout
        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.alarm_list_row, parent, false);

            viewHolder.textView_id = (TextView) convertView.findViewById(R.id.listItemAlarmID);
            viewHolder.textView_description = (TextView) convertView.findViewById(R.id.listItemAlarmDesc);
            //viewHolder.textView_sensorsQty = (ImageView) convertView.findViewById(R.id.listItemNoteImg);

            //Para que recuerda el holder de las referencias
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView_id.setText(alarm.getID());
        viewHolder.textView_description.setText(alarm.getDescription());
        //viewHolder.textView_sensorsQty.setText( alarm.getSensors().size());

        return convertView;
    }
}