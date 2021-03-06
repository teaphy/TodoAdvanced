package advanced.todo.com.todoadvanced.aRouter;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import advanced.todo.com.todoadvanced.R;
import advanced.todo.com.todoadvanced.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/todo/test5")
public class ARouterTest5Activity extends BaseActivity {


	@BindView(R.id.tv_test)
	TextView mTvTest;

	@Autowired
	int id;
	@Autowired
	String name;

	@Override
	public int getLayoutId() {
		return R.layout.activity_arouter_test;
	}

	@Override
	public void initData() {
		ARouter.getInstance().inject(this);
	}

	@Override
	public void initView() {
		mTvTest.setText("通过URL跳转,参数：id = " + id + " & name = " + name);
	}

	@Override
	public void setListener() {

	}

	@Override
	public String initTitle() {
		return "URL跳转，携带参数";
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ButterKnife.bind(this);
	}
}
