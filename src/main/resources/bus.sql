/*
Navicat MySQL Data Transfer

Source Server         : localhsot
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : bus

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2016-03-29 17:13:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `loginId` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `cardNo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456', '秦始皇', '18618618612', '210211191111111111');
INSERT INTO `admin` VALUES ('4', 'tangtaizong', '123456', '唐太宗', '18618618612', '210211191111111111');
INSERT INTO `admin` VALUES ('5', 'hangaozu', '123456', '汉高祖', '18618618612', '210211191111111111');
INSERT INTO `admin` VALUES ('6', 'chubawang', '123456', '楚霸王', '18618618612', '210211191111111111');

-- ----------------------------
-- Table structure for `bus`
-- ----------------------------
DROP TABLE IF EXISTS `bus`;
CREATE TABLE `bus` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `busNo` varchar(255) DEFAULT NULL,
  `lisenceNo` varchar(255) DEFAULT NULL,
  `driverId` int(32) NOT NULL,
  `maxPerson` int(32) DEFAULT NULL,
  `lineId` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus
-- ----------------------------
INSERT INTO `bus` VALUES ('1', '1', '辽B.F4D3B', '1', '25', '1');
INSERT INTO `bus` VALUES ('2', '2', '辽B.5EGF4', '2', '25', '2');
INSERT INTO `bus` VALUES ('3', '3', '辽B.F20AA', '0', '25', null);
INSERT INTO `bus` VALUES ('4', '4', '辽B.62GAC', '0', '25', null);
INSERT INTO `bus` VALUES ('5', '5', '辽B.F106D', '0', '25', '0');
INSERT INTO `bus` VALUES ('6', '6', '辽B.43CEC', '0', '25', '0');
INSERT INTO `bus` VALUES ('7', '7', '辽B.6A32G', '0', '30', '0');
INSERT INTO `bus` VALUES ('8', '8', '辽B.2GFCA', '0', '30', '0');
INSERT INTO `bus` VALUES ('9', '9', '辽B.G5034', '0', '30', '0');
INSERT INTO `bus` VALUES ('10', '10', '辽B.B4204', '0', '30', '0');
INSERT INTO `bus` VALUES ('11', '11', '辽B.AGF02', '0', '35', '0');
INSERT INTO `bus` VALUES ('12', '12', '辽B.FD5G4', '0', '35', '0');
INSERT INTO `bus` VALUES ('13', '13', '辽B.1CF3G', '0', '35', '0');
INSERT INTO `bus` VALUES ('14', '14', '辽B.BC26G', '0', '35', '0');
INSERT INTO `bus` VALUES ('15', '15', '辽B.1CFB4', '0', '35', '0');
INSERT INTO `bus` VALUES ('16', '16', '辽B.2CF16', '0', '35', '0');
INSERT INTO `bus` VALUES ('17', '17', '辽B.0D6C1', '0', '37', '0');
INSERT INTO `bus` VALUES ('18', '18', '辽B.0EDB6', '0', '37', '0');
INSERT INTO `bus` VALUES ('19', '19', '辽B.1GD0G', '0', '37', '0');
INSERT INTO `bus` VALUES ('20', '20', '辽B.35BDA', '0', '37', '0');
INSERT INTO `bus` VALUES ('21', '21', '辽B.05D4A', '0', '37', '0');
INSERT INTO `bus` VALUES ('22', '22', '辽B.D5553', '0', '37', '0');
INSERT INTO `bus` VALUES ('23', '23', '辽B.143EB', '0', '20', '0');
INSERT INTO `bus` VALUES ('24', '24', '辽B.C1425', '0', '38', '0');
INSERT INTO `bus` VALUES ('25', '25', '辽B.5E0G3', '0', '38', '0');
INSERT INTO `bus` VALUES ('26', '26', '辽B.46A1A', '0', '38', '0');

-- ----------------------------
-- Table structure for `driver`
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `loginId` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `busId` int(32) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES ('1', 'liubei', '刘备', '123456', '18618618612', '00000000000000000000000000000001');
INSERT INTO `driver` VALUES ('2', 'guanyu', '关羽', '123456', '18618618612', '00000000000000000000000000000002');
INSERT INTO `driver` VALUES ('3', 'zhangfei', '张飞', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('4', 'zhaoyun', '赵云', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('5', 'machao', '马超', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('6', 'huangzhong', '黄忠', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('7', 'zhugeliang', '诸葛亮', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('8', 'weiyan', '魏延', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('9', 'jiangwei', '姜维', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('10', 'sunquan', '孙权', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('11', 'zhouyu', '周瑜', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('12', 'huanggai', '黄盖', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('13', 'luxun', '陆逊', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('14', 'sunjian', '孙坚', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('15', 'sunce', '孙策', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('16', 'caocao', '曹操', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('17', 'caochong', '曹冲', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('18', 'caoren', '曹仁', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('19', 'simayi', '司马懿', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('20', 'zhangliao', '张辽', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('21', 'lejin', '乐进', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('22', 'xuhuang', '徐晃', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('23', 'lidian', '李典', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('24', 'dianwei', '典韦', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('25', 'xiahouyuan', '夏侯渊', '123456', '18618618612', '00000000000000000000000000000000');
INSERT INTO `driver` VALUES ('26', 'xiahouchuen', '夏侯淳', '123456', '18618618612', '00000000000000000000000000000000');

-- ----------------------------
-- Table structure for `line`
-- ----------------------------
DROP TABLE IF EXISTS `line`;
CREATE TABLE `line` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `allStationName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line
-- ----------------------------
INSERT INTO `line` VALUES ('1', '2路公交车', '青泥洼桥，武昌街，桃园街，秀月街，老虎滩');
INSERT INTO `line` VALUES ('2', '202路有轨电车', '兴工街，解放广场，和平广场，万达广场，小平岛');
INSERT INTO `line` VALUES ('3', '5路公交车', '青泥洼桥，八一路，半岛晨报社，付家庄，银沙滩');
INSERT INTO `line` VALUES ('4', '303路公交车', '天洋路，天河路，金三角，工人村，五一广场，青泥洼桥');
INSERT INTO `line` VALUES ('5', '10路公交车', '沙河口火车站，兴工街，净水厂，软件园，数码广场，东北财经大学');
INSERT INTO `line` VALUES ('6', '10路公交车', '中山广场，友好广场，人民广场，香工街，友谊桥，玉镜路');
INSERT INTO `line` VALUES ('7', '406路公交车', '希望广场，唐山街，云山街，太原街，黑石礁，理工大学');
INSERT INTO `line` VALUES ('8', '407路公交车', '安阳街，鲁迅路，儿童公园，长春路，香炉礁，亿达世纪城');
INSERT INTO `line` VALUES ('9', '408路公交车', '甘井子，文体街，大纺，工人村，英华街，大连火车站');
INSERT INTO `line` VALUES ('10', '409路公交车', '中山光广场，青泥洼桥，金三角市场，第四人民医院，杨西街');
INSERT INTO `line` VALUES ('11', '8路公交车', '姚家，大连北站，二十三中学，天河路，千山路，金三角，高云街');
INSERT INTO `line` VALUES ('12', '6路公交车', '甘井子，周家街，王家桥，东维路，周水前，香工街，锦辉商城,和平广场');
INSERT INTO `line` VALUES ('13', '413路公交车', '华南国际商城，华南中学，山东路，富强路，松江路，刘家桥，富民中路');
INSERT INTO `line` VALUES ('14', '20路公交车', '华南广场，山东路，千山路，金三角，金家街，第四人民医院，甘井子');
INSERT INTO `line` VALUES ('15', '15路公交车', '人民路，中山广场，一二九街，奥林匹克广场，南沙街，孙家沟，星海公园');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `userId` int(32) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '建议增加经过杏林湾-东渡-思北一线公交！！！', '1', '2014-12-19 15:25:05');
INSERT INTO `message` VALUES ('2', '建议70路公交车延长到太原南站，方便东客站的乘客去太原南站坐车！！！', '1', '2014-12-10 15:25:14');
INSERT INTO `message` VALUES ('3', '滨河东路上的楼盘滨河果岭、三千渡、恒大御景湾这三个楼盘在9月份会陆续交房。是三个很大的小区。附近还有翠馨苑和莱茵香榭。这附近就一个820支，我想了解一下会不会在这边增加公交车？这边出行太不方便。', '1', '2016-03-17 15:23:05');
INSERT INTO `message` VALUES ('4', '公交车速普遍较低，希望公司能站在广大乘客的角度想想，大家都赶时间，在保证安全的情况下提速，给司机师傅们更多的自主权', '1', '2016-05-29 15:23:09');
INSERT INTO `message` VALUES ('5', '2016年3月23日上午8点10分，39路公交车，车牌94371，由学府街坞城路口至平阳路学府街口，司机服务态度差，为了多拉人，让人从后门上车，想赚钱想疯了！！！！', '2', '2015-02-28 15:23:14');
INSERT INTO `message` VALUES ('6', '感谢2016年3月23日上午7：30出车动物园方向的25路晋AA0206的年轻后生，一路上特别招呼我这个准妈妈，多次提醒乘客给我让座。祝福他生活、工作、家庭都圆圆满满。', '3', '2015-06-29 15:23:23');
INSERT INTO `message` VALUES ('7', '每天坐37路的人越来越多，建议37路增加车辆或缩短车距', '3', '2015-06-29 15:23:28');
INSERT INTO `message` VALUES ('8', '我们居住在许东，这边的楼不断增加居住人群也多了，每天早晨23，837公交车到了许东站就不能上了，(挤的不能开门)，是否增加车或者缩短车距，或者附近安装公交自行车点，请求公交公司领导考虑一下。', '3', '2015-10-16 15:23:34');
INSERT INTO `message` VALUES ('9', '今天在胜利桥东坐849，原本几分钟来一趟的今天等了快半个小时！给个说法！', '3', '2015-10-08 15:23:40');
INSERT INTO `message` VALUES ('10', '会有人看么？看了会有人管么？这个社会的人都没有长良心还是良心被狗吃了！', '3', '2015-01-30 15:23:47');
INSERT INTO `message` VALUES ('11', '这样的素质还让他在那开公交车，真是公司领导都瞎了眼了！公交公司就是这样的公司文化么？', '4', '2016-04-23 15:23:54');
INSERT INTO `message` VALUES ('12', '我今天乘坐5路车从招呼站到和平南路长风街口，车上人多，一个男的在门口站着，在义井站的时候从前门下了，我由于怀孕，也不方便跟车上的人挤，准备从前门下，司机因为前站有人从前门下，把气都出在我身上，', '4', '2016-03-01 15:23:58');
INSERT INTO `message` VALUES ('13', '我在昨天即2016年3月17日下午2点左右乘坐801路公交丢失一把越野汽车钥匙。请问是否有人捡到？', '4', '2016-02-03 15:24:02');
INSERT INTO `message` VALUES ('14', '904路公交16号走新兰路，17号就变道滨河东路，怎么没有通知？变化太快耽误我事情', '5', '2016-08-19 15:24:07');
INSERT INTO `message` VALUES ('15', '为什么给公交热线打电话回复说没有太原公交网站？咱们网站下方的电话显示是空号？修路是好事，可让人找不到出行路线也太不合适了吧？整整等了快一个小时，打了半天电话没解决问题，表示不满意！', '5', '2015-06-18 15:24:14');
INSERT INTO `message` VALUES ('16', '817支路多会能开通啊，以前车距很大，以后能不能加几台车呢？', '5', '2016-12-07 15:24:21');
INSERT INTO `message` VALUES ('17', '尖草坪立交桥旁龙城小区汽车没办法出行，一条路都没有了，请问开车的怎么出行？', '5', '2016-01-12 15:24:27');
INSERT INTO `message` VALUES ('18', '想坐201路去机场，从火车站到机场，走多长时间？发车间隔？上午11：00-12：00之间的发车时间？谢谢。', '6', '2015-12-18 15:24:34');
INSERT INTO `message` VALUES ('19', '投诉举报813路公交车安检员，素质低，态度恶劣，与孕妇吵架，希望核查', '6', '2015-11-05 15:24:42');
INSERT INTO `message` VALUES ('20', '今天早上坐的公交车813路，车牌号为晋A93913，司机都不考虑乘客的安全，把我的脚就给夹住了，太不负责人了', '6', '2015-06-26 15:24:49');
INSERT INTO `message` VALUES ('21', '尊敬的领导，能否考虑在南中环东口大院、山大南门附近装些锁桩，方便这一带居民的出行。', '6', '2016-04-15 15:24:55');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '2016-03-01 15:07:59', '为方便38路乘客去往检测中心，3月15日起，平日早晚高峰设立38路区间车，由龙泉小学-检测中心（龙泉小学7：00-8：30，16：00-17：30检测中心7：10-8：40，16：10-17：40），平峰不变，坐车方式不变');
INSERT INTO `notice` VALUES ('2', '2016-03-02 15:08:07', '从大连市交通局轨道交通管理处获悉，近日，地铁1号线会展中心车站通过了辽宁省交通厅组织的专家评审，具备了试运营基本条件。');
INSERT INTO `notice` VALUES ('3', '2016-03-03 15:08:35', '为方便居民出行，1月5日起49路往复行走向由星雨街、星海广场内环、滨海西路调整为星雨街、星海广场外环、中山路、会展路、星河街、太原街、滨海西路。');
INSERT INTO `notice` VALUES ('4', '2016-03-04 15:08:46', '12月31日起备受社会各界关注的金州-大连 公交化线路将正式开通。');
INSERT INTO `notice` VALUES ('5', '2016-03-05 15:09:02', '为方便七贤路、七贤东路周边居民出行，按照市交通局工作部署，公交集团于2015年12月11日起开通以未名山为始终点站的社区巴士802路公交线路。');
INSERT INTO `notice` VALUES ('6', '2016-03-06 15:09:19', '为了缓解早高峰换乘客流压力，大连地铁运营有限公司已将每天早高峰2号线的车隔，从原先的10分钟缩短至7分半。');
INSERT INTO `notice` VALUES ('7', '2016-03-07 15:09:38', ' 为了缓解早高峰换乘客流压力，大连地铁运营有限公司已将每天早高峰2号线的车隔，从原先的10分钟缩短至7分半。');
INSERT INTO `notice` VALUES ('8', '2016-03-08 15:09:56', '丹大快铁开通运营在即，为保障广大市民方便乘坐快铁，庄河将同时开通东、西两条临时线路直通庄河北站。');
INSERT INTO `notice` VALUES ('9', '2016-03-09 15:10:21', '11月1日起为方便居民乘车，公交集团将520路小公汽线路更名为49路大公交线路。更名后，49路享受大公交各项优惠政策。');
INSERT INTO `notice` VALUES ('10', '2016-03-10 15:10:29', '0月29日起因彩云路变更通行秩序，公交集团对途径公交线路站点进行调整。');
INSERT INTO `notice` VALUES ('11', '2016-03-11 15:10:34', '为方便居民出行，9月1日起公交集团开通520路小公汽线路。线路由孙家沟开往森林动物园南门。');
INSERT INTO `notice` VALUES ('12', '2016-03-12 15:10:38', '8月28日起旅顺口区新辟的30路、31路、32路、33路等4条公交线路正式运营，同时，首批20台新能源公交车也在这四条线路上正式使用。');
INSERT INTO `notice` VALUES ('13', '2016-03-13 15:10:42', '快轨202路延伸线自试运营以来一直备受市民关注，为更好地满足广大市民的出行需求，大连地铁运营公司根据市交通局指示，自2015年10月1日起，202路延伸线延长运营时间，增加运营车次，缩短运行间隔。');
INSERT INTO `notice` VALUES ('14', '2016-03-14 15:10:46', ' 7月1日零时起，我市34条路街改为单行。为此我集团公司陆续对相关线路做出调整，确保线路正常运营。');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `busId` int(32) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `price` double(32,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1', '2015-10-13', '505.00');
INSERT INTO `record` VALUES ('2', '1', '2015-07-28', '512.22');
INSERT INTO `record` VALUES ('3', '1', '2016-02-16', '394.78');
INSERT INTO `record` VALUES ('4', '1', '2016-04-20', '296.66');
INSERT INTO `record` VALUES ('5', '1', '2016-07-28', '789.00');
INSERT INTO `record` VALUES ('6', '2', '2016-03-17', '654.00');
INSERT INTO `record` VALUES ('7', '2', '2016-10-12', '123.32');
INSERT INTO `record` VALUES ('8', '2', '2013-06-11', '218.66');
INSERT INTO `record` VALUES ('9', '2', '2015-07-16', '125.66');
INSERT INTO `record` VALUES ('10', '2', '2014-07-17', '814.00');
INSERT INTO `record` VALUES ('11', '3', '2016-12-17', '926.00');
INSERT INTO `record` VALUES ('12', '3', '2016-05-16', '456.00');
INSERT INTO `record` VALUES ('13', '3', '2016-03-13', '658.00');
INSERT INTO `record` VALUES ('14', '3', '2016-02-22', '896.99');
INSERT INTO `record` VALUES ('15', '3', '2016-04-15', '965.50');
INSERT INTO `record` VALUES ('16', '4', '2016-05-27', '1005.50');
INSERT INTO `record` VALUES ('17', '4', '2015-06-16', '1100.00');
INSERT INTO `record` VALUES ('18', '4', '2016-08-18', '369.00');
INSERT INTO `record` VALUES ('19', '5', '2016-03-13', '278.00');
INSERT INTO `record` VALUES ('20', '5', '2016-06-22', '956.00');
INSERT INTO `record` VALUES ('21', '5', '2013-11-29', '659.00');
INSERT INTO `record` VALUES ('22', '6', '2012-08-17', '456.00');
INSERT INTO `record` VALUES ('23', '6', '2016-02-25', '759.60');
INSERT INTO `record` VALUES ('24', '6', '2016-05-26', '823.60');
INSERT INTO `record` VALUES ('25', '7', '2016-03-02', '458.88');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `loginId` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `cardNo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'songjiang', '123456', '宋江', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('2', 'lujunyi', '123456', '卢俊义', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('3', 'wuyong', '123456', '吴用', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('4', 'gongsunsheng', '123456', '公孙胜', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('5', 'guansheng', '123456', '关胜', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('6', 'linchong', '123456', '林冲', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('7', 'qinming', '123456', '秦明', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('8', 'huyanzhuo', '123456', '呼延灼', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('9', 'huarong', '123456', '花容', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('10', 'liying', '123456', '李英', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('11', 'luzhishen', '123456', '鲁智深', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('12', 'wusong', '123456', '武松', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('13', 'dongping', '123456', '董平', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('14', 'zhangqing', '123456', '张清', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('15', 'yangzhi', '123456', '杨志', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('16', 'xuning', '123456', '徐宁', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('17', 'suochao', '123456', '索超', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('18', 'daizong', '123456', '戴宗', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('19', 'liutang', '123456', '刘唐', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('20', 'likui', '123456', '李逵', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('21', 'shijin', '123456', '史进', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('22', 'lijun', '123456', '李俊', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('23', 'ruanxiaoer', '123456', '阮小二', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('24', 'zhangheng', '123456', '张衡', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('25', 'yangxiong', '123456', '杨雄', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('26', 'shixiu', '123456', '石秀', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('27', 'yanqing', '123456', '燕青', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('28', 'sunli', '123456', '孙立', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('29', 'yanglin', '123456', '杨林', '18618618612', '210211191111111234');
INSERT INTO `user` VALUES ('30', 'wangying', '123456', '王英', '18618618612', '210211191111111234');
