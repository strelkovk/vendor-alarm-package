vendor-alarm-package
====================

Class fo android to find vendor alarm settings. Can run intent of vendor alarm. Intent to launch the clock application on android. com.android.alarmclock. Updating 


Ho to use

Static call, just pass the context VendorAlarmPackage.getAlarmPackage(context)

>>
			pendingIntent = PendingIntent.getActivity(context, 0, VendorAlarmPackage.getAlarmPackage(context), 0);
			views.setOnClickPendingIntent(R.id.Widget, pendingIntent);