package com.berdnikov.dmitry.architectureexample.model.common.rxbus;

import com.berdnikov.dmitry.architectureexample.model.common.rxbus.event.BusEvent;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/**
 * Created by Dmitry on 25.12.2016.
 */

public class RxBus<T> {

    private final SerializedSubject<BusEvent, BusEvent> bus = new SerializedSubject<>(PublishSubject.create());

    public void post(BusEvent event) {
        bus.onNext(event);
    }

    public Observable<T> events(Class<T> type) {
        return events().ofType(type);
    }

    public Observable<BusEvent> events() {
        return bus.asObservable();
    }
}