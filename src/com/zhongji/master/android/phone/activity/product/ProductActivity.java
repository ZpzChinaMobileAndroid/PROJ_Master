package com.zhongji.master.android.phone.activity.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.RequestParams;
import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.activity.product.LazyScrollView.OnScrollListener;
import com.zhongji.master.android.phone.base.BaseIndexActivity;
import com.zhongji.master.android.phone.entity.CompanyListBean;
import com.zhongji.master.android.phone.net.HttpAPI;
import com.zhongji.master.android.phone.net.HttpRestClient;
import com.zhongji.master.android.phone.net.ResponseUtils;
import com.zhongji.master.android.phone.until.JsonUtils;

/**
 * 产品
 * 
 */
public class ProductActivity extends BaseIndexActivity {

	private LazyScrollView waterfall_scroll;
	private LinearLayout waterfall_container;
	private ArrayList<LinearLayout> waterfall_items;
	private Display display;
	private AssetManager assetManager;
	private List<String> image_filenames;
	private final String image_path = "images";
	private int itemWidth;
	private int column_count = 2;// 显示列数
	private int page_count = 15;// 每次加载15张图片
	private int current_page = 0;
	private int page = 0;
	private int size = 5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prodcut_waterfall);

		display = this.getWindowManager().getDefaultDisplay();
		itemWidth = display.getWidth() / column_count;// 根据屏幕大小计算每列大小
		assetManager = this.getAssets();

		InitLayout();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		setTitle("产品");
		getproduct();
	}

	// 滚动方式
	private void InitLayout() {
		waterfall_scroll = (LazyScrollView) findViewById(R.id.waterfall_scroll);
		waterfall_scroll.getView();
		waterfall_scroll.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onTop() {
				// 滚动到最顶端
				Log.d("LazyScroll", "Scroll to top");
			}

			@Override
			public void onScroll() {
				// 滚动中
				Log.d("LazyScroll", "Scroll");
			}

			@Override
			public void onBottom() {
				// 滚动到最低端
				AddItemToContainer(++current_page, page_count);
			}
		});

		waterfall_container = (LinearLayout) this
				.findViewById(R.id.lin_waterfall);
		waterfall_items = new ArrayList<LinearLayout>();

		for (int i = 0; i < column_count; i++) {
			LinearLayout itemLayout = new LinearLayout(this);
			LinearLayout.LayoutParams itemParam = new LinearLayout.LayoutParams(
					itemWidth, LayoutParams.WRAP_CONTENT);
			// itemParam.width = itemWidth;
			// itemParam.height = LayoutParams.WRAP_CONTENT;
			itemLayout.setPadding(2, 2, 2, 2);
			itemLayout.setOrientation(LinearLayout.VERTICAL);

			itemLayout.setLayoutParams(itemParam);
			waterfall_items.add(itemLayout);
			waterfall_container.addView(itemLayout);
		}

		// 加载所有图片路径

		try {
			image_filenames = Arrays.asList(assetManager.list(image_path));

		} catch (IOException e) {
			e.printStackTrace();
		}
		// 第一次加载
		AddItemToContainer(current_page, page_count);
	}

	private void AddItemToContainer(int i, int page_count) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * 获取产品信息
	 * 
	 */

	private void getproduct() {
		// TODO 自动生成的方法存根

		HttpRestClient.get(ProductActivity.this, HttpAPI.PROJUCT_ALL,
				new ResponseUtils(ProductActivity.this) {

					@Override
					public void getResult(int httpCode, String result) {
						// TODO 自动生成的方法存根
						dismissProgressDialog();
						if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
							CompanyListBean bean = JSON.parseObject(
									JsonUtils.parseString(result),
									CompanyListBean.class);
							if (getData(bean)) {
								return;
							}

						} else {
							showNetShortToast(httpCode);
						}
					}
				});
	}
}
