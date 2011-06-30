package mrsohn.samplecode.service;

import java.util.Timer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.util.Log;
import android.widget.Toast;

public class ServiceEx extends Service{
	private Timer updateTimer;
	
	private int minimumMagnitude = 0;
	private boolean autoUpdate = false;
	private int updateFreq = 0;
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO : 처리를 수행할 백그라운드 스레드를 띄운다.
		//안드로이드 2.0 이전에 사용하던 onStart를 대체한다. 
		//서비스가 명시적으로 stopService나 StopSelf를 호출하기 전에 시스템이 서비스를 종료하는 경우에 시스템에게 재시작을 어떻게 처리해야 하는지 알려줄수 있따
		
		//서비스가 비정상 종료후 재시작되었음을 나타낸다. 서비스가 START_STICKY,로 설정된 경우 전달된다
		
		Toast.makeText(this, "서비스 : onStartCommand", 3000).show();
		Log.e("서비스", "onStartCommand");
		if ((flags & START_FLAG_RETRY) == 0) {
			// TODO : 재시작 된 경우에 원하는 작업을 수행한다.
		}else {
			// TODO : 처리를 수행할 백그라운드 스레드를 띄운다.
		}
		return Service.START_STICKY; 	//
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO : 서비스 바인딩 구현으로 대체한다.
		Toast.makeText(this, "서비스 : onBind", 3000).show();
		Log.e("서비스", "onBind");
		return null;
	}
	
	@Override
	public void onCreate() {
		// : 서비스 수행 시 수행할 동작
		Toast.makeText(this, "서비스 : onCreate", 3000).show();
		Log.e("서비스", "onCreate");
		super.onCreate();
	}
	
	
//	final RemoteCallbackList<IRemoteServiceCallback> mCallbackList = new RemoteCallbackList<IRemoteServiceCallback>();
//	Binder mBinder;
//	@Override
//	public IBinder onBind(Intent intent) {
//		// TODO Auto-generated method stub
//		if (IRemoteService.class.getName().equals(intent.getAction())) {
//			return mBinder;
//		}
//		return null;
//	}
	
}
