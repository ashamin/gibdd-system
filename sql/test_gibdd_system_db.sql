/*
 * Model: gibdd-system
 * Database: MySQL 5.5
 */

-- Insert into humas section ---------------------------------------------------

INSERT INTO humans (name,passport_number,address)
VALUES ('Петр Алексеевич Вавилов','0110568941','ул. Матросова, 21'),
       ('Алексей Геннадьевич Свиридов','0543325610','ул. Строителей, 4'),
       ('Марина Свиридовна Забоева','5438932548','ул. Широкая, 36'),
       ('Александр Владиславович Ливин','9359675216','ул. Соколова, 2'),
       ('Ашот Араратович Мовсисян','1574354987','ул. Строителей, 54'),
       ('Артем Петрович Павлов','1257456912','ул. Ленина, 52'),
       ('Геннадий Алексеевич Птицин','3254961453','ул. Большая, 25'),
       ('Антон Валерьевич Радаев','2146458312','ул. Крупской, 16'),
       ('Андрей Валентинович Сабитов','4520912300','ул. Матросова, 25'),
       ('Роман Петрович Сушко','1367786341','ул. Ленина, 12'),
       ('Петр Александрович Сидоров','1234586620','ул. Мостовая, 10'),
       ('Степан Родионович Уваров','1384483126','ул. Кривая, 6'),
       ('Валерий Романович Успешный','1903482519','ул. Большая, 65'),
       ('Валентин Романович Углов','1526482034','ул. Ленина, 47'),
       ('Юрий Юрьевич Фадин','1237456898','ул. Кривая, 43'),
       ('Степан Иванович Помидоров','1694694864','ул. Крупской, 46'),
       ('Анастасия Гавриловна Баклажанова','6546654654','ул. Ленина, 6'),
       ('Илья Никифорович Огурцов','3216986450','ул. Большая, 18'),
       ('Степан Ильич Редькин','9815489982','ул. Соколова, 48'),
       ('Елена Владимировна Капустина','8206985613','ул. Широкая, 3'),
       ('Елена Викторовна Овощная','9816036156','ул. Матросова, 35'),
       ('Николай Николаевич Картошкин','8945201564','ул. Ленина, 32'),
       ('Инокентий Григорьевич Абрикосов','1069155151','ул. Мостовая, 4'),
       ('Гаврила Арделионович Ананасов','6150896450','ул. Большая, 13'),
       ('Василий Петрович Грушевский','9485875463','ул. Соколова, 25'),
       ('Иван Ильич Яблочкин','9861564321','ул. Строителей, 44'),
       ('Евгения Евгеньевна Апельсинова','9831986530','ул. Кривая, 24'),
       ('Василиса Матвеевна Бананова','9865895632','ул. Большая, 34'),
       ('Родион Романович Фруктовский','8615896156','ул. Матросова, 3');

-- Insert into posts section ---------------------------------------------------

INSERT INTO posts (post)
VALUES ('Начальник отдела'),
       ('Начальник экзаменационного отделения'),
       ('Старший государственный инспектор'),
       ('Государственный инспектор'),
       ('Сотрудник ДПС'),
       ('Сотрудник экзаменационного отделения');

-- Insert into ranks section ---------------------------------------------------

INSERT INTO ranks (rank)
VALUES ('Прапорщик полиции'),
       ('Старший прапорщик полиции'),
       ('Младший лейтенант полиции'),
       ('Лейтенант полиции'),
       ('Старший лейтенант полиции'),
       ('Капитан полиции'),
       ('Майор полиции'),
       ('Подполковник полиции'),
       ('Полковник полиции'),
       ('Генерал-майор полиции'),
       ('Генерал-лейтенант полиции'),
       ('Генерал-полковник полиции'),
       ('Генерал полиции');

-- Insert into inspectors section ----------------------------------------------

INSERT INTO inspectors (login,password,human_id,post_id,rank_id)
VALUES ('inspectors_1','inspectors_1',1,1,9),
       ('inspectors_2','inspectors_2',2,2,7),
       ('inspectors_3','inspectors_3',3,3,6),
       ('inspectors_4','inspectors_4',4,4,5),
       ('inspectors_5','inspectors_5',5,4,4),
       ('inspectors_6','inspectors_6',6,6,4),
       ('inspectors_7','inspectors_7',7,6,4),
       ('inspectors_8','inspectors_8',8,6,4),
       ('inspectors_9','inspectors_9',9,4,5),
       ('inspectors_10','inspectors_10',10,5,1),
       ('inspectors_11','inspectors_11',11,5,1),
       ('inspectors_12','inspectors_12',12,5,2),
       ('inspectors_13','inspectors_13',13,5,2),
       ('inspectors_14','inspectors_14',14,5,1),
       ('inspectors_15','inspectors_15',15,5,2),
       ('inspectors_16','inspectors_16',16,5,1),
       ('inspectors_17','inspectors_17',17,5,2);

-- Insert into driver_license_inspectors section -------------------------------

INSERT INTO driver_license_inspectors (inspector_id)
VALUES (2), (6), (7), (8);

-- Insert into driver_licenses section -----------------------------------------

INSERT INTO driver_licenses (registration_date,leave_date,categories,driver_license_inspector_id,human_id)
VALUES ('2005-06-06','2015-06-06','A',1,18),
       ('2005-07-01','2015-07-01','B',2,19),
       ('2003-03-02','2013-03-02','C',2,20),
       ('2005-04-04','2015-04-04','CD',4,21),
       ('2003-05-05','2013-05-05','BCDE',3,22),
       ('2006-10-08','2016-10-08','AB',1,23),
       ('2006-12-09','2016-12-09','BC',3,24),
       ('2007-11-10','2017-11-10','B',2,25),
       ('2007-03-12','2017-03-12','C',1,26),
       ('2007-01-14','2017-01-14','CD',4,27),
       ('2004-02-13','2014-02-13','B',4,28),
       ('2003-08-15','2013-08-15','B',3,29),
       ('2003-09-17','2013-09-17','C',2,17),
       ('2008-07-18','2018-07-18','BC',3,16),
       ('2008-03-20','2013-03-20','BC',3,15),
       ('2004-04-21','2014-04-21','B',1,14),
       ('2004-10-22','2014-10-22','ABC',1,13),
       ('2009-08-24','2019-08-24','B',4,12),
       ('2009-06-26','2019-06-26','BC',3,2),
       ('2010-05-28','2020-05-28','AB',2,6),
       ('2010-01-30','2020-01-30','ABC',4,7),
       ('2011-09-01','2021-09-01','BC',1,8);

-- Insert into vehicle_inspectors section --------------------------------------

INSERT INTO vehicle_inspectors (inspector_id)
VALUES (3), (4), (5), (9);

-- Insert into brands section --------------------------------------------------

INSERT INTO brands (brand)
VALUES ('Audi'), ('BMW'), ('Ford'), ('Fiat'), ('Citroen'), ('Honda'), ('Mazda'), ('Suzuki'), ('Mitsubishi'), ('Volkswagen'), ('Renault'), ('Lada');

-- Insert into vehicles section ------------------------------------------------

INSERT INTO vehicles (color,EIN,VIN,year,brand_id)
VALUES ('Черный','4532178','X9F5XXEED55A12345','2005-05-01',1),
       ('Белый','1456354','C8S4GTRFD54C36547','2006-03-01',5),
       ('Красный','1236987','A4V1PLHTD36N95124','2003-04-01',4),
       ('Синий','1459674','L7M1LHNBT32V36954','2004-09-01',3),
       ('Черный','1697453','P2B9TGFRK36M65418','2007-04-01',1),
       ('Желтый','4569831','U2H4TMURK87F54720','2008-10-01',10),
       ('Красный','7856412','H1N0JVWE00J63012','2011-12-01',11),
       ('Синий','4578321','G7V1VVBNN16F56301','2009-03-01',7),
       ('Черный','9654101','R1B0UNFTH06S68411','2004-08-01',8),
       ('Черный','4863214','J6F0TGMJJ33G16548','2003-07-01',3),
       ('Белый','7890052','F7J5FGTJN67W55187','2006-02-01',2),
       ('Черный','9674153','T7D6BBJKY24V45698','2000-09-01',1);

-- Insert into vehicle_registration_certificates section -----------------------

INSERT INTO vehicle_registration_certificates (registration_number,registration_date,leave_date,vehicle_inspector_id,vehicle_id,human_id)
VALUES ('ОЛ 645 Р','2005-06-15',NULL,1,1,18),
       ('ЛО 878 А','2006-04-10',NULL,2,2,19),
       ('СЛ 719 М','2003-04-16','2008-08-05',4,3,20),
       ('СЛ 719 М','2008-08-12',NULL,3,3,24),
       ('ДЛ 870 П','2004-09-20',NULL,1,4,22),
       ('ЗИ 066 К','2007-04-05',NULL,4,5,23),
       ('НП 984 М','2008-10-10',NULL,2,6,20),
       ('ДУ 981 К','2011-12-06',NULL,3,7,26),
       ('УЛ 035 Н','2009-03-15','2011-02-05',2,8,26),
       ('УЛ 035 Н','2011-02-15',NULL,3,8,25),
       ('ПО 910 О','2004-08-08',NULL,4,9,28),
       ('ЛР 684 Е','2003-09-03',NULL,4,10,29),
       ('НР 980 А','2006-02-04',NULL,4,11,21),
       ('РТ 036 В','2011-09-03',NULL,2,12,27);

-- Insert into patrol_inspectors section ---------------------------------------

INSERT INTO patrol_inspectors (inspector_id)
VALUES (12), (13), (14), (15), (16), (17);

-- Insert into duty_inspectors section -----------------------------------------

INSERT INTO duty_inspectors (inspector_id)
VALUES (1), (10), (11);

-- Insert into duty_tours section ----------------------------------------------

INSERT INTO duty_tours (start_date,finish_date,duty_inspector_id)
VALUES ('2012-02-16','2012-02-18',1), ('2012-03-20','2012-03-21',2), ('2012-04-24','2012-04-26',3), ('2012-05-28','2012-05-29',3), ('2012-06-02','2012-06-03',2), ('2012-07-06','2012-07-07',1);

-- Insert into duties section --------------------------------------------------

INSERT INTO duties (duty_tour_id,patrol_inspector_id)
VALUES (1,1), (1,2), (1,3), (2,4), (2,5), (3,6), (3,3), (3,1), (4,2), (4,5), (5,6), (5,4), (6,2), (6,5), (6,3);

-- Insert into violations section ----------------------------------------------

INSERT INTO violations (title,description,punishment)
VALUES ('Управление транспортным средством с нарушением правил установки на нем государственных регистрационных знаков','Управление ТС без государственных регистрационных знаков','Штраф 5000 руб. или лишение права управления ТС на срок от 1 до 3 мес. / изъятие ВУ'),
       ('Управление транспортным средством водителем, не имеющим права управления транспортным средством','Управление ТС водителем, лишенным права управления ТС','Арест на срок до 15 суток или штраф 5000 руб. для лиц, в отношении которых не может применяться арест / отстранение от управления ТС, задержание ТС'),
       ('Управление транспортным средством водителем, находящимся в состоянии опьянения, передача управления транспортным средством лицу, находящемуся в состоянии опьянения','Управление ТС водителем, находящимся в состоянии опьянения','Лишение права управления ТС на срок от 1,5 до 2 лет / отстранение от управления ТС, направление на медицинское освидетельствование,	изъятие ВУ, задержание ТС'),
       ('Превышение установленной скорости движения','Превышение установленной скорости движения ТС на величину не менее 10, но не более 20 километров в час','Предупреждение или штраф 100 руб.'),
       ('Превышение установленной скорости движения','Превышение установленной скорости движения ТС на величину более 20, но не более 40 километров в час','Штраф 300 руб.'),
       ('Превышение установленной скорости движения','Превышение установленной скорости движения ТС на величину более 40, но не более 60 километров в час','Штраф от 1000 до 1500 руб.'),
       ('Превышение установленной скорости движения','Превышение установленной скорости движения ТС на величину более 60 километров в час','Штраф от 2000 до 2500 руб. или лишение права управления ТС на срок от 4 до 6 мес. / изъятие ВУ'),
       ('Проезд на запрещающий сигнал светофора или на запрещающий жест регулировщика','Проезд на запрещающий сигнал светофора или на запрещающий жест регулировщика','Штраф 1000 руб.'),
       ('Нарушение правил расположения транспортного средства на проезжей части дороги, встречного разъезда или обгона','Выезд в нарушение Правил дорожного движения на полосу, предназначенную для встречного движения, либо на трамвайные пути встречного направления','Лишение права управления ТС на срок от 4 до 6 мес. / изъятие ВУ'),
       ('Несоблюдение требований, предписанных дорожными знаками или разметкой проезжей части дороги','Движение во встречном направлении по дороге с односторонним движением','Штраф 5000 руб или лишение на 4-6 мес.'),
       ('Несоблюдение требований, предписанных дорожными знаками или разметкой проезжей части дороги','Несоблюдение требований дорожных знаков или разметки, запрещающих остановку или стоянку ТС','Штраф 1500 руб. или задержание ТС'),
       ('Непредоставление преимущества в движении пешеходам или иным участникам дорожного движения','Невыполнение требования ПДД уступить дорогу пешеходам, велосипедистам или иным участникам дорожного движения (за исключением водителей ТС),пользующимся преимуществом в движении','Штраф от 800 до 1000 руб');

-- Insert into protocols section -----------------------------------------------

INSERT INTO protocols (date,violation_id,patrol_inspector_id,vehicle_id,human_id)
VALUES ('2012-01-03',3,1,1,18),
       ('2012-02-04',4,2,2,20),
       ('2012-02-28',2,3,4,21),
       ('2012-03-30',6,3,5,19),
       ('2012-03-06',7,5,6,25),
       ('2012-03-10',8,6,10,24),
       ('2012-04-11',9,4,8,29),
       ('2012-05-12',12,5,7,23),
       ('2012-05-16',8,4,11,22),
       ('2012-05-18',11,1,5,27),
       ('2012-05-20',10,2,3,28),
       ('2012-06-22',5,3,9,18),
       ('2012-06-23',4,6,10,26),
       ('2012-07-08',2,4,1,19),
       ('2012-08-09',12,5,2,26),
       ('2012-09-04',3,5,3,22),
       ('2012-10-05',1,4,4,19),
       ('2012-11-15',5,6,6,18),
       ('2012-02-18',10,2,7,26),
       ('2012-03-13',11,1,8,29),
       ('2012-06-12',10,3,9,23),
       ('2012-08-017',9,2,10,21),
       ('2012-07-08',7,2,11,20),
       ('2012-01-09',6,1,12,25),
       ('2012-10-10',3,1,5,24),
       ('2012-09-12',5,3,6,18),
       ('2012-09-13',4,4,7,19),
       ('2012-09-26',2,6,8,22),
       ('2012-06-27',1,5,2,26),
       ('2012-06-30',6,1,1,24),
       ('2012-04-19',7,1,3,28),
       ('2012-03-03',8,2,8,27),
       ('2012-02-04',10,2,7,20),
       ('2012-01-01',5,3,6,25);

-- Insert into automatic_recorders section -------------------------------------

INSERT INTO automatic_recorders (UID)
VALUES ('1258GF45'), ('6598NH24'), ('6894UJ32'), ('9620KF37'), ('4872TC19'), ('4804KU36'), ('4905HK60'), ('6456IU15'), ('8645BI35');
