package com.example.test

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.lynx.service.image.LynxImageService
import com.lynx.service.http.LynxHttpService
import com.lynx.service.log.LynxLogService
import com.lynx.tasm.LynxEnv
import com.lynx.tasm.service.LynxServiceCenter

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // 1. Inisialisasi Fresco (Wajib untuk render gambar)
        Fresco.initialize(this)

        // 2. Registrasi Service Lynx agar fitur gambar, network, dan log aktif
        val serviceCenter = LynxServiceCenter.inst()
        
        // Image Service (menggunakan Fresco)
        serviceCenter.registerService(LynxImageService.getInstance())
        
        // Http Service (agar bisa load gambar dari URL/network jika diperlukan)
        serviceCenter.registerService(LynxHttpService)
        
        // Log Service (agar log dari Lynx muncul di Logcat)
        serviceCenter.registerService(LynxLogService)

        // 3. Inisialisasi Lynx Environment
        LynxEnv.inst().init(this, null, null, null)
    }
}
