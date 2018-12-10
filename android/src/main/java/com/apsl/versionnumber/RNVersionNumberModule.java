package com.apsl.versionnumber;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;

import java.util.HashMap;
import java.util.Map;

public class RNVersionNumberModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  private static final String APP_VERSION = "appVersion";
  private static final String APP_BUILD = "buildVersion";
  private static final String APP_ID = "bundleIdentifier";
  
  private static final String BASESTATION_APP_VERSION = "basestationAppVersion";
  private static final String BASESTATION_APP_BUILD = "basestationBuildVersion";
  private static final String BASESTATION_APP_ID = "basestationBundleIdentifier";
  
  public RNVersionNumberModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNVersionNumber";
  }

  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();
    final PackageManager packageManager = this.reactContext.getPackageManager();
    final String packageName = this.reactContext.getPackageName();
    final String basestationName = "com.dthera.basestation";
    try {
      constants.put(APP_VERSION, packageManager.getPackageInfo(packageName, 0).versionName);
      constants.put(APP_BUILD, packageManager.getPackageInfo(packageName, 0).versionCode);
      constants.put(APP_ID, packageName);
      constants.put(BASESTATION_APP_VERSION, packageManager.getPackageInfo(basestationName, 0).versionName);
      constants.put(BASESTATION_APP_BUILD, packageManager.getPackageInfo(basestationName, 0).versionCode);
      constants.put(BASESTATION_APP_ID, basestationName);
    } catch (NameNotFoundException e) {
      e.printStackTrace();
    }
    return constants;
  }

  @ReactMethod
  public void getVersionName(final String packageName, final Promise promise)  {
    PackageManager packageManager = this.reactContext.getPackageManager();
    String versionName = "1.0.0";
    try {
      versionName = packageManager.getPackageInfo(packageName, 0).versionName;
    } catch (NameNotFoundException e) {
      e.printStackTrace();
    }
    promise.resolve(versionName);
  }
}
