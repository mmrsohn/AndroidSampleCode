package mrsohn.samplecode.optionMenu;

import mrsohn.samplecode.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;

public class OptionMenuActivity extends Activity{
	
	static final private int MENU_ITEM = Menu.FIRST;
	
	/** 
	 * 옵션메뉴 생성
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		
      // Group ID
	  int groupId = 0;
	  // Unique menu item identifier. Used for event handling.
	  int menuItemId = MENU_ITEM;
	  // The order position of the item
	  int menuItemOrder = Menu.NONE;
	  // Text to be displayed for this menu item.
	  int menuItemText = R.string.hello;

	  // Create the menu item and keep a reference to it.
	  MenuItem menuItem = menu.add(groupId, menuItemId, menuItemOrder, menuItemText);
	  
	  //서브 메뉴
	  SubMenu subMenu = menu.addSubMenu( 0, 0, Menu.NONE, "하위메뉴");
	  MenuItem subMenuItem = subMenu.add(0, 0, Menu.NONE, "하위메뉴 아이템");
		return true;
	}
	
	/**
	 * 옵션메뉴 선택시 
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_ITEM:
			
			break;

		}
			
		// 메뉴아이템을 처리하지 않았다면 false반환
		return false;
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// 동적 메뉴 수정
		
//		MenuItem item = menu.findItem(MENU_ITEM);
		
		return true;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
//		setContentView(layoutResID);
		// 뷰에 컨텍스트 메뉴 설정		
//		registerForContextMenu(view);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// 컨텍스트 메뉴 생성
		super.onCreateContextMenu(menu, v, menuInfo);
		
		menu.setHeaderTitle("Context Menu");
		  menu.add(0, menu.FIRST, Menu.NONE, "Item 1").setIcon(R.drawable.gradient_line);
		  menu.add(0, menu.FIRST+1, Menu.NONE, "Item 2").setCheckable(true);
		  menu.add(0, menu.FIRST+2, Menu.NONE, "Item 3").setShortcut('3', '3');
		  SubMenu sub = menu.addSubMenu("Submenu");
		  sub.add("Submenu Item");
		  
		  /**
		   * xml메뉴 인플레이트 시키기
		   */
//		  MenuInflater inflater = getMenuInflater();
//		  inflater.inflate(R.menu.xml_menu_create , menu);
//		  menu.setHeaderTitle("xml컨텍스트 메뉴");
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) { 
	  super.onContextItemSelected(item);

//	  [ ... Handle menu item selection ... ]

	  return false;
	}
}
