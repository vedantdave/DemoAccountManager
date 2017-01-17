package com.vedant.demoaccountmanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Vedant on 17-01-2017.
 */

public class SyncService extends Service {
    private static SyncAdapter sSyncAdapter = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sSyncAdapter = new SyncAdapter(getApplicationContext(), false);


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return sSyncAdapter.getSyncAdapterBinder();
    }
}
