CREATE TABLE `survey` (
  `surveyNo` int(11) NOT NULL AUTO_INCREMENT,
  `quesNo` int(11) DEFAULT NULL,
  `cateNo` int(11) DEFAULT NULL,
  `companyNo` int(11) DEFAULT NULL,
  `manager` varchar(30) DEFAULT NULL,
  `surveyDate` date DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `answer` varchar(500) DEFAULT NULL,
  `dissatisReason` varchar(500) DEFAULT NULL,
  `satisVal` int(10) DEFAULT NULL,
  PRIMARY KEY (`surveyNo`),
  KEY `quesNo` (`quesNo`),
  KEY `cateNo` (`cateNo`),
  KEY `companyNo` (`companyNo`),
  CONSTRAINT `survey_ibfk_1` FOREIGN KEY (`quesNo`) REFERENCES `question` (`quesNo`),
  CONSTRAINT `survey_ibfk_2` FOREIGN KEY (`cateNo`) REFERENCES `cate` (`cateNo`),
  CONSTRAINT `survey_ibfk_3` FOREIGN KEY (`companyNo`) REFERENCES `company` (`companyNo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8


CREATE TABLE `surveyForm` (
                          `surveyFormGroupNo` int(11) NOT NULL AUTO_INCREMENT,
                          `cateName` varchar(100) NOT NULL,
                          `regDate` date DEFAULT NULL,
                          PRIMARY KEY (`surveyFormGroupNo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;


CREATE TABLE `surveyForm` (
                          `surveyFormNo` int(11) NOT NULL AUTO_INCREMENT,
                          `surveyFormGroupNo` int(10) NOT NULL,
                          `quesName` varchar(100) DEFAULT NULL,
                          `type` int(10) DEFAULT NULL,
                          `order` int(10) DEFAULT NULL,
                          PRIMARY KEY (`surveyFormNo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `cate` (
  `cateNo` int(11) NOT NULL AUTO_INCREMENT,
  `cateName` varchar(100) NOT NULL,
  `cateInfo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`cateNo`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8


CREATE TABLE `company` (
  `companyNo` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(100) NOT NULL,
  `manager` varchar(30) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8


CREATE TABLE `user` (
  `userNo` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `department` varchar(30) DEFAULT NULL,
  `telephone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

