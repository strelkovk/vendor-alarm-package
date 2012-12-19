package net.strelkov.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class VendorAlarmPackage {
	
	static Intent getAlarmPackage(Context context)
	{
		PackageManager packageManager = context.getPackageManager();
		Intent AlarmClockIntent = new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER);
		
		String clockImpls[][] = {
				{ "Standard Alarm", "com.android.alarmclock", "com.android.alarmclock.AlarmClock" },
				{ "HTC Alarm ClockDT", "com.htc.android.worldclock", "com.htc.android.worldclock.WorldClockTabControl" },
				{ "Standard Alarm ClockDT", "com.android.deskclock", "com.android.deskclock.AlarmClock" },
				{ "Standar Alarm Clock2", "com.google.android.deskclock", "com.android.deskclock.AlarmClock"},
				{ "Froyo Nexus Alarm ClockDT","com.google.android.deskclock", "com.android.deskclock.DeskClock" },
				{ "Moto Blur Alarm ClockDT","com.motorola.blur.alarmclock", "com.motorola.blur.alarmclock.AlarmClock" },
				{ "Samsung Galaxy S", "com.sec.android.app.clockpackage","com.sec.android.app.clockpackage.ClockPackage" },
				{ "Sony Ericsson", "com.sonyericsson.alarm", "com.sonyericsson.alarm.Alarm" },
		};


		boolean foundClockImpl = false;

		for (int i = 0; i < clockImpls.length; i++)
		{
			String packageName = clockImpls[i][1];
			String className = clockImpls[i][2];
			try
			{
				ComponentName cn = new ComponentName(packageName, className);
				packageManager.getActivityInfo(cn,PackageManager.GET_META_DATA);
				AlarmClockIntent.setComponent(cn);
				foundClockImpl = true;
			} catch (NameNotFoundException nf)
			{
			}
		}
		
		if (foundClockImpl) {
			return AlarmClockIntent;
		} 
		else {
			return null;
		}		
	}

}
