package advanced.todo.com.todoadvanced.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import advanced.todo.com.todoadvanced.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/9
 */
public abstract class BaseActivity extends AppCompatActivity {

	@BindView(R.id.toolBar)
	Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());

		ButterKnife.bind(this);

		initData();

		initView();

		setListener();

		initToolBar();
	}

	private  void initToolBar() {
		mToolbar.setTitle(initTitle());
		mToolbar.setNavigationIcon(R.mipmap.ic_back);
		setSupportActionBar(mToolbar);
		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				BaseActivity.this.finish();
			}
		});
	}

	public abstract int getLayoutId();

	public abstract void initData();

	public abstract void initView();

	public abstract void setListener();

	public abstract String initTitle();

}
