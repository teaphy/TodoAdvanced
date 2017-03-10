package advanced.todo.com.todoadvanced.aRouter.provider;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import advanced.todo.com.todoadvanced.aRouter.viewProvider.LoginCallBack;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/10
 */
// 实现接口
@Route(path = "/service/login", name = "测试服务")
public class LoginServiceIMPL implements LoginService {

	Context mContext;


	@Override
	public String doLogin(LoginCallBack callBack) {
		callBack.loginSuccess("success");
		return "success";
	}

	@Override
	public void init(Context context) {
		this.mContext = context;
		ARouter.getInstance().inject(this);
	}
}
