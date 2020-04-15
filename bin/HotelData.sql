drop database HotelBookingDB;
create database HotelBookingDB;
 
use HotelBookingDB;
 
CREATE TABLE `Hotel` (
    `id` integer NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `description` varchar(4096) NOT NULL,
    `url` varchar(4096) NOT NULL,
    PRIMARY KEY (`id`)
);
insert into `Hotel`(`id`, `name`, `description`, `url`) values 
(1,'Hótel Höfn','Góð gisting á besta stað','http://www.hi.is'),
(2,'Hótel Holt','Góð gisting í Þingholtunum','http://www.hi.is'),
(3,'Hótel Borg','Góð gisting við Austurvöll','http://www.hi.is'),
(4,'Hótel Esja','Góð gisting, allavega var það','http://www.hi.is'),
(5,'Hótel Hekla','Góð gisting í sveitinni','http://www.hi.is'),
(6,'Hótel City','Góð gisting... já','http://www.hi.is');

CREATE TABLE `Location` (
    `id` integer NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);
insert into `Location`(`id`, `name`) values 
(1,'Norðurland'),
(2,'Suðurland'),
(3,'Austurland'),
(4,'Vesturland');

CREATE TABLE `Tag` (
    `id` integer NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);
insert into `Tag`(`id`, `name`) values 
(1,'Útsýni'),
(2,'Gönguleiðir'),
(3,'Miðbær'),
(4,'Matur');

CREATE TABLE `Images` (
    `id` integer NOT NULL AUTO_INCREMENT,
    `type` integer, -- 0 = picture, 1 == video
    `hotel` integer,
    `url` varchar(8192) NOT NULL,
    PRIMARY KEY (`id`)
);
insert into `Images`(`id`, `type`, `hotel`, `url`) values 
(1,0,1,'https://www.hotelhofn.is/static/gallery/hotel-hofn/md/dji_0040.jpg'),
(2,0,2,'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQU0RKPqw7hGlrG0rKwvZEa8X2cfg44IeHgBowabD_tclgrp6dH&usqp=CAU'),
(3,0,2,'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcReSYMoB1HGaV9fbq58fC_yfHoS1bfEPcChHfP9HAyNq_5MN3RD&usqp=CAU'),
(4,0,4,'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcShdAyn8lJrjwiJ2BTVqlGSV_gWvQOwqS6LWPl_R48Riajvegz5&usqp=CAU');

CREATE TABLE `Room` (
    `id` integer NOT NULL AUTO_INCREMENT,
    `no` integer,
    `type` integer, -- 0 = room, 1 == suit
    `hotel` integer,
    `persons` integer,
    PRIMARY KEY (`id`)
);
insert into `Room`(`id`, `no`, `type`, `hotel`, `persons`) values
(1,101,0,1,2),
(2,102,0,1,2),
(3,103,0,1,2),
(4,201,0,1,2),
(5,202,0,1,2),
(6,203,0,1,2),
(7,101,0,2,2),
(8,102,0,2,2),
(9,103,0,2,2),
(10,201,0,2,2),
(11,202,0,2,2),
(12,203,0,2,2),
(13,101,0,3,2),
(14,102,0,3,2),
(15,103,0,3,2),
(16,201,0,3,2),
(17,202,0,3,2),
(18,203,0,3,2),
(19,101,0,4,2),
(20,102,0,4,2),
(20,103,0,4,2),
(22,201,0,4,2),
(23,202,0,4,2),
(24,203,0,4,2),
(25,101,0,5,2),
(26,102,0,5,2),
(27,103,0,5,2),
(28,201,0,5,2),
(29,202,0,5,2),
(30,203,0,5,2),
(31,101,0,6,1),
(32,102,0,6,1),
(33,103,0,6,1),
(34,201,0,6,1),
(35,202,0,6,1),
(36,203,0,6,1);

CREATE TABLE `Review` (
    `id` integer NOT NULL AUTO_INCREMENT,
    `user` integer,
    `hotel` integer,
    `text` varchar(4096),
    PRIMARY KEY (`id`)
);
insert into `Review`(`id`, `user`, `hotel`, `text`) values
(1,1,1,'lorum ipsum eða hvað'),
(2,1,1,'lorum ipsum blah'),
(3,1,2,'lorum ipsum no2'),
(4,1,4,'lorum ipsum no4'),
(5,1,6,'lorum ipsum no6');

CREATE TABLE `HotelLocation` (
    `hotel` integer NOT NULL,
    `location` integer NOT NULL
);
insert into `HotelLocation`(`hotel`, `location`) values
(1,1),
(5,1),
(2,2),
(3,3),
(4,4),
(5,5);

