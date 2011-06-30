package mrsohn.samplecode.background;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServiceExam extends Service{
	
	@Override
	public void onCreate() {
		// TODO : 서비스 생성 시 수행할 동작
		
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO : 서비스 바인딩으로 구현을 대체한다.
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO : 처리를 수행할 백그라운드 스레드를 띄운다.
//		return super.onStartCommand(intent, flags, startId);
		if ((flags & START_FLAG_RETRY) == 0) {
			// TODO : 재시작 된경우에 원하는 작업을 수행
			
		}else {
			// TODO : 처리를 수행할 백그라운드 스레드를 띄운다.
			
		}
		
		return Service.START_STICKY;
	}
	
}
