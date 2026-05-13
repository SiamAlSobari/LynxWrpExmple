package com.example.test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.lynx.tasm.LynxViewBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // 1. Siapkan Builder
        val viewBuilder = LynxViewBuilder()

        // 2. Hubungkan dengan loader (pastikan file DemoTemplateProvider.kt sudah ada)
        viewBuilder.setTemplateProvider(DemoTemplateProvider(this))

        // 3. Bangun LynxView
        val lynxView = viewBuilder.build(this)

        // 4. Tampilkan LynxView ke layar Android (Ini baru benar!)
        setContentView(lynxView)

        // 5. Render file bundle dari folder assets
        lynxView.renderTemplateUrl("main.lynx.bundle", "")
    }
}