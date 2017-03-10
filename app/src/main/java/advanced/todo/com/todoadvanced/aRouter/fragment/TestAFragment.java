package advanced.todo.com.todoadvanced.aRouter.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;

import advanced.todo.com.todoadvanced.R;
import advanced.todo.com.todoadvanced.aRouter.provider.LoginService;
import advanced.todo.com.todoadvanced.aRouter.viewProvider.LoginCallBack;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestAFragment extends Fragment {


	@BindView(R.id.tv_test)
	TextView mTvTest;
	@BindView(R.id.btn_fun)
	Button mBtnFun;

	@Autowired
	LoginService mLoginService;


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ARouter.getInstance().inject(this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_test_a, container, false);

		ButterKnife.bind(this, view);

		return view;
	}

	@OnClick(R.id.btn_fun)
	public void onClick() {
		mLoginService.doLogin(new LoginCallBack() {
			@Override
			public void loginSuccess(String msg) {
				mTvTest.setText(msg);
			}

			@Override
			public void loginFailure() {

			}
		});
	}
}
