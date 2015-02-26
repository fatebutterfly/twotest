package com.example.twotestr;

import java.util.List;

import com.example.twotest.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.winad.android.offers.AddScoreListener;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements AddScoreListener {

	private View txt1;
	private SlidingMenu menu;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt1);
        initSlidingMenu();
        com.winad.android.offers.AdManager.setAddScoreListener(this, this);
		com.winad.android.offers.AdManager.setUserID(this, "userid" );
		txt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				com.winad.android.offers.AdManager
				.showAdOffers(MainActivity.this);
			}});
		
		
		
    }


    private void initSlidingMenu() {  
        // 设置主界面视图  
    	//setContentView(R.layout.content_frame);  
        //getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new SampleListFragment()).commit();  
  
        
        
        // 设置滑动菜单的属性值  
        menu = new SlidingMenu(this);  
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);  
        menu.setShadowWidthRes(R.dimen.shadow_width);  
        menu.setShadowDrawable(R.drawable.shadow);  
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);  
        menu.setFadeDegree(0.35f);  
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);  
        // 设置滑动菜单的视图界面  
        menu.setMenu(R.layout.ad_main);
        View v1 = menu.findViewById(R.id.content_bar_back);
        v1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "似懂非懂沙发上地方", Toast.LENGTH_SHORT).show();
				
				Intent intent = getViewWebIntent(); 
		        //printInterestedActivitiesByIntent(intent); 
		        /*
		        // set the className to use the specific browser to open the webpage. 
		        intent.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity"); 
		        startActivity(intent); 
				*/
				
			}});
        txt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				menu.showMenu(true);
			}});
        
        //getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame, new SampleListFragment()).commit();  
    }
    
    private Intent getViewWebIntent() { 
        Intent viewWebIntent = new Intent(Intent.ACTION_VIEW); 
        Uri uri = Uri.parse("http://www.baidu.com"); 

        viewWebIntent.setData(uri); 
        return viewWebIntent; 
    } 
     
    
    @Override  
    public void onBackPressed() {  
        //点击返回键关闭滑动菜单  
        if (menu.isMenuShowing()) {  
            menu.showContent();  
        } else {  
            super.onBackPressed();  
        }  
    }


	@Override
	public void addScoreFaild(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addScoreSucceed(int arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub
		
	} 
    
}
