package com.democode.firstlinecode.demo7.customlistview;

/**
 * �������Bean��,�������������չʾ����ͼ�е�ListView�б��е�����,���ݾ��Ǵ洢�����JavaBean�൱�е�.
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