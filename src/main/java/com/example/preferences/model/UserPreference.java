package com.example.preferences.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;

@Introspected
public class UserPreference {

    @NonNull
    private String user;
    @NonNull
    private String key;
    @Nullable
    private String value;

    public UserPreference() {
    }

    public UserPreference(String user, String key, String value) {
        this.user = user;
        this.key = key;
        this.value = value;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}