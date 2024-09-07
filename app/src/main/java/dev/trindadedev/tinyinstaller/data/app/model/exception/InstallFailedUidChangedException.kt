package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedUidChangedException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}