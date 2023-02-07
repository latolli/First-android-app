plugins {
    id ("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.example.app123"
    compileSdk = sdk.compile

    defaultConfig {
        applicationId = "com.example.app123"
        minSdk = sdk.min
        targetSdk = sdk.target
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
//add dependencies from buildSrc folder
dependencies {
    implementation(project(":core-database"))
    implementation(project(":core-data"))
    implementation(project(":core-domain"))

    implementation (androidx.core.ktx)
    implementation (androidx.lifecycle.runtimektx)
    implementation (androidx.lifecycle.compose)
    implementation (androidx.activity.activity)
    implementation (androidx.compose.ui.ui)
    implementation (androidx.compose.ui.preview)
    implementation (androidx.compose.material)

    testImplementation (androidx.junit.junit)
    androidTestImplementation (androidx.test.ext.junit)
    androidTestImplementation (androidx.test.espresso.core)
    androidTestImplementation (androidx.compose.ui.junit)
    debugImplementation (androidx.compose.ui.tooling)
    debugImplementation (androidx.compose.ui.manifest)
    implementation (androidx.navigation.navigation)

    //hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.44")
}

kapt {
    correctErrorTypes = true
}