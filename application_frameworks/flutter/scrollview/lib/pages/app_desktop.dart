import 'package:flutter/material.dart';
import 'package:scrollview/pages/goods_detail_page.dart';
import 'package:scrollview/pages/goods_page.dart';
import 'package:scrollview/pages/home_page.dart';
import 'package:scrollview/pages/lottie_page.dart';

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
      body: PageView(
        children: const [
          HomePage(),
          GoodsPage(),
          LottiePage(),
          GoodsDetailPage(),
        ],
      ),
    );
  }
}