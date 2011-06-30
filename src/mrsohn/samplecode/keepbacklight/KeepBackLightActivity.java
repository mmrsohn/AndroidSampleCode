package mrsohn.samplecode.keepbacklight;

import mrsohn.samplecode.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class KeepBackLightActivity extends Activity {
	PowerManager pm;
	PowerManager.WakeLock wl;
	ToggleButton keepLightTgBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.keep_backlight);
		keepLightTgBtn = (ToggleButton)findViewById(R.id.KeepLightBtn);
		
		
		pm= (PowerManager) KeepBackLightActivity.this.getSystemService(Context.POWER_SERVICE);
		wl= pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "My Tag");

		if (keepLightTgBtn.isEnabled()) {
			wl.acquire();
		}else {
			wl.release();
		}
	}
}
