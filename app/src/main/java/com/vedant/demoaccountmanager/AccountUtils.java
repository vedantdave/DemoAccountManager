package com.vedant.demoaccountmanager;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Vedant on 16-01-2017.
 */

public class AccountUtils {
    private Context context;
    private AccountManager accountManager;
    private Account[] accounts;

    public AccountUtils(Context context) {
        this.context= context;
        accountManager = (AccountManager) context.getSystemService(context.ACCOUNT_SERVICE);
    }

    public static AccountUtils get(Context context) {

        return new AccountUtils(context);
    }

    public boolean createAccount(String email,String password)
    {
        if (!hasAccount(email)) {
        Account account = new Account(email,"com.gmail");
        Bundle b = new Bundle();
        b.putString("email",email);
        return accountManager.addAccountExplicitly(account,"N/A",b);}
        else
        {
            Toast.makeText(context, "Already exists", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public boolean hasAccount(String name) {
        for (Account account : getAccounts()) {
            if (account.name.equals(name))
                return true;
        }
        return false;
    }

    public Account[] getAccounts() {
        return accountManager.getAccountsByType("com.gmail");
    }
}
