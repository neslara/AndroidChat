package com.example.neslaram.androidchat.lib;

import java.util.Objects;

/**
 * Created by neslaram on 03/07/16.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object subscriber);
}
