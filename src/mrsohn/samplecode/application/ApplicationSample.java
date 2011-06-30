package mrsohn.samplecode.application;

import android.app.Application;
import android.content.res.Configuration;
	/**
	 * Application 
	 * 
	 * manifest에 android:name="ApplicationSample" 등록 해야 함
	 * 
	 *  사용할 땐
	 *  MyObject value = ApplicationSample.getInstance().getGlobalStateValue();
	 *  ApplicationSample.getInstance().setGlobalStateBalue(myObjectValue);
	 */
public class ApplicationSample extends Application{
	
	private static ApplicationSample singleton;
	
	// 애플리케이션  인스턴스를  리턴
	public static ApplicationSample getInstance() {
		return singleton;
	}
	@Override
	public void onCreate() {
		// 애플리케이션 생성시 호출 애플리케이션 싱글턴을 초기화 하고 
		// 애플리케이션의 모든 상태변수와 공유 리소스를 초기화 하려면 이 메서드를 재정의
		super.onCreate();
		singleton = this;
	}
	
	@Override
		public void onTerminate() {
			// 애플리케이션 객체가 종료할 때 호출 되지만, 항상 호출이 보장되는 것은 아님
			// 애플리케이션 리소스 회수를 위한 목적으로 커널에 의해 종료 되는 경우 
			// 해당 프로세스는 아무런 경고도 없이 종료 되며, 
			// 애플리케이션 객체의 onTerminate 핸들러도 호출되지 않을것이다. 
			super.onTerminate();
		}
	
	@Override
		public void onLowMemory() {
			// 액티비티와 달리 애플리케이션 객체는 구성 변경을 위해 종료 되었다 재시작 하지 않는다.
			// 애플리케이션 차원에서 구성 변경을 다룰 필요가 있다면 이 핸들러를 재정의 한다.
			super.onLowMemory();
		}
	
	@Override
		public void onConfigurationChanged(Configuration newConfig) {
			// TODO Auto-generated method stub
			super.onConfigurationChanged(newConfig);
		}
	
	
}
