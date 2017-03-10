package advanced.todo.com.todoadvanced.aRouter.interceptor;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import advanced.todo.com.todoadvanced.aRouter.LoginActivity;
import advanced.todo.com.todoadvanced.aRouter.constant.CommonConstant;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/10
 */
// 比较经典的应用就是在跳转过程中处理登陆事件，这样就不需要在目标页重复做登陆检查
// 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
@Interceptor(priority = 1, name = "进入登录界面")
public class TestInterceptor implements IInterceptor {

	Context mContext;

	@Override
	public void process(Postcard postcard, InterceptorCallback callback) {

		//  allback.onContinue(postcard);  // 处理完成，交还控制权
		// callback.onInterrupt(new RuntimeException("我觉得有点异常"));  // 觉得有问题，中断路由流程
		// 以上两种至少需要调用其中一种，否则不会继续路由
		if (postcard.getExtra() == 1001) {
			callback.onInterrupt(null);
			LoginActivity.launch();
		} else {
			callback.onContinue(postcard);
		}
	}

	@Override
	public void init(Context context) {
		this.mContext = context;
	}
}
