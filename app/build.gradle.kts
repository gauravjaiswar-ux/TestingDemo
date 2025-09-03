plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id ("org.sonarqube") version "5.1.0.4882"
}


sonarqube {
    properties {
        property("sonar.projectName", "truvideo-image-sdk")
        property("sonar.projectKey", "com.truvideo.sdk.image")
        property("sonar.host.url", "http://localhost:9000")
        property("sonar.sources", "src/main") // list of sources
        property("sonar.language", "kotlin")
        property ("sonar.java.binaries", "build")
        property("sonar.scm.disabled", "true")
        property("sonar.token", "squ_faba1a72b53efe4c267d0966b354584632e28af5")

        //property("sonar.login", "admin")
        // property("sonar.password", "Anurag@9589393555")
        property("sonar.gradle.skipCompile", "true") // ✅ Added to avoid implicit compilation
    }
}

android {
    namespace = "com.example.applinkdemo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.applinkdemo"
        minSdk = 24
        targetSdk = 35
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}