package advanced.todo.com.todoadvanced.aRouter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/9
 */
// 新建一个Activity用于监听Schame事件,之后直接把url传递给ARouter即可
public class SchemeFilterActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 直接通过ARouter处理外部Uri
		Intent intent = getIntent();
		Uri uri = intent.getData();
		Log.e("123", "scheme:" +intent.getScheme());

		ARouter.getInstance().build(uri).navigation(this, new NavigationCallback() {
			@Override
			public void onFound(Postcard postcard) {
				finish();
			}

			@Override
			public void onLost(Postcard postcard) {
				finish();
			}
		});
	}
}
