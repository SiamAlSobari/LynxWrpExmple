package com.example.test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.lynx.tasm.LynxViewBuilder
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher
import com.lynx.tasm.resourceprovider.LynxResourceRequest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // 1. Siapkan Builder
        val viewBuilder = LynxViewBuilder()

        // 2. Hubungkan dengan loader (pastikan file DemoTemplateProvider.kt sudah ada)
        viewBuilder.setTemplateProvider(DemoTemplateProvider(this))
        
        // Aktifkan resource fetcher agar shouldRedirectUrl dipanggil
        viewBuilder.setEnableGenericResourceFetcher(com.lynx.tasm.LynxBooleanOption.TRUE)
        
        // Tambahkan MediaResourceFetcher untuk menangani path gambar lokal
        viewBuilder.setMediaResourceFetcher(object : LynxMediaResourceFetcher() {
            override fun shouldRedirectUrl(request: LynxResourceRequest): String {
                val url = request.url ?: ""
                android.util.Log.d("LynxImage", "Redirecting URL: $url")
                
                // Logika: Jika path lokal tapi tidak ada scheme, arahkan ke asset:///
                return when {
                    url.startsWith("/static/") -> "asset://$url"
                    url.startsWith("static/") -> "asset:///$url"
                    !url.contains("://") && url.isNotEmpty() -> "asset:///$url"
                    else -> url
                }
            }
        })

        // 3. Bangun LynxView
        val lynxView = viewBuilder.build(this)

        // 4. Tampilkan LynxView ke layar Android
        setContentView(lynxView)

        // 5. Render file bundle dari folder assets
        // Gunakan URL lengkap dengan scheme asset:/// agar base path-nya benar
        lynxView.renderTemplateUrl("asset:///main.lynx.bundle", null as String?)
    }
}
