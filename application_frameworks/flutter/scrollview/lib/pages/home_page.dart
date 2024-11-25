import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<StatefulWidget> createState() => HomePageState();
}

class HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: 300,
      itemExtent: 50.0,
      itemBuilder: (BuildContext context, int index) {
        return ListTile(title: Text('$index'),);
      }
    );
  }
}