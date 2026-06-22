package com.reflexologia.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Pantalla completa inmersiva (sin barra de estado)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        WebView myWebView = new WebView(this);
        WebSettings webSettings = myWebView.getSettings();
        
        // Ajustes clave para que tu JS y JSON locales carguen en Android
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setDomStorageEnabled(true);
        
        myWebView.setWebViewClient(new WebViewClient());
        
        // Carga tu index.html desde la carpeta assets
        myWebView.loadUrl("file:///android_asset/index.html");
        setContentView(myWebView);
    }
}
