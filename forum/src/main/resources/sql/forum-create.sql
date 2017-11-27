/*
Navicat MySQL Data Transfer

Source Server         : Marine
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : forum

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-17 18:04:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `forum_checkin`
-- ----------------------------
DROP TABLE IF EXISTS `forum_checkin`;
CREATE TABLE `forum_checkin` (
  `checkin_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `user_id` bigint(20) unsigned NOT NULL COMMENT '签到人',
  `checkin_date` date NOT NULL COMMENT '签到日期（年-月-日）',
  `series_times` int(11) DEFAULT NULL COMMENT '连续签到次数',
  `checkin_integration` int(11) DEFAULT NULL COMMENT '此次签到所得积分',
  PRIMARY KEY (`checkin_id`),
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `checkin_date` (`checkin_date`) USING BTREE,
  CONSTRAINT `forum_checkin_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `forum_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_checkin
-- ----------------------------
INSERT INTO `forum_checkin` VALUES ('1', '2017-11-13 12:45:02', null, '1', '2017-11-13', '1', '1');
INSERT INTO `forum_checkin` VALUES ('27', '2017-11-15 07:43:38', null, '2', '2017-11-15', '1', '1');
INSERT INTO `forum_checkin` VALUES ('28', '2017-11-15 07:43:54', null, '1', '2017-11-15', '1', '1');
INSERT INTO `forum_checkin` VALUES ('29', '2017-11-16 02:47:55', null, '1', '2017-11-16', '2', '2');
INSERT INTO `forum_checkin` VALUES ('30', '2017-11-16 15:57:34', null, '3', '2017-11-16', '1', '1');
INSERT INTO `forum_checkin` VALUES ('31', '2017-11-16 16:29:58', null, '2', '2017-11-16', '2', '2');
INSERT INTO `forum_checkin` VALUES ('32', '2017-11-17 08:49:20', null, '9', '2017-11-17', '1', '1');
INSERT INTO `forum_checkin` VALUES ('33', '2017-11-17 09:13:55', null, '1', '2017-11-17', '3', '2');
INSERT INTO `forum_checkin` VALUES ('34', '2017-11-17 09:21:25', null, '5', '2017-11-17', '1', '1');
INSERT INTO `forum_checkin` VALUES ('35', '2017-11-17 09:59:22', null, '6', '2017-11-17', '1', '1');
INSERT INTO `forum_checkin` VALUES ('36', '2017-11-17 11:17:41', null, '3', '2017-11-17', '2', '2');
INSERT INTO `forum_checkin` VALUES ('37', '2017-11-17 13:32:49', null, '10', '2017-11-17', '1', '1');
INSERT INTO `forum_checkin` VALUES ('38', '2017-11-17 14:23:46', null, '12', '2017-11-17', '1', '1');
INSERT INTO `forum_checkin` VALUES ('39', '2017-11-17 14:24:56', null, '11', '2017-11-17', '1', '1');

-- ----------------------------
-- Table structure for `forum_comment`
-- ----------------------------
DROP TABLE IF EXISTS `forum_comment`;
CREATE TABLE `forum_comment` (
  `comment_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '跟帖主键',
  `comment_post_id` bigint(20) unsigned NOT NULL COMMENT '跟帖的主题帖ID',
  `comment_user_id` bigint(20) unsigned NOT NULL COMMENT '评论人ID',
  `comment_ip` varchar(100) DEFAULT NULL COMMENT '评论人当前IP',
  `comment_date` datetime NOT NULL COMMENT '评论时间',
  `comment_date_gmt` datetime NOT NULL COMMENT '评论时间GMT',
  `comment_content` text NOT NULL COMMENT '跟帖正文',
  `comment_approved` varchar(20) NOT NULL DEFAULT '1' COMMENT '跟帖是否被批准',
  `comment_agent` varchar(255) DEFAULT NULL COMMENT '评论者的USER AGENT',
  `comment_parent` bigint(20) unsigned DEFAULT NULL COMMENT '父评论ID',
  PRIMARY KEY (`comment_id`),
  KEY `comment_post_id` (`comment_post_id`) USING BTREE,
  KEY `comment_user_id` (`comment_user_id`) USING BTREE,
  KEY `comment_parent` (`comment_parent`) USING BTREE,
  CONSTRAINT `forum_comment_ibfk_1` FOREIGN KEY (`comment_post_id`) REFERENCES `forum_post` (`post_id`) ON UPDATE CASCADE,
  CONSTRAINT `forum_comment_ibfk_2` FOREIGN KEY (`comment_user_id`) REFERENCES `forum_user` (`user_id`) ON UPDATE CASCADE,
  CONSTRAINT `forum_comment_ibfk_3` FOREIGN KEY (`comment_parent`) REFERENCES `forum_comment` (`comment_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_comment
-- ----------------------------
INSERT INTO `forum_comment` VALUES ('1', '1', '1', null, '2017-11-13 00:00:00', '2017-11-13 20:01:12', '好顶赞！沙发！', '1', null, null);
INSERT INTO `forum_comment` VALUES ('2', '1', '2', null, '2017-11-13 00:00:00', '2017-11-13 20:02:06', '厉害了我的哥', '1', null, null);
INSERT INTO `forum_comment` VALUES ('3', '1', '1', null, '2017-11-13 00:00:00', '2017-11-13 20:02:31', '继续好评！', '1', null, null);
INSERT INTO `forum_comment` VALUES ('4', '2', '1', null, '2017-11-13 00:00:00', '2017-11-13 20:37:53', '真是太棒了！写的很好！', '1', null, null);
INSERT INTO `forum_comment` VALUES ('5', '1', '1', null, '2017-11-15 07:06:03', '2017-11-15 07:06:03', '支持支持！！！', '1', null, null);
INSERT INTO `forum_comment` VALUES ('6', '4', '1', null, '2017-11-15 07:50:31', '2017-11-15 07:50:31', '〒▽〒', '1', null, null);
INSERT INTO `forum_comment` VALUES ('7', '4', '1', null, '2017-11-15 07:58:10', '2017-11-15 07:58:10', '可疑的', '1', null, null);
INSERT INTO `forum_comment` VALUES ('8', '4', '1', null, '2017-11-15 07:59:50', '2017-11-15 07:59:50', '5555', '1', null, null);
INSERT INTO `forum_comment` VALUES ('9', '4', '1', null, '2017-11-15 08:00:04', '2017-11-15 08:00:04', '5555〒▽〒〒▽〒', '1', null, null);
INSERT INTO `forum_comment` VALUES ('10', '4', '1', null, '2017-11-15 08:00:40', '2017-11-15 08:00:40', '=_=', '1', null, null);
INSERT INTO `forum_comment` VALUES ('11', '4', '1', null, '2017-11-15 08:01:08', '2017-11-15 08:01:08', '⊙0⊙', '1', null, null);
INSERT INTO `forum_comment` VALUES ('12', '3', '1', null, '2017-11-15 08:01:48', '2017-11-15 08:01:48', '自己坐沙发=￣ω￣=', '1', null, null);
INSERT INTO `forum_comment` VALUES ('13', '4', '1', null, '2017-11-15 08:17:53', '2017-11-15 08:17:53', '接近', '1', null, null);
INSERT INTO `forum_comment` VALUES ('14', '4', '1', null, '2017-11-15 08:17:55', '2017-11-15 08:17:55', '6', '1', null, null);
INSERT INTO `forum_comment` VALUES ('15', '4', '1', null, '2017-11-15 08:17:56', '2017-11-15 08:17:56', '7', '1', null, null);
INSERT INTO `forum_comment` VALUES ('16', '4', '1', null, '2017-11-15 08:17:57', '2017-11-15 08:17:57', '9', '1', null, null);
INSERT INTO `forum_comment` VALUES ('17', '4', '1', null, '2017-11-15 08:17:58', '2017-11-15 08:17:58', '-', '1', null, null);
INSERT INTO `forum_comment` VALUES ('18', '4', '1', null, '2017-11-15 08:18:01', '2017-11-15 08:18:01', '绝密飞行', '1', null, null);
INSERT INTO `forum_comment` VALUES ('19', '4', '1', null, '2017-11-15 08:18:04', '2017-11-15 08:18:04', '附件麻烦很久没', '1', null, null);
INSERT INTO `forum_comment` VALUES ('20', '4', '1', null, '2017-11-15 08:18:06', '2017-11-15 08:18:06', '几乎没干嘛', '1', null, null);
INSERT INTO `forum_comment` VALUES ('21', '4', '1', null, '2017-11-15 08:18:09', '2017-11-15 08:18:09', '54我用5有', '1', null, null);
INSERT INTO `forum_comment` VALUES ('22', '4', '1', null, '2017-11-15 08:18:11', '2017-11-15 08:18:11', '6有恶意', '1', null, null);
INSERT INTO `forum_comment` VALUES ('23', '4', '1', null, '2017-11-15 08:18:14', '2017-11-15 08:18:14', '鹤骨鸡肤给你', '1', null, null);
INSERT INTO `forum_comment` VALUES ('24', '4', '1', null, '2017-11-15 08:18:17', '2017-11-15 08:18:17', '回复南方姑娘', '1', null, null);
INSERT INTO `forum_comment` VALUES ('25', '4', '1', null, '2017-11-15 08:18:21', '2017-11-15 08:18:21', '54又态度特别好', '1', null, null);
INSERT INTO `forum_comment` VALUES ('26', '4', '1', null, '2017-11-15 08:18:23', '2017-11-15 08:18:23', '656', '1', null, null);
INSERT INTO `forum_comment` VALUES ('27', '4', '1', null, '2017-11-15 08:18:26', '2017-11-15 08:18:26', '结构化', '1', null, null);
INSERT INTO `forum_comment` VALUES ('28', '4', '1', null, '2017-11-15 08:18:31', '2017-11-15 08:18:31', '加工费发给你', '1', null, null);
INSERT INTO `forum_comment` VALUES ('29', '4', '1', null, '2017-11-15 08:18:33', '2017-11-15 08:18:33', '就', '1', null, null);
INSERT INTO `forum_comment` VALUES ('30', '4', '1', null, '2017-11-15 08:18:35', '2017-11-15 08:18:35', '5', '1', null, null);
INSERT INTO `forum_comment` VALUES ('31', '4', '1', null, '2017-11-15 08:18:36', '2017-11-15 08:18:36', '5', '1', null, null);
INSERT INTO `forum_comment` VALUES ('32', '4', '1', null, '2017-11-15 08:18:37', '2017-11-15 08:18:37', '6', '1', null, null);
INSERT INTO `forum_comment` VALUES ('33', '4', '1', null, '2017-11-15 08:18:38', '2017-11-15 08:18:38', '7', '1', null, null);
INSERT INTO `forum_comment` VALUES ('34', '4', '1', null, '2017-11-15 08:18:39', '2017-11-15 08:18:39', '4', '1', null, null);
INSERT INTO `forum_comment` VALUES ('35', '4', '1', null, '2017-11-15 08:18:40', '2017-11-15 08:18:40', '7', '1', null, null);
INSERT INTO `forum_comment` VALUES ('36', '4', '1', null, '2017-11-15 08:18:41', '2017-11-15 08:18:41', '9', '1', null, null);
INSERT INTO `forum_comment` VALUES ('37', '4', '1', null, '2017-11-15 08:18:42', '2017-11-15 08:18:42', '2', '1', null, null);
INSERT INTO `forum_comment` VALUES ('38', '4', '1', null, '2017-11-15 08:18:45', '2017-11-15 08:18:45', '555', '1', null, null);
INSERT INTO `forum_comment` VALUES ('39', '4', '1', null, '2017-11-15 08:18:49', '2017-11-15 08:18:49', '546456', '1', null, null);
INSERT INTO `forum_comment` VALUES ('40', '5', '1', null, '2017-11-15 08:39:36', '2017-11-15 08:39:36', 'gdfgfd', '1', null, null);
INSERT INTO `forum_comment` VALUES ('41', '4', '1', null, '2017-11-15 08:42:38', '2017-11-15 08:42:38', 'ˋωˊ', '1', null, null);
INSERT INTO `forum_comment` VALUES ('42', '6', '1', null, '2017-11-16 01:17:51', '2017-11-16 01:17:51', '66666', '1', null, null);
INSERT INTO `forum_comment` VALUES ('43', '6', '1', null, '2017-11-16 01:17:56', '2017-11-16 01:17:56', '〒▽〒', '1', null, null);
INSERT INTO `forum_comment` VALUES ('44', '16', '1', null, '2017-11-16 03:40:36', '2017-11-16 03:40:36', '不错不错', '1', null, null);
INSERT INTO `forum_comment` VALUES ('45', '4', '1', null, '2017-11-16 04:42:05', '2017-11-16 04:42:05', '⊙0⊙', '1', null, null);
INSERT INTO `forum_comment` VALUES ('46', '4', '1', null, '2017-11-16 04:47:25', '2017-11-16 04:47:25', '7', '1', null, null);
INSERT INTO `forum_comment` VALUES ('47', '16', '2', null, '2017-11-16 16:29:15', '2017-11-16 16:29:15', '=￣ω￣=一切为人民服务', '1', null, null);
INSERT INTO `forum_comment` VALUES ('48', '2', '2', null, '2017-11-16 16:33:21', '2017-11-16 16:33:21', 'o(≧v≦)o', '1', null, null);
INSERT INTO `forum_comment` VALUES ('49', '2', '9', null, '2017-11-17 08:49:28', '2017-11-17 08:49:28', 'ˋωˊ', '1', null, null);
INSERT INTO `forum_comment` VALUES ('50', '2', '9', null, '2017-11-17 09:11:54', '2017-11-17 09:11:54', '关注功能： http://192.168.1.168:8080/api/user/follow 参数： { 	\"vid\": \"1\" }', '1', null, null);
INSERT INTO `forum_comment` VALUES ('51', '16', '5', null, '2017-11-17 09:19:57', '2017-11-17 09:19:57', '⊙﹏⊙', '1', null, null);
INSERT INTO `forum_comment` VALUES ('52', '13', '5', null, '2017-11-17 09:49:29', '2017-11-17 09:49:29', '⊙0⊙', '1', null, null);
INSERT INTO `forum_comment` VALUES ('53', '4', '5', null, '2017-11-17 09:49:52', '2017-11-17 09:49:52', '=￣ω￣==￣ω￣=', '1', null, null);
INSERT INTO `forum_comment` VALUES ('54', '4', '5', null, '2017-11-17 09:50:09', '2017-11-17 09:50:09', 'fff', '1', null, null);
INSERT INTO `forum_comment` VALUES ('55', '4', '5', null, '2017-11-17 09:50:10', '2017-11-17 09:50:10', 'ssd', '1', null, null);
INSERT INTO `forum_comment` VALUES ('56', '4', '5', null, '2017-11-17 09:50:11', '2017-11-17 09:50:11', 'dsadsa', '1', null, null);
INSERT INTO `forum_comment` VALUES ('57', '4', '5', null, '2017-11-17 09:50:13', '2017-11-17 09:50:13', 'gfdgd', '1', null, null);
INSERT INTO `forum_comment` VALUES ('58', '4', '5', null, '2017-11-17 09:50:14', '2017-11-17 09:50:14', 'asdad', '1', null, null);
INSERT INTO `forum_comment` VALUES ('59', '4', '5', null, '2017-11-17 09:50:16', '2017-11-17 09:50:16', 'dsfsdf', '1', null, null);
INSERT INTO `forum_comment` VALUES ('60', '21', '3', null, '2017-11-17 10:11:50', '2017-11-17 10:11:50', '我问问', '1', null, null);
INSERT INTO `forum_comment` VALUES ('61', '2', '6', null, '2017-11-17 10:17:23', '2017-11-17 10:17:23', '⊙0⊙', '1', null, null);
INSERT INTO `forum_comment` VALUES ('62', '21', '3', null, '2017-11-17 10:41:38', '2017-11-17 10:41:38', '支持支持！！！', '1', null, null);
INSERT INTO `forum_comment` VALUES ('63', '34', '1', null, '2017-11-17 10:46:00', '2017-11-17 10:46:00', '=_=', '1', null, null);
INSERT INTO `forum_comment` VALUES ('64', '1', '3', null, '2017-11-17 11:22:37', '2017-11-17 11:22:37', '单独的', '1', null, null);
INSERT INTO `forum_comment` VALUES ('65', '5', '3', null, '2017-11-17 12:06:25', '2017-11-17 12:06:25', '单独的', '1', null, null);
INSERT INTO `forum_comment` VALUES ('68', '21', '3', null, '2017-11-17 12:13:14', '2017-11-17 12:13:14', '333', '1', null, null);
INSERT INTO `forum_comment` VALUES ('69', '21', '3', null, '2017-11-17 12:17:56', '2017-11-17 12:17:56', '222', '1', null, null);
INSERT INTO `forum_comment` VALUES ('70', '21', '3', null, '2017-11-17 12:29:45', '2017-11-17 12:29:45', '1233412', '1', null, null);
INSERT INTO `forum_comment` VALUES ('71', '5', '3', null, '2017-11-17 12:45:06', '2017-11-17 12:45:06', 'tseese', '1', null, null);
INSERT INTO `forum_comment` VALUES ('72', '17', '5', null, '2017-11-17 13:00:32', '2017-11-17 13:00:32', '可以的很帅╮(╯▽╰)╭', '1', null, null);
INSERT INTO `forum_comment` VALUES ('73', '3', '5', null, '2017-11-17 13:01:58', '2017-11-17 13:01:58', '看了看', '1', null, null);
INSERT INTO `forum_comment` VALUES ('74', '21', '5', null, '2017-11-17 13:03:37', '2017-11-17 13:03:37', '可以', '1', null, null);
INSERT INTO `forum_comment` VALUES ('75', '33', '1', null, '2017-11-17 13:21:09', '2017-11-17 13:21:09', 'ˋωˊ', '1', null, null);
INSERT INTO `forum_comment` VALUES ('76', '15', '1', null, '2017-11-17 13:36:54', '2017-11-17 13:36:54', '人工置顶', '1', null, null);
INSERT INTO `forum_comment` VALUES ('77', '29', '5', null, '2017-11-17 13:50:54', '2017-11-17 13:50:54', '=￣ω￣=', '1', null, null);
INSERT INTO `forum_comment` VALUES ('78', '31', '1', null, '2017-11-17 13:55:14', '2017-11-17 13:55:14', '哇萨法', '1', null, null);
INSERT INTO `forum_comment` VALUES ('79', '29', '3', null, '2017-11-17 14:37:59', '2017-11-17 14:37:59', '333', '1', null, null);
INSERT INTO `forum_comment` VALUES ('80', '32', '3', null, '2017-11-17 16:02:17', '2017-11-17 16:02:17', 'shafa', '1', null, null);

-- ----------------------------
-- Table structure for `forum_favorite`
-- ----------------------------
DROP TABLE IF EXISTS `forum_favorite`;
CREATE TABLE `forum_favorite` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `post_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `relate_type` varchar(10) NOT NULL DEFAULT 'FAVOR' COMMENT '收藏类型（FAVOR-收藏；LIKE-点赞）',
  PRIMARY KEY (`id`),
  KEY `post_id` (`post_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `relate_type` (`relate_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_favorite
-- ----------------------------
INSERT INTO `forum_favorite` VALUES ('1', '2017-11-16 18:59:01', '1', '1', 'FAVOR');
INSERT INTO `forum_favorite` VALUES ('2', '2017-11-16 19:10:06', '2', '1', 'FAVOR');
INSERT INTO `forum_favorite` VALUES ('3', '2017-11-16 19:10:59', '2', '1', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('4', '2017-11-17 10:21:44', '31', '6', 'FAVOR');
INSERT INTO `forum_favorite` VALUES ('5', '2017-11-17 10:24:42', '1', '3', 'FAVOR');
INSERT INTO `forum_favorite` VALUES ('6', '2017-11-17 10:25:07', '32', '3', 'FAVOR');
INSERT INTO `forum_favorite` VALUES ('7', '2017-11-17 10:26:56', '28', '3', 'FAVOR');
INSERT INTO `forum_favorite` VALUES ('8', '2017-11-17 10:29:55', '1', '6', 'FAVOR');
INSERT INTO `forum_favorite` VALUES ('9', '2017-11-17 10:30:01', '27', '3', 'FAVOR');
INSERT INTO `forum_favorite` VALUES ('10', '2017-11-17 10:53:51', '1', '1', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('11', '2017-11-17 10:55:13', '21', '1', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('12', '2017-11-17 10:56:45', '34', '1', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('13', '2017-11-17 10:57:15', '13', '1', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('14', '2017-11-17 11:01:03', '16', '1', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('15', '2017-11-17 11:01:21', '27', '1', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('16', '2017-11-17 11:01:33', '26', '1', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('17', '2017-11-17 11:01:36', '25', '1', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('18', '2017-11-17 11:01:38', '28', '1', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('19', '2017-11-17 12:23:56', '1', '3', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('20', '2017-11-17 12:30:03', '21', '3', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('23', '2017-11-17 13:04:53', '3', '5', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('24', '2017-11-17 13:06:10', '32', '1', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('25', '2017-11-17 13:07:44', '2', '5', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('26', '2017-11-17 13:08:46', '1', '5', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('27', '2017-11-17 13:36:59', '15', '1', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('28', '2017-11-17 13:37:39', '1', '10', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('30', '2017-11-17 14:25:54', '35', '5', 'LIKE');
INSERT INTO `forum_favorite` VALUES ('31', '2017-11-17 15:32:30', '39', '3', 'LIKE');

-- ----------------------------
-- Table structure for `forum_history`
-- ----------------------------
DROP TABLE IF EXISTS `forum_history`;
CREATE TABLE `forum_history` (
  `history_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `post_id` bigint(20) NOT NULL COMMENT '文章id',
  `history_date` datetime NOT NULL COMMENT '浏览日期',
  PRIMARY KEY (`history_id`)
) ENGINE=InnoDB AUTO_INCREMENT=216 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_history
-- ----------------------------
INSERT INTO `forum_history` VALUES ('39', '1', '1', '2017-11-16 05:52:41');
INSERT INTO `forum_history` VALUES ('40', '1', '2', '2017-11-16 05:54:17');
INSERT INTO `forum_history` VALUES ('41', '1', '4', '2017-11-16 05:59:07');
INSERT INTO `forum_history` VALUES ('42', '1', '1', '2017-11-16 06:03:23');
INSERT INTO `forum_history` VALUES ('43', '1', '1', '2017-11-16 06:05:15');
INSERT INTO `forum_history` VALUES ('44', '1', '1', '2017-11-16 14:20:00');
INSERT INTO `forum_history` VALUES ('45', '1', '2', '2017-11-16 14:20:17');
INSERT INTO `forum_history` VALUES ('46', '1', '1', '2017-11-16 15:39:50');
INSERT INTO `forum_history` VALUES ('47', '1', '17', '2017-11-16 15:56:48');
INSERT INTO `forum_history` VALUES ('48', '3', '1', '2017-11-16 15:57:28');
INSERT INTO `forum_history` VALUES ('49', '4', '2', '2017-11-16 16:14:35');
INSERT INTO `forum_history` VALUES ('50', '1', '4', '2017-11-16 16:15:59');
INSERT INTO `forum_history` VALUES ('51', '1', '1', '2017-11-16 16:16:04');
INSERT INTO `forum_history` VALUES ('52', '1', '17', '2017-11-16 16:16:07');
INSERT INTO `forum_history` VALUES ('53', '1', '4', '2017-11-16 16:16:20');
INSERT INTO `forum_history` VALUES ('54', '1', '17', '2017-11-16 16:21:19');
INSERT INTO `forum_history` VALUES ('55', '1', '4', '2017-11-16 16:25:50');
INSERT INTO `forum_history` VALUES ('56', '2', '16', '2017-11-16 16:28:45');
INSERT INTO `forum_history` VALUES ('57', '2', '16', '2017-11-16 16:29:50');
INSERT INTO `forum_history` VALUES ('58', '2', '1', '2017-11-16 16:31:13');
INSERT INTO `forum_history` VALUES ('59', '2', '17', '2017-11-16 16:31:18');
INSERT INTO `forum_history` VALUES ('60', '2', '17', '2017-11-16 16:32:16');
INSERT INTO `forum_history` VALUES ('61', '2', '2', '2017-11-16 16:33:15');
INSERT INTO `forum_history` VALUES ('62', '2', '4', '2017-11-16 16:33:36');
INSERT INTO `forum_history` VALUES ('63', '1', '1', '2017-11-16 16:39:11');
INSERT INTO `forum_history` VALUES ('64', '1', '4', '2017-11-16 16:40:07');
INSERT INTO `forum_history` VALUES ('65', '1', '16', '2017-11-16 16:41:55');
INSERT INTO `forum_history` VALUES ('66', '1', '1', '2017-11-16 16:42:08');
INSERT INTO `forum_history` VALUES ('67', '1', '15', '2017-11-16 16:42:19');
INSERT INTO `forum_history` VALUES ('68', '1', '13', '2017-11-16 16:42:28');
INSERT INTO `forum_history` VALUES ('69', '1', '4', '2017-11-16 16:42:46');
INSERT INTO `forum_history` VALUES ('70', '1', '18', '2017-11-16 16:43:18');
INSERT INTO `forum_history` VALUES ('71', '1', '19', '2017-11-16 16:44:51');
INSERT INTO `forum_history` VALUES ('72', '1', '20', '2017-11-16 16:46:46');
INSERT INTO `forum_history` VALUES ('73', '1', '17', '2017-11-16 16:47:51');
INSERT INTO `forum_history` VALUES ('74', '1', '1', '2017-11-16 16:49:01');
INSERT INTO `forum_history` VALUES ('75', '3', '4', '2017-11-17 08:47:20');
INSERT INTO `forum_history` VALUES ('76', '9', '2', '2017-11-17 08:49:23');
INSERT INTO `forum_history` VALUES ('77', '9', '4', '2017-11-17 09:04:05');
INSERT INTO `forum_history` VALUES ('78', '9', '2', '2017-11-17 09:08:46');
INSERT INTO `forum_history` VALUES ('79', '9', '13', '2017-11-17 09:09:48');
INSERT INTO `forum_history` VALUES ('80', '9', '2', '2017-11-17 09:11:32');
INSERT INTO `forum_history` VALUES ('81', '9', '2', '2017-11-17 09:12:04');
INSERT INTO `forum_history` VALUES ('82', '9', '4', '2017-11-17 09:12:22');
INSERT INTO `forum_history` VALUES ('83', '9', '2', '2017-11-17 09:12:29');
INSERT INTO `forum_history` VALUES ('84', '1', '1', '2017-11-17 09:13:21');
INSERT INTO `forum_history` VALUES ('85', '1', '15', '2017-11-17 09:13:28');
INSERT INTO `forum_history` VALUES ('86', '9', '2', '2017-11-17 09:14:12');
INSERT INTO `forum_history` VALUES ('87', '9', '4', '2017-11-17 09:14:14');
INSERT INTO `forum_history` VALUES ('88', '9', '13', '2017-11-17 09:14:16');
INSERT INTO `forum_history` VALUES ('89', '9', '13', '2017-11-17 09:14:18');
INSERT INTO `forum_history` VALUES ('90', '9', '13', '2017-11-17 09:14:31');
INSERT INTO `forum_history` VALUES ('91', '5', '16', '2017-11-17 09:19:51');
INSERT INTO `forum_history` VALUES ('92', '5', '2', '2017-11-17 09:20:36');
INSERT INTO `forum_history` VALUES ('93', '3', '2', '2017-11-17 09:20:39');
INSERT INTO `forum_history` VALUES ('94', '5', '26', '2017-11-17 09:22:12');
INSERT INTO `forum_history` VALUES ('95', '5', '27', '2017-11-17 09:22:32');
INSERT INTO `forum_history` VALUES ('96', '5', '26', '2017-11-17 09:24:22');
INSERT INTO `forum_history` VALUES ('97', '5', '27', '2017-11-17 09:24:25');
INSERT INTO `forum_history` VALUES ('98', '5', '28', '2017-11-17 09:24:43');
INSERT INTO `forum_history` VALUES ('99', '5', '2', '2017-11-17 09:41:04');
INSERT INTO `forum_history` VALUES ('100', '5', '2', '2017-11-17 09:41:46');
INSERT INTO `forum_history` VALUES ('101', '5', '3', '2017-11-17 09:47:26');
INSERT INTO `forum_history` VALUES ('102', '5', '29', '2017-11-17 09:47:48');
INSERT INTO `forum_history` VALUES ('103', '5', '13', '2017-11-17 09:49:22');
INSERT INTO `forum_history` VALUES ('104', '5', '4', '2017-11-17 09:49:49');
INSERT INTO `forum_history` VALUES ('105', '5', '4', '2017-11-17 09:50:01');
INSERT INTO `forum_history` VALUES ('106', '5', '4', '2017-11-17 09:50:30');
INSERT INTO `forum_history` VALUES ('107', '5', '4', '2017-11-17 09:50:50');
INSERT INTO `forum_history` VALUES ('108', '5', '4', '2017-11-17 09:50:54');
INSERT INTO `forum_history` VALUES ('109', '5', '4', '2017-11-17 09:51:05');
INSERT INTO `forum_history` VALUES ('110', '6', '2', '2017-11-17 09:58:26');
INSERT INTO `forum_history` VALUES ('111', '6', '2', '2017-11-17 09:59:04');
INSERT INTO `forum_history` VALUES ('112', '6', '2', '2017-11-17 09:59:11');
INSERT INTO `forum_history` VALUES ('113', '6', '2', '2017-11-17 09:59:12');
INSERT INTO `forum_history` VALUES ('114', '3', '1', '2017-11-17 10:11:40');
INSERT INTO `forum_history` VALUES ('115', '3', '21', '2017-11-17 10:11:46');
INSERT INTO `forum_history` VALUES ('116', '6', '1', '2017-11-17 10:16:37');
INSERT INTO `forum_history` VALUES ('117', '6', '2', '2017-11-17 10:16:41');
INSERT INTO `forum_history` VALUES ('118', '6', '1', '2017-11-17 10:16:43');
INSERT INTO `forum_history` VALUES ('119', '6', '2', '2017-11-17 10:17:19');
INSERT INTO `forum_history` VALUES ('120', '6', '1', '2017-11-17 10:17:32');
INSERT INTO `forum_history` VALUES ('121', '6', '1', '2017-11-17 10:17:34');
INSERT INTO `forum_history` VALUES ('122', '6', '2', '2017-11-17 10:17:44');
INSERT INTO `forum_history` VALUES ('123', '6', '1', '2017-11-17 10:18:32');
INSERT INTO `forum_history` VALUES ('124', '6', '2', '2017-11-17 10:18:36');
INSERT INTO `forum_history` VALUES ('125', '6', '2', '2017-11-17 10:19:23');
INSERT INTO `forum_history` VALUES ('126', '6', '2', '2017-11-17 10:19:26');
INSERT INTO `forum_history` VALUES ('127', '6', '2', '2017-11-17 10:19:30');
INSERT INTO `forum_history` VALUES ('128', '6', '2', '2017-11-17 10:21:06');
INSERT INTO `forum_history` VALUES ('129', '6', '2', '2017-11-17 10:21:18');
INSERT INTO `forum_history` VALUES ('130', '6', '2', '2017-11-17 10:21:35');
INSERT INTO `forum_history` VALUES ('131', '6', '2', '2017-11-17 10:21:37');
INSERT INTO `forum_history` VALUES ('132', '6', '31', '2017-11-17 10:21:42');
INSERT INTO `forum_history` VALUES ('133', '3', '1', '2017-11-17 10:22:53');
INSERT INTO `forum_history` VALUES ('134', '3', '1', '2017-11-17 10:22:55');
INSERT INTO `forum_history` VALUES ('135', '3', '1', '2017-11-17 10:24:40');
INSERT INTO `forum_history` VALUES ('136', '3', '32', '2017-11-17 10:25:06');
INSERT INTO `forum_history` VALUES ('137', '3', '28', '2017-11-17 10:26:54');
INSERT INTO `forum_history` VALUES ('138', '6', '1', '2017-11-17 10:29:54');
INSERT INTO `forum_history` VALUES ('139', '3', '27', '2017-11-17 10:29:59');
INSERT INTO `forum_history` VALUES ('140', '6', '1', '2017-11-17 10:30:01');
INSERT INTO `forum_history` VALUES ('141', '6', '31', '2017-11-17 10:30:11');
INSERT INTO `forum_history` VALUES ('142', '1', '21', '2017-11-17 10:43:11');
INSERT INTO `forum_history` VALUES ('143', '1', '33', '2017-11-17 10:43:17');
INSERT INTO `forum_history` VALUES ('144', '1', '15', '2017-11-17 10:43:47');
INSERT INTO `forum_history` VALUES ('145', '1', '20', '2017-11-17 10:45:32');
INSERT INTO `forum_history` VALUES ('146', '1', '1', '2017-11-17 10:45:39');
INSERT INTO `forum_history` VALUES ('147', '1', '34', '2017-11-17 10:45:57');
INSERT INTO `forum_history` VALUES ('148', '1', '16', '2017-11-17 10:47:01');
INSERT INTO `forum_history` VALUES ('149', '1', '28', '2017-11-17 10:47:22');
INSERT INTO `forum_history` VALUES ('150', '1', '1', '2017-11-17 10:48:01');
INSERT INTO `forum_history` VALUES ('151', '1', '27', '2017-11-17 11:01:27');
INSERT INTO `forum_history` VALUES ('152', '3', '1', '2017-11-17 11:17:43');
INSERT INTO `forum_history` VALUES ('153', '3', '1', '2017-11-17 11:21:26');
INSERT INTO `forum_history` VALUES ('154', '3', '5', '2017-11-17 12:06:22');
INSERT INTO `forum_history` VALUES ('155', '3', '21', '2017-11-17 12:09:17');
INSERT INTO `forum_history` VALUES ('156', '3', '21', '2017-11-17 12:17:07');
INSERT INTO `forum_history` VALUES ('157', '3', '21', '2017-11-17 12:17:53');
INSERT INTO `forum_history` VALUES ('158', '3', '21', '2017-11-17 12:20:26');
INSERT INTO `forum_history` VALUES ('159', '3', '21', '2017-11-17 12:29:41');
INSERT INTO `forum_history` VALUES ('160', '3', '5', '2017-11-17 12:45:03');
INSERT INTO `forum_history` VALUES ('161', '5', '31', '2017-11-17 13:00:08');
INSERT INTO `forum_history` VALUES ('162', '5', '17', '2017-11-17 13:00:23');
INSERT INTO `forum_history` VALUES ('163', '5', '17', '2017-11-17 13:00:43');
INSERT INTO `forum_history` VALUES ('164', '5', '29', '2017-11-17 13:00:58');
INSERT INTO `forum_history` VALUES ('165', '5', '3', '2017-11-17 13:01:50');
INSERT INTO `forum_history` VALUES ('166', '5', '1', '2017-11-17 13:02:25');
INSERT INTO `forum_history` VALUES ('167', '5', '1', '2017-11-17 13:02:29');
INSERT INTO `forum_history` VALUES ('168', '5', '21', '2017-11-17 13:02:38');
INSERT INTO `forum_history` VALUES ('169', '5', '21', '2017-11-17 13:02:48');
INSERT INTO `forum_history` VALUES ('170', '5', '3', '2017-11-17 13:03:03');
INSERT INTO `forum_history` VALUES ('171', '5', '17', '2017-11-17 13:03:06');
INSERT INTO `forum_history` VALUES ('172', '5', '17', '2017-11-17 13:03:09');
INSERT INTO `forum_history` VALUES ('173', '5', '3', '2017-11-17 13:03:13');
INSERT INTO `forum_history` VALUES ('174', '5', '4', '2017-11-17 13:03:17');
INSERT INTO `forum_history` VALUES ('175', '5', '1', '2017-11-17 13:03:22');
INSERT INTO `forum_history` VALUES ('176', '5', '21', '2017-11-17 13:03:26');
INSERT INTO `forum_history` VALUES ('177', '5', '21', '2017-11-17 13:03:48');
INSERT INTO `forum_history` VALUES ('178', '5', '1', '2017-11-17 13:03:53');
INSERT INTO `forum_history` VALUES ('179', '5', '4', '2017-11-17 13:03:57');
INSERT INTO `forum_history` VALUES ('180', '5', '21', '2017-11-17 13:04:35');
INSERT INTO `forum_history` VALUES ('181', '1', '33', '2017-11-17 13:21:04');
INSERT INTO `forum_history` VALUES ('182', '10', '33', '2017-11-17 13:32:28');
INSERT INTO `forum_history` VALUES ('183', '10', '1', '2017-11-17 13:35:00');
INSERT INTO `forum_history` VALUES ('184', '10', '1', '2017-11-17 13:35:05');
INSERT INTO `forum_history` VALUES ('185', '10', '1', '2017-11-17 13:35:12');
INSERT INTO `forum_history` VALUES ('186', '10', '1', '2017-11-17 13:35:18');
INSERT INTO `forum_history` VALUES ('187', '10', '2', '2017-11-17 13:36:30');
INSERT INTO `forum_history` VALUES ('188', '1', '15', '2017-11-17 13:36:50');
INSERT INTO `forum_history` VALUES ('189', '10', '1', '2017-11-17 13:37:01');
INSERT INTO `forum_history` VALUES ('190', '10', '1', '2017-11-17 13:37:47');
INSERT INTO `forum_history` VALUES ('191', '5', '29', '2017-11-17 13:50:47');
INSERT INTO `forum_history` VALUES ('192', '1', '28', '2017-11-17 13:52:40');
INSERT INTO `forum_history` VALUES ('193', '1', '28', '2017-11-17 13:52:46');
INSERT INTO `forum_history` VALUES ('194', '1', '31', '2017-11-17 13:55:07');
INSERT INTO `forum_history` VALUES ('195', '1', '31', '2017-11-17 13:55:51');
INSERT INTO `forum_history` VALUES ('196', '3', '1', '2017-11-17 14:24:51');
INSERT INTO `forum_history` VALUES ('197', '1', '35', '2017-11-17 14:27:52');
INSERT INTO `forum_history` VALUES ('198', '1', '5', '2017-11-17 14:35:11');
INSERT INTO `forum_history` VALUES ('199', '1', '5', '2017-11-17 14:35:19');
INSERT INTO `forum_history` VALUES ('200', '1', '15', '2017-11-17 14:35:28');
INSERT INTO `forum_history` VALUES ('201', '1', '1', '2017-11-17 14:35:42');
INSERT INTO `forum_history` VALUES ('202', '1', '3', '2017-11-17 14:35:48');
INSERT INTO `forum_history` VALUES ('203', '1', '17', '2017-11-17 14:35:53');
INSERT INTO `forum_history` VALUES ('204', '3', '29', '2017-11-17 14:37:57');
INSERT INTO `forum_history` VALUES ('205', '1', '5', '2017-11-17 14:47:06');
INSERT INTO `forum_history` VALUES ('206', '2', '4', '2017-11-17 14:58:18');
INSERT INTO `forum_history` VALUES ('207', '2', '1', '2017-11-17 14:58:28');
INSERT INTO `forum_history` VALUES ('208', '3', '1', '2017-11-17 15:09:23');
INSERT INTO `forum_history` VALUES ('209', '3', '1', '2017-11-17 15:10:59');
INSERT INTO `forum_history` VALUES ('210', '9', '21', '2017-11-17 15:20:09');
INSERT INTO `forum_history` VALUES ('211', '5', '37', '2017-11-17 16:01:29');
INSERT INTO `forum_history` VALUES ('212', '3', '32', '2017-11-17 16:02:11');
INSERT INTO `forum_history` VALUES ('213', '5', '31', '2017-11-17 16:12:11');
INSERT INTO `forum_history` VALUES ('214', '3', '27', '2017-11-17 16:12:50');
INSERT INTO `forum_history` VALUES ('215', '3', '27', '2017-11-17 16:33:18');

-- ----------------------------
-- Table structure for `forum_integration`
-- ----------------------------
DROP TABLE IF EXISTS `forum_integration`;
CREATE TABLE `forum_integration` (
  `integration_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `integration_num` int(11) NOT NULL DEFAULT '0' COMMENT '积分额度',
  `start_checkin_num` int(11) NOT NULL DEFAULT '0' COMMENT '最少连续次数',
  `end_checkin_num` int(11) NOT NULL DEFAULT '0' COMMENT '最多连续签到次数',
  PRIMARY KEY (`integration_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_integration
-- ----------------------------
INSERT INTO `forum_integration` VALUES ('1', '2017-11-15 11:12:20', null, '1', '1', '1');
INSERT INTO `forum_integration` VALUES ('2', '2017-11-15 11:13:55', null, '2', '2', '4');
INSERT INTO `forum_integration` VALUES ('3', '2017-11-15 11:14:50', null, '5', '5', '10');
INSERT INTO `forum_integration` VALUES ('4', '2017-11-15 11:15:24', null, '10', '11', '20');
INSERT INTO `forum_integration` VALUES ('5', '2017-11-15 11:15:42', null, '15', '21', '30');
INSERT INTO `forum_integration` VALUES ('6', '2017-11-15 11:16:03', null, '20', '31', '9999');

-- ----------------------------
-- Table structure for `forum_like_relationship`
-- ----------------------------
DROP TABLE IF EXISTS `forum_like_relationship`;
CREATE TABLE `forum_like_relationship` (
  `like_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) unsigned NOT NULL COMMENT '文章ID',
  PRIMARY KEY (`like_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_like_relationship
-- ----------------------------

-- ----------------------------
-- Table structure for `forum_notice`
-- ----------------------------
DROP TABLE IF EXISTS `forum_notice`;
CREATE TABLE `forum_notice` (
  `notice_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `notice_date` datetime NOT NULL,
  `notice_type` tinyint(2) NOT NULL COMMENT '通知类型（被关注1、被点赞2、被评论3）',
  `user_id` bigint(20) unsigned NOT NULL,
  `follower_id` bigint(20) unsigned DEFAULT NULL COMMENT '粉丝ID',
  `post_id` bigint(20) unsigned DEFAULT NULL COMMENT '文章ID，类型为评论和点赞时可用',
  `comment_id` bigint(20) unsigned DEFAULT NULL COMMENT '评论ID，当类型为评论时可用',
  `favor_id` bigint(20) unsigned DEFAULT NULL COMMENT '收藏ID，当类型为点赞时可用',
  `notice_status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '通知状态（0-未读， 1-已读）',
  PRIMARY KEY (`notice_id`),
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `post_id` (`post_id`) USING BTREE,
  KEY `comment_id` (`comment_id`) USING BTREE,
  KEY `favor_id` (`favor_id`) USING BTREE,
  KEY `follower_id` (`follower_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_notice
-- ----------------------------
INSERT INTO `forum_notice` VALUES ('1', '2017-11-17 10:15:38', '1', '3', '1', null, null, null, '1');
INSERT INTO `forum_notice` VALUES ('3', '2017-11-17 11:21:28', '1', '1', '3', null, null, null, '0');
INSERT INTO `forum_notice` VALUES ('7', '2017-11-17 12:18:09', '3', '3', '3', '21', '69', null, '0');
INSERT INTO `forum_notice` VALUES ('9', '2017-11-17 12:29:45', '3', '3', '3', '21', '70', null, '0');
INSERT INTO `forum_notice` VALUES ('11', '2017-11-17 12:31:25', '2', '1', '3', '5', null, '21', '0');
INSERT INTO `forum_notice` VALUES ('12', '2017-11-17 12:45:06', '3', '1', null, '5', '71', null, '0');
INSERT INTO `forum_notice` VALUES ('13', '2017-11-17 13:00:32', '3', '1', null, '17', '72', null, '0');
INSERT INTO `forum_notice` VALUES ('14', '2017-11-17 13:01:47', '1', '1', '5', null, null, null, '0');
INSERT INTO `forum_notice` VALUES ('15', '2017-11-17 13:01:58', '3', '1', null, '3', '73', null, '0');
INSERT INTO `forum_notice` VALUES ('16', '2017-11-17 13:02:43', '1', '3', '5', null, null, null, '0');
INSERT INTO `forum_notice` VALUES ('17', '2017-11-17 13:03:37', '3', '3', null, '21', '74', null, '0');
INSERT INTO `forum_notice` VALUES ('18', '2017-11-17 13:04:53', '2', '1', null, '3', null, '23', '0');
INSERT INTO `forum_notice` VALUES ('19', '2017-11-17 13:06:10', '2', '5', null, '32', null, '24', '0');
INSERT INTO `forum_notice` VALUES ('20', '2017-11-17 13:07:44', '2', '1', null, '2', null, '25', '0');
INSERT INTO `forum_notice` VALUES ('21', '2017-11-17 13:08:46', '2', '1', null, '1', null, '26', '0');
INSERT INTO `forum_notice` VALUES ('22', '2017-11-17 13:21:09', '3', '5', null, '33', '75', null, '0');
INSERT INTO `forum_notice` VALUES ('23', '2017-11-17 13:35:01', '1', '1', '10', null, null, null, '0');
INSERT INTO `forum_notice` VALUES ('24', '2017-11-17 13:36:54', '3', '1', null, '15', '76', null, '0');
INSERT INTO `forum_notice` VALUES ('25', '2017-11-17 13:36:59', '2', '1', null, '15', null, '27', '0');
INSERT INTO `forum_notice` VALUES ('26', '2017-11-17 13:37:39', '2', '1', null, '1', null, '28', '0');
INSERT INTO `forum_notice` VALUES ('27', '2017-11-17 13:50:54', '3', '5', null, '29', '77', null, '0');
INSERT INTO `forum_notice` VALUES ('28', '2017-11-17 13:55:14', '3', '5', null, '31', '78', null, '0');
INSERT INTO `forum_notice` VALUES ('29', '2017-11-17 14:25:54', '2', '11', null, '35', null, '30', '0');
INSERT INTO `forum_notice` VALUES ('30', '2017-11-17 14:32:19', '1', '10', '1', null, null, null, '0');
INSERT INTO `forum_notice` VALUES ('31', '2017-11-17 14:37:59', '3', '5', null, '29', '79', null, '0');
INSERT INTO `forum_notice` VALUES ('32', '2017-11-17 15:18:49', '1', '3', '9', null, null, null, '0');
INSERT INTO `forum_notice` VALUES ('33', '2017-11-17 15:20:22', '1', '5', '9', null, null, null, '0');
INSERT INTO `forum_notice` VALUES ('34', '2017-11-17 15:32:30', '2', '9', null, '39', null, '31', '0');
INSERT INTO `forum_notice` VALUES ('35', '2017-11-17 16:02:17', '3', '5', null, '32', '80', null, '0');

-- ----------------------------
-- Table structure for `forum_post`
-- ----------------------------
DROP TABLE IF EXISTS `forum_post`;
CREATE TABLE `forum_post` (
  `post_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `post_author_id` bigint(20) unsigned NOT NULL COMMENT '作者ID',
  `post_date` datetime NOT NULL COMMENT '发布时间',
  `post_date_gmt` datetime NOT NULL COMMENT '发布时间GMT',
  `post_content` longtext COMMENT '正文',
  `post_title` text NOT NULL COMMENT '标题',
  `post_name` varchar(200) DEFAULT NULL COMMENT '缩略名',
  `post_excerpt` text COMMENT '摘录',
  `post_status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态（发布、草稿、删除）',
  `post_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `post_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `post_modified_gmt` datetime DEFAULT NULL COMMENT '修改时间GMT',
  `post_mime_type` varchar(100) DEFAULT NULL COMMENT 'MIME',
  `comment_status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '评论状态（可评论/关闭评论）',
  `read_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '阅读数',
  `is_sticky` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否加精',
  `is_official` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否官方',
  `is_top` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否置顶',
  PRIMARY KEY (`post_id`),
  KEY `post_author_id` (`post_author_id`) USING BTREE,
  FULLTEXT KEY `post_title` (`post_title`),
  FULLTEXT KEY `post_content` (`post_content`),
  CONSTRAINT `forum_post_ibfk_1` FOREIGN KEY (`post_author_id`) REFERENCES `forum_user` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_post
-- ----------------------------
INSERT INTO `forum_post` VALUES ('1', '1', '2017-11-13 00:00:00', '2017-11-13 15:09:09', '　　11月8日，由中国南海研究院、日本笹川和平财团海洋政策研究所和武汉大学中国边界与海洋研究院共同举办的“2017中日海洋对话会”在海口召开。\r\n　　中国南海研究院院长吴士存、日本笹川和平财团海洋政策研究所所长角南笃以及中国外交部边界与海洋事务司参赞贺湘琦在开幕式上分别致辞。来自解放军军事科学院、中科院烟台海岸带研究所、上海社科院、南京大学、浙江大学、复旦大学、中国渔业协会，以及日本东京海洋大学、同志社大学、法政大学、上智大学、国立研究开发法人水产研究教育机构等中日两国涉海研究机构、高校和知名智库的专家学者共约50人参加了此次对话会。', '2017中日海洋对话会”在海南省海口市召开', null, '　　中国南海研究院院长吴士存、日本笹川和平财团海洋政策研究所所长角南笃以及中国外交部边界与海洋事务司参赞贺湘琦在开幕式上分别致辞。', '1', null, null, null, null, '1', '82', '1', '1', '1');
INSERT INTO `forum_post` VALUES ('2', '1', '2017-11-13 00:00:00', '2017-11-13 15:12:24', '日前，国家海洋局办公室发布旨在贯彻落实《中共中央 国务院关于开展质量提升行动的指导意见》和国家海洋局《关于加强海洋质量管理的指导意见》的行动计划，全面提升海洋公共服务和综合管理质量。\r\n　　行动计划由国家海洋局组织，于2017年~2020年在海洋公共服务和综合管理中所涉及的数据、资料、信息与服务的有关业务活动（含重大专项和海洋业务工作）中实施。\r\n　　计划明确了海洋质量提升目标。到2020年，在海洋工作单位中健全质量管理机制，完善质量管理体系，提升海洋质量管理能力，强化质量监督，全面实现海洋业务活动全过程质量管理。\r\n　　计划要求健全海洋质量管理机制。海洋工作单位，包括海洋系统各相关单位和开展海洋业务活动的企事业单位，对重大专项任务完成质量、海洋业务工作成果负责，其法定代表人是质量管理工作第一责任人。其中，涉及数据、资料、信息与服务的国家海洋局局属单位在本行动计划中，全面建立健全质量管理的组织机构、质量管理人员队伍和质量管理体系。\r\n　　计划指出，要实施海洋业务活动的全过程质量管理。通过实施质量策划、质量保证、质量控制和质量改进，保证重要工作节点及其成果满足规定和预期要求。2017年~2018年，各海洋工作单位要率先在海洋重大专项中实现全过程质量管理；2019年~2020年，海洋业务工作要达到全过程质量管理的要求。', '国家海洋局实施加强海洋质量管理行动计划', null, '　　计划指出，要实施海洋业务活动的全过程质量管理。通过实施质量策划、质量保证、质量控制和质量改进，保证重要工作节点及其成果满足规定和预期要求。', '1', null, null, null, null, '1', '32', '0', '1', '0');
INSERT INTO `forum_post` VALUES ('3', '1', '2017-11-13 00:00:00', '2017-11-13 15:13:04', '　据日本共同社10月30日报道，日本首相安倍晋三30日晚与访日的菲律宾总统杜特尔特在官邸举行会谈，就合作应对地区课题达成了一致。在会谈后发表的联合声明中，日本政府写入了围绕马尼拉首都圈的地铁项目等，探讨向菲方提供总计约6000亿日元（约合人民币350亿元）的日元贷款。\r\n　　报道还称，考虑到中国南海问题，安倍表示将为提升菲律宾海上警备能力提供合作。日本政府此前就向菲方提供大型巡逻船等达成了共识。为了提升包括菲律宾在内的东南亚各国海上警备能力，安倍称，日本海上保安厅将于11月在马尼拉实施马来西亚和越南等相关负责人员参加的训练。日媒认为，此举旨在制衡海洋活动活跃的中国。\r\n　　不过，台湾《联合报》31日报道称，日方对会谈中针对南海议题达成什么共识，则低调未说明。英国路透社31日报道称，杜特尔特在菲方所发的声明中只字未提中国。\r\n　　此外，在双方的联合声明中，除了基础设施建设外，还写入了鉴于在菲律宾南部棉兰老岛马拉维持续的伊斯兰极端派和政府军的战斗结束，将援助马拉维及周边地区重建的内容。\r\n　　会谈中，安倍表示有意切实实施1月访菲时提出的今后五年实施1万亿日元规模援助一事。声明中写入的用于地铁项目的约6000亿日元是其中一部分。安倍在会谈上表示，近期作为第一批将提供约1000亿日元的日元贷款。', '日菲首脑会谈提海洋合作 安倍不忘中国遭冷脸', null, '　据日本共同社10月30日报道，日本首相安倍晋三30日晚与访日的菲律宾总统杜特尔特在官邸举行会谈，就合作应对地区课题达成了一致。', '1', null, null, null, null, '1', '11', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('4', '2', '2017-11-14 00:00:00', '2017-11-14 15:58:12', '记者从青岛海洋科学与技术国家实验室今天举办的新闻发布会上获悉，11月16日，海洋国家实验室将与美国国家大气研究中心、美国德州农工大学正式签约，三方共建“国际高分辨率地球系统预测实验室”。据介绍，这是我国首次与全球顶尖的地球科学研究机构建立实验室，也是中美两国1990年以来首次开展实质性的海洋科技合作。\r\n\r\n据介绍，美国国家大气研究中心是全球大气与海洋预报最权威的机构研究，论文平均引用量在世界地球科学机构中排名第一；美国德州农工大学是综合大洋钻探计划总部所在地，拥有高性能计算系统、海湾近岸海洋观测系统等先进设备，在高分辨率大气预报研究方面一直居世界领先水平。作为我国首个获批试点运行的国家实验室，海洋国家实验室组建了全球海洋科研领域最快的超算平台――高性能计算与系统仿真平台，在高分辨率全球和区域海洋耦合模式等方面居于世界一流水平。\r\n\r\n三方强强联合后，将在美国、青岛两地同时建设实验室，面向单个国家无法独立解决的、人类共同面临的全球气候变化问题，深入开展高分辨率海洋及地球系统模型开发、模拟和预测，增强对地球系统多尺度相互作用的科学认识。未来五年内，实验室将以工业化革命的1900年为坐标零点，研究其前后500年的时间范围内地球气球在气温、水分、碳浓度等方面的变化，利用高性能计算机做出高尺度分辨率的全球气侯变化模拟，从而更好地理解气候变化和环境演变机理，预测全球气候的未来变化。\r\n\r\n“国际高分辨率地球系统预测实验室”建成后，将成为海洋国家实验室继南半球海洋研究中心之后的第二个国际联合研究中心。11月18日，海洋国家实验室还将与北大、清华、山大、浪潮集团、国家超算济南中心等签约组建“智能超算与大数据联合实验室”，搭建国际一流的超高精度全球海洋系统智能超算与大数据应用的核心技术体系。', '中美首次联合共建海洋科研实验室 16日签约', null, '记者从青岛海洋科学与技术国家实验室今天举办的新闻发布会上获悉，11月16日，海洋国家实验室将与美国国家大气研究中心、美国德州农工大学正式签约，三方共建“国际高分辨率地球系统预测实验室”。', '1', null, null, null, null, '1', '49', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('5', '1', '2017-11-15 16:19:39', '2017-11-15 16:19:39', '这是测试正文内容', '这是一个标题', null, '这是测试正文内容', '1', null, '2017-11-15 08:21:53', '2017-11-15 08:21:53', null, '1', '9', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('6', '1', '2017-11-15 16:30:36', '2017-11-15 16:30:36', '<img src=\"http://zr816.top/upload/2017/11/15/5a0bfb1eeceb8.png\"><div>噜啦啦</div><div><img src=\"http://zr816.top/upload/2017/11/15/5a0bfb2778ce2.jpg\"><br></div>', '哈利路亚', null, null, '3', null, '2017-11-16 02:50:05', '2017-11-16 02:50:05', null, '1', '2', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('10', '1', '2017-11-16 09:44:45', '2017-11-16 09:44:45', '<img src=\"http://zr816.top/upload/2017/11/15/5a0bfb1eeceb8.png\"><div>啊哈防守打法  范德萨发生 范德萨发大水发撒的挖发送到 范德萨发的飞洒发 手动阀房顶上撒阿瓦我 范德萨发大厦是沃尔沃人为地发发生的的 的是发顺丰阿瑟发放阿达feature第三方阿尔法无法反倒是哒风扇3日发售发大水发3阿事实上发说说分发生 份额额饿啊发的发送到三33发的发放哇大大大发发呆   32424发斯蒂芬啊发放个人房交会发卡量的积分hi爱疯阿卡hi放假啊开发哪的上课就发货发四六级   丰盛的机动地那肥牛饭打卡机四分局安副科级的水库及覅额按 撒到奥是否 </div><div><img src=\"http://zr816.top/upload/2017/11/15/5a0bfb2778ce2.jpg\"><br></div>', '这是一个标题', null, '啊哈防守打法  范德萨发生 范德萨发大水发撒的挖发送到 范德萨发的飞洒发 手动阀房顶上撒阿瓦我 范德', '3', null, '2017-11-16 05:48:02', '2017-11-16 05:48:02', null, '1', '7', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('11', '1', '2017-11-16 10:31:32', '2017-11-16 10:31:32', '<img src=\"http://zr816.top/upload/2017/11/15/5a0bfb1eeceb8.png\"><div>啊哈防守打法  范德萨发生 范德萨发大水发撒的挖发送到 范德萨发的飞洒发 手动阀房顶上撒阿瓦我 范德萨发大厦是沃尔沃人为地发发生的的 的是发顺丰阿瑟发放阿达feature第三方阿尔法无法反倒是哒风扇3日发售发大水发3阿事实上发说说分发生 份额额饿啊发的发送到三33发的发放哇大大大发发呆   32424发斯蒂芬啊发放个人房交会发卡量的积分hi爱疯阿卡hi放假啊开发哪的上课就发货发四六级   丰盛的机动地那肥牛饭打卡机四分局安副科级的水库及覅额按 撒到奥是否 </div><div><img src=\"http://zr816.top/upload/2017/11/15/5a0bfb2778ce2.jpg\"><br></div>', '这是一个标题', null, '啊哈防守打法  范德萨发生 范德萨发大水发撒的挖发送到 范德萨发的飞洒发 手动阀房顶上撒阿瓦我 范德', '3', null, '2017-11-16 05:57:58', '2017-11-16 05:57:58', null, '1', '2', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('12', '1', '2017-11-16 10:33:21', '2017-11-16 10:33:21', '的是发顺丰', '这是一个标题', null, '的是发顺丰', '3', null, '2017-11-16 03:40:49', '2017-11-16 03:40:49', null, '1', '1', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('13', '1', '2017-11-16 10:33:26', '2017-11-16 10:33:26', '<h1 data-spm=\"1000983\" style=\"padding-bottom: 0.2em; font-size: 16px; font-family: &quot;microsoft yahei&quot;; line-height: 1; color: rgb(0, 0, 0);\">洗猫袋猫咪洗澡神器宠物剪指甲打针防抓咬固定猫包袋猫咪清洁用品<img src=\"http://zr816.top/upload/2017/11/16/5a0cf8410c74d.jpg\" style=\"color: rgb(51, 51, 51); font-size: 14px; font-family: &quot;Microsoft YaHei&quot;;\"></h1><div>s</div>', '洗猫袋猫咪洗澡神器宠物剪指甲打针防抓咬固定猫包袋猫咪清洁用品', null, '洗猫袋猫咪洗澡神器宠物剪指甲打针防抓咬固定猫包袋猫咪清洁用品s', '1', null, null, null, null, '1', '16', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('14', '1', '2017-11-16 10:34:21', '2017-11-16 10:34:21', 'd', '', null, 'd', '3', null, '2017-11-16 02:39:32', '2017-11-16 02:39:32', null, '1', '1', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('15', '1', '2017-11-16 10:34:29', '2017-11-16 10:34:29', '的是发顺丰的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶发送到发放沙发的的萨芬撒的撒防守打法sad的范德萨啊的飞洒啊的的的的等等的的的等等地地道道的的都', '这是一个测试标题', null, '的是发顺丰的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶发送到发放沙发的的萨芬撒的撒防', '1', null, null, null, null, '1', '8', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('16', '1', '2017-11-16 10:51:00', '2017-11-16 10:51:00', '<img src=\"https://gdp.alicdn.com/imgextra/i3/3296567944/TB2qcKTcDZRMeJjSspnXXcJdFXa_!!3296567944.jpg\"><div></div><div>这是介绍</div>', '喵喵喵', null, '这是介绍', '1', null, null, null, null, '1', '7', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('17', '1', '2017-11-16 11:42:37', '2017-11-16 11:42:37', '<img src=\"http://zr816.top/upload/2017/11/16/5a0d09164ab5f.jpeg\"><div></div><div><br></div><div>这是迈克尔·杰克逊</div>', '测试图片主题', null, '这是迈克尔·杰克逊', '1', null, null, null, null, '1', '16', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('18', '1', '2017-11-16 16:43:13', '2017-11-16 16:43:13', '', '', null, '', '3', null, '2017-11-16 16:44:08', '2017-11-16 16:44:08', null, '1', '1', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('19', '1', '2017-11-16 16:44:46', '2017-11-16 16:44:46', '', '', null, '', '3', null, '2017-11-16 16:45:08', '2017-11-16 16:45:08', null, '1', '1', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('20', '1', '2017-11-16 16:46:44', '2017-11-16 16:46:44', '', '', null, '', '3', null, '2017-11-16 16:46:53', '2017-11-16 16:46:53', null, '1', '2', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('21', '3', '2017-11-16 20:05:09', '2017-11-16 20:05:09', '的是发顺丰的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶发送到发放沙发的的萨芬撒的撒防守打法sad的范德萨啊的飞洒啊的的的的等等的的的等等地地道道的的都', '这是一个测试标题233', null, '的是发顺丰的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶发送到发放沙发的的萨芬撒的撒防', '1', null, null, null, null, '1', '13', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('22', '9', '2017-11-17 08:50:17', '2017-11-17 08:50:17', '3333', '这是一首简单的小情歌', null, '3333', '1', null, null, null, null, '1', '0', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('23', '9', '2017-11-17 09:14:48', '2017-11-17 09:14:48', '333', '333', null, '333', '1', null, null, null, null, '1', '0', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('24', '9', '2017-11-17 09:14:55', '2017-11-17 09:14:55', '444', '444', null, '444', '1', null, null, null, null, '1', '0', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('25', '9', '2017-11-17 09:15:19', '2017-11-17 09:15:19', '<i>嘎嘎嘎巴巴爸爸下表现出发布感谢</i><div></div>', '666', null, '嘎嘎嘎巴巴爸爸下表现出发布感谢', '1', null, null, null, null, '1', '0', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('26', '5', '2017-11-17 09:22:07', '2017-11-17 09:22:07', '<div style=\"text-align: center;\">xxx</div><div></div>', 'zrtobeno1', null, 'xxx', '1', null, null, null, null, '1', '2', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('27', '5', '2017-11-17 09:22:29', '2017-11-17 09:22:29', '<span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><div><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\"><br></span></div><div><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\"><br></span></div><div><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\"><br></span></div>', '家海洋局实施加强海洋质量', null, '家海洋局实施加强海洋质量家海洋局实施加强海洋质量家海洋局实施加强海洋质量家海洋局实施加强海洋质量家海', '1', null, null, null, null, '1', '9', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('28', '5', '2017-11-17 09:24:40', '2017-11-17 09:24:40', '<span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span><span style=\"color: rgb(196, 26, 22); font-family: Consolas, &quot;Lucida Console&quot;, &quot;Courier New&quot;, monospace; font-size: 12px; white-space: pre;\">家海洋局实施加强海洋质量</span>', '家海洋局实施加强海洋质量3', null, '家海洋局实施加强海洋质量家海洋局实施加强海洋质量家海洋局实施加强海洋质量家海洋局实施加强海洋质量家海', '1', null, null, null, null, '1', '11', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('29', '5', '2017-11-17 09:47:42', '2017-11-17 09:47:42', '<span style=\"color: rgb(0, 0, 0); font-family: PingFangSC-Regular, Verdana, Arial, 微软雅黑, 宋体; background-color: rgb(253, 252, 248);\">何的版本的 Internet Explorer （包括 IE8）都不支持属性值 \"inherit\"</span>', '何的版本的 Internet Explorer （包括 IE8）都不支持属性值 \"inherit\"', null, '何的版本的 Internet Explorer （包括 IE8）都不支持属性值 \"inherit\"', '1', null, null, null, null, '1', '4', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('30', '5', '2017-11-17 09:47:58', '2017-11-17 09:47:58', '<span style=\"color: rgb(0, 0, 0); font-family: PingFangSC-Regular, Verdana, Arial, 微软雅黑, 宋体; background-color: rgb(253, 252, 248);\">这个属性声明建立布局过程中如何处理元素中的空白符。</span>', '这个属性声明建立布局过程中如何处理元素中的空白符。', null, '这个属性声明建立布局过程中如何处理元素中的空白符。', '1', null, null, null, null, '1', '0', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('31', '5', '2017-11-17 09:48:08', '2017-11-17 09:48:08', '<span style=\"color: rgb(0, 0, 0); font-family: PingFangSC-Regular, Verdana, Arial, 微软雅黑, 宋体; background-color: rgb(253, 252, 248);\">这个属性声明建立布局过程中如何处理元素中的空白符。ss</span>', '这个属性声明建ss', null, '这个属性声明建立布局过程中如何处理元素中的空白符。ss', '1', null, null, null, null, '1', '6', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('32', '5', '2017-11-17 09:48:18', '2017-11-17 09:48:18', 'dddd', '建立布局过程中如何处理元素中的空白符。', null, 'dddd', '1', null, null, null, null, '1', '2', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('33', '5', '2017-11-17 09:48:34', '2017-11-17 09:48:34', 'dsd', 'sdad', null, 'dsd', '1', null, null, null, null, '1', '3', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('34', '1', '2017-11-17 10:45:51', '2017-11-17 10:45:51', '', '444', null, '', '1', null, null, null, null, '1', '1', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('35', '11', '2017-11-17 14:24:52', '2017-11-17 14:24:52', '压going明明明明哦', '压力测试', null, '压going明明明明哦', '1', null, null, null, null, '1', '1', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('36', '3', '2017-11-17 14:38:12', '2017-11-17 14:38:12', '的顶顶顶顶顶顶顶顶顶顶', 'testteset', null, '的顶顶顶顶顶顶顶顶顶顶', '1', null, null, null, null, '1', '0', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('37', '9', '2017-11-17 15:21:31', '2017-11-17 15:21:31', '<hr>ff、<div></div>', '22222222222222 是防守', null, 'ff、', '1', null, null, null, null, '1', '1', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('38', '9', '2017-11-17 15:21:57', '2017-11-17 15:21:57', '房贷首付', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊顶顶顶发士大', null, '房贷首付', '3', null, '2017-11-17 15:22:11', '2017-11-17 15:22:11', null, '1', '0', '0', '0', '0');
INSERT INTO `forum_post` VALUES ('39', '9', '2017-11-17 15:22:21', '2017-11-17 15:22:21', '广泛大使馆士大夫给电饭锅', '豆腐干豆腐干豆腐干豆腐干符合规定东方红烦', null, '广泛大使馆士大夫给电饭锅', '1', null, null, null, null, '1', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for `forum_term`
-- ----------------------------
DROP TABLE IF EXISTS `forum_term`;
CREATE TABLE `forum_term` (
  `term_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `term_name` varchar(200) NOT NULL,
  `term_slug` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`term_id`),
  KEY `term_name` (`term_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_term
-- ----------------------------

-- ----------------------------
-- Table structure for `forum_term_relationship`
-- ----------------------------
DROP TABLE IF EXISTS `forum_term_relationship`;
CREATE TABLE `forum_term_relationship` (
  `term_relation_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '分类与文章关联主键',
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `post_id` bigint(20) unsigned NOT NULL COMMENT '文章ID',
  `term_id` bigint(20) unsigned NOT NULL COMMENT '分类ID',
  PRIMARY KEY (`term_relation_id`),
  KEY `post_id` (`post_id`) USING BTREE,
  KEY `term_id` (`term_id`) USING BTREE,
  CONSTRAINT `forum_term_relationship_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `forum_post` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `forum_term_relationship_ibfk_2` FOREIGN KEY (`term_id`) REFERENCES `forum_term` (`term_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_term_relationship
-- ----------------------------

-- ----------------------------
-- Table structure for `forum_user`
-- ----------------------------
DROP TABLE IF EXISTS `forum_user`;
CREATE TABLE `forum_user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `login_name` varchar(30) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '登录密码',
  `portrait` varchar(300) DEFAULT NULL COMMENT '头像路径',
  `display_name` varchar(100) NOT NULL COMMENT '显示名字，个人用户显示个人名称，企业用户显示企业名称',
  `integration` int(5) NOT NULL DEFAULT '0' COMMENT '积分',
  `signature` varchar(300) DEFAULT NULL COMMENT '个性签名',
  `user_type` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '用户类别（1-个人；2-企业）',
  `trade` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '所属行业',
  `personal_name` varchar(30) DEFAULT NULL COMMENT '个人姓名',
  `personal_phone` varchar(30) DEFAULT NULL COMMENT '个人电话',
  `personal_sex` tinyint(2) unsigned DEFAULT NULL COMMENT '个人性别',
  `personal_mail` varchar(30) DEFAULT NULL COMMENT '个人邮箱',
  `personal_company_name` varchar(100) DEFAULT NULL COMMENT '个人所在公司名称',
  `personal_post` varchar(30) DEFAULT NULL COMMENT '个人职位',
  `company_name` varchar(60) DEFAULT NULL COMMENT '企业名称',
  `company_address` varchar(100) DEFAULT NULL COMMENT '企业地址',
  `company_phone` varchar(16) DEFAULT NULL COMMENT '企业电话',
  `company_mail` varchar(30) DEFAULT NULL COMMENT '企业邮箱',
  `contacts_name` varchar(30) DEFAULT NULL COMMENT '企业联系人姓名',
  `contacts_phone` varchar(16) DEFAULT NULL COMMENT '企业联系人电话',
  `contacts_mail` varchar(30) DEFAULT NULL COMMENT '企业联系人邮箱',
  `contacts_post` varchar(30) DEFAULT NULL COMMENT '企业联系人职位',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `index_login_name` (`login_name`) USING BTREE,
  KEY `personal_phone` (`personal_phone`) USING BTREE,
  KEY `personal_mail` (`personal_mail`) USING BTREE,
  KEY `company_phone` (`company_phone`) USING BTREE,
  KEY `company_mail` (`company_mail`) USING BTREE,
  KEY `personal_name` (`personal_name`) USING BTREE,
  KEY `company_name` (`company_name`) USING BTREE,
  KEY `personal_company_name` (`personal_company_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_user
-- ----------------------------
INSERT INTO `forum_user` VALUES ('1', '2017-11-09 00:00:00', '2017-11-16 13:57:49', '0001', '	e10adc3949ba59abbe56e057f20f883e', null, '青岛博亚海洋工程有限公司', '38', '<div>555</div>', '2', '2', '', null, null, null, null, null, '青岛博亚海洋工程有限公司', '青岛蓝色硅谷创业中心', '0532-67720615', 'marine@boyamarine.com', '景宗雷', '18615320314', 'ray@boyamarine.com', 'java');
INSERT INTO `forum_user` VALUES ('2', '2017-11-13 14:16:35', '2017-11-16 16:30:33', '0002', '	e10adc3949ba59abbe56e057f20f883e', null, '景宗雷', '31', '这是啥意思', '1', '1', '景宗雷', '18615320314', '1', 'ray@boyamarine.com', '青岛博亚海工', '研发工程师', null, null, null, null, null, null, null, null);
INSERT INTO `forum_user` VALUES ('3', '2017-11-16 15:05:33', '2017-11-17 16:00:27', 'ray', '202cb962ac59075b964b07152d234b70', null, 'ray@boyamarine.com', '3', '我是不是', '1', '1', 'ray@boyamarine.com', '1121312321', '1', 'fdsfs@fff.com', null, 'ffdssssssss', null, null, null, null, null, null, null, null);
INSERT INTO `forum_user` VALUES ('4', '2017-11-16 16:14:07', null, 'zhangsan', '	698d51a19d8a121ce581499d7b701668', null, '测试用户张三', '0', null, '1', '1', '测试用户张三', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `forum_user` VALUES ('5', '2017-11-17 08:45:04', '2017-11-17 16:11:51', 'zr', 'c3bf26db16183dd7bd0903b9def79bf3', null, '郑然', '1', '大家好', '1', '1', '郑然', '13061486398', '1', '476938200@qq.com', null, 'zz', null, null, null, null, null, null, null, null);
INSERT INTO `forum_user` VALUES ('6', '2017-11-17 08:47:17', '2017-11-17 09:59:32', 'zr2', 'c3bf26db16183dd7bd0903b9def79bf3', null, '郑然2', '1', '5556', '1', '1', '郑然2', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `forum_user` VALUES ('8', '2017-11-17 08:48:23', null, 'zr3', 'c3bf26db16183dd7bd0903b9def79bf3', null, 'zr', '0', null, '1', '1', 'zr', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `forum_user` VALUES ('9', '2017-11-17 08:48:54', '2017-11-17 08:49:03', 'zr5', 'c3bf26db16183dd7bd0903b9def79bf3', null, 'zr', '1', 'zrrrrr', '1', '1', 'zr', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `forum_user` VALUES ('10', '2017-11-17 13:32:19', null, 'ray1', '123', null, '嘎哈和', '1', null, '1', '1', '嘎哈和', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `forum_user` VALUES ('11', '2017-11-17 14:22:40', null, 'qqq', 'qqq', null, 'qqq', '1', null, '1', '1', 'qqq', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `forum_user` VALUES ('12', '2017-11-17 14:23:35', null, 'Wwwww', '120120', null, '哦啦啦', '1', null, '1', '1', '哦啦啦', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `forum_user` VALUES ('13', '2017-11-17 15:22:54', null, 'zz', 'zz', null, 'zz', '0', null, '1', '1', 'zz', null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `forum_user_relationship`
-- ----------------------------
DROP TABLE IF EXISTS `forum_user_relationship`;
CREATE TABLE `forum_user_relationship` (
  `user_relation_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `user_id` bigint(20) unsigned NOT NULL,
  `follower_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`user_relation_id`),
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `follower_id` (`follower_id`) USING BTREE,
  CONSTRAINT `forum_user_relationship_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `forum_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `forum_user_relationship_ibfk_2` FOREIGN KEY (`follower_id`) REFERENCES `forum_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_user_relationship
-- ----------------------------
INSERT INTO `forum_user_relationship` VALUES ('1', '2017-11-14 15:42:59', null, '1', '2');
INSERT INTO `forum_user_relationship` VALUES ('4', '2017-11-16 15:15:57', null, '2', '3');
INSERT INTO `forum_user_relationship` VALUES ('7', '2017-11-17 09:07:02', null, '1', '9');
INSERT INTO `forum_user_relationship` VALUES ('10', '2017-11-17 09:50:52', null, '2', '5');
INSERT INTO `forum_user_relationship` VALUES ('11', '2017-11-17 09:58:27', null, '1', '6');
INSERT INTO `forum_user_relationship` VALUES ('13', '2017-11-17 10:43:21', null, '5', '1');
INSERT INTO `forum_user_relationship` VALUES ('15', '2017-11-17 11:21:28', null, '1', '3');
INSERT INTO `forum_user_relationship` VALUES ('16', '2017-11-17 13:01:47', null, '1', '5');
INSERT INTO `forum_user_relationship` VALUES ('17', '2017-11-17 13:02:43', null, '3', '5');
INSERT INTO `forum_user_relationship` VALUES ('18', '2017-11-17 13:35:01', null, '1', '10');
INSERT INTO `forum_user_relationship` VALUES ('19', '2017-11-17 14:32:19', null, '10', '1');
INSERT INTO `forum_user_relationship` VALUES ('20', '2017-11-17 15:18:48', null, '3', '9');
INSERT INTO `forum_user_relationship` VALUES ('21', '2017-11-17 15:20:22', null, '5', '9');

-- ----------------------------
-- Table structure for `sys_enum_detail`
-- ----------------------------
DROP TABLE IF EXISTS `sys_enum_detail`;
CREATE TABLE `sys_enum_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `enum_type` varchar(20) NOT NULL COMMENT '枚举类型',
  `enum_value` tinyint(2) unsigned NOT NULL COMMENT '枚举值',
  `enum_name` varchar(100) NOT NULL COMMENT '枚举值显示名称',
  `enum_desc` varchar(100) DEFAULT NULL COMMENT '枚举描述',
  PRIMARY KEY (`id`),
  KEY `index_type` (`enum_type`) USING BTREE,
  KEY `index_value` (`enum_name`) USING BTREE,
  KEY `index_name` (`enum_name`) USING BTREE,
  CONSTRAINT `sys_enum_detail_ibfk_1` FOREIGN KEY (`enum_type`) REFERENCES `sys_enum_main` (`enum_type`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_enum_detail
-- ----------------------------
INSERT INTO `sys_enum_detail` VALUES ('1', '2017-11-09 18:18:34', null, 'trade', '1', '船舶配套', null);
INSERT INTO `sys_enum_detail` VALUES ('2', '2017-11-09 18:18:57', null, 'trade', '2', '海工装备', null);
INSERT INTO `sys_enum_detail` VALUES ('3', '2017-11-09 18:19:17', null, 'trade', '3', '码头工程装备', null);
INSERT INTO `sys_enum_detail` VALUES ('4', '2017-11-09 18:19:35', null, 'trade', '4', '远洋捕捞装备', null);
INSERT INTO `sys_enum_detail` VALUES ('5', '2017-11-09 18:19:51', null, 'trade', '5', '深海养殖装备', null);
INSERT INTO `sys_enum_detail` VALUES ('6', '2017-11-09 18:20:08', null, 'trade', '6', '海洋旅游装备', null);
INSERT INTO `sys_enum_detail` VALUES ('7', '2017-11-09 18:20:25', null, 'trade', '7', '海洋生物科技', null);
INSERT INTO `sys_enum_detail` VALUES ('8', '2017-11-09 18:20:43', null, 'trade', '8', '海洋能源', null);
INSERT INTO `sys_enum_detail` VALUES ('9', '2017-11-09 18:21:03', null, 'trade', '9', '海洋科研技术及应用', null);
INSERT INTO `sys_enum_detail` VALUES ('10', '2017-11-09 18:21:23', null, 'trade', '10', '其他', null);
INSERT INTO `sys_enum_detail` VALUES ('11', '2017-11-13 13:39:48', null, 'user_type', '1', '个人用户', null);
INSERT INTO `sys_enum_detail` VALUES ('12', '2017-11-13 13:41:23', null, 'user_type', '2', '企业展商', null);
INSERT INTO `sys_enum_detail` VALUES ('13', '2017-11-13 14:18:54', null, 'sex', '1', '男', null);
INSERT INTO `sys_enum_detail` VALUES ('14', '2017-11-13 14:19:11', null, 'sex', '0', '女', null);

-- ----------------------------
-- Table structure for `sys_enum_main`
-- ----------------------------
DROP TABLE IF EXISTS `sys_enum_main`;
CREATE TABLE `sys_enum_main` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `enum_type` varchar(20) DEFAULT NULL COMMENT '枚举类型',
  `enum_title` varchar(50) DEFAULT NULL COMMENT '枚举名称',
  PRIMARY KEY (`id`),
  KEY `index_type` (`enum_type`) USING BTREE,
  KEY `index_name` (`enum_title`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_enum_main
-- ----------------------------
INSERT INTO `sys_enum_main` VALUES ('1', '2017-11-09 18:17:12', null, 'trade', '所属行业');
INSERT INTO `sys_enum_main` VALUES ('2', '2017-11-13 13:40:57', null, 'user_type', '用户类别');
INSERT INTO `sys_enum_main` VALUES ('3', '2017-11-13 14:18:35', null, 'sex', '性别');
