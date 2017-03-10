package advanced.todo.com.todoadvanced.rxJava.provider;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/10
 */
@Route(path = "/todo/testRx" , name = "测试RxJava")
public class TestRxServiceIMPL implements TestRxService {

	Context mContext;
	private CompositeDisposable mCompositeDisposable;


	@Override
	public void init(Context context) {
		mContext = context;
		mCompositeDisposable = new CompositeDisposable();
	}

	@Override
	public void doPrint() {
		mCompositeDisposable.add(Flowable.interval(1, 1, TimeUnit.SECONDS)
				.subscribeWith(new DisposableSubscriber<Long>() {
					@Override
					public void onNext(Long aLong) {
						Log.i("123", "aLong: " + aLong);
					}

					@Override
					public void onError(Throwable t) {

					}

					@Override
					public void onComplete() {

					}
				}));

	}

	@Override
	public void doDispose() {
		if (null != mCompositeDisposable && !mCompositeDisposable.isDisposed()) {
			mCompositeDisposable.dispose();
			mCompositeDisposable = null;
		}
	}
}
