package com.duster.premium;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class MainActivity extends Activity {
    private WebView web;
    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().setSystemUiVisibility(5894 | 1024 | 512 | 4096);
        web = new WebView(this);
        web.setBackgroundColor(0xff080e17);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setDomStorageEnabled(true);
        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient());
        web.addJavascriptInterface(new CarBridge(), "Car");
        setContentView(web);
        web.loadUrl("file:///android_asset/index.html");
    }
    private class CarBridge {
        @JavascriptInterface public void openApp(String name) {
            runOnUiThread(() -> launch(name));
        }
    }
    private void launch(String name) {
        try {
            Intent i;
            switch (name) {
                case "maps":
                    i = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
                    if (i == null) i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=navegación"));
                    break;
                case "music":
                    i = getPackageManager().getLaunchIntentForPackage("com.spotify.music");
                    if (i == null) i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://music.youtube.com"));
                    break;
                case "bluetooth":
                    i = new Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
                    break;
                case "settings":
                    i = new Intent(android.provider.Settings.ACTION_SETTINGS);
                    break;
                case "radio":
                    Toast.makeText(this, "Abre la aplicación Radio FM de tu unidad", Toast.LENGTH_LONG).show();
                    return;
                default: return;
            }
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        } catch (Exception e) {
            Toast.makeText(this, "No se pudo abrir esa aplicación", Toast.LENGTH_SHORT).show();
        }
    }
    @Override public void onBackPressed() {
        if (web != null && web.canGoBack()) web.goBack(); else super.onBackPressed();
    }
}
