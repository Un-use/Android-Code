package com.cnq.apapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
	private List<Fragment> fragList;

	public MyAdapter(FragmentManager fm, List<Fragment> fragList) {
		super(fm);
		this.fragList = fragList;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragList.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragList.size();
	}

}
