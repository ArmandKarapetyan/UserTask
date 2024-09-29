plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.task.data"
    compileSdk = libs.versions.compileSdk.get().toInt()


    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField("String", "BASE_URL", "\"https://api.github.com/\"")

        }
        debug {
            buildConfigField("String", "BASE_URL", "\"https://api.github.com/\"")
        }
    }
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        buildConfig = true
    }
    android.libraryVariants.configureEach {
        sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/${name}/kotlin")
            }
        }
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":entities"))
    implementation(libs.koin.android)
    implementation(libs.koin.annotations)
    ksp (libs.koin.ksp.compiler)
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.logging)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}