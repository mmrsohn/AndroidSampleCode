package mrsohn.samplecode.BroadcastReceiver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BroadCastReceiverActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		/** 자바코드로 레이아웃 생성  */
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		
		Button broadCastTestBtn = new Button(this);
		broadCastTestBtn.setText("브로드캐스트 시작");
		
		int llHeight = LinearLayout.LayoutParams.FILL_PARENT;
		int llWidth = LinearLayout.LayoutParams.WRAP_CONTENT;
		
		ll.addView(broadCastTestBtn, new LinearLayout.LayoutParams(llHeight, llWidth));
		
		setContentView(ll);
		
		broadCastTestBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Log.e("MrsohnSampleCode", "BroadCastReceiverActivity : onClick");
				Intent intent = new Intent("mrsohn.samplecode.FIRE");	// manifest의 <action 에 지정된 메시지로 호출
				intent.putExtra("type", "warning");			//Intent로 값 전달
				
				//Broadcast 보내기
				sendBroadcast(intent);
				
				//Broadcast 순차적으로 보낼때 
//				sendOrderedBroadcast(intent, null);
			}
		});
	}
	
}
