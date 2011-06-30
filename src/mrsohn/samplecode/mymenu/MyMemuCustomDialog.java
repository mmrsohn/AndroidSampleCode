package mrsohn.samplecode.mymenu;

import mrsohn.samplecode.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Toast;

public class MyMemuCustomDialog extends Activity {
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.mymenu_dialog);			
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND, WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
			
			findViewById(R.id.m01).setOnClickListener(onClickListener);
			findViewById(R.id.m02).setOnClickListener(onClickListener);
			findViewById(R.id.m03).setOnClickListener(onClickListener);
			findViewById(R.id.m04).setOnClickListener(onClickListener);
			findViewById(R.id.m05).setOnClickListener(onClickListener);
			findViewById(R.id.m06).setOnClickListener(onClickListener);
			findViewById(R.id.m07).setOnClickListener(onClickListener);
			findViewById(R.id.m08).setOnClickListener(onClickListener);
			findViewById(R.id.m09).setOnClickListener(onClickListener);
			findViewById(R.id.m10).setOnClickListener(onClickListener);
			findViewById(R.id.m11).setOnClickListener(onClickListener);
			findViewById(R.id.m12).setOnClickListener(onClickListener);
			findViewById(R.id.m13).setOnClickListener(onClickListener); 
		}
		OnClickListener onClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.m01:
					Toast.makeText(MyMemuCustomDialog.this, "관심종목", Toast.LENGTH_SHORT).show();
					break;
				case R.id.m02:
					Toast.makeText(MyMemuCustomDialog.this, "현재가", Toast.LENGTH_SHORT).show();
					break;
				case R.id.m03:
					Toast.makeText(MyMemuCustomDialog.this, "호가", Toast.LENGTH_SHORT).show();
					break;
				case R.id.m04:
					Toast.makeText(MyMemuCustomDialog.this, "해외지수", Toast.LENGTH_SHORT).show();
					break;
				case R.id.m05:
					Toast.makeText(MyMemuCustomDialog.this, "주요지수", Toast.LENGTH_SHORT).show();
					break;
				case R.id.m06:
					Toast.makeText(MyMemuCustomDialog.this, "주문", Toast.LENGTH_SHORT).show();
					break;
				case R.id.m07:
					Toast.makeText(MyMemuCustomDialog.this, "ELW", Toast.LENGTH_SHORT).show();
					break;
				case R.id.m08:
					Toast.makeText(MyMemuCustomDialog.this, "선물/옵션", Toast.LENGTH_SHORT).show();
					break;
				case R.id.m09:
					Toast.makeText(MyMemuCustomDialog.this, "뱅킹/지로", Toast.LENGTH_SHORT).show();
					break;
				case R.id.m10:
					Toast.makeText(MyMemuCustomDialog.this, "계좌", Toast.LENGTH_SHORT).show();
					break;
				case R.id.m11:
					Toast.makeText(MyMemuCustomDialog.this, "투자정보", Toast.LENGTH_SHORT).show();
					break;
				case R.id.m12:
					Toast.makeText(MyMemuCustomDialog.this, "거래내역", Toast.LENGTH_SHORT).show();
					break;
				case R.id.m13:
					Toast.makeText(MyMemuCustomDialog.this, "거래원", Toast.LENGTH_SHORT).show();
					break;
				}
			}
		};
		
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			super.onKeyDown(keyCode, event);
			if (event.getAction() == KeyEvent.ACTION_DOWN) {
				switch (keyCode) {
				case KeyEvent.KEYCODE_HOME:
					Toast.makeText(this, "홈눌림", Toast.LENGTH_SHORT).show();
					finish();
					break;
				}			
			}
			return true;
			};
}
