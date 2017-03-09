package advanced.todo.com.todoadvanced.aRouter;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import advanced.todo.com.todoadvanced.R;
import advanced.todo.com.todoadvanced.base.BaseActivity;
import advanced.todo.com.todoadvanced.bean.PersonBean;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/todo/test3")
public class ARouterTest3Activity extends BaseActivity {


	@BindView(R.id.tv_test)
	TextView mTvTest;

	// 为每一个参数声明一个字段，并使用 @Autowired 标注
	// ARouter会自动对字段进行赋值，无需主动获取
	@Autowired
	int id;
	@Autowired
	String name;
	@Autowired(name = "isMale")  // 通过name来映射URL中的不同参数
	boolean isMale;


	PersonBean mPersonBean;
	ArrayList<PersonBean> mLists;



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
		// 支持序列化，但是不支持自动注入
		mLists = getIntent().getParcelableArrayListExtra("persons");
		mPersonBean = getIntent().getParcelableExtra("person");
		mTvTest.setText("id=" + id + " | name=" + name + " | isMale=" + isMale + " | person=" + mPersonBean + " | persons=" + mLists);
	}

	@Override
	public void setListener() {

	}

	@Override
	public String initTitle() {
		return "带参跳转";
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ButterKnife.bind(this);
	}
}
