package org.wikipedia.config;


import org.aeonbits.owner.Config;

/*
Настройки конфигурации беруться из resources mobile.properties. Маппинг настроек реализуется через библиотеку Owner.
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties", "classpath:mobile.properties"
})


public interface PROP extends Config {

    @Key("android.version")
    String getAndroidversion();

    @Key("android.device")
    String getAndroidDevice();

    @Key("android.app")
    String getAndroidApp();

    @Key("url")
    String getUrl();

    @Key("android.app.path")
    String getAndroidAppPath();

    @Key("android.apppackage")
    String getAndroidAppPackage();

    @Key("android.appactivity")
    String getAndroidAppActivity();
}
