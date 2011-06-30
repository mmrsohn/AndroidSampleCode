package mrsohn.samplecode.dndlist;

import java.util.ArrayList;

import mrsohn.samplecode.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DndListActivity extends Activity implements DndListView.DragListener, DndListView.DropListener{
    
	private static final String TAG = "DndListActivity";
	public ArrayList<String> data = new ArrayList<String>();
	private DndListView customListView;
	private boolean isDnd = false;
	private ArrayAdapter mAdapter;
	
	/**
	 * 	최초 시작 List의 아이템을 ArrayList에 저장하는 부분
	 * */ 
	public DndListActivity(){
		super();
		data.add("1.손승범");
		data.add("2.김지현");
		data.add("3.박종필");
		data.add("4.정주열");
		data.add("5.관심종목");
		data.add("6.현재가");
		data.add("7.시세");
		data.add("8.손승범"); 
		data.add("9.김지현");
		data.add("10.박종필");
		data.add("11.정주열");
		data.add("12.관심종목");
		data.add("13.현재가");
		data.add("14.시세");
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnd_list_view);
        customListView = (DndListView) this.findViewById(android.R.id.list);//Custom List View 
        
        /**
         * 리스트어뎁터에 List의 Row가 될 레이아웃과  ArrayList<>를 넘긴다. 
		 * DB에서 여러개의  Row데이터를 받을 땐  별도의 클래스를 생성 ArrayList<>대신 Setter를 이용하면 좋다.
		 *  */
        mAdapter = new ListAdapter(this, R.layout.dnd_list_row, data);	
        customListView.setAdapter(mAdapter);
        
        customListView.setDragListener(this);	//DndListView 의 DragListener
		customListView.setDropListener(this);	//DndListView 의 DropListener
    }
	
	/**
	 * 리스트 어뎁터.
	 * @method		: ListAdapter
	 * @date		: 2011. 3. 29. 
	 * @author		: Mr-Sohn
	 * @history		: 
	 */
	private class ListAdapter extends ArrayAdapter<String> {

        private ArrayList<String> items;
        public ListAdapter(Context context, int textViewResourceId, ArrayList<String> item) {
                super(context, textViewResourceId, item);
                this.items = item;
                Log.e("", String.valueOf(item));
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;
	            if (v == null) {
	                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	                v = vi.inflate(R.layout.dnd_list_row, null);	// 
	            }
                if (data != null) {
            	    //dnd_list_row_title  TEXTVIEW에 배열 값 순서대로 집어 넣기
                    ((TextView) v.findViewById(R.id.dnd_list_row_title)).setText(items.get(position));
              }
                return v;
        }
	}

	/**
	 * DndListView의 drag Interface 
	 * @method		: drag
	 * @date		: 2011. 3. 29. 
	 * @author		: Mr-Sohn
	 * @history		: DndListView의 drag 인터페이스
	 */
	public void drag(int from, int to) {
		if(!isDnd){
			
			isDnd = true;
			Log.i("Drag and Drop : drag", "from : " + from + ", to : " + to);
		}
	}
	/**
	 * DndListView의 drop Interface 
	 * @method		: drop
	 * @date		: 2011. 3. 29. 
	 * @author		: Mr-Sohn
	 * @history		: DndListView의 drop 인터페이스
	 */
	public void drop(int from, int to) {
		if(isDnd){
			Log.i("Drag and Drop : drop", "from : " + from + ", to : " + to);
			if(from == to)
				return;
			
			String item = data.remove(from);
			data.add(to, item);
			
			isDnd = false;
			mAdapter.notifyDataSetChanged();
			Log.e(TAG +" drop",String.valueOf(data));
		}
	}
}