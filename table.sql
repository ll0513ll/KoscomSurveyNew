CREATE TABLE `cate` (
  `cateNo` int(11) NOT NULL AUTO_INCREMENT,
  `cateName` varchar(100) NOT NULL,
  `cateInfo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`cateNo`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8


CREATE TABLE `company` (
  `companyNo` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(100) NOT NULL,
  `companyManager` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`companyNo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8

CREATE TABLE `question` (
  `quesNo` int(11) NOT NULL AUTO_INCREMENT,
  `cateNo` int(11) DEFAULT NULL,
  `companyNo` int(11) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `quesName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`quesNo`),
  KEY `cateNo` (`cateNo`),
  KEY `companyNo` (`companyNo`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`cateNo`) REFERENCES `cate` (`cateNo`),
  CONSTRAINT `question_ibfk_2` FOREIGN KEY (`companyNo`) REFERENCES `company` (`companyNo`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8


CREATE TABLE `survey` (
  `surveyGroupNo` int(11) NOT NULL,
  `surveyNo` int(11) NOT NULL AUTO_INCREMENT,
  `companyNo` int(11) DEFAULT NULL,
  `quesName` varchar(200) DEFAULT NULL,
  `cateName` varchar(200) DEFAULT NULL,
  `manager` varchar(30) DEFAULT NULL COMMENT '담당자',
  `surveyDate` date DEFAULT NULL COMMENT '설문지 생성일',
  `type` int(10) DEFAULT NULL COMMENT '객관식/주관식 타입',
  `answer` varchar(500) DEFAULT NULL COMMENT '주관식 답변',
  `dissatisReason` varchar(500) DEFAULT NULL COMMENT '객관식 나쁨 선택 사유',
  `satisVal` int(10) DEFAULT NULL COMMENT '객관식 만족도 선택',
  `participate` int(10) DEFAULT '0',
  PRIMARY KEY (`surveyNo`),
  KEY `companyNo` (`companyNo`),
  CONSTRAINT `survey_ibfk_3` FOREIGN KEY (`companyNo`) REFERENCES `company` (`companyNo`)
) ENGINE=InnoDB AUTO_INCREMENT=403 DEFAULT CHARSET=utf8


CREATE TABLE `surveyform` (
  `surveyFormNo` int(11) NOT NULL AUTO_INCREMENT,
  `surveyFormGroupNo` int(11) NOT NULL,
  `quesName` varchar(100) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `orderNo` int(10) DEFAULT NULL,
  `quesNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`surveyFormNo`),
  KEY `quesNo` (`quesNo`),
  CONSTRAINT `quesNo` FOREIGN KEY (`quesNo`) REFERENCES `question` (`quesNo`)
) ENGINE=InnoDB AUTO_INCREMENT=420 DEFAULT CHARSET=utf8


CREATE TABLE `surveyformgroup` (
  `endDate` date DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `surveyFormGroupNo` int(11) NOT NULL AUTO_INCREMENT,
  `cateName` varchar(100) NOT NULL,
  `regDate` date DEFAULT NULL,
  PRIMARY KEY (`surveyFormGroupNo`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8

CREATE TABLE `user` (
  `userNo` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `department` varchar(30) DEFAULT NULL,
  `telephone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `client` (
  `cliNo` int(50) NOT NULL,
  `companyNo` int(11) DEFAULT NULL,
  `cliName` varchar(100) DEFAULT NULL,
  `cliEmail` varchar(100) DEFAULT NULL,
  `cliPassword` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cliNo`),
  KEY `companyNo` (`companyNo`),
  CONSTRAINT `client_ibfk_1` FOREIGN KEY (`companyNo`) REFERENCES `company` (`companyNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

