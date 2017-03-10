package advanced.todo.com.todoadvanced.aRouter;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.Arrays;

import advanced.todo.com.todoadvanced.R;
import advanced.todo.com.todoadvanced.adapter.SingleTextAdapter;
import advanced.todo.com.todoadvanced.base.BaseRecyclerViewActivity;
import advanced.todo.com.todoadvanced.bean.PersonBean;

@Route(path = "/todo/arouter")
public class ARouterActivity extends BaseRecyclerViewActivity<String, SingleTextAdapter> {

	public static final int CODE_REQUEST = 0x01;

	SingleTextAdapter mAdapter;

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == CODE_REQUEST) {
			if (null != data) {
				Toast.makeText(this, data.getExtras().getString("result"), Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "返回值为空", Toast.LENGTH_SHORT).show();
			}
		}
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_single_recycler_view;
	}

	@Override
	public void initData() {
		mList.addAll(Arrays.asList(getResources().getStringArray(R.array.arouterList)));
		mAdapter = new SingleTextAdapter(R.layout.item_single_text, mList);
	}

	@Override
	public void initView() {

	}

	@Override
	public void setListener() {

	}

	@Override
	public String initTitle() {
		return "ARouter";
	}

	@Override
	public SingleTextAdapter initAdapter() {
		return mAdapter;
	}

	@Override
	public void doOnItemClick(int position) {
		switch (position) {
			case 0: // 应用内跳转
				jumpNormal();

				Toast.makeText(this, "应用内跳转", Toast.LENGTH_SHORT).show();
				break;
			case 1: // ForResult跳转
				jumpForResult();
				Toast.makeText(this, "ForResult跳转", Toast.LENGTH_SHORT).show();
				break;
			case 2: // 带参跳转
				jumpWithParameters();
				Toast.makeText(this, "带参跳转", Toast.LENGTH_SHORT).show();
				break;
			case 3: // 跳转到Module
				jumpOtherModule();
				Toast.makeText(this, "跳转到Module", Toast.LENGTH_SHORT).show();
				break;
			case 4: // URI跳转
				jumpByUri();
				Toast.makeText(this, "URI跳转", Toast.LENGTH_SHORT).show();
				break;
			case 5: // 拦截器
				Toast.makeText(this, "拦截器", Toast.LENGTH_SHORT).show();
				jumpNormal();
				break;
			case 6: // Fragment依赖注入测试
				jumpTab();
				break;
			default:
				break;
		}
	}

	private void jumpTab() {
		TabActivity.launch();
	}

	private void jumpNormal() {
		ARouter.getInstance()
				.build("/todo/test1")
				.navigation();
	}

	private void jumpForResult() {
		// 使用两个参数的navigation方法，可以获取单次跳转的结果
		// NavigationCallback 如果设置了，本次跳转的结果就会被这个回调处理，是优先于全局降级的
		ARouter.getInstance()
				.build("/todo/test2")
				.navigation(this, CODE_REQUEST, new NavigationCallback() {
					@Override
					public void onFound(Postcard postcard) {
						Log.i("123", "onFound");
					}

					@Override
					public void onLost(Postcard postcard) {
						Log.i("123", "onLost");
					}
				});
	}

	private void jumpWithParameters() {
		ArrayList<PersonBean> list = new ArrayList<>();
		list.add(new PersonBean(3, "王五", false));
		list.add(new PersonBean(4, "刘能", true));
//		Bundle bundle = new Bundle();
//		bundle.putParcelable("person", new PersonBean(2, "赵四", false));
//		bundle.putParcelableArrayList("persons", list);
		// 支持序列化，但是不支持自动注入
		ARouter.getInstance()
				.build("/todo/test3")
				.withInt("id", 1)
				.withString("name", "张三")
				.withBoolean("isMale", true)
				.withParcelable("person", new PersonBean(2, "赵四", false))
				.withParcelableArrayList("persons", list)
				.navigation();
	}

	private void jumpOtherModule() {
		ARouter.getInstance()
				.build("/test/1")
				.navigation();
	}

	private void jumpByUri() {

		ARouter.getInstance()
				.build("/todo/webview")
				.withString("url", "file:///android_asset/schame-test.html")
				.navigation();
	}
}
