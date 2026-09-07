plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.habittracker1"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.habittracker1"
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
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // ROOM
    implementation 'androidx.room:room-runtime:2.6.1'
    annotationProcessor 'androidx.room:room-compiler:2.6.1'

    // Lifecycle
    implementation 'androidx.lifecycle:lifecycle-livedata:2.8.0'
    implementation 'androidx.lifecycle:lifecycle-viewmodel:2.8.0'

    // RecyclerView
    implementation 'androidx.recyclerview:recyclerview:1.3.2'

    // Retrofit API
    implementation 'com.squareup.retrofit2:retrofit:2.11.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.11.0'

    // Material Design
    implementation 'com.google.android.material:material:1.12.0'
}