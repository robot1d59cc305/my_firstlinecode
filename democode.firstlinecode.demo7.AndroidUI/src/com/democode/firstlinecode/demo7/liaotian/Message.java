package com.democode.firstlinecode.demo7.liaotian;

/*
 * ��Ϣ��,������Ϣ�������Լ���Ϣ������.
 */
public class Message{
	
	/**
	 * ���������Ϣ�����������û����ı�������󷢳���.
	 */
	public static final int fachu = 0;
	
	/**
	 * ���������Ϣ�����������û����ܶԷ���.
	 */
	public static final int shou  = 1;
	
	private int zhaungtaima;
	
	/**
	 * ��ʾ�����Ϣ������
	 */
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static int getFachu() {
		return fachu;
	}

	public static int getShou() {
		return shou;
	}

	public int getZhaungtaima() {
		return zhaungtaima;
	}

	public void setZhaungtaima(int zhaungtaima) {
		this.zhaungtaima = zhaungtaima;
	}

	public Message(int zhaungtaima, String content) {
		super();
		this.zhaungtaima = zhaungtaima;
		this.content = content;
	}
	
}