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
                    image: AssetImage('images/india_chettinad_silk_maker.png'),
                  )),
            ),
            const Padding(
              padding: EdgeInsets.only(left: 8, top: 0, right: 8, bottom: 0),
              child: Text(
                'Text Name',
                maxLines: 2,
                style: TextStyle(fontSize: 12),
              ),
              ),
          ],
        ),
      ),
    );
  }
}