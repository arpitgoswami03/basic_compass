plugins {
    id("com.android.application") version "8.7.3"
    id("org.jetbrains.kotlin.android") version "1.9.10"
    id("com.google.devtools.ksp") version "1.9.0-1.0.13"
}

android {
    namespace = "com.example.compassapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.compassapp"
        minSdk = 25
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3" // Set to the Compose compiler version
    }

    // Enable view binding
    buildFeatures {
        viewBinding = true
        compose = true // Enable Jetpack Compose
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
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Core AndroidX dependencies
    implementation(libs.androidx.core.ktx.v1150)
    implementation(libs.androidx.appcompat.v170)
    implementation(libs.material.v1120)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.constraintlayout)

    // CircleImageView
    implementation(libs.circleimageview)

    // Coroutines
    implementation(libs.coroutines.android)

    // Room Database
    implementation(libs.room.runtime)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.ui.graphics.android)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.animation.core.android)
    implementation(libs.material)
    implementation(libs.androidx.junit.ktx)
    implementation(libs.androidx.monitor)
    ksp(libs.room.compiler)
}