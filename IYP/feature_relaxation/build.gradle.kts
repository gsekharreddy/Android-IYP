plugins {
    // CRITICAL FIX: Changed from .application to .library
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.example.feature_relaxation"
    compileSdk = 36

    defaultConfig {
        minSdk = 26
        // REMOVED: applicationId, targetSdk, versionCode, and versionName
        // These only belong in the main :app module.

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
    // ADDED: You'll need this for your fragment's layout
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // This part is correct!
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
