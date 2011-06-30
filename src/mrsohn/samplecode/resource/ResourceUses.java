package mrsohn.samplecode.resource;

import android.R;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;

public class ResourceUses extends Activity{
	private Resources res;
	private AnimationDrawable animDraw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
//		resources.getText(R.string.cancel);
//		resources.getDimension(R.dimen.app_icon_size);
		
		animDraw = (AnimationDrawable)res.getDrawable(mrsohn.samplecode.R.anim.anim_frame_samle);		
		
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			//달라진 방향에 따라 반응한다.
		}
		
		if (newConfig.keyboardHidden == Configuration.KEYBOARDHIDDEN_NO) {
			//변경된 키보드 보임 여부에 반응한다.
		}
	}
	
}
