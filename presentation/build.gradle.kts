plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "kr.hs.dgsw.b1nd.mentomen"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "kr.hs.dgsw.b1nd.mentomen"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(Libraries.AndroidX.APP_COMPAT)
    implementation(Libraries.AndroidX.MATERIAL)
    implementation(Libraries.AndroidX.CONSTRAINT_LAYOUT)

    testImplementation(Libraries.Test.JUNIT)

    androidTestImplementation(Libraries.AndroidTest.TEST_RUNNER)
    androidTestImplementation(Libraries.AndroidTest.ESPRESSO_CORE)

    implementation(Libraries.KTX.CORE)

    implementation(Libraries.Hilt.HILT)
    kapt(Libraries.Hilt.HILT_COMPILER)

    implementation(Libraries.OkHttp.OKHTTP)
    implementation(Libraries.OkHttp.OKHTTP_INTERCEPTOR)

    implementation(Libraries.Retrofit.RETROFIT)
    implementation(Libraries.Retrofit.RETROFIT_GSON)

    implementation(Libraries.Coroutine.COROUTINE)
    implementation(Libraries.Coroutine.COROUTINE_CORE)

    implementation(Libraries.CoordinatorLayout.COORDINATOR_LAYOUT)

    implementation(Libraries.Glide.GLIDE)
    kapt(Libraries.Glide.GLIDE_COMPILER)

    implementation(Libraries.Navigation.NAVIGATION_FRAGMENT)
    implementation(Libraries.Navigation.NAVIGATION_UI)

    implementation(Libraries.SwipeRefreshLayout.SWIPE_REFRESH_LAYOUT)

    implementation(Libraries.ViewPager.VIEW_PAGER)
    implementation(Libraries.ViewPager.DOTS_INDICATOR)

    implementation(project(":domain"))
    implementation(project(":data"))
}