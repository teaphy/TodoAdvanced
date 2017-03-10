package advanced.todo.com.todoadvanced.aRouter;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import advanced.todo.com.todoadvanced.R;
import advanced.todo.com.todoadvanced.aRouter.provider.LoginService;
import advanced.todo.com.todoadvanced.aRouter.viewProvider.LoginCallBack;
import advanced.todo.com.todoadvanced.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/todo/login")
public class LoginActivity extends BaseActivity {


	@BindView(R.id.tv_test)
	TextView mTvTest;
	@BindView(R.id.btn_login)
	Button mBtnLogin;


	@Autowired
	LoginService mLoginService;


	public static void launch() {
		ARouter.getInstance()
				.build("/todo/login")
				.navigation();
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_login;
	}

	@Override
	public void initData() {
		ARouter.getInstance().inject(this);
	}

	@Override
	public void initView() {

	}

	@Override
	public void setListener() {

	}

	@Override
	public String initTitle() {
		return "登录界面";
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ButterKnife.bind(this);
	}

	@OnClick(R.id.btn_login)
	public void onClick() {
		new Handler().postDelayed(() -> mLoginService.doLogin(new LoginCallBack() {
			@Override
			public void loginSuccess(String msg) {
				mTvTest.setText(msg);
			}

			@Override
			public void loginFailure() {

			}
		}), 1000);
	}

}
