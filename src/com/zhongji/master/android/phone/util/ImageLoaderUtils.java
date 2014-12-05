package com.zhongji.master.android.phone.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.net.HttpRestClient;

public class ImageLoaderUtils {

	private static ImageLoaderUtils mImageLoaderUtils;
	private static DisplayImageOptions options;
	private static int drawable = R.drawable.ic_launcher;

	public ImageLoaderUtils() {
		
	}

	public static ImageLoaderUtils getInstance() {
		if (mImageLoaderUtils == null) {
			mImageLoaderUtils = new ImageLoaderUtils();
		}
		setOptions(drawable);
		return mImageLoaderUtils;
	}

	public static ImageLoaderUtils getInstance(int defaultdraw) {
		if (mImageLoaderUtils == null) {
			mImageLoaderUtils = new ImageLoaderUtils();
		}
		setOptions(defaultdraw);
		return mImageLoaderUtils;
	}

	private static void setOptions(int drawable) {
		options = new DisplayImageOptions.Builder()
				.showImageForEmptyUri(drawable)
				.showImageOnFail(drawable)
				.showImageOnLoading(drawable)
				.cacheInMemory(true).cacheOnDisk(true)
				.bitmapConfig(Bitmap.Config.RGB_565).build();
	}
	
	public void displayImage(Context context, String uri, ImageView imageAware) {
		if(TextUtils.isEmpty(uri)){
			uri = "";
		}
		ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
		if(!uri.startsWith("http://")){
			uri = HttpRestClient.BASE_URL + uri;
		}
		ImageLoader.getInstance().displayImage(uri, imageAware, options);
	}
}
