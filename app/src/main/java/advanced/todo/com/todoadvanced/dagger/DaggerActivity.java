package advanced.todo.com.todoadvanced.dagger;

import com.google.gson.Gson;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

import advanced.todo.com.todoadvanced.R;
import advanced.todo.com.todoadvanced.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/todo/dagger")
public class DaggerActivity extends BaseActivity {


	@BindView(R.id.tv_dagger)
	TextView mTvDagger;
	@BindView(R.id.btn_loading)
	Button mBtnLoading;
	@BindView(R.id.iv_loading)
	ImageView mIvLoading;

	@Inject
	DaggerBean mDaggerBean;
	@Inject
	Gson mGson;

	public static void launch() {
		ARouter.getInstance()
				.build("/todo/dagger")
				.navigation();
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_dagger;
	}

	@Override
	public void initData() {
		// 使用Dagger2生成的类 生成组件进行构造，并注入
		DaggerDaggerComponent.builder()
				.daggerModule(new DaggerModule())
				.build()
				.inject(this);
		mDaggerBean.setId(1);
		mDaggerBean.setName("刘能");
	}

	@Override
	public void initView() {
		mTvDagger.setText(mDaggerBean.toString());
		mTvDagger.append("\n");
		mTvDagger.append(mGson.toJson(mDaggerBean));
	}

	@Override
	public void setListener() {

	}

	@Override
	public String initTitle() {
		return "Dagger";
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO: add setContentView(...) invocation
		ButterKnife.bind(this);
	}

	@OnClick(R.id.btn_loading)
	public void onClick() {
	}
}
