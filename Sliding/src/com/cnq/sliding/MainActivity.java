package com.cnq.sliding;

import java.util.ArrayList;
import java.util.List;

import com.cnq.apapter.MyAdapter;
import com.cnq.fragment.ContactListFragment;
import com.cnq.fragment.FindFragment;
import com.cnq.fragment.ProfileFragment;
import com.cnq.fragment.WechatFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements OnClickListener,
		OnPageChangeListener {
	private WechatFragment wechatFragment;
	private ContactListFragment contactListFragment;
	private FindFragment findFragment;
	private ProfileFragment profileFragment;
	private List<ImageView> imgViewList;
	private List<Fragment> fragList;
	private ViewPager viewPager;
	private MyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		initData();
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
	}

	private void initData() {
		// TODO Auto-generated method stub
		imgViewList.get(0).setAlpha(1.0f);
		for (int i = 1; i < imgViewList.size(); i++) {
			imgViewList.get(i).setAlpha(0.0f);
		}

		fragList.add(wechatFragment);
		fragList.add(contactListFragment);
		fragList.add(findFragment);
		fragList.add(profileFragment);
	}

	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.container);
		wechatFragment = new WechatFragment();
		contactListFragment = new ContactListFragment();
		findFragment = new FindFragment();
		profileFragment = new ProfileFragment();

		fragList = new ArrayList<Fragment>();

		imgViewList = new ArrayList<ImageView>();
		ImageView imgView = (ImageView) findViewById(R.id.iv_wechat);
		imgView.setOnClickListener(this);
		imgViewList.add(imgView);
		imgView = (ImageView) findViewById(R.id.iv_contactList);
		imgView.setOnClickListener(this);
		imgViewList.add(imgView);
		imgView = (ImageView) findViewById(R.id.iv_find);
		imgView.setOnClickListener(this);
		imgViewList.add(imgView);
		imgView = (ImageView) findViewById(R.id.iv_profile);
		imgView.setOnClickListener(this);
		imgViewList.add(imgView);
		imgView.setOnClickListener(this);

		adapter = new MyAdapter(getSupportFragmentManager(), fragList);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		for (int i = 0; i < imgViewList.size(); i++) {
			imgViewList.get(i).setAlpha(0f);
		}
		switch (arg0.getId()) {
		case R.id.ib_wechat:
			viewPager.setCurrentItem(0, false);
			imgViewList.get(0).setAlpha(1.0f);
			break;
		case R.id.ib_contactList:
			viewPager.setCurrentItem(1, false);
			imgViewList.get(1).setAlpha(1.0f);
			break;
		case R.id.ib_find:
			viewPager.setCurrentItem(2, false);
			imgViewList.get(2).setAlpha(1.0f);
			break;
		case R.id.ib_profile:
			viewPager.setCurrentItem(3, false);
			imgViewList.get(3).setAlpha(1.0f);
			break;
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		if (arg1 > 0) {
			ImageView left = imgViewList.get(arg0);
			ImageView right = imgViewList.get(arg0 + 1);

			left.setAlpha(1 - arg1);
			right.setAlpha(arg1);
		}
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub

	}
}
