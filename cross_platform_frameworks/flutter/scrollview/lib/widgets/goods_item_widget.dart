import 'package:flutter/material.dart';

class GoodsItemWidget extends StatelessWidget {
  const GoodsItemWidget(this.icon, {super.key});

  final IconData icon;

  @override
  Widget build(BuildContext context) {
    return Icon(icon);
  }
}