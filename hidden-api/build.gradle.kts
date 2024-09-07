@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.agp.lib)
}

android {
    namespace = "dev.trindadedev.hidden_api"
    compileSdk = 33

    defaultConfig {
        minSdk = 19
    }
}

dependencies {
}