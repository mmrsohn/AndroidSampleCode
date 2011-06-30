package mrsohn.samplecode;

import mrsohn.samplecode.BroadcastReceiver.BroadCastReceiverActivity;
import mrsohn.samplecode.activityStatus.ActivityStatus;
import mrsohn.samplecode.audioTest.AudioRecordTest;
import mrsohn.samplecode.dndlist.DndListActivity;
import mrsohn.samplecode.imageswitcher.ImageSwitcherActivity;
import mrsohn.samplecode.internet.InternetActivity;
import mrsohn.samplecode.keepbacklight.KeepBackLightActivity;
import mrsohn.samplecode.mainmenu2.MainMenu2Activity;
import mrsohn.samplecode.mymenu.MyMenuActivity;
import mrsohn.samplecode.sensor.GeoLocation;
import mrsohn.samplecode.sensor.SensorTestActivity;
import mrsohn.samplecode.service.ServiceEx;
import mrsohn.samplecode.sidepopup.SidePopupActivity;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SampleMainActivity extends Activity implements OnClickListener{

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        /** Drag and Drop 리스트 **/
        findViewById(R.id.DndListViewActivity).setOnClickListener(this);
        findViewById(R.id.ImageSwitcherActivity).setOnClickListener(this);
        findViewById(R.id.KeepBackLightActivity).setOnClickListener(this);
        findViewById(R.id.MainMenu2Activity).setOnClickListener(this);
        findViewById(R.id.MyMenuActivity).setOnClickListener(this);
        findViewById(R.id.SidePopupActivity).setOnClickListener(this);
        findViewById(R.id.SensorTestActivity).setOnClickListener(this);
        findViewById(R.id.BroadcastReceiverActivity).setOnClickListener(this);
        findViewById(R.id.InternetTestActivity).setOnClickListener(this);
        findViewById(R.id.GeoLocation).setOnClickListener(this);
        findViewById(R.id.ActivityStatus).setOnClickListener(this);
        findViewById(R.id.audiotest).setOnClickListener(this);
        
        startService(new Intent(this, ServiceEx.class));
        
    }
	
//	@Override
//	protected void onStop() {
//		// TODO Auto-generated method stub
//		
//		//서비스 중지하기
//		ComponentName service = startService(new Intent(this, ServiceEx.class));
//		stopService(new Intent(this, service.getClass()));
//		try {
//			Class serviceClass = Class.forName(service.getClassName());
//			stopService(new Intent(this, serviceClass));
//		} catch (ClassNotFoundException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		super.onStop();
//	}
//	
	
	public void onClick(View v) {
		switch (v.getId()) {
		/** Drag and Drop 리스트 **/
		case R.id.DndListViewActivity:
			startActivity(new Intent(this, DndListActivity.class));
			break;
		/** 이미지 스위처 */
		case R.id.ImageSwitcherActivity:
			startActivity(new Intent(this, ImageSwitcherActivity.class));
			break;
		/** 백라이트 유지 */
		case R.id.KeepBackLightActivity:
			startActivity(new Intent(this, KeepBackLightActivity.class));
			break;
		/** 메인메뉴2 */
		case R.id.MainMenu2Activity:
			startActivity(new Intent(this, MainMenu2Activity.class));
			break;
		case R.id.MyMenuActivity:
			startActivity(new Intent(this, MyMenuActivity.class));
			break;
		/** 사이트 팝업 메뉴 */
		case R.id.SidePopupActivity:
			startActivity(new Intent(this, SidePopupActivity.class));
			break;
		/** 센서 테스트 */
		case R.id.SensorTestActivity:
			startActivity(new Intent(this, SensorTestActivity.class));
			break;
		/** BroadcastReceiver 액티비티 */
		case R.id.BroadcastReceiverActivity:
			startActivity(new Intent(this, BroadCastReceiverActivity.class));
			break;
		/** 인터넷테스트 */
		case R.id.InternetTestActivity:
			startActivity(new Intent(this, InternetActivity.class));
			break;
		/** 위치 정보 */
		case R.id.GeoLocation:
			startActivity(new Intent(this, GeoLocation.class));
			break;
		/** Activity 생명주기 */
		case R.id.ActivityStatus:
			startActivity(new Intent(this, ActivityStatus.class));
			break;
		/** 오디오테스트 */
		case R.id.audiotest:
			startActivity(new Intent(this, AudioRecordTest.class));
			break;
		}
		
	}
}
