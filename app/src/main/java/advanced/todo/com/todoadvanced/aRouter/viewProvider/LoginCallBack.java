package advanced.todo.com.todoadvanced.aRouter.viewProvider;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/10
 */
public interface LoginCallBack {
	void loginSuccess(String msg);

	void loginFailure();
}
