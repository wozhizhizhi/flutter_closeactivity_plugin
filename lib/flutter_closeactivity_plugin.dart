import 'dart:async';

import 'package:flutter/services.dart';

class FlutterCloseactivityPlugin {
  static const MethodChannel _channel =
      const MethodChannel('flutter_closeactivity_plugin');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<int> get activityClose async {
    final int type = await _channel.invokeMethod('activityClose');
    return type;
  }
}
