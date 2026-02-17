package com.yash.airportpool.concurrency;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class RideLockManager {

    private final ConcurrentHashMap<Long, ReentrantLock> lockMap
            = new ConcurrentHashMap<>();

    public void lock(Long rideId) {
        lockMap.computeIfAbsent(rideId, id -> new ReentrantLock())
                .lock();
    }

    public void unlock(Long rideId) {
        ReentrantLock lock = lockMap.get(rideId);
        if (lock != null) {
            lock.unlock();
        }
    }
}
