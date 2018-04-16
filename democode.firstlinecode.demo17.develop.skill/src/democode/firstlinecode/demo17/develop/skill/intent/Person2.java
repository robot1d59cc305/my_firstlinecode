package democode.firstlinecode.demo17.develop.skill.intent;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 除了 Serializable 之外，使用 Parcelable 也可以实现相同的效果，不过不同于将对象进行
序列化，Parcelable 方式的实现原理是将一个完整的对象进行分解，而分解后的每一部分都
是 Intent 所支持的数据类型，这样也就实现传递对象的功能了。

   首先继承实现Parcelable接口,重写 describeContents()和 writeToParcel()这两个方法.
   其中describeContents方法返回0即可.
   其中writeToParcel方法中我们需要调用Parcel,writeXxx()方法将 Person 类中的字段一一写出。注意字符串型数据就调用 writeString()方
法，整型数据就调用 writeInt()方法，以此类推。    
   
 * @author Administrator
 *
 */
public class Person2 implements Parcelable {

	private String name;
	
	private int age;
	
	/**
	 * 我们还必须在 Person 类中提供一个名为 CREATOR 的常量，这里创建了Parcelable.Creator 接口的一个实现，并将泛型指定为 Person。
	 */
	public static final Parcelable.Creator<Person2> CREATOR = new Parcelable.Creator<Person2>() {
		
		/**
		 * 接着需要重写 createFromParcel()
和 newArray()这两个方法，在 createFromParcel()方法中我们要去读取刚才写出的 name 和 age
字段，并创建一个 Person 对象进行返回，其中 name 和 age 都是调用 Parcel 的 readXxx()方法
读取到的，注意这里读取的顺序一定要和刚才写出的顺序完全相同。
		 */
		public Person2 createFromParcel(Parcel source) {
			
			Person2 person = new Person2();
			
			person.name = source.readString();
			
			person.age = source.readInt();
			
			return person;
		}

		/**
		 * 而 newArray()方法中的实现就简单多了，只需要 new 出一个 Person 数组，并使用方法中传入的 size 作为数组大小就可以了。
		 */
		@Override
		public Person2[] newArray(int size) {
			
			return new Person2[size];
		};
		
	};
	
	/**
	 * 这个方法返回0即可.
	 */
	@Override
	public int describeContents() {
		
		return 0;
	}

	/**
	 * 我们需要调用 Parcel的 writeXxx()方法将 Person 类中的字段一一写出
	 * 注意字符串型数据就调用 writeString()方法，整型数据就调用 writeInt()方法，以此类推。
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {

	}

}