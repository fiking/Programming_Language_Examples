import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';

class LottiePage extends StatefulWidget {
  const LottiePage({super.key});

  @override
  State<LottiePage> createState() => LottiePageState();
}

class LottiePageState extends State<LottiePage> {
  @override
  Widget build(BuildContext context) {
    return ListView(
      children:  [
      Lottie.network('https://raw.githubusercontent.com/xvrh/lottie-flutter/master/example/assets/Mobilo/A.json'),
      Lottie.asset('images/Animation.json'),
      Lottie.asset('images/B.json'),
      ],
    );
  }
}