package advanced.todo.com.todoadvanced.rxJava.provider;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/10
 */

public interface TestRxService extends IProvider {

//	void initData();

	void doPrint();

	void doDispose();
}
