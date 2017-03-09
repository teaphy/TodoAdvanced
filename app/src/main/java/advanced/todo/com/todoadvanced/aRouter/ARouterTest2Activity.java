package advanced.todo.com.todoadvanced.aRouter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import advanced.todo.com.todoadvanced.R;
import advanced.todo.com.todoadvanced.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/todo/test2")
public class ARouterTest2Activity extends BaseActivity {


	@BindView(R.id.tv_test)
	TextView mTvTest;

	@Override
	public int getLayoutId() {
		return R.layout.activity_arouter_test;
	}

	@Override
	public void initData() {

		ARouter.getInstance().inject(this);

		Intent intent = new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("result", "The result from the ARouterTest2Activity");
		intent.putExtras(bundle);

		setResult(RESULT_OK, intent);

	}

	@Override
	public void initView() {

	}

	@Override
	public void setListener() {

	}

	@Override
	public String initTitle() {
		return "ForResult跳转";
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ButterKnife.bind(this);
	}
}
