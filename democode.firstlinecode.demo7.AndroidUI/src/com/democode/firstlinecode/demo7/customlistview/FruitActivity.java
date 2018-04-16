package com.democode.firstlinecode.demo7.customlistview;

import java.util.ArrayList;
import java.util.List;

import com.democode.firstlinecode.demo7.androidui.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * 
 * ʹ��FruitAdapter�����������й���,������չʾ.
 * @author Administrator
 *
 */
public class FruitActivity extends Activity {
	
	/**
	 * ����Դ.
	 */
	private List<Fruit> fruitList;
	
	/**
	 * ����������չ�����һ��������,ײ��ListView�൱��.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 1.������ͼ.
		setContentView(R.layout.fruitlayout);
		
		// 2.���س�ʼ��������
		initFruit();
		
		// 3.װ��һ��������.
		FruitAdapter fruitAdapter = new FruitAdapter(FruitActivity.this,R.layout.fruit_item,fruitList);
		
		// 4.��ȡ��ListView����Դ
		ListView listView = (ListView) findViewById(R.id.fruitlayout_listview1);
		
		// 5.��������װ��ListView����.
		listView.setAdapter(fruitAdapter);
		
	}
	
	/**
	 * ��ʼ������Դ�ķ���,��������Դ�����������.
	 * ����Ϊ�˲���һЩ����������,��˾����������ظ�������˷ǳ���Ķ���.
	 */
	public void initFruit() {
		fruitList = new ArrayList<Fruit>();
		Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
		fruitList.add(apple);
		Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
		fruitList.add(banana);
		Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
		fruitList.add(orange);
		Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
		fruitList.add(watermelon);
		Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
		fruitList.add(pear);
		Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
		fruitList.add(grape);
		Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
		fruitList.add(pineapple);
		Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
		fruitList.add(strawberry);
		Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
		fruitList.add(cherry);
		Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
		fruitList.add(mango);
		
		Fruit apple1 = new Fruit("Apple", R.drawable.apple_pic);
		fruitList.add(apple);
		Fruit banana1 = new Fruit("Banana", R.drawable.banana_pic);
		fruitList.add(banana);
		Fruit orange1 = new Fruit("Orange", R.drawable.orange_pic);
		fruitList.add(orange);
		Fruit watermelon1 = new Fruit("Watermelon", R.drawable.watermelon_pic);
		fruitList.add(watermelon);
		Fruit pear1 = new Fruit("Pear", R.drawable.pear_pic);
		fruitList.add(pear);
		Fruit grape1 = new Fruit("Grape", R.drawable.grape_pic);
		fruitList.add(grape);
		Fruit pineapple1 = new Fruit("Pineapple", R.drawable.pineapple_pic);
		fruitList.add(pineapple);
		Fruit strawberry1 = new Fruit("Strawberry", R.drawable.strawberry_pic);
		fruitList.add(strawberry);
		Fruit cherry1 = new Fruit("Cherry", R.drawable.cherry_pic);
		fruitList.add(cherry);
		Fruit mango1 = new Fruit("Mango", R.drawable.mango_pic);
		fruitList.add(mango);
		
		Fruit apple2 = new Fruit("Apple", R.drawable.apple_pic);
		fruitList.add(apple);
		Fruit banana2 = new Fruit("Banana", R.drawable.banana_pic);
		fruitList.add(banana);
		Fruit orange2 = new Fruit("Orange", R.drawable.orange_pic);
		fruitList.add(orange);
		Fruit watermelon3 = new Fruit("Watermelon", R.drawable.watermelon_pic);
		fruitList.add(watermelon);
		Fruit pear3 = new Fruit("Pear", R.drawable.pear_pic);
		fruitList.add(pear);
		Fruit grape3 = new Fruit("Grape", R.drawable.grape_pic);
		fruitList.add(grape);
		Fruit pineapple3 = new Fruit("Pineapple", R.drawable.pineapple_pic);
		fruitList.add(pineapple);
		Fruit strawberry3 = new Fruit("Strawberry", R.drawable.strawberry_pic);
		fruitList.add(strawberry);
		Fruit cherry3 = new Fruit("Cherry", R.drawable.cherry_pic);
		fruitList.add(cherry);
		Fruit mango3 = new Fruit("Mango", R.drawable.mango_pic);
		fruitList.add(mango);
		
		Fruit apple4 = new Fruit("Apple", R.drawable.apple_pic);
		fruitList.add(apple);
		Fruit banana4 = new Fruit("Banana", R.drawable.banana_pic);
		fruitList.add(banana);
		Fruit orange4 = new Fruit("Orange", R.drawable.orange_pic);
		fruitList.add(orange);
		Fruit watermelon4 = new Fruit("Watermelon", R.drawable.watermelon_pic);
		fruitList.add(watermelon);
		Fruit pear4 = new Fruit("Pear", R.drawable.pear_pic);
		fruitList.add(pear);
		Fruit grape4 = new Fruit("Grape", R.drawable.grape_pic);
		fruitList.add(grape);
		Fruit pineapple4 = new Fruit("Pineapple", R.drawable.pineapple_pic);
		fruitList.add(pineapple);
		Fruit strawberry4 = new Fruit("Strawberry", R.drawable.strawberry_pic);
		fruitList.add(strawberry);
		Fruit cherry4 = new Fruit("Cherry", R.drawable.cherry_pic);
		fruitList.add(cherry);
		Fruit mango4 = new Fruit("Mango", R.drawable.mango_pic);
		fruitList.add(mango);
	}
	
}