package advanced.todo.com.todoadvanced.aRouter;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import advanced.todo.com.todoadvanced.R;
import advanced.todo.com.todoadvanced.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

// 可以通过 Route 注解中的 extras 属性进行扩展，这个属性是一个 int值，换句话说，单个int有4字节，也就是32位，可以配置32个开关
// 剩下的可以自行发挥，通过字节操作可以标识32个开关，通过开关标记目标页面的一些属性，在拦截器中可以拿到这个标记进行业务逻辑判断
@Route(path = "/todo/test1", extras = 1001)
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
