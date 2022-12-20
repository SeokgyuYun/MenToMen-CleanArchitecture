object Versions {
    // AndroidX
    const val APP_COMPAT = "1.5.1"
    const val MATERIAL = "1.6.1"
    const val CONSTRAINT_LAYOUT = "2.1.4"

    // KTX
    const val CORE = "1.7.0"

    // TEST
    const val JUNIT = "4.13.2"

    const val TEST_JUNIT = "1.1.3"

    // Android Test
    const val ESPRESSO_CORE = "3.4.0"

    // Dagger Hilt
    const val HILT = "2.44.2"

    // OkHttp3
    const val OKHTTP = "4.10.0"

    // Retrofit2
    const val RETROFIT = "2.9.0"

    // Room
    const val ROOM = "2.4.3"

    // Coroutine
    const val COROUTINE = "1.3.9"

    // CoordinatorLayout
    const val COORDINATOR_LAYOUT = "1.2.0"

    // Glide
    const val GLIDE = "4.14.2"

    // Navigation
    const val NAVIGATION = "2.5.3"

    // SwipeRefreshLayout
    const val SWIPE_REFRESH_LAYOUT = "1.1.0"

    //ViewPager
    const val VIEW_PAGER = "1.0.0"
    const val DOTS_INDICATOR = "4.3"
}


object Libraries {
    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    }

    object KTX {
        const val CORE = "androidx.core:core-ktx:${Versions.CORE}"
    }

    object Test {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
    }

    object AndroidTest {
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
        const val TEST_RUNNER = "androidx.test.ext:junit:${Versions.TEST_JUNIT}"
    }

    object Hilt {
        const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    }

    object OkHttp {
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
        const val OKHTTP_INTERCEPTOR =
            "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    }

    object Retrofit {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    }

    object Room {
        const val ROOM = "androidx.room:room-runtime:${Versions.ROOM}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
    }

    object Coroutine {
        const val COROUTINE =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE}"
        const val COROUTINE_CORE =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE}"
    }

    object CoordinatorLayout {
        const val COORDINATOR_LAYOUT =
            "androidx.coordinatorlayout:coordinatorlayout:${Versions.COORDINATOR_LAYOUT}"
    }

    object Glide {
        const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
        const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
    }

    object Navigation {
        const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
        const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    }

    object SwipeRefreshLayout {
        const val SWIPE_REFRESH_LAYOUT =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH_LAYOUT}"
    }

    object ViewPager {
        const val VIEW_PAGER = "androidx.viewpager2:viewpager2:${Versions.VIEW_PAGER}"
        const val DOTS_INDICATOR = "com.tbuonomo:dotsindicator:${Versions.DOTS_INDICATOR}"
    }
}
