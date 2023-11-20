USE `employee_directory`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

CREATE TABLE `members` (
  `user_id` varchar(50) DEFAULT NULL,
  `pw` varchar(68) DEFAULT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `members`
VALUES
('john', '{noop}test123', 1),
('mary', '{noop]test123', 1),
('susan', '{noop}test123', 1);



CREATE TABLE `roles` (
  `user_id` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  UNIQUE KEY `roles_idx_1` (`user_id`, `role`),
  CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members`(`user_id`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `roles`
VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMIN');
