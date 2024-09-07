package dev.trindadedev.tinyinstaller.data.app.util

import kotlinx.serialization.Serializable

@Serializable
enum class DataType {
    AUTO,
    APK,
    APKS,
    APKM,
    XAPK
}
