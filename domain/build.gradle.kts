plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


    }
}

dependencies {

    implementation(Libraries.Hilt.HILT)
    kapt(Libraries.Hilt.HILT_COMPILER)

    implementation(Libraries.OkHttp.OKHTTP)
    implementation(Libraries.OkHttp.OKHTTP_INTERCEPTOR)

    implementation(Libraries.Retrofit.RETROFIT)
    implementation(Libraries.Retrofit.RETROFIT_GSON)

    implementation(Libraries.Coroutine.COROUTINE)
    implementation(Libraries.Coroutine.COROUTINE_CORE)

}