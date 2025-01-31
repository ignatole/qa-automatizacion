package com.enviopack.config;

import com.enviopack.enums.Browser;

public class ConfigBrowser {

    private final ConfigAccessor configAccessor;

    public ConfigBrowser(ConfigAccessor configAccessor) {
        this.configAccessor = configAccessor;
    }

    public Browser getBrowser() {
        String browser = configAccessor.getKey("browser").toUpperCase();
        return Browser.valueOf(browser);
    }
}
