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
				if( url.startsWith("http:") || url.startsWith("https:") ) {
					return false;
				}

				return true;
			}
		});

		webview.loadUrl(getIntent().getStringExtra("url"));

	}
}
