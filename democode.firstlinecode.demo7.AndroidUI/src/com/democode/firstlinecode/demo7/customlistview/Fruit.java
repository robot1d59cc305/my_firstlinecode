package com.democode.firstlinecode.demo7.customlistview;

/**
 * 最基础的Bean类,用来保存最基本展示在视图中的ListView列表中的数据,数据就是存储在这个JavaBean类当中的.
 * @author Administrator
 *
 */
public class Fruit {

	private String name;
	
	private int resourceId;
	
	public Fruit() {
		super();
	}

	public Fruit(String name, int resourceId) {
		super();
		this.name = name;
		this.resourceId = resourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	
}