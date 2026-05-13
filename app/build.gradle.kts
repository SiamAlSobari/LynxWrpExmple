plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.test"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.test"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
// Core Lynx Engine
    implementation("org.lynxsdk.lynx:lynx:3.7.0")
    implementation("org.lynxsdk.lynx:lynx-jssdk:3.7.0")
    implementation("org.lynxsdk.lynx:lynx-trace:3.7.0")
    implementation("org.lynxsdk.lynx:primjs:3.7.0")
    implementation("org.lynxsdk.lynx:lynx-service-image:3.7.0")
    // Image & Network Services (Agar gambar bisa muncul)
    implementation("org.lynxsdk.lynx:lynx-service-image:3.7.0")
    implementation("com.facebook.fresco:fresco:2.3.0")
    implementation("org.lynxsdk.lynx:lynx-service-log:3.7.0")
    implementation("org.lynxsdk.lynx:lynx-service-http:3.7.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}