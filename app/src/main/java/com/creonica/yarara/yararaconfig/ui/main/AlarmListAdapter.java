package com.creonica.yarara.yararaconfig.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.creonica.yarara.yararaconfig.R;
import com.creonica.yarara.yararaconfig.model.Alarm;

import java.util.ArrayList;


/**
 * Created by ak03 on 09/08/2016.
 */
public class AlarmListAdapter extends ArrayAdapter<Alarm> {

    public AlarmListAdapter(Context context, ArrayList<Alarm> alarms) {
        super(context, 0, alarms);
    }

    public static class ViewHolder {
        TextView alarmID;
        TextView alarmDesc;
        TextView sensorCount;
        TextView userCount;
        ImageView alarmEnabled;
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

            viewHolder.alarmID = (TextView) convertView.findViewById(R.id.listItemAlarmID);
            viewHolder.alarmDesc = (TextView) convertView.findViewById(R.id.listItemAlarmDesc);
            viewHolder.sensorCount = (TextView) convertView.findViewById(R.id.listItemSensorCount);
            viewHolder.userCount = (TextView) convertView.findViewById(R.id.listItemUsersCount);
            viewHolder.alarmEnabled = (ImageView) convertView.findViewById(R.id.listItemEnabled_image);

            //Para que recuerda el holder de las referencias
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.alarmID.setText(Integer.toString(alarm.getID()));
        viewHolder.alarmDesc.setText(alarm.getDescription());
        viewHolder.sensorCount.setText(String.valueOf(alarm.getSensors().size()));
        viewHolder.userCount.setText(String.valueOf(alarm.getUsers().size()));

        return convertView;
    }

}
