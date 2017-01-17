package com.vedant.demoaccountmanager.orm.models;

import android.content.Context;

import com.vedant.demoaccountmanager.orm.OModel;

import java.util.HashMap;

/**
 * Created by Vedant on 17-01-2017.
 */

public class ModelRegistry {
    public HashMap<String, OModel> models(Context context) {
        HashMap<String, OModel> model = new HashMap<>();
        model.put("account.manager", new AccountMaster(context));
        return model;
    }
}
