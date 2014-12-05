package com.zhongji.master.android.phone.util;

import java.io.File;
import java.io.FileNotFoundException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

/**
 * 图片处理 http://blog.csdn.net/swust_chenpeng/article/details/10898451
 * http://blog.csdn.net/floodingfire/article/details/8144615
 * 
 * @author Administrator 1.去掉截图
 */
public class PhotoUtils {

	private String TAG = "PhotoUtils";
	private Context context;
	private Bitmap bitmap;
	private static final String IMAGE_FILE_LOCATION = "file:///sdcard/temp.jpg";// temp
	Uri imageUri = Uri.parse(IMAGE_FILE_LOCATION);// The Uri to store the big
													// bitmap
	private static final int CHOOSE_SMALL_PICTURE = 1;
	public static final int CHOOSE_BIG_PICTURE = 2;
	public static final int CHOOSE_TAKE_PICTURE = 3;
	public static final int GET_IMAGE_VIA_CAMERA = 4;
	public int outputX = 100;
	public int outputY = 100;

	public PhotoUtils(Context context) {
		this.context = context;
	}

	/**
	 * 对话框-没截图
	 */
	public void getDialog() {
		CharSequence[] items = { "相册", "相机" };
		new AlertDialog.Builder(context).setTitle("选择图片来源")
				.setItems(items, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						if (which == 0) {
							// getBigPhoto();
							getImageFromAlbum();
						} else {
							// getBigTakePhoto();
							// getImageFromCamera();
							getImageFromCamera2();
						}
					}
				}).create().show();
	}

	/**
	 * 对话框-有截图
	 */
	public void getDialog2() {
		CharSequence[] items = { "相册", "相机" };
		new AlertDialog.Builder(context).setTitle("选择图片来源")
				.setItems(items, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						if (which == 0) {
							getBigPhoto();
							// getImageFromAlbum();
						} else {

							getBigTakePhoto();
							// getImageFromCamera();
						}
					}
				}).create().show();
	}

	public void getImageFromCamera2() {
		// 先验证手机是否有sdcard
		String status = Environment.getExternalStorageState();
		if (status.equals(Environment.MEDIA_MOUNTED)) {
			try {

				Intent intent = new Intent(
						android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
				((Activity) context).startActivityForResult(intent,
						GET_IMAGE_VIA_CAMERA);
			} catch (ActivityNotFoundException e) {
				// TODO Auto-generated catch block
				ToastUtils.getStance(context).showShortToast("没有找到储存目录");
			}
		} else {
			ToastUtils.getStance(context).showShortToast("没有储存卡");
		}
	}

	/**
	 * 拍照图片-无截图 bitmap = data.getParcelableExtra("data");
	 */
	public void getImageFromCamera() {
		Intent getImageByCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		((Activity) context).startActivityForResult(getImageByCamera,
				CHOOSE_SMALL_PICTURE);
	}

	/**
	 * 相册取图-无截图-有压缩 uri = data.getData(); uir to bitmap
	 */
	public void getImageFromAlbum() {
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType("image/*");// 相片类型
		((Activity) context).startActivityForResult(intent, CHOOSE_BIG_PICTURE);
	}

	/**
	 * 拍照-大图-截图 拍照-截图-imageUri to bitmap CHOOSE_TAKE_PICTURE-getTakePhoto()
	 */
	public void getBigTakePhoto() {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// action is
																	// capture
		intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		((Activity) context)
				.startActivityForResult(intent, CHOOSE_TAKE_PICTURE);// or
																		// TAKE_SMALL_PICTURE
	}

	/**
	 * 拍照-大图-截图2
	 */
	public void getTakePhoto() {
		Intent intent = new Intent("com.android.camera.action.CROP");
		setIntent(intent);
		intent.setDataAndType(imageUri, "image/*");
		intent.putExtra("return-data", false);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		((Activity) context).startActivityForResult(intent, CHOOSE_BIG_PICTURE);
	}

	/**
	 * 相册-大图-截图 imageUri to bitmap
	 */
	public void getBigPhoto() {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
		setIntent(intent);
		intent.putExtra("return-data", false);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		((Activity) context).startActivityForResult(intent, CHOOSE_BIG_PICTURE);
	}

	/**
	 * 相册-小图 bitmap = data.getParcelableExtra("data");
	 */
	public void getSamllPhoto() {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
		setIntent(intent);
		((Activity) context).startActivityForResult(intent,
				CHOOSE_SMALL_PICTURE);
	}

	/**
	 * 参数设置
	 * 
	 * @return
	 */
	private Intent setIntent(Intent intent) {
		intent.setType("image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
//		intent.putExtra("outputX", outputX);
//		intent.putExtra("outputY", outputY);
		intent.putExtra("scale", true);
		intent.putExtra("return-data", false);
		intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		intent.putExtra("noFaceDetection", true); // no face detection
		return intent;
	}

	/**
	 * Activity回调
	 * 
	 * @param requestCode
	 * @param resultCode
	 * @param data
	 * @return
	 */
	public Bitmap onActivityResult(int requestCode, int resultCode, Intent data) {
		System.out.println("CHOOSE_BIG_PICTURE" + CHOOSE_BIG_PICTURE);
		switch (requestCode) {

		case CHOOSE_BIG_PICTURE:
			Log.d(TAG, "CHOOSE_BIG_PICTURE: data = " + data);// it seems to be
																// null
			if (data.getData() != null) {
				// 相册-无截图
				imageUri = data.getData(); // 新增
			}

			if (imageUri != null) {
				if (bitmap != null) {
					bitmap.recycle();
				}
				bitmap = decodeUriAsBitmap(imageUri);// decode bitmap
				// bitmap = decodeUri(imageUri);
				System.out.println("1111" + imageUri.getPath());
				delFile(imageUri.getPath());
				return bitmap;
			}
			break;
		case CHOOSE_SMALL_PICTURE:
			if (data != null) {
				if (bitmap != null) {
					bitmap.recycle();
				}
				bitmap = data.getParcelableExtra("data");
				return bitmap;
			} else {
				Log.e(TAG, "CHOOSE_SMALL_PICTURE: data = " + data);
			}
			break;
		case CHOOSE_TAKE_PICTURE:
			if (bitmap != null) {
				bitmap.recycle();
			}
			Log.d(TAG, "TAKE_BIG_PICTURE: data = " + data);// it seems to be
															// null
			getTakePhoto();

			break;
		case GET_IMAGE_VIA_CAMERA:
			if (imageUri != null) {
				if (bitmap != null) {
					bitmap.recycle();
				}
				bitmap = decodeUriAsBitmap(imageUri);// decode bitmap
				// bitmap = decodeUri(imageUri);
				System.out.println("1111" + imageUri.getPath());
				delFile(imageUri.getPath());
				return bitmap;
			}
			// File f=new File(Environment.getExternalStorageDirectory()
			// +"/"+localTempImgDir+"/"+localTempImgFileName);
			// try {
			// Uri u =
			// Uri.parse(android.provider.MediaStore.Images.Media.insertImage(getContentResolver(),
			// f.getAbsolutePath(), null, null));
			// //u就是拍摄获得的原始图片的uri，剩下的你想干神马坏事请便……
			// } catch (FileNotFoundException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			break;
		default:
			break;
		}

		return null;
	}

	private Bitmap decodeUriAsBitmap(Uri uri) {
		
		Options options = new Options();
		options.inSampleSize = 4;
		Bitmap bitmap = null;
		try {
			bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
			System.out.println(bitmap.getDensity());
			System.out.println(bitmap.getRowBytes());
			System.out.println(bitmap.getByteCount());
			if(bitmap.getByteCount() > 5000000){
				bitmap = BitmapFactory.decodeStream(context.getContentResolver()
						.openInputStream(uri), null, options);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return bitmap;
	}

	public String saveBitmap() {
		if (bitmap == null) {
			return "bitmap null";
		}
		return BitmapUtil.saveBitmap(context, System.currentTimeMillis()
				+ ".jpg", bitmap);
	}

	private void delFile(String path) {
		File file = new File(path);
		file.delete();
	}

	public static File getFilePath(String filePath, String fileName) {
		File file = null;
		makeRootDirectory(filePath);
		try {
			file = new File(filePath + fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}

	public static void makeRootDirectory(String filePath) {
		File file = null;
		try {
			file = new File(filePath);
			if (!file.exists()) {
				file.mkdir();
			}
		} catch (Exception e) {

		}
	}
}
