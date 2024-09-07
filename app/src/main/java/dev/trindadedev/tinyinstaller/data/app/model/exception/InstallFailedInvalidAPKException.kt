package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedInvalidAPKException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}