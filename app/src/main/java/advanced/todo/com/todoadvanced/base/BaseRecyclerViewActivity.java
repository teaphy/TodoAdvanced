package advanced.todo.com.todoadvanced.base;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import advanced.todo.com.todoadvanced.R;
import advanced.todo.com.todoadvanced.adapter.SingleTextAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/9
 */
public abstract class BaseRecyclerViewActivity<T, V extends BaseQuickAdapter<T, BaseViewHolder>> extends BaseActivity {

	@BindView(R.id.rv_singleText)
	RecyclerView mRecyclerView;

	public List<T> mList;
	V mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mList = new ArrayList<>();
		super.onCreate(savedInstanceState);

		ButterKnife.bind(this);

		initRecyclerView();

		setItemClickListener();
	}



	private void initRecyclerView(){
		mAdapter = initAdapter();
		mRecyclerView.setAdapter(mAdapter);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
	}

	private void setItemClickListener() {
		mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
			@Override
			public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
				doOnItemClick(position);
			}
		});
	}

	public abstract V initAdapter();

	public abstract void doOnItemClick(int position);
}
