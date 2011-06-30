package mrsohn.samplecode.mymenu;

import mrsohn.samplecode.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MyMenuActivity extends Activity{   
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mymenu);
		
		//하단의 "메뉴선택" 누를 때    투명Activity 띄우기  
		findViewById(R.id.myMenu_alert_btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.myMenu_alert_btn:
					Intent intent = new Intent(MyMenuActivity.this, MyMemuCustomDialog.class);
					startActivity(intent);
					break;
				}
			}
		});
	}
}
