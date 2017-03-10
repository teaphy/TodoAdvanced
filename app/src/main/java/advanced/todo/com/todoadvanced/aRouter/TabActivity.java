package advanced.todo.com.todoadvanced.aRouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import advanced.todo.com.todoadvanced.R;
import advanced.todo.com.todoadvanced.base.BaseActivity;

@Route(path = "/todo/tab")
public class TabActivity extends BaseActivity {

	public static void launch() {
		ARouter.getInstance()
				.build("/todo/tab")
				.navigation();
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_tab;
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
		return "Fragment依赖注入测试";
	}
}
