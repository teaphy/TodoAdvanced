package advanced.todo.com.todoadvanced.aRouter;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import advanced.todo.com.todoadvanced.R;
import advanced.todo.com.todoadvanced.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/todo/test1")
public class ARouterTest1Activity extends BaseActivity {


	@BindView(R.id.tv_test)
	TextView mTvTest;

	@Override
	public int getLayoutId() {
		return R.layout.activity_arouter_test;
	}

	@Override
	public void initData() {

	}

	@Override
	public void initView() {

	}

	@Override
	public void setListener() {

	}

	@Override
	public String initTitle() {
		return "应用内跳转";
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ButterKnife.bind(this);
	}
}
