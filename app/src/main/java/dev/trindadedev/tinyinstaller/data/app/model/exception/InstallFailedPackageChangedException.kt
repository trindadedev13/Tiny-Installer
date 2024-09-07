package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedPackageChangedException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}