package mrsohn.samplecode.application;

import java.text.AttributedCharacterIterator.Attribute;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;

public class TextViewExtend extends TextView{

	public TextViewExtend(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	public TextViewExtend(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public TextViewExtend(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		// 텍스트 뒤에 나타날 것들을 캔버스에 그림
		super.onDraw(canvas);
		// 텍스트 앞에 나타낼 것들을 캔버스에 그림

	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//특정키 누름에 기반해 몇가지 특별한 처리 함
		//기반 클래스에 구현된 기존 기능을 이용해 키누름 이벤트에 반응한다.
		
		return super.onKeyDown(keyCode, event);
	}
}
