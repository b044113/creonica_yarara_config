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
import com.creonica.yarara.yararaconfig.model.Sensor;

import java.util.ArrayList;

/**
 * Created by ak03 on 23/08/2016.
 */
public class SensorListAdapter extends ArrayAdapter<Sensor> {
    public SensorListAdapter(Context context, ArrayList<Sensor> sensors) {
        super(context, 0, sensors);
    }

    public static class ViewHolder {
        TextView sensorID;
        TextView sensorDesc;
        ImageView sensorEnabled;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the data item for this position
        Sensor sensor = getItem(position);

        ViewHolder viewHolder;

        //Check if an existing View is being reused, otherwise inflate a new from custom row layout
        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.sensor_list_row, parent, false);

            viewHolder.sensorID = (TextView) convertView.findViewById(R.id.listItemSensorID);
            viewHolder.sensorDesc = (TextView) convertView.findViewById(R.id.listItemSensorDesc);
            //viewHolder.sensorEnabled = (ImageView) convertView.findViewById(R.id.listItemEnabled_image);

            //Para que recuerda el holder de las referencias
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.sensorID.setText(Integer.toString(sensor.getID()));
        viewHolder.sensorDesc.setText(sensor.getDescription());


        return convertView;
    }


}
