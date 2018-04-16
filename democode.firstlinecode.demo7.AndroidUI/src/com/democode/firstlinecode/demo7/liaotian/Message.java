package com.democode.firstlinecode.demo7.liaotian;

/*
 * 信息类,保存信息的内容以及信息的类型.
 */
public class Message{
	
	/**
	 * 代表这个消息类型是属于用户在文本框输入后发出的.
	 */
	public static final int fachu = 0;
	
	/**
	 * 代表这个消息类型是属于用户接受对方的.
	 */
	public static final int shou  = 1;
	
	private int zhaungtaima;
	
	/**
	 * 表示这个消息的内容
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