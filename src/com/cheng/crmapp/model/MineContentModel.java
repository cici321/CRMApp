/*AUTO-GENERATED FILE.  DO NOT MODIFY.
 * 项目名称：	FamilyFun   
 * @DESCRIPTION: 
 * Copyright 	BF Corporation 2015   
 * 版权所有  
 *    
 */
package com.cheng.crmapp.model;

/*******************************************
 * @COMPANY: 武汉早点科技技术有限责任公司
 * @CLASS: MineContentModel
 * @DESCRIPTION:
 * @AUTHOR: CiCi
 * @VERSION: v1.0.1
 * @DATE: 2015-6-9 下午4:14:16
 *******************************************/
public class MineContentModel {
	public int image;
	public String imageUrl;
	public String key;
	public String name;
	public int type;
	public boolean isShow;

	public MineContentModel(int image, String imageUrl, String key, String name, int type, boolean isShow) {
		super();
		this.image = image;
		this.imageUrl = imageUrl;
		this.key = key;
		this.name = name;
		this.type = type;
		this.isShow = isShow;
	}

}