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
    @Key("authorization.login")
    String login();
    @Key("authorization.password")
    String password();
    @Key("recovery.password")
    String recoveryPassword();
    @Key("recovery.login")
    String recoveryLogin();
}
