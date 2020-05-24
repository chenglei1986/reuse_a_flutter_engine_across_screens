import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class PageA extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: GestureDetector(
          child: Icon(Icons.arrow_back),
          onTap: () => onBackPressed(context),
        ),
        title: Text('Page A'),
      ),
      body: Container(),
    );
  }

  void onBackPressed(BuildContext context) {
    NavigatorState navigatorState = Navigator.of(context);
    if (navigatorState.canPop()) {
      navigatorState.pop();
    } else {
      SystemNavigator.pop();
    }
  }
}
