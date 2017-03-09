package advanced.todo.com.todoadvanced.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/9
 */
public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// 开启Log、Debug应在ARouter.init();之前
		// 开启日志
		ARouter.openLog();
		// 使用InstantRun的时候，需要打开该开关，上线之后关闭，否则有安全风险
		ARouter.openDebug();
		// 打印日志的时候打印线程堆栈
		ARouter.printStackTrace();

		// ARouter初始化
		ARouter.init(this);
	}
}
