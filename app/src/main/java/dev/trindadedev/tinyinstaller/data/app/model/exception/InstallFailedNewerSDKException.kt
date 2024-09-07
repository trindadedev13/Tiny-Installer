package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedNewerSDKException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}