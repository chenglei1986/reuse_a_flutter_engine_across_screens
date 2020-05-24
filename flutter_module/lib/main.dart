import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_module/page_a.dart';
import 'package:flutter_module/page_b.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  MethodChannel _methodChannel = MethodChannel('com.example/method_channel');
  Widget _initRoute = DefaultHomePage();

  @override
  void initState() {
    super.initState();
    _methodChannel.setMethodCallHandler((call) async {
      switch (call.method) {
        case 'setInitRoute':
          _handleInitRouteMethodCall(call);
          break;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: _initRoute,
    );
  }

  void _handleInitRouteMethodCall(MethodCall call) async {
    switch (call.arguments) {
      case '/page_a':
        _initRoute = PageA();
        break;
      case '/page_b':
        _initRoute = PageB();
        break;
      default:
        _initRoute = DefaultHomePage();
        break;
    }
    setState(() {});
  }
}

class DefaultHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: GestureDetector(
          child: Icon(Icons.arrow_back),
          onTap: () => SystemNavigator.pop(),
        ),
        title: Text('Default Home Page'),
      ),
      body: Container(),
    );
  }
}
