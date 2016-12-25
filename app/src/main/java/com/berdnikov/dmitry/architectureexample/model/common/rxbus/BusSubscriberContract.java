package com.berdnikov.dmitry.architectureexample.model.common.rxbus;

import com.berdnikov.dmitry.architectureexample.model.common.rxbus.event.BusEvent;

import rx.functions.Action1;

/**
 * Created by Dmitry on 25.12.2016.
 */

public interface BusSubscriberContract<T extends BusEvent> {
    void bus(RxBus<T> bus);
    void subscribe(Class<T> clazz, Action1<T> callback);
    void unsubscribe();
}
