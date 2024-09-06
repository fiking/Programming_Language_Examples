import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<StatefulWidget> createState() => HomePageState();
}

class HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return Container(  
      padding: EdgeInsets.all(20.0), //容器内补白
      color: Colors.orange,
      child: Text("Hello world!"),);
  }
}