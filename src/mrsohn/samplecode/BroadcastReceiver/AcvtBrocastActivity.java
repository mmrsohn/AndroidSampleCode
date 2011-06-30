package mrsohn.samplecode.BroadcastReceiver;

import mrsohn.samplecode.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class AcvtBrocastActivity extends Activity{
	private Intent intent 	= getIntent();
	private String action 	= intent.getAction();
	private Uri 	uri 	= intent.getData();
	private String dataPath = intent.getData().toString();
	private Cursor cursor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acvt_brocast_listview);
		//broadcastReceiver 처리 떠넘기기 
		startNextMatchingActivity(intent);
		
		final Uri data = Uri.parse(dataPath + "people/");
		cursor = managedQuery(data, null, null, null, null);
		
		String[] from = new String[] {People.NAME};
		int[] to = new int[] {R.id.actv_brocast_textView};
		
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.acvt_brocast_textview, cursor, from, to);
		
		ListView lv = (ListView)findViewById(R.id.actv_brocast_listView);
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(itemClickListener);
	}
	
	OnItemClickListener itemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
			cursor.moveToPosition(pos);
			int rowId = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
			
//			Uri outUri = Uri.parse(data)
			
		}
		
	};
}
