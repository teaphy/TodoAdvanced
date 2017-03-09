package advanced.todo.com.todoadvanced.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import advanced.todo.com.todoadvanced.R;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/9
 */
public class SingleTextAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
	public SingleTextAdapter(int layoutResId, List<String> data) {
		super(layoutResId, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, String item) {
		helper.setText(R.id.tv_singleText, item);
	}
}
