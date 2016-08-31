package com.creonica.yarara.yararaconfig.utils;

import android.content.Context;

import com.creonica.yarara.yararaconfig.model.Alarm;
import com.creonica.yarara.yararaconfig.model.Sensor;
import com.creonica.yarara.yararaconfig.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ak03 on 24/08/2016.
 */
public class AlarmFactory {
    private static AlarmFactory sAlarmFactory;

    private ArrayList<Alarm> mAlarms;

    public static AlarmFactory getAlarmFactory(Context context) {
        if (sAlarmFactory == null) {
            sAlarmFactory = new AlarmFactory(context);
        }

        return sAlarmFactory;
    }

    private AlarmFactory(Context context) {
        mAlarms =  getAllAlarms();
    }

    public ArrayList<Alarm> getAlarms() {
        return mAlarms;
    }

    public Alarm getAlarm(Integer id) {
        for (Alarm alarm : mAlarms) {
            if (alarm.getID() == id) {
                return alarm;
            }
        }

        return null;
    }

    private ArrayList<Alarm>getAllAlarms() {
        ArrayList<Alarm> alarms = new ArrayList<Alarm>();

        alarms.add(new Alarm(1000, "Alarma 1", "5491134548654"));
        alarms.add(new Alarm(1001, "Alarma 2", "5491154124874"));
        alarms.add(new Alarm(1002, "Alarma 3", "5491132142876"));
        alarms.add(new Alarm(1003, "Alarma 4", "5491139081758"));

        alarms.get(0).getSensors().put("10000001", new Sensor(10000001, "Cocina", Sensor.SensorStatus.ENABLED));
        alarms.get(0).getSensors().put("10000002", new Sensor(10000002, "Habitación Ppal.", Sensor.SensorStatus.DISABLED));
        alarms.get(0).getSensors().put("10000003", new Sensor(10000003, "Habitación Chicos", Sensor.SensorStatus.DISABLED));
        alarms.get(0).getUsers().put("10000001", new User(10000001, "Pepe", "15654866", true));
        alarms.get(0).getUsers().put("10000002", new User(10000002, "Juana", "156543675", false));

        alarms.get(1).getSensors().put("10010001", new Sensor(10001001, "Cocina", Sensor.SensorStatus.ENABLED));
        alarms.get(1).getSensors().put("10010002", new Sensor(10001002, "Habitación", Sensor.SensorStatus.ENABLED));
        alarms.get(1).getUsers().put("10000001", new User(10010001, "Raul", "15654866", true));

        alarms.get(2).getSensors().put("10020001", new Sensor(10020001, "Jardín", Sensor.SensorStatus.ENABLED));
        alarms.get(2).getSensors().put("10020002", new Sensor(10020002, "Comedor", Sensor.SensorStatus.DISABLED));
        alarms.get(2).getUsers().put("10000001", new User(10020001, "Cacho", "15654866", true));


        return alarms;
    }
}
