package com.example.test
import android.content.Context
import com.lynx.tasm.provider.AbsTemplateProvider
import java.io.ByteArrayOutputStream
class DemoTemplateProvider(private val context: Context) : AbsTemplateProvider() {
    override fun loadTemplate(uri: String, callback: Callback) {
        try {
            val inputStream = context.assets.open(uri)
            val outputStream = ByteArrayOutputStream()
            inputStream.copyTo(outputStream)
            callback.onSuccess(outputStream.toByteArray())
        } catch (e: Exception) {
            callback.onFailed(e.message)
        }
    }
}