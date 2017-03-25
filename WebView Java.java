package com.example.webviewtest;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends Activity
{
	EditText txtUrl;
	WebView wView;
	ProgressDialog pDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity);
		
		
		pDialog=new ProgressDialog(MainActivity.this);
		pDialog.setMessage("loading...");
		
		
		txtUrl=(EditText)findViewById(R.id.txtURl);
		wView=(WebView)findViewById(R.id.wView);	
		 
	}
	
	public void go(View v)
	{	
		
		if(txtUrl.getText().toString().startsWith("http://"))
		{
			wView.loadUrl(txtUrl.getText().toString()); 
		}
		else
		{
			wView.loadUrl("http://"+txtUrl.getText().toString()); 
		}
		
		
		wView.setWebViewClient(new WebViewClient()
		{
				
				@Override
				public void onPageStarted(WebView view, String url, Bitmap favicon) {
					// TODO Auto-generated method stub
					super.onPageStarted(view, url, favicon);
					pDialog.show();
				}
				
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					// TODO Auto-generated method stub
					
					
					view.loadUrl(url);
					
					
					return super.shouldOverrideUrlLoading(view, url);
					
				}
				
				@Override
				public void onPageFinished(WebView view, String url)
				{
					// TODO Auto-generated method stub
					super.onPageFinished(view, url);
					
					pDialog.dismiss();
					
				}
				
				
				
		});
		
		
		
		wView.getSettings().setJavaScriptEnabled(true); 
		wView.getSettings().setBuiltInZoomControls(true); 
		
		
		
		
		
	}
	
	
	
	
}