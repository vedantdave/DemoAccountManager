package com.vedant.demoaccountmanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Vedant on 16-01-2017.
 */

public class DemoAccountService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new DemoAccountAuthenticator(getApplicationContext()).getIBinder();
    }
}
