/*AUTO-GENERATED FILE.  DO NOT MODIFY.
 * 项目名称：	ZitiShop   
 * @DESCRIPTION: 
 * Copyright 	BF Corporation 2015   
 * 版权所有  
 *    
 */
package com.cheng.crmapp.model;

/*******************************************
 * @COMPANY: 武汉早点科技技术有限责任公司
 * @CLASS: MenuMOdel
 * @DESCRIPTION:
 * @AUTHOR: CiCi
 * @VERSION: v1.0.1
 * @DATE: 2015-7-18 下午2:41:44
 *******************************************/
public class MenuModel {
	private int image;
	private int selectImage;
	private String name;

	public MenuModel(int image, String name) {
		super();
		this.image = image;
		this.name = name;
	}

	public MenuModel(int image, int selectImage, String name) {
		super();
		this.image = image;
		this.selectImage = selectImage;
		this.name = name;
	}

	public int getSelectImage() {
		return selectImage;
	}

	public void setSelectImage(int selectImage) {
		this.selectImage = selectImage;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
