# DemoAccountManager
Android Custom Account Creation 

-Steps
  -Be ready with your Login and Signup Code
  -In Signup code, use the method <b>createAccount()</b> and pass the details of the user
  -In AccountUtils, implement the logic for : if the account is already present.
    -if not then, use the method <b>addAccountExplicitly</b>
  -Make another class DemoAccountAuthenticator and extend <b>AbstractAccountAuthenticator</b> and implement its method and a constructor.
  -Make a service <b>DemoAccount</b> by extending <b>Service</b> class and implement its method.
    - In onBind() Method, return new DemoAccountAuthenticator object with calling of <b>getIBinder()</b>.
-Android Manifest File
  -Add permissions
    -<uses-permission android:name="android.permission.GET_ACCOUNTS" />
    -<uses-permission android:name="android.permission.AUTHENTICATE_ACCOUNTS" />
  - Register Service
    write the following code
     <service android:name=".DemoAccountService">
            <intent-filter>
                <action android:name="android.accounts.AccountAuthenticator" />
            </intent-filter>

            <meta-data
                android:name="android.accounts.AccountAuthenticator"
                android:resource="@xml/authenticator" />
        </service>
- authenticator.xml
  - set the accountType to your desired domain e.g. - "com.gmail"
