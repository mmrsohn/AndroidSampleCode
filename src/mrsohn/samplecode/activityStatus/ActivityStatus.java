package mrsohn.samplecode.activityStatus;

import mrsohn.samplecode.R;
import mrsohn.samplecode.mymenu.MyMemuCustomDialog;
import mrsohn.samplecode.mymenu.MyMenuActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ActivityStatus extends Activity{
	
	// 전체 수명이 시작될 때 호출
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//액티비티를 초기화 한다
		Toast.makeText(getApplicationContext(), "onCreate", 10000).show();
		
		setContentView(R.layout.mymenu);
		
		//하단의 "메뉴선택" 누를 때    투명Activity 띄우기  
		findViewById(R.id.myMenu_alert_btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.myMenu_alert_btn:
					Intent intent = new Intent(getApplicationContext(), MyMemuCustomDialog.class);
					startActivity(intent);
					break;
				}
			}
		});
	}
	
	// onCreate가 종료 되고 호출된다
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		//savedInstanceState를 이용해 UI상태를 복구한다.
		//이 Bundle는 onCreate에도 전달된다.
		Toast.makeText(getApplicationContext(), "onRestoreInstanceState", 10000).show();
	}
	
	/**
	 * 가시수명 : onStart 호출과 onStop 호출 사이다.
	 */
	// 가시 수명으로 이어지기 전, 액티비티 처리를 위해 호출된다.
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		// 액티비티가 이미 화면에 보이고 있다고 생각하고 
		// 변경된 내용을 읽어 들인다.
		Toast.makeText(getApplicationContext(), "onRestart", 10000).show();
	}
	
	// 가시 수명이 시작될 때 호출된다.
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		// 이제 액티비티가 화면에 보이므로 
		// 필요한 모든 UI 변경사항을 적용한다.
		Toast.makeText(getApplicationContext(), "onStart", 10000).show();
	}
	
	/**
	 * 활성 수명 : onResume 호출에서 시작하고 그에 대응하는 onPause호출에서 끝난다
	 */
	// 활성 수명이 사직될때 호출된다.
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// 일시 중지된 UI 업데이트 스레드
		// 혹은 액티비티가 비활성화 되면서 잠시 중단됐던 처리를
		// 모두 재개한다.
		Toast.makeText(getApplicationContext(), "onResume", 10000).show();
	}
	
	// 활성 수명이 끝날때, UI 상태변화를 저장하기 위해 호출된다.
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		// UI상태 변화를 저장하기 saveIntanceState에 저장한다
		// 프로세스가 종료되고 재시작 될 경우
		// 이 번들이 onCreate에 전달 될 것이다.
		Toast.makeText(getApplicationContext(), "onSaveInstanceState", 10000).show();
	}
	
	// 활성 수명이 끝날 때 호출된다.
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// 액티비티가 활성 상태의 포그라운드 액티비티가 아닐경우
		// 업데이트 할 필요가 없는 UI업데이트나 스레드
		//혹은 CPU 사용량이 많은 처리를 일시 중단한다.
		Toast.makeText(getApplicationContext(), "onPause", 10000).show();
	}
	// 가시 수명이 끝날 때 호출된다.
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		//남아있는 UI 업데이트나 스레드 혹은 
		//이 액티비티가 화면에 보이지 않을때 필요치 않은 처리를 일시 중단한다.
		// 이 메서드가 호출되고 난 뒤에는 프로세스가 종료 될 가능성이 있으므로
		// 바뀐 모든 내용과 상태 변화를 지속시킨다.
		Toast.makeText(getApplicationContext(), "onStop", 10000).show();
	}
	
	// 전체 수명이 끝날 때 호출된다.
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		// 스레드를 종료하고, 데이터베이스 연결을 닫는 등
		// 모든 리소스를 해제한다.
		Toast.makeText(getApplicationContext(), "onDestroy", 10000).show();
	}
}
