plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.hrudhaykanth116.openplayassignment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hrudhaykanth116.openplayassignment"
        minSdk = 24
        targetSdk = 33
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Kotlin
    implementation("androidx.core:core-ktx:1.10.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    // Kotlin immutable collections. (https://github.com/Kotlin/kotlinx.collections.immutable)
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5")

    implementation("androidx.appcompat:appcompat:1.6.1")

    val composeBom = platform("androidx.compose:compose-bom:2023.08.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-util")
    implementation("androidx.compose.foundation:foundation")

    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    // Material
    // implementation("androidx.compose.material:material")
    // https://developer.android.com/jetpack/androidx/releases/compose-material3
    implementation("androidx.compose.material3:material3")

    // Material design icons
    implementation("androidx.compose.material:material-icons-core")
    implementation("androidx.compose.material:material-icons-extended")

    // Integration with activities
    implementation("androidx.activity:activity-compose:1.7.2")
    // Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    // Integration with lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")

    // hilt
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation("androidx.metrics:metrics-performance:1.0.0-alpha04")

    /***************************** Jetpack Compose ****************************/

    //kot-pref for local shared preferences data.
    val kotpref_version = "2.13.1"
    implementation("com.chibatching.kotpref:enum-support:$kotpref_version")
    implementation("com.chibatching.kotpref:kotpref:$kotpref_version")
    implementation("com.chibatching.kotpref:initializer:$kotpref_version")
    implementation("com.chibatching.kotpref:gson-support:$kotpref_version")
    implementation("com.chibatching.kotpref:livedata-support:$kotpref_version")

    // Network
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // Moshi
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.moshi:moshi:1.14.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.45")
    kapt("com.google.dagger:hilt-compiler:2.45")

    // Material design(https://maven.google.com/web/index.html#com.google.android.material:material)
    implementation("com.google.android.material:material:1.9.0")

    //intuit sdp(scalable dp) and ssp(scalable sp)
    val intuit_version = "1.0.6"
    implementation("com.intuit.sdp:sdp-android:$intuit_version")
    implementation("com.intuit.ssp:ssp-android:$intuit_version")

    // Coil
    implementation("io.coil-kt:coil:2.4.0")
    implementation("io.coil-kt:coil-compose:2.4.0")

}