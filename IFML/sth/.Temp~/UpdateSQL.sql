-- Group [Group]
create table `group` (
   `oid`  integer  not null,
   `groupname`  varchar(255),
  primary key (`oid`)
) ENGINE=InnoDB;


-- Module [Module]
create table `module` (
   `oid`  integer  not null,
   `moduleid`  varchar(255),
   `modulename`  varchar(255),
  primary key (`oid`)
) ENGINE=InnoDB;


-- User [User]
create table `user` (
   `oid`  integer  not null,
   `username`  varchar(255),
   `password`  varchar(255),
   `email`  varchar(255),
   `birth_date`  datetime,
   `score`  double precision,
   `name`  varchar(255),
   `piggy_bank`  double precision,
  primary key (`oid`)
) ENGINE=InnoDB;


-- Skill [ent11]
create table `skill` (
   `oid`  integer  not null,
   `name`  varchar(255),
  primary key (`oid`)
) ENGINE=InnoDB;


-- Item [ent12]
create table `item` (
   `oid`  integer  not null,
   `url`  varchar(255),
   `caption`  varchar(255),
   `title`  varchar(255),
  primary key (`oid`)
) ENGINE=InnoDB;


-- Annotation [ent13]
create table `annotation` (
   `oid`  integer  not null,
   `confidence`  integer,
   `label`  varchar(255),
   `marked`  bit,
  primary key (`oid`)
) ENGINE=InnoDB;


-- Task [ent14]
create table `task` (
   `oid`  integer  not null,
   `title`  varchar(255),
   `description`  varchar(255),
   `reward`  double precision,
   `expiration_date`  datetime,
   `maximum_exec_time`  time,
   `grade`  integer,
  primary key (`oid`)
) ENGINE=InnoDB;


-- AnnotationCampaign [ent15]
create table `annotationcampaign` (
   `oid`  integer  not null,
   `status`  varchar(255),
   `budget`  double precision,
   `name`  varchar(255),
  primary key (`oid`)
) ENGINE=InnoDB;


-- Group_DefaultModule [Group2DefaultModule_DefaultModule2Group]
alter table `group`  add column  `module_oid`  integer;
alter table `group`   add index fk_group_module (`module_oid`), add constraint fk_group_module foreign key (`module_oid`) references `module` (`oid`);


-- Group_Module [Group2Module_Module2Group]
create table `group_module` (
   `group_oid`  integer not null,
   `module_oid`  integer not null,
  primary key (`group_oid`, `module_oid`)
) ENGINE=InnoDB;
alter table `group_module`   add index fk_group_module_group (`group_oid`), add constraint fk_group_module_group foreign key (`group_oid`) references `group` (`oid`);
alter table `group_module`   add index fk_group_module_module (`module_oid`), add constraint fk_group_module_module foreign key (`module_oid`) references `module` (`oid`);


-- User_DefaultGroup [User2DefaultGroup_DefaultGroup2User]
alter table `user`  add column  `group_oid`  integer;
alter table `user`   add index fk_user_group (`group_oid`), add constraint fk_user_group foreign key (`group_oid`) references `group` (`oid`);


-- User_Group [User2Group_Group2User]
create table `user_group` (
   `user_oid`  integer not null,
   `group_oid`  integer not null,
  primary key (`user_oid`, `group_oid`)
) ENGINE=InnoDB;
alter table `user_group`   add index fk_user_group_user (`user_oid`), add constraint fk_user_group_user foreign key (`user_oid`) references `user` (`oid`);
alter table `user_group`   add index fk_user_group_group (`group_oid`), add constraint fk_user_group_group foreign key (`group_oid`) references `group` (`oid`);


-- Task_Item [rel17]
create table `task_item` (
   `task_oid`  integer not null,
   `item_oid`  integer not null,
  primary key (`task_oid`, `item_oid`)
) ENGINE=InnoDB;
alter table `task_item`   add index fk_task_item_task (`task_oid`), add constraint fk_task_item_task foreign key (`task_oid`) references `task` (`oid`);
alter table `task_item`   add index fk_task_item_item (`item_oid`), add constraint fk_task_item_item foreign key (`item_oid`) references `item` (`oid`);


-- AnnotationCampaign_Task [rel18]
alter table `task`  add column  `annotationcampaign_oid`  integer;
alter table `task`   add index fk_task_annotationcampaign (`annotationcampaign_oid`), add constraint fk_task_annotationcampaign foreign key (`annotationcampaign_oid`) references `annotationcampaign` (`oid`);


-- Task_Skill [rel19]
create table `task_skill` (
   `task_oid`  integer not null,
   `skill_oid`  integer not null,
  primary key (`task_oid`, `skill_oid`)
) ENGINE=InnoDB;
alter table `task_skill`   add index fk_task_skill_task (`task_oid`), add constraint fk_task_skill_task foreign key (`task_oid`) references `task` (`oid`);
alter table `task_skill`   add index fk_task_skill_skill (`skill_oid`), add constraint fk_task_skill_skill foreign key (`skill_oid`) references `skill` (`oid`);


-- Item_Annotation [rel20]
create table `item_annotation` (
   `item_oid`  integer not null,
   `annotation_oid`  integer not null,
  primary key (`item_oid`, `annotation_oid`)
) ENGINE=InnoDB;
alter table `item_annotation`   add index fk_item_annotation_item (`item_oid`), add constraint fk_item_annotation_item foreign key (`item_oid`) references `item` (`oid`);
alter table `item_annotation`   add index fk_item_annotation_annotation (`annotation_oid`), add constraint fk_item_annotation_annotation foreign key (`annotation_oid`) references `annotation` (`oid`);


-- User_Task [rel21]
create table `user_task` (
   `user_oid`  integer not null,
   `task_oid`  integer not null,
  primary key (`user_oid`, `task_oid`)
) ENGINE=InnoDB;
alter table `user_task`   add index fk_user_task_user (`user_oid`), add constraint fk_user_task_user foreign key (`user_oid`) references `user` (`oid`);
alter table `user_task`   add index fk_user_task_task (`task_oid`), add constraint fk_user_task_task foreign key (`task_oid`) references `task` (`oid`);


-- User_Skill [rel22]
create table `user_skill` (
   `user_oid`  integer not null,
   `skill_oid`  integer not null,
  primary key (`user_oid`, `skill_oid`)
) ENGINE=InnoDB;
alter table `user_skill`   add index fk_user_skill_user (`user_oid`), add constraint fk_user_skill_user foreign key (`user_oid`) references `user` (`oid`);
alter table `user_skill`   add index fk_user_skill_skill (`skill_oid`), add constraint fk_user_skill_skill foreign key (`skill_oid`) references `skill` (`oid`);


-- User_Annotation [rel23]
alter table `annotation`  add column  `user_oid`  integer;
alter table `annotation`   add index fk_annotation_user (`user_oid`), add constraint fk_annotation_user foreign key (`user_oid`) references `user` (`oid`);


-- User_AnnotationCampaign [rel24]
alter table `annotationcampaign`  add column  `user_oid`  integer;
alter table `annotationcampaign`   add index fk_annotationcampaign_user (`user_oid`), add constraint fk_annotationcampaign_user foreign key (`user_oid`) references `user` (`oid`);


