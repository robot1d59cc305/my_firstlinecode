package democode.firstlinecode.demo12.multimedia.choosepic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.democode.firstlinecode.demo12.notifications.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 照片程序
 * 当用户点击按钮启动拍照程序.
 * 拍照照片将照片自动放入修饰照片程序.
 * 用户修饰完照片将照片显示在应用程序当中.
 * 用户从相册选择图片然后将这张图片进行修饰放入照片程序.(这个做的失败,只是在相册里面选择了一张图片然后就显示图片加载失败,但是我确实是按照书上的代码写的).
 * @author Administrator
 *
 */
public class ChoosePicActivity extends Activity {
	
	public static final int TAKE_PHOTO = 1;
	
	public static final int CROP_PHOTO = 2;
	
	/**
	 * 拍照程序按钮,一般是用于用户还没有进行拍照的时候,用户需要点击这个按钮程序然后启动系统自带的拍照程序来拍照.
	 */
	private Button takePhoto;
	
	/**
	 * 图片展示控件,用户通过拍照程序按钮拍完照片之后,我们直接将拍完的图片展示出来,展示在这个控件里面.
	 */
	private ImageView picture;
	
	/**
	 * 通过这个Uri类,包装了拍照程序后说保存的图片,需要通过Uri类来访问这个图片,同样也需要通过Uri类作为创建Intent的实参之一.
	 * 我们为什么需要使用到Intent?因为我们需要通过Intent来启动拍照程序.
	 */
	private Uri       imageUri;
	
	/**
	 * 通过这个按钮,从相册里面选择图片进行裁剪.
	 */
	private Button chooseFromAlbum;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 1.设置内容视图,展现给用户.
		setContentView(R.layout.choosepic);
		
		// 2.获取资源ID.
		takePhoto = (Button) findViewById(R.id.take_photo);
		chooseFromAlbum = (Button) findViewById(R.id.choose_from_album);
		picture   = (ImageView) findViewById(R.id.picture);
		
		// 3.给takePhoto设置按钮响应事件.
		takePhoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*
				 * 4.在启动拍照程序之前,首先需要指定一个文件,这个文件因为这里是要拍照,拍完照片之后需要将得到的数据保存在一张照片文件之中.
				 *   所以选择使用的是.jpg类型的文件,同时给定了文件名,文件类型之后还需要给定的是这个文件的存储位置.这个文件是存储在手机内部还是存储在数据库当中.
				 *   我们这里给出的是SD卡的位置.同样将数据写到SD卡中也需要在AndroidManifest.xml文件中申明权限.
				 * */
				File outputImage = new File(Environment.getExternalStorageDirectory(),"tempImage.jpg");

				try {
					
					// 5.判断4中的图片是否已经存在,如果存在则进行删除操作.
					if (outputImage.exists()) {
						// 5.1 删除图片
						outputImage.delete();
					}
					
					// 6.重新创建一个新的文件出来.
					outputImage.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// 7.将outputImages文件加载到Uri的imageUri中.
				imageUri = Uri.fromFile(outputImage);
				
				// 8.准备跳转到相机程序然后再调用 Uri 的 fromFile()方法将 File 对象转换成 Uri 对象，这个 Uri 对象标识着 output_image.jpg 这张图片 的唯一地址.
				// 8.1 准备Intent
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
				
				// 8.2  调用putExtra方法指定imageUri的输出地址.
				intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
				
				/* 8.3 启动intent 
				 *  由于我们使用的是一个隐式Intent，系统会找出能够响应这个 Intent 的活动去启动，这样照相机程序就会被打开，拍下的照片将会输出到4中的 output_image.jpg 中.
				 * */
				startActivityForResult(intent,TAKE_PHOTO);  
			}
			
		});
		
		// 4.给chooseFromAlbum设置响应事件.
		chooseFromAlbum.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// 1.创建File对象,用于存储从相册中选择的照片,毕竟总不能够把用户相册里面的照片直接拿来进行修改.
				File outputImage = new File(Environment.getExternalStorageDirectory(),"output_image.jpg");
				
				try {
					// 2.判断outoutImage是否已经存在
					if (outputImage.exists()) {
						outputImage.delete();
					}
					
					// 3.创建一个新的文件.
					outputImage.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// 4.将1中的outputImage放入到Uri类中.
				imageUri = Uri.fromFile(outputImage);
				
				// 5.准备intent,指定action,这是隐式注册,正准备打开相册程序.
				Intent intent = new Intent("android.intent.action.GET_CONTENT");
				
				// 6.给这个intent设置一些必要的参数,包括是否允许缩放,裁剪,图片的输出位置.
				intent.setType("image/*");
				intent.putExtra("crop",true);
				intent.putExtra("scale",true);
				intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
				
				// 7.最后调用这个方法就可以打开相册选择照片,可以复用之前编写的逻辑.
				startActivityForResult(intent,CROP_PHOTO);
				
			}
			
		});
		
	}
	
	/**
	 * 9.在8当中调用的是startActivityForResult()方法,因此当用户拍完照之后会有结果返回到onActivityResult方法中.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		/*
		 * 10.匹配requestCode,就是在调用startActivityForResult给出的第二个参数.
		 * */
		switch (requestCode) {
			case TAKE_PHOTO:
				 
				 // 11.如果拍照程序执行成功.
				 if (resultCode == RESULT_OK) {
					 
					 // 12.则再构建出一个Intent出来,这个 Intent 是用于对拍出的照片进行裁剪的，因为摄像头拍出的照片都比较大，而我们可能只希望截取其中的一小部分。
					 Intent intent = new Intent("com.android.camera.action.CROP");
					 
					 // 13.然后给这个 Intent 设置上一些必要的属性
					 intent.setDataAndType(imageUri,"image/*");
					 intent.putExtra("scale",true);
					 intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
					 
					 // 14.并再次调用 startActivityForResult()来启动裁剪程序。裁剪后的照片同样会输出到 output_image.jpg 中. 执行完之后同样又会回调onActivityResult()方法.此时就会执行step15.
					 startActivityForResult(intent,CROP_PHOTO); // 启动裁剪程序.
				 }
				
			 	 break;
			 	 
			 // 15.
			case CROP_PHOTO:
				 
					 try {
						 // 16. 如果用户裁剪照片成功.
						 if (resultCode == RESULT_OK) {
							 
							 // 17.这个时候我们就可以调用 BitmapFactory 的 decodeStream()方法将 output_image.jpg 这张照片解析成 Bitmap 对象.因为我们要将裁剪好的照片放在ImageView控件中的,而这个控件放置图片需要这种类型数据.
							 Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
							 
							 // 18.然后此时再调用picture设置图片,但是这里的步骤还缺少一些,因为有可能会因为照片即使进行了裁剪但是还是因为照片太大,直接加载到内存当中会导致内存崩溃,需要对照片进行压缩后才能够再加载出来.
							 picture.setImageBitmap(bitmap); // 将裁剪后的照片显示出来
						 }
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				
				 break;
			default:
				break;
		}
		
	}
	
	
}