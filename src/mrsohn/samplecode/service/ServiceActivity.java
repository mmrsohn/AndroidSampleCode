package mrsohn.samplecode.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class ServiceActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
//	private IRemoteService mService = null;
//	private Handler mHandler ;
//	//Service Component
//	private IRemoteServiceCallback mCallback = new IRemoteServiceCallback.Stub() {
//		
//		@Override
//		public void MessageCallback(int msg) {
//			// TODO Auto-generated method stub
//			mHandler.sendEmptyMessage(msg);
//		}
//	};
//	
//	//Service Connection
//	private ServiceConnection mConnection  = new ServiceConnection() {
//		
//		@Override
//		public void onServiceConnected(ComponentName name, IBinder service) {
//			// IRemoteService Interface
//			mService = IRemoteService.Stub.asInterface(service);
//			try {
//				mService.registerCallback(mCallback);
//			} catch (RemoteException e) {
//				// TODO: handle exception
//				Log.e("ServiceActivity", String.valueOf(e));
//			}
//			
//		}
//		
//		@Override
//		public void onServiceDisconnected(ComponentName name) {
//			// TODO Auto-generated method stub
//			mService = null;
//		}
//	};
}
