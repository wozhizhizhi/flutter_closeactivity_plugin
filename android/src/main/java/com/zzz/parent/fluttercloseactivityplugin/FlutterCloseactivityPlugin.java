package com.zzz.parent.fluttercloseactivityplugin;

import android.app.Activity;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterCloseactivityPlugin */
public class FlutterCloseactivityPlugin implements MethodCallHandler {
  private Activity activity;
  private MethodChannel channel;

  public FlutterCloseactivityPlugin(Activity activity, MethodChannel channel)
  {
    this.activity = activity;
    this.channel = channel;
  }
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_closeactivity_plugin");
    channel.setMethodCallHandler(new FlutterCloseactivityPlugin(registrar.activity() , channel));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    }
    else if(call.method.equals("activityClose"))
    {
      activity.finish();
    }
    else {
      result.notImplemented();
    }
  }
}
