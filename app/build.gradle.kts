import java.io.FileInputStream
import java.util.*
import java.io.ByteArrayOutputStream

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.agp.app)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose.compiler)
    id("kotlin-kapt")
    id("kotlinx-serialization")
}

val app_version = "0.0.1"

@Suppress("UnstableApiUsage")
android {
    compileSdk = 34

    defaultConfig {
        // If you use Tiny-Installer source code, package it into apk or other installation package format
        // Please change the applicationId to one that does not conflict with any official release.
        applicationId = "dev.trindadedev.tinyinstaller"
        namespace = "dev.trindadedev.tinyinstaller"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = app_version

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        javaCompileOptions {
            annotationProcessorOptions {
                compilerArgumentProviders(
                    RoomSchemaArgProvider(File(projectDir, "schemas"))
                )
            }
        }
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file(layout.buildDirectory.dir("../testkey.keystore"))
            storePassword = "testkey"
            keyAlias = "testkey"
            keyPassword = "testkey"
        }
        create("release") {
            storeFile = file(layout.buildDirectory.dir("../release_key.jks"))
            storePassword = "tinyinstaller"
            keyAlias = "tinyinstaller"
            keyPassword = "tinyinstaller"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
            resValue("string", "app_name", "Tiny-Installer")
            resValue("string", "app_version", app_version)
            resValue("string", "GIT_COMMIT_HASH", getGitHash())
            resValue("string", "GIT_COMMIT_AUTHOR", getGitCommitAuthor())
            resValue("string", "GIT_COMMIT_BRANCH", getGitBranch())
        }
        getByName("debug") {
            versionNameSuffix = "-@" + getShortGitHash()
            resValue("string", "app_name", "Tiny-Installer Debug")
            resValue("string", "app_version", app_version)
            resValue("string", "GIT_COMMIT_HASH", getGitHash())
            resValue("string", "GIT_COMMIT_AUTHOR", getGitCommitAuthor())
            resValue("string", "GIT_COMMIT_BRANCH", getGitBranch())
        }
    }

    flavorDimensions += "level"

    productFlavors {
        create("unstable") {
            dimension = "level"
            isDefault = true
        }

        create("preview") {
            dimension = "level"
        }

        create("stable") {
            dimension = "level"
        }
    }

    applicationVariants.all {
        val level = when (flavorName) {
            "unstable" -> 0
            "preview" -> 1
            "stable" -> 2
            else -> 0
        }.toString()
        buildConfigField("int", "BUILD_LEVEL", level)
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_18
        sourceCompatibility = JavaVersion.VERSION_18
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_18)
        }
    }

    buildFeatures {
        buildConfig = true
        compose = true
        aidl = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlin.get()
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

class RoomSchemaArgProvider(
    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    val schemaDir: File
) : CommandLineArgumentProvider {

    override fun asArguments(): Iterable<String> {
        return listOf("room.schemaLocation=${schemaDir.path}")
    }
}

fun execAndGetOutput(vararg command: String): String {
    val stdout = ByteArrayOutputStream()
    exec {
        commandLine(*command)
        standardOutput = stdout
    }
    return stdout.toString().trim()
}

fun getGitHash() = execAndGetOutput("git", "rev-parse", "HEAD")

fun getShortGitHash() = execAndGetOutput("git", "rev-parse", "--short", "HEAD")

fun getGitBranch() = execAndGetOutput("git", "rev-parse", "--abbrev-ref", "HEAD")

fun getGitCommitAuthor() = execAndGetOutput("git", "log", "-1", "--pretty=format:%an")


dependencies {
    compileOnly(project(":hidden-api"))

    implementation(libs.androidx.core)
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.activity.compose)
    implementation(libs.material)
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.material3)
    implementation(libs.compose.uiToolingPreview)

    implementation(libs.compose.navigation)
    implementation(libs.compose.materialIcons)

    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)

    implementation(libs.work.runtime.ktx)

    implementation(libs.ktx.serializationJson)

    implementation(libs.lsposed.hiddenapibypass)

    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)

    implementation(libs.lottie.compose)

    implementation(libs.accompanist.navigationAnimation)
    implementation(libs.accompanist.flowlayout)
    implementation(libs.accompanist.drawablepainter)
    implementation(libs.accompanist.systemuicontroller)

    implementation(libs.rikka.shizuku.api)
    implementation(libs.rikka.shizuku.provider)

    implementation(libs.compose.coil)

    implementation(libs.xxpermissions)

    implementation(libs.iamr0s.dhizuku.api)

    implementation(libs.iamr0s.androidAppProcess)
}


