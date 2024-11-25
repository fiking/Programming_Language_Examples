import 'package:flutter/material.dart';
import 'package:scrollview/widgets/goods_item_widget.dart';

class GoodsDetailPage extends StatefulWidget {
  const GoodsDetailPage({super.key});

  @override
  State<GoodsDetailPage> createState() => GoodsDetailPageState();
}

class GoodsDetailPageState extends State<GoodsDetailPage> {
  final TextEditingController textEditingController = TextEditingController();
  final List<String> comments = [
    '好看',
    '很好用',
    '多少钱',
    '有21寸的轮胎嘛',
    '纹路很好',
  ];

  void submitComment(String text) {
    setState(() {
      comments.add(text);
      textEditingController.clear();
    });
  }

    List<IconData> icons = [];

  @override
  void initState() {
    super.initState();

    // 初始化数据
    retrieveIcons();
  }

  void retrieveIcons() {
   // Future.delayed(const Duration(milliseconds: 200)).then((e){
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
   // });
  }

  @override
  Widget build(BuildContext context) {
    return Material(
        color: Colors.white,
        borderRadius: BorderRadius.circular(5),
        clipBehavior: Clip.antiAlias,
        child: Padding(
          padding: const EdgeInsets.only(left: 8, top: 10, right: 8, bottom: 0),
          child: CustomScrollView(
            slivers: [
              SliverList(
                  delegate: SliverChildBuilderDelegate(
                (BuildContext context, int index) {
                  return Column(
                    mainAxisAlignment: MainAxisAlignment.start,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Row(
                        mainAxisAlignment: MainAxisAlignment.start,
                        children: [
                          const CircleAvatar(
                            radius: 18,
                            backgroundImage: NetworkImage(
                                'https://pic2.zhimg.com/v2-639b49f2f6578eabddc458b84eb3c6a1.jpg'),
                          ),
                          Padding(
                            padding: const EdgeInsets.only(
                                left: 8, top: 0, right: 0, bottom: 0),
                            child: Column(
                              mainAxisAlignment: MainAxisAlignment.start,
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                const Text(
                                  '天空蓝色',
                                  style: TextStyle(fontSize: 14),
                                ),
                                Row(
                                  mainAxisAlignment: MainAxisAlignment.start,
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: const [
                                    Text(
                                      '7分钟前来过',
                                      style: TextStyle(
                                          color: Color.fromARGB(
                                              220, 239, 233, 230),
                                          fontSize: 10),
                                    ),
                                    Text(
                                      '合肥',
                                      style: TextStyle(
                                          color: Color.fromARGB(
                                              220, 239, 233, 230),
                                          fontSize: 10),
                                    ),
                                  ],
                                )
                              ],
                            ),
                          ),
                        ],
                      ),
                      Padding(
                        padding: const EdgeInsets.only(
                            left: 0, top: 20, right: 0, bottom: 0),
                        child: Row(
                            mainAxisAlignment: MainAxisAlignment.start,
                            children: const <Widget>[
                              SizedBox(
                                width: 5,
                              ),
                              Text(
                                '￥',
                                style: TextStyle(
                                    fontSize: 10, color: Color(0xFFff5410)),
                              ),
                              Text(
                                '789.78',
                                style: TextStyle(
                                    fontSize: 20, color: Color(0xFFff5410)),
                              ),
                              SizedBox(
                                width: 10,
                              ),
                              Expanded(
                                child: Text(
                                  '包邮',
                                  style: TextStyle(
                                      fontSize: 10, color: Color(0xFF979896)),
                                ),
                              ),
                            ]),
                      ),
                      const Padding(
                        padding: EdgeInsets.only(
                            left: 8, top: 80, right: 8, bottom: 0),
                        child: Text(
                          '还剩13张！全新傲风玉桂狗电竞椅皮卡丘限量款电竞椅子家用游戏 椅电脑椅办公椅可躺椅靠背椅学生宿舍椅 全新外贸出口品质电【现货低 价处理】电脑椅家用舒适电竞椅女久坐主播座椅书房沙发椅直播转椅靠背椅子双层分区释压，远离弯腰驼背。升级无档位，调节更自在。大幅度后仰90-130°，自由升降，上下调节。双层承重座包，吸收强有力冲击，坐垫不易坍塌变形。无声静音滑轮，沉稳无阻，静音享受，不伤地板。都是外贸出口的椅子，现在因客户原因，这批椅子不能出，电竞椅品质好，性价比高，质量有保证压货清库存，处理一批电脑椅子，电竞椅供实体店品质，质量有保证。本店产品质量非常好。大家放心购买，所有产品都有质保的。用心经营！质量保证！价格便宜，放心购买。全新未拆封，质量问题签收前确认可直接拒收！',
                          style: TextStyle(fontSize: 18, height: 2),
                        ),
                      ),
                      const Padding(
                        padding: EdgeInsets.only(
                            left: 8, top: 80, right: 8, bottom: 0),
                        child: Text(
                          '颜色: 灰色 米色 黑色',
                          style: TextStyle(fontSize: 18, height: 2),
                        ),
                      ),
                      const Padding(
                        padding: EdgeInsets.only(
                            left: 8, top: 5, right: 8, bottom: 0),
                        child: Text(
                          '规格: 头枕 + 脚踏',
                          style: TextStyle(fontSize: 18, height: 2),
                        ),
                      ),
                      const Padding(
                        padding: EdgeInsets.only(
                            left: 8, top: 5, right: 8, bottom: 0),
                        child: Text(
                          '数量有限，拍完下架。需要可以点“我想要”颜色备注留言，有问题可以给我留言',
                          style: TextStyle(fontSize: 18, height: 2),
                        ),
                      ),
                      const Padding(
                        padding: EdgeInsets.only(
                            left: 8, top: 5, right: 8, bottom: 0),
                        child: Text(
                          '偏远地区不包邮.全新包邮，运费较高，到货后验货再签收。有质量问题拒收，签收后不退换（退换运费自理）',
                          style: TextStyle(fontSize: 18, height: 2),
                        ),
                      ),
                      const Padding(
                        padding: EdgeInsets.only(
                            left: 8, top: 5, right: 8, bottom: 0),
                        child: Text(
                          '#电竞电脑装备 #办公家具 #宿舍电脑椅',
                          style: TextStyle(fontSize: 18, height: 2),
                        ),
                      ),
                      const Padding(
                        padding: EdgeInsets.only(
                            left: 8, top: 20, right: 8, bottom: 0),
                        child: Text(
                          '45条留言',
                          style: TextStyle(fontSize: 18, height: 2),
                        ),
                      ),
                    ],
                  );
                },
                childCount: 1,
              )),
              SliverList(
                delegate: SliverChildBuilderDelegate(
                  (BuildContext context, int index) {
                    if (index == 0) {
                      return Column(
                        mainAxisAlignment: MainAxisAlignment.start,
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Padding(
                            padding: const EdgeInsets.only(
                                left: 8, top: 20, right: 8, bottom: 0),
                            child: TextField(
                              controller: textEditingController,
                              decoration: const InputDecoration(
                                hintText: '请输入评论',
                                enabledBorder: OutlineInputBorder(
                                  borderRadius: BorderRadius.all( 
                                    Radius.circular(5)
                                  ),
                                  borderSide: BorderSide(
                                    color: Color.fromARGB(255, 16, 6, 6),
                                    width: 2,
                                  )
                                ),
                                focusedBorder: OutlineInputBorder(
                                  borderRadius: BorderRadius.all( 
                                    Radius.circular(5)
                                  ),
                                  borderSide: BorderSide(
                                    color: Color.fromARGB(255, 16, 6, 6),
                                    width: 2,
                                  )
                                ),
                              ),
                              onSubmitted: (String text) {
                                submitComment(text);
                              },
                              style: const TextStyle(),
                            ),
                          ),
                          Padding(
                            padding: const EdgeInsets.only(
                                left: 8, top: 10, right: 8, bottom: 10),
                            child: Text(
                              comments[index],
                              style: const TextStyle(
                                fontSize: 16,
                              ),
                            ),
                          )
                        ],
                      );
                    } else {
                      return Padding(
                        padding: const EdgeInsets.only(
                            left: 8, top: 10, right: 8, bottom: 10),
                        child: Text(
                          comments[index],
                          style: const TextStyle(
                            fontSize: 16,
                          ),
                        ),
                      );
                    }
                  },
                  childCount: comments.length,
                ),
              ),
              SliverList(
                delegate: SliverChildBuilderDelegate(
                  (BuildContext context, int index) {
                    if (index == icons.length - 1 && icons.length < 200) {
                      retrieveIcons();
                    }
                    return Padding(
                      padding: const EdgeInsets.only(
                            left: 8, top: 10, right: 8, bottom: 10),
                      child: Image.network(
                              'https://photo.16pic.com/00/13/89/16pic_1389821_b.jpg')
                    );
                  },
                  childCount: icons.length,
                )
              ),
            ],
          ),
        ));
  }
}
