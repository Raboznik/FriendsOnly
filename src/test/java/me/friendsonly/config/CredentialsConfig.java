package me.friendsonly.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:credentials.properties")
public interface CredentialsConfig extends Config {

    @Key("remote.login")
    String remoteLogin();

    @Key("remote.password")
    String remotePassword();

    @Key("remote.url")
    String remoteUrl();
}
