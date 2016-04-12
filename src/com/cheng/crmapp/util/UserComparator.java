package com.cheng.crmapp.util;

import java.util.Comparator;

import com.cheng.crmapp.model.UserModel;

public class UserComparator implements Comparator<UserModel> {

	public int compare(UserModel o1, UserModel o2) {
		
		
		String sortpy1= o1.nickname_py;
		String sortpy2= o2.nickname_py;
		
		
		if (sortpy1.equals("@")
				|| sortpy2.equals("#")) {
			return -1;
		} else if (sortpy1.equals("#")
				|| sortpy2.equals("@")) {
			return 1;
		} else {
			return sortpy1.compareTo(sortpy2);
		}
	}

}
