import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<StatefulWidget> createState() => HomePageState();
}

class HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return ListView(
      shrinkWrap: true,
      padding: const EdgeInsets.all(20.0),
      children: const [
        Text('I\'m dedicating every day to you'),
        Text('Domestic life was never quite my style'),
        Text('When you smile, you knock me out, I fall apart'),
        Text('And I thought I was so smart'),
      ],
    );
  }
}