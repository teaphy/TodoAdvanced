package advanced.todo.com.todoadvanced;

import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Arrays;

import advanced.todo.com.todoadvanced.adapter.SingleTextAdapter;
import advanced.todo.com.todoadvanced.base.BaseRecyclerViewActivity;

public class MainActivity extends BaseRecyclerViewActivity<String, SingleTextAdapter> {


	SingleTextAdapter mAdapter;

	@Override
	public int getLayoutId() {
		return R.layout.activity_single_recycler_view;
	}

	@Override
	public void initData() {
		mList.addAll(Arrays.asList(getResources().getStringArray(R.array.advancedList)));
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
		return "todo";
	}

	@Override
	public SingleTextAdapter initAdapter() {
		return mAdapter;
	}

	@Override
	public void doOnItemClick(int position) {
		switch (position) {
			case 0: // ARouter
				ARouter.getInstance()
						.build("/todo/arouter")
						.navigation();
				Toast.makeText(this, "ARouter", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
		}
	}
}
