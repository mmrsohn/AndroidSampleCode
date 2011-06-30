package mrsohn.samplecode.dndlist;

import mrsohn.samplecode.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DndListView extends ListView {
	
	private Context mContext;	
	private ImageView mDragView;    
    private WindowManager mWindowManager;    
    private WindowManager.LayoutParams mWindowParams;    
    private int mDragPos;      // 드래그 아이템의 위치    
    private int mFirstDragPos; // 드래그 아이템의 원래 위치    
    private int mDragPoint;    
    private int mCoordOffset;  // 스크린에서의 위치와 뷰내에서의 위치의 차이    
    private DragListener mDragListener;    
    private DropListener mDropListener;    
    private int mUpperBound;    
    private int mLowerBound;    
    private int mHeight;    
    private Rect mTempRect = new Rect();    
    private Bitmap mDragBitmap;    
    private final int mTouchSlop;    
    private int mItemHeightNormal;    
    private int dndViewId;    
    private int dragImageX = 0;    
    private View vItem;	
    
	/**
	 * Instantiates a new dnd list view.
	 *
	 * @param context the context
	 * @param attrs the attrs
	 */
	public DndListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
	}
	
	/**
	 * 리스트가 클릭될 때 스크롤링 되는 부분을 컨트롤 할 수 있다.
	 *
	 * @param ev the ev
	 * @return true, if successful
	 */
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		final int x = (int) ev.getX();
        final int y = (int) ev.getY();
        final int itemnum = pointToPosition(x, y);
		if (mDragListener != null || mDropListener != null) {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (itemnum == AdapterView.INVALID_POSITION) {
                        break;
                    }
                    vItem = (View) getChildAt(itemnum - getFirstVisiblePosition()); // 드래그 아이템
                    View dragger = vItem.findViewById(dndViewId); // 드래그 이벤트를 할 아이템내에서의 뷰
                    
                    if(dragger == null)
                    	dragger = vItem;
                    final Rect r = mTempRect;
                    dragger.getDrawingRect(r);
                    
                    //Delete버튼 ClickListener
                    vItem.findViewById(R.id.dnd_list_deleteBtn).setOnClickListener(onClickListener);	
                    
                    /** 
                     * List를 이동 시킬 때 Move버튼을 이용하여 List의 위치를 변경
                     *  */
                    vItem.findViewById(R.id.dnd_list_moveBtn).setOnTouchListener(new OnTouchListener() {
						@Override
						public boolean onTouch(View v, MotionEvent event) {
							if (x < r.right * 2) {
		                        vItem.setDrawingCacheEnabled(true);
		                        // 드래그 하는 아이템의 이미지 캡쳐
		                        Bitmap bitmap = Bitmap.createBitmap(vItem.getDrawingCache());
		                        startDragging(bitmap, y);	//드레그 이미지를 y축으로 이동 
		                        mDragPos = itemnum;			//드레그 아이템의 위치
		                        mFirstDragPos = mDragPos;	//드레그 아이템의 첫번째 위치
		                        mHeight = getHeight();
		                        // 스크롤링을 위한 값 획득
		                        int touchSlop = mTouchSlop;
		                        mUpperBound = Math.min(y - touchSlop, mHeight / 3);
		                        mLowerBound = Math.max(y + touchSlop, mHeight * 2 /3);
		                    } 
							return false;
						}
					});
                    
                    mDragView = null;
                    break;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }
	
	/** The on click listener. */
	OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.dnd_list_deleteBtn :
				Log.e("dndLIstVeiw ONclickListener" ,  "   OnClickListener 의 delete 버튼 눌러짐 ");
				String tt = ((TextView)vItem.findViewById(R.id.dnd_list_row_title)).getText().toString();
				DndListActivity dndListActivity = new DndListActivity();
				Toast.makeText(mContext, tt, Toast.LENGTH_SHORT).show();
                Log.e("DndListView : onclickListener", tt + String.valueOf(mDragPos )			+"  "+
		                									String.valueOf(mFirstDragPos)		+"  "+
											                String.valueOf( mUpperBound)		+"  "+
											                String.valueOf(mLowerBound)			+"  "+
											                String.valueOf(mHeight)				+"  "+
											                String.valueOf( mItemHeightNormal)	+"  "+
											                String.valueOf(dndViewId)			+"  "+ 
											                String.valueOf(dndListActivity.data));
				break;
			}
		}
	};
	
	/* (non-Javadoc)
	 * @see android.widget.ListView#onTouchEvent(android.view.MotionEvent)
	 */
	@Override
    public boolean onTouchEvent(MotionEvent ev) {
        if ((mDragListener != null || mDropListener != null) && mDragView != null) {
            int action = ev.getAction(); 
            switch (action) {
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    Rect r = mTempRect;
                    mDragView.getDrawingRect(r);
                    stopDragging();
                    if (mDropListener != null && mDragPos >= 0 && mDragPos < getCount()) {
                        mDropListener.drop(mFirstDragPos, mDragPos);
                    }
                    unExpandViews(false);
                    break;
                    
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    int x = (int) ev.getX();
                    int y = (int) ev.getY();
                    dragView(x, y);
                    int itemnum = getItemForPosition(y);
                    if (itemnum >= 0) {
                        if (action == MotionEvent.ACTION_DOWN || itemnum != mDragPos) {
                            if (mDragListener != null) {
                                mDragListener.drag(mDragPos, itemnum);
                            }
                            mDragPos = itemnum;
                        }
                        int speed = 0;
                        adjustScrollBounds(y); // 스크롤 계산
                        if (y > mLowerBound) {
                            // 스크롤 최상위
                            speed = y > (mHeight + mLowerBound) / 2 ? 16 : 4;
                        } else if (y < mUpperBound) {
                            // 스크롤 최하위
                            speed = y < mUpperBound / 2 ? -16 : -4;
                        }
                        if (speed != 0) {
                            int ref = pointToPosition(0, mHeight / 2);
                            if (ref == AdapterView.INVALID_POSITION) {
                                //we hit a divider or an invisible view, check somewhere else
                                ref = pointToPosition(0, mHeight / 2 + getDividerHeight() + 64);
                            }
                            View v = getChildAt(ref - getFirstVisiblePosition());
                            if (v!= null) {
                                int pos = v.getTop();
                                setSelectionFromTop(ref, pos - speed);
                            }
                        }
                    }
                    break;
            }
            return true;
        }
        return super.onTouchEvent(ev);
    }
	
	/**
	 * Gets the item for position.
	 *
	 * @param y the y
	 * @return the item for position
	 */
	private int getItemForPosition(int y) {
        int adjustedy = y - mDragPoint - 32;
        int pos = myPointToPosition(0, adjustedy);
        if (pos >= 0) {
            if (pos <= mFirstDragPos) {
                pos += 1;
            }
        } else if (adjustedy < 0) {
            pos = 0;
        }
        return pos;
    }
	
	/**
	 * My point to position.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the int
	 */
	private int myPointToPosition(int x, int y) {
        Rect frame = mTempRect;
        final int count = getChildCount();
        for (int i = count - 1; i >= 0; i--) {
            final View child = getChildAt(i);
            child.getHitRect(frame);
            if (frame.contains(x, y)) {
                return getFirstVisiblePosition() + i;
            }
        }
        return INVALID_POSITION;
    }
	
	/**
	 * Adjust scroll bounds.
	 *
	 * @param y the y
	 */
	private void adjustScrollBounds(int y) {
        if (y >= mHeight / 3) {
            mUpperBound = mHeight / 3;
        }
        if (y <= mHeight * 2 / 3) {
            mLowerBound = mHeight * 2 / 3;
        }
    }
    
	/**
	 * Un expand views.
	 *
	 * @param deletion the deletion
	 */
	private void unExpandViews(boolean deletion) {
        for (int i = 0;; i++) {
            View v = getChildAt(i);
            if (v == null) {
                if (deletion) {
                    int position = getFirstVisiblePosition();
                    int y = getChildAt(0).getTop();
                    setAdapter(getAdapter());
                    setSelectionFromTop(position, y);
                }
                layoutChildren();
                v = getChildAt(i);
                if (v == null) {
                    break;
                }
            }
            ViewGroup.LayoutParams params = v.getLayoutParams();
            params.height = mItemHeightNormal;
            v.setLayoutParams(params);
            v.setVisibility(View.VISIBLE);
        }
    }
    
	
	/**
	 * Start dragging.
	 *	드레그가 시작될 때 전달받은 Bitmap와 Y축 좌표를 이용하여 드레깅 이미지 표현
	 * @param bm the bm
	 * @param y the y
	 */
	private void startDragging(Bitmap bm, int y) {
        stopDragging();

        mWindowParams = new WindowManager.LayoutParams();
        mWindowParams.gravity = Gravity.TOP;
        mWindowParams.x = dragImageX;
        mWindowParams.y = y - mDragPoint + mCoordOffset;

        mWindowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mWindowParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mWindowParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
			                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
			                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
			                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        mWindowParams.format = PixelFormat.TRANSLUCENT;
        mWindowParams.windowAnimations = 0;
        
        ImageView v = new ImageView(mContext);
        int backGroundColor = Color.parseColor("#e0103010");	//백그라운드 색 지정
        v.setBackgroundColor(backGroundColor);					//백그라운드 색깔 설정
        v.setImageBitmap(bm);									
        mDragBitmap = bm;

        mWindowManager = (WindowManager)mContext.getSystemService("window");
        mWindowManager.addView(v, mWindowParams);
        mDragView = v;
    }
	
	/**
	 * Drag view.
	 *
	 * @param x the x
	 * @param y the y
	 */
	private void dragView(int x, int y) {
        mWindowParams.y = y - mDragPoint + mCoordOffset;
        mWindowManager.updateViewLayout(mDragView, mWindowParams);
    }
    
	// 드래그 종료 처리
    
	/**
	 * Stop dragging.
	 */
	private void stopDragging() {
        if (mDragView != null) {
            WindowManager wm = (WindowManager)mContext.getSystemService("window");
            wm.removeView(mDragView);
            mDragView.setImageDrawable(null);
            mDragView = null;
        }
        if (mDragBitmap != null) {
            mDragBitmap.recycle();
            mDragBitmap = null;
        }
    }
    
    /**
     * 드래그 이벤트 리스너 등록.
     *
     * @param l 드래그 이벤트 리스너
     */
	public void setDragListener(DragListener l) {
        mDragListener = l;
    }
    
	/**
	 * 드랍 이벤트 리스너 등록.
	 *
	 * @param l 드랍 이벤트 리스너
	 */
    public void setDropListener(DropListener l) {
        mDropListener = l;
    }
    
    /**
     * 리스트 아이템에 있는 뷰들 중 드래그 드랍 이벤트를 발생시킬 뷰의 아이.
     *
     * @param id 드래그 드랍 이벤트를 발생시킬 뷰의 아이디
     */
    public void setDndView(int id){
    	dndViewId = id;
    }
    
    /**
     * 드래그시 표시되는 뷰의 스크린에서의 left padding.
     *
     * @param x 스크린에서의 left padding, 설정안하면 0
     */
    public void setDragImageX(int x){
    	dragImageX = x;
    }
    
    /**
     * The listener interface for receiving drag events.
     * The class that is interested in processing a drag
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addDragListener<code> method. When
     * the drag event occurs, that object's appropriate
     * method is invoked.
     *
     * @see DragEvent
     */
    public interface DragListener {
        
        /**
         * Drag.
         *
         * @param from the from
         * @param to the to
         */
        void drag(int from, int to);
    }
    
    /**
     * The listener interface for receiving drop events.
     * The class that is interested in processing a drop
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addDropListener<code> method. When
     * the drop event occurs, that object's appropriate
     * method is invoked.
     *
     * @see DropEvent
     */
    public interface DropListener {
        
        /**
         * Drop.
         *
         * @param from the from
         * @param to the to
         */
        void drop(int from, int to);
    }
}
