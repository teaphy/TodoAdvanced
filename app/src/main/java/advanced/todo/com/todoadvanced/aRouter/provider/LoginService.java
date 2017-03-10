package advanced.todo.com.todoadvanced.aRouter.provider;

import com.alibaba.android.arouter.facade.template.IProvider;

import advanced.todo.com.todoadvanced.aRouter.viewProvider.LoginCallBack;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/10
 */
// 声明接口,其他组件通过接口来调用服务
public interface LoginService extends IProvider {
	String doLogin(LoginCallBack callBack);
}
