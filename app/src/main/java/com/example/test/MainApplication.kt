package com.example.test

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.lynx.service.image.LynxImageService
import com.lynx.tasm.LynxEnv
import com.lynx.tasm.service.LynxServiceCenter

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Inisialisasi Fresco (untuk gambar)
        Fresco.initialize(this)

        // Daftar service gambar Lynx
        LynxServiceCenter.inst().registerService(LynxImageService.getInstance())

        // Inisialisasi Environment Lynx (Hanya butuh dipanggil sekali seumur hidup aplikasi)
        LynxEnv.inst().init(this, null, null, null)
    }
}