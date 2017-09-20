DROP DATABASE IF EXISTS `hrs`;
CREATE DATABASE `hrs` default charset utf8;
USE `hrs`;

DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept` (
  `dno` int(11) NOT NULL,
  `dname` varchar(20) NOT NULL,
  `dloc` varchar(50) NOT NULL,
  PRIMARY KEY (`dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tb_emp`;
CREATE TABLE `tb_emp` (
  `eno` int(11) NOT NULL,
  `ename` varchar(20) NOT NULL,
  `esex` bit(1) DEFAULT b'1',
  `ejob` varchar(20) NOT NULL,
  `emgr` int(11) DEFAULT NULL,
  `esal` float DEFAULT NULL,
  `ehiredate` date DEFAULT NULL,
  `estatus` bit(1) DEFAULT b'1',
  `ephoto` varchar(255) DEFAULT NULL,
  `etel` char(11) DEFAULT NULL,
  `dno` int(11) NOT NULL,
  PRIMARY KEY (`eno`),
  KEY `fk_emp_dno` (`dno`),
  KEY `fk_emp_emgr` (`emgr`),
  CONSTRAINT `fk_emp_dno` FOREIGN KEY (`dno`) REFERENCES `tb_dept` (`dno`) ON UPDATE CASCADE,
  CONSTRAINT `fk_emp_emgr` FOREIGN KEY (`emgr`) REFERENCES `tb_emp` (`eno`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `username` varchar(20) NOT NULL,
  `password` char(32) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tb_dept` VALUES ('10','财务部','北京'), ('20','研发部','成都'), ('30','销售部','深圳');
INSERT INTO `tb_user` VALUES ('jackfrued','4297f44b13955235245b2497399d7a93','jackfrued@126.com');
