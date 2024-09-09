import 'package:flutter/material.dart';
import 'package:scrollview/widgets/goods_item_widget.dart';

class GoodsPage extends StatefulWidget {
  const GoodsPage({super.key});


  @override
  State<GoodsPage> createState() => GoodsPageState();
}

class GoodsPageState extends State<GoodsPage> {
  List<IconData> icons = [];

  @override
  void initState() {
    super.initState();

    // 初始化数据
    retrieveIcons();
  }

  void retrieveIcons() {
    Future.delayed(const Duration(milliseconds: 200)).then((e){
      setState(() {
        icons.addAll([
          Icons.ac_unit,
          Icons.airport_shuttle,
          Icons.all_inclusive,
          Icons.beach_access,
          Icons.cake,
          Icons.free_breakfast,
        ]);
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return GridView.builder(
      gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
        crossAxisCount: 2,
        childAspectRatio: 1.0,
      ),

      itemCount: icons.length,
      itemBuilder: (context, index) {
        if (index == icons.length - 1 && icons.length < 200) {
          retrieveIcons();
        }
        return GoodsItemWidget(icons[index]);
        //Icon(icons[index]);
      },
    );
  }

}