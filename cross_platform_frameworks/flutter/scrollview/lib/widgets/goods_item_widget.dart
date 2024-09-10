import 'package:flutter/material.dart';

class GoodsItemWidget extends StatelessWidget {
  const GoodsItemWidget(this.icon, {super.key});

  final IconData icon;

  @override
  Widget build(BuildContext context) {
    return Padding(
        padding: const EdgeInsets.all(0),
        child: Material(
          color: Colors.white,
          borderRadius: BorderRadius.circular(5),
          clipBehavior: Clip.antiAlias,
          child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Expanded(
                  child: ConstrainedBox(
                      constraints: const BoxConstraints.expand(),
                      child: const Image(
                        image:
                            AssetImage('images/india_chettinad_silk_maker.png'),
                      )),
                ),
                const Padding(
                  padding:
                      EdgeInsets.only(left: 8, top: 0, right: 8, bottom: 0),
                  child: Text(
                    '华为Mate X5原装拆机自带手机壳保护套透明',
                    maxLines: 2,
                    style: TextStyle(fontSize: 12),
                  ),
                ),
                const SizedBox(
                  height: 2,
                ),
                Row(children: [
                  Container(
                    margin: const EdgeInsets.only(
                        left: 8, top: 0, right: 0, bottom: 0),
                    decoration: BoxDecoration(
                        borderRadius:
                            const BorderRadius.all(Radius.circular(3)),
                        border: Border.all(
                            width: 1, color: const Color(0xFFff692d))),
                    child: const Text(
                      '百亿补贴',
                      style: TextStyle(color: Color(0xFFff692d), fontSize: 10),
                    ),
                  ),
                  Container(
                    margin: const EdgeInsets.only(
                        left: 8, top: 0, right: 0, bottom: 0),
                    decoration: BoxDecoration(
                        borderRadius:
                            const BorderRadius.all(Radius.circular(3)),
                        border: Border.all(
                            width: 1, color: const Color(0xFFffd589))),
                    child: const Text(
                      '包邮',
                      style: TextStyle(color: Color(0xFFfebe35), fontSize: 10),
                    ),
                  ),
                ]),
                const SizedBox(
                  height: 18,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.start,
                  children: const <Widget>[
                    SizedBox(
                      width: 5,
                    ),
                    Text(
                      '￥',
                      style: TextStyle(fontSize: 10, color: Color(0xFFff5410)),
                    ),
                    Text(
                      '789.78',
                      style: TextStyle(fontSize: 16, color: Color(0xFFff5410)),
                    ),
                    SizedBox(
                      width: 10,
                    ),
                    Expanded(
                      child: Text(
                        '10人想要',
                        style:
                            TextStyle(fontSize: 10, color: Color(0xFF979896)),
                      ),
                    ),
                    Icon(
                      Icons.more_horiz,
                      size: 15,
                      color: Color(0xFF979896),
                    ),
                    SizedBox(
                      width: 8,
                    ),
                  ],
                ),
              ]),
        ));
  }
}