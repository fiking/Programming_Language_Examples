import 'package:flutter/material.dart';

class AppDesktop extends StatefulWidget {
  const AppDesktop({super.key});

  @override
  State<AppDesktop> createState() => AppDesktopState();
}

class AppDesktopState extends State<AppDesktop> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("App Desktop"),
      ),
    );
  }
}