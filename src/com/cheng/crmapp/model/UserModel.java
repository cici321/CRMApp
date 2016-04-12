package com.cheng.crmapp.model;

public class UserModel {
	public String nickname = null;
	public String nickname_py = null;// 昵称拼音

	public String sex;
	public String phone;
	public String remark;

	public UserModel(String nickname, String nickname_py) {
		super();
		this.nickname = nickname;
		this.nickname_py = nickname_py;
	}

}
