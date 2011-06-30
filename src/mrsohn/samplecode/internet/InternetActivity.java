package mrsohn.samplecode.internet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class InternetActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		RelativeLayout layout = new RelativeLayout(this);
		Button btn = new Button(this);
		btn.setText("인터넷테스트");
		
		int height = LinearLayout.LayoutParams.FILL_PARENT;
		int width = LinearLayout.LayoutParams.WRAP_CONTENT;
		
		layout.addView(btn);
		
		setContentView(layout);
		
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Context context = getApplicationContext();
				new SaxParserActivity(context);
			}
		});
	}
}
