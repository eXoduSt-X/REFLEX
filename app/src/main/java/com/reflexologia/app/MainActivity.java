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
        
        // Pantalla completa inmersiva
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        WebView myWebView = new WebView(this);
        WebSettings webSettings = myWebView.getSettings();
        
        // 🛠️ CONFIGURACIONES CRÍTICAS PARA IMPEDIR EL REBLOQUEO DEL JSON:
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowFileAccess(true);
        
        // Estas dos líneas permiten hacer fetch() local a organos.json sin romper el CORS
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        
        myWebView.setWebViewClient(new WebViewClient());
        
        // Carga el mapa desde assets
        myWebView.loadUrl("file:///android_asset/index.html");
        setContentView(myWebView);
    }
}
