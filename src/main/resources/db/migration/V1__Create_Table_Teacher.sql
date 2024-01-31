CREATE TABLE IF NOT EXISTS `teacher` (
  `rgm` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `hiring_date` date DEFAULT NULL,
  PRIMARY KEY (`rgm`)
)