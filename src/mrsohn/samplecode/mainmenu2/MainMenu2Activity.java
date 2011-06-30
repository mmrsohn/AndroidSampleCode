package mrsohn.samplecode.mainmenu2;

import mrsohn.samplecode.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainMenu2Activity extends Activity{
	LinearLayout vLayout, vLayout2, vLayoutBottom;
	Context mContext;
	WindowManager windowManager;
	ImageButton imageButton;
	Bitmap bitmap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu2);
		
		mContext = getApplicationContext();
		
		findViewById(R.id.main_menu01).setOnClickListener(onClickListener);
		findViewById(R.id.main_menu02).setOnClickListener(onClickListener);
		findViewById(R.id.main_menu03).setOnClickListener(onClickListener);
		findViewById(R.id.main_menu04).setOnClickListener(onClickListener);
		findViewById(R.id.main_menu05).setOnClickListener(onClickListener);
		findViewById(R.id.main_menu06).setOnClickListener(onClickListener);
		findViewById(R.id.main_menu07).setOnClickListener(onClickListener);
		findViewById(R.id.main_menu08).setOnClickListener(onClickListener);
		findViewById(R.id.main_menu09).setOnClickListener(onClickListener);
		findViewById(R.id.main_menu10).setOnClickListener(onClickListener);
		findViewById(R.id.main_menu11).setOnClickListener(onClickListener);
		findViewById(R.id.main_menu12).setOnClickListener(onClickListener);
		
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.main_menu01:
				vLayout = (LinearLayout)findViewById(R.id.main_menu_layout01);		
				vLayoutBottom = (LinearLayout)findViewById(R.id.main_menu_bottom1);	//숨겨진 레이아웃 
				vLayout.setDrawingCacheEnabled(true);		
				
				bitmap = vLayout.getDrawingCache();
				if (bitmap == null) {
					Toast.makeText(MainMenu2Activity.this, "null", Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(MainMenu2Activity.this, "not null", Toast.LENGTH_SHORT).show();
					Drawable d = new BitmapDrawable(bitmap);
					
					vLayoutBottom.setBackgroundDrawable(d);
					
				}
				
				break;
			case R.id.main_menu05:
				vLayout = (LinearLayout)findViewById(R.id.main_menu_layout02);
				vLayoutBottom = (LinearLayout)findViewById(R.id.main_menu_bottom2);
				vLayout.setDrawingCacheEnabled(true);		
				
				bitmap = vLayout.getDrawingCache();
				if (bitmap == null) {
					Toast.makeText(MainMenu2Activity.this, "null", Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(MainMenu2Activity.this, "not null", Toast.LENGTH_SHORT).show();
					Drawable d = new BitmapDrawable(bitmap);
					
					vLayoutBottom.setBackgroundDrawable(d);
				}
				
				break;
			case R.id.main_menu09:
				vLayout = (LinearLayout)findViewById(R.id.main_menu_layout03);
				vLayoutBottom = (LinearLayout)findViewById(R.id.main_menu_bottom3);
				vLayout.setDrawingCacheEnabled(true);		
				
				bitmap = vLayout.getDrawingCache();
				
				if (bitmap == null) {
					Toast.makeText(MainMenu2Activity.this, "null", Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(MainMenu2Activity.this, "not null", Toast.LENGTH_SHORT).show();
					Drawable d = new BitmapDrawable(bitmap);
					
					vLayoutBottom.setBackgroundDrawable(d);
				}
				
				break;
			}
		}
	};
	
}
