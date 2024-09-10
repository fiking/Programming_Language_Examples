import 'package:flutter/material.dart';

class GoodsItemWidget extends StatelessWidget {
  const GoodsItemWidget(this.icon, this.index, {super.key});

  final IconData icon;
  final int index;

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
                      child: icon == Icons.ac_unit
                          ? Image.network(
                              'https://pic4.zhimg.com/v2-19dced236bdff0c47a6b7ac23ad1fbc3.jpg')
                          : Image.network(
                              'https://photo.16pic.com/00/13/89/16pic_1389821_b.jpg')),
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
                    child: Text(
                      '包邮',
                      style: TextStyle(color: Color(0xFFff692d), fontSize: 12),
                    ),
                  ),
                  Container(
                    margin: const EdgeInsets.only(
                        left: 8, top: 0, right: 8, bottom: 0),
                    child: const Text(
                      '华为Mate X5原装拆机自',
                      maxLines: 2,
                      style: TextStyle(fontSize: 12),
                    ),
                  ),
                ]),
                const SizedBox(
                  height: 2,
                ),
                Padding(
                  padding: const EdgeInsets.only(
                      left: 8, top: 0, right: 8, bottom: 0),
                  child: Text(
                    '带手机壳保护套透明 $index',
                    maxLines: 2,
                    style: const TextStyle(fontSize: 12),
                  ),
                ),
                const SizedBox(
                  height: 5,
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
                Row(
                  mainAxisAlignment: MainAxisAlignment.start,
                  children: [
                    Container(
                      margin: const EdgeInsets.only(
                          left: 8, top: 0, right: 0, bottom: 0),
                      decoration: BoxDecoration(
                          borderRadius:
                              const BorderRadius.all(Radius.circular(3)),
                          border: Border.all(
                              width: 1, color: const Color(0xFFff692d))),
                      child: const Text(
                        '24小时发货',
                        style:
                            TextStyle(color: Color(0xFFff692d), fontSize: 12),
                      ),
                    ),
                    Container(
                      margin: const EdgeInsets.only(
                          left: 8, top: 0, right: 0, bottom: 0),
                      decoration: BoxDecoration(
                          borderRadius:
                              const BorderRadius.all(Radius.circular(3)),
                          border: Border.all(
                              width: 1, color: const Color(0xFFff692d))),
                      child: const Text(
                        '几乎全新',
                        style: TextStyle(
                            color: Color.fromARGB(255, 228, 225, 225),
                            fontSize: 12),
                      ),
                    ),
                  ],
                ),
                const SizedBox(
                  height: 5,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.start,
                  children: [
                    const SizedBox(
                      height: 5,
                    ),
                    CircleAvatar(
                      radius: 10,
                      backgroundImage: NetworkImage(
                          'https://pic2.zhimg.com/v2-639b49f2f6578eabddc458b84eb3c6a1.jpg'),
                    ),
                    Container(
                      margin: const EdgeInsets.only(
                          left: 8, top: 0, right: 0, bottom: 0),
                      child: Text(
                        '上海 ',
                        style: TextStyle(
                            color: Color.fromARGB(255, 228, 225, 225),
                            fontSize: 12),
                      ),
                    ),
                  ],
                ),
                const SizedBox(
                  height: 5,
                ),
              ]),
        ));
  }
}
