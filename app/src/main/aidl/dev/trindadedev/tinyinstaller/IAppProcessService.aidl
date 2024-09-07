package dev.trindadedev.tinyinstaller;

import dev.trindadedev.tinyinstaller.IPrivilegedService;

interface IAppProcessService {
    void quit();

    IPrivilegedService getPrivilegedService();
}
