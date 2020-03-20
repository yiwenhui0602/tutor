package com.tutor.thread;

import com.tutor.log.AppLog;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadPoolExceptionHandler implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        AppLog.LOG_COMMON.error(t.getName(), e);
    }

}
