create table `case`(
  'id' int primary key auto_crement,
  'name' varchar(255),
  'time' BIGINT,
  'case_info_id' int,
  `procuracy_id` int
)