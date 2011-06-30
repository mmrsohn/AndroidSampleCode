package mrsohn.samplecode.BroadcastReceiver;

import mrsohn.samplecode.R;
import mrsohn.samplecode.SampleMainActivity;
import mrsohn.samplecode.mainmenu2.MainMenu2Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Note;
import android.util.Log;
import android.widget.Toast;

public class BroadCastReceiverEx extends BroadcastReceiver{

	public static final String FIRE = "mrsohn.samplecode.FIRE";
	
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		// 수신 된 Intent 처리
		Uri data = intent.getData();
		String type = intent.getStringExtra("type");
		
		if (type.equals("warning")) {
			Log.e("MroshnSampleCode", "BroadCastReceiverEx : onReceiver");
			Intent startIntent = new Intent(FIRE, data);
//			startIntent.putExtra("type", type);
//			context.startActivity(startIntent);
			Toast.makeText(context, "Fire Borcast Receiver", 1000).show();
			
		}
		
	}

}
