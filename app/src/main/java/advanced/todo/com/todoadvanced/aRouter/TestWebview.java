package advanced.todo.com.todoadvanced.aRouter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import advanced.todo.com.todoadvanced.R;

@Route(path = "/todo/webview")
public class TestWebview extends AppCompatActivity {

	WebView webview;
	String mUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_webview);


		webview = (WebView) findViewById(R.id.webview);

		WebSettings webSettings = webview.getSettings();
		webSettings.setJavaScriptEnabled(true);

		webview.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// 以"http","https"开头的url在本页用webview进行加载，其他链接进行跳转
				if( url.startsWith("http:") || url.startsWith("https:") ) {
					return false;
				}
				//如果不需要其他对点击链接事件的处理返回true，否则返回false
				ARouter.getInstance()
						.build(Uri.parse(url))
						.navigation();
//				Intent intent = new Intent(TestWebview.this, SchemeFilterActivity.class);
//				intent.setData(Uri.parse(url));
//				startActivity(intent);
				return true;
			}
		});

		webview.loadUrl(getIntent().getStringExtra("url"));

	}
}
