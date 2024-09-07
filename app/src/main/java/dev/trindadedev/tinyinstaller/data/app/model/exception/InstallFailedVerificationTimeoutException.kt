package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedVerificationTimeoutException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}