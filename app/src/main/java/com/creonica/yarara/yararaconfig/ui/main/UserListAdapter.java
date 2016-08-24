package com.creonica.yarara.yararaconfig.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.creonica.yarara.yararaconfig.R;
import com.creonica.yarara.yararaconfig.model.Sensor;
import com.creonica.yarara.yararaconfig.model.User;

import java.util.ArrayList;

/**
 * Created by ak03 on 23/08/2016.
 */
public class UserListAdapter extends ArrayAdapter<User> {
    public UserListAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    public static class ViewHolder {
        TextView userName;
        TextView userPhone;
        ImageView isAdmin;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the data item for this position
        User user = getItem(position);

        ViewHolder viewHolder;

        //Check if an existing View is being reused, otherwise inflate a new from custom row layout
        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_list_row, parent, false);

            viewHolder.userName= (TextView) convertView.findViewById(R.id.listItemUserName);
            viewHolder.userPhone = (TextView) convertView.findViewById(R.id.listItemUserPhone);
            //viewHolder.sensorEnabled = (ImageView) convertView.findViewById(R.id.listItemEnabled_image);

            //Para que recuerda el holder de las referencias
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.userName.setText(user.getName());
        viewHolder.userPhone.setText(user.getPhoneNumber());


        return convertView;
    }


}
