package advanced.todo.com.todoadvanced.rxJava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import advanced.todo.com.todoadvanced.R;
import advanced.todo.com.todoadvanced.base.BaseActivity;
import advanced.todo.com.todoadvanced.rxJava.provider.TestRxService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/todo/testRxjava")
public class TestRxJavaActivity extends BaseActivity {


	@BindView(R.id.tv_test)
	TextView mTvTest;
	@BindView(R.id.btn_start)
	Button mBtnStart;
	@BindView(R.id.btn_end)
	Button mBtnEnd;

	@Autowired
	TestRxService mTestRxService;

	public static void launch() {
		ARouter.getInstance()
				.build("/todo/testRxjava")
				.navigation();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mTestRxService.doDispose();
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_test_rx_java;
	}

	@Override
	public void initData() {
		ARouter.getInstance()
				.inject(this);

	}

	@Override
	public void initView() {

	}

	@Override
	public void setListener() {

	}

	@Override
	public String initTitle() {
		return "RxJava生命周期测试";
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO: add setContentView(...) invocation
		ButterKnife.bind(this);
	}

	@OnClick({R.id.btn_start, R.id.btn_end})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.btn_start:
				mTestRxService.doPrint();
				break;
			case R.id.btn_end:
//				mTestRxService.doDispose();
				break;
			default:
				break;
		}
	}
}
