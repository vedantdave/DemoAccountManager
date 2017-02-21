package com.vedant.demoaccountmanager.orm.models;

import android.content.Context;

import com.vedant.demoaccountmanager.orm.ColumnType;
import com.vedant.demoaccountmanager.orm.OColumn;
import com.vedant.demoaccountmanager.orm.OModel;

/**
 * Created by Vedant on 17-01-2017.
 */

public class AccountMaster extends OModel {

    OColumn name = new OColumn("name", ColumnType.VARCHAR);

    public AccountMaster(Context context) {
        super(context, "account.master");
    }
}
