plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.exampleapplication"
    compileSdk = 35  // Updated to 35

    defaultConfig {
        applicationId = "com.example.exampleapplication"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17  // Updated Java version
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.navigation.runtime)

    // ✅ Google Maps + Location + Places API
    implementation("com.google.android.gms:play-services-maps:18.1.0")       // Google Maps SDK
    implementation("com.google.android.gms:play-services-location:21.0.1")    // Location services (for user's location)
    implementation("com.google.android.libraries.places:places:3.4.0")        // Places API for search and place details

    // Optional: Add Flexbox dependency here if required
    // implementation("com.google.android.flexbox:flexbox:3.0.0")  // Uncomment if you need Flexbox

    // Unit Testing
    testImplementation(libs.junit)

    // Android Tests
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
