package com.berdnikov.dmitry.architectureexample.model.common.rxbus;

import com.berdnikov.dmitry.architectureexample.model.common.rxbus.event.BusEvent;

import java.util.LinkedList;
import java.util.List;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Dmitry on 25.12.2016.
 */

public class BusSubscriber<T extends BusEvent> implements BusSubscriberContract<T> {
    private RxBus<T> bus;
    private final List<Subscription> subscriptions = new LinkedList<>();

    @Override
    public void bus(RxBus<T> bus) {
        this.bus = bus;
    }

    @Override
    public void subscribe(Class<T> clazz, Action1<T> callback) {
        subscriptions.add(bus.events(clazz).subscribe(callback));
    }

    @Override
    public void unsubscribe() {
        for (Subscription item : subscriptions) {
            item.unsubscribe();
        }
        subscriptions.clear();
    }
}