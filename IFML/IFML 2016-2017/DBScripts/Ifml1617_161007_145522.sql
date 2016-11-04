-- Group [Group]
create table `group` (
   `oid_group`  integer  not null,
   `groupname`  varchar(255),
  primary key (`oid_group`)
) ENGINE=InnoDB;


-- Module [Module]
create table `module` (
   `oid_module`  integer  not null,
   `moduleid`  varchar(255),
   `modulename`  varchar(255),
  primary key (`oid_module`)
) ENGINE=InnoDB;


-- User [User]
create table `user` (
   `oid_user`  integer  not null,
   `username`  varchar(255),
   `password`  varchar(255),
   `email`  varchar(255),
   `birthday`  varchar(255),
   `payment`  varchar(255),
   `name`  varchar(255),
   `wisdomscore`  varchar(255),
  primary key (`oid_user`)
) ENGINE=InnoDB;


-- Payment [ent1]
create table `payment` (
   `oid_payment`  integer  not null,
   `creditcardnumber`  varchar(255),
   `currency`  varchar(255),
   `expirationdate`  date,
  primary key (`oid_payment`)
) ENGINE=InnoDB;


-- Campaigns [ent2]
create table `campaigns` (
   `oid_camp`  integer  not null,
   `title`  varchar(255),
   `description`  varchar(255),
   `amount`  integer,
   `status`  bit,
   `quality`  integer,
   `popularity`  varchar(255),
   `expiration`  datetime,
  primary key (`oid_camp`)
) ENGINE=InnoDB;


-- Questions [ent3]
create table `questions` (
   `oid_questions`  integer  not null,
   `question`  varchar(255),
   `answer`  varchar(255),
   `status`  bit,
  primary key (`oid_questions`)
) ENGINE=InnoDB;


-- KeywordsTAGS [ent4]
create table `keywordstags` (
   `oid_keywords`  integer  not null,
   `keyword`  varchar(255),
  primary key (`oid_keywords`)
) ENGINE=InnoDB;


-- Contributions_bySupporters [ent5]
create table `contributions_bysupporters` (
   `oid_usercontr`  integer  not null,
   `amount`  varchar(255),
   `user_id`  varchar(255),
  primary key (`oid_usercontr`)
) ENGINE=InnoDB;


-- ContributionsPerks [ent6]
create table `contributionsperks` (
   `oid_contr`  integer  not null,
   `userid`  integer,
   `campaignid`  integer,
   `titleperk`  varchar(255),
   `description`  varchar(255),
   `min_amount`  integer,
   `expirationperk`  date,
  primary key (`oid_contr`)
) ENGINE=InnoDB;


-- Group_DefaultModule [Group2DefaultModule_DefaultModule2Group]
alter table `group`  add column  `module_oid_module`  integer;
alter table `group`   add index fk_group_module (`module_oid_module`), add constraint fk_group_module foreign key (`module_oid_module`) references `module` (`oid_module`);


-- Group_Module [Group2Module_Module2Group]
create table `group_module` (
   `group_oid_group`  integer not null,
   `module_oid_module`  integer not null,
  primary key (`group_oid_group`, `module_oid_module`)
) ENGINE=InnoDB;
alter table `group_module`   add index fk_group_module_group (`group_oid_group`), add constraint fk_group_module_group foreign key (`group_oid_group`) references `group` (`oid_group`);
alter table `group_module`   add index fk_group_module_module (`module_oid_module`), add constraint fk_group_module_module foreign key (`module_oid_module`) references `module` (`oid_module`);


-- User_DefaultGroup [User2DefaultGroup_DefaultGroup2User]
alter table `user`  add column  `group_oid_group`  integer;
alter table `user`   add index fk_user_group (`group_oid_group`), add constraint fk_user_group foreign key (`group_oid_group`) references `group` (`oid_group`);


-- User_Group [User2Group_Group2User]
create table `user_group` (
   `user_oid_user`  integer not null,
   `group_oid_group`  integer not null,
  primary key (`user_oid_user`, `group_oid_group`)
) ENGINE=InnoDB;
alter table `user_group`   add index fk_user_group_user (`user_oid_user`), add constraint fk_user_group_user foreign key (`user_oid_user`) references `user` (`oid_user`);
alter table `user_group`   add index fk_user_group_group (`group_oid_group`), add constraint fk_user_group_group foreign key (`group_oid_group`) references `group` (`oid_group`);


-- User_Payment [rel1]
alter table `user`  add column  `payment_oid_payment`  integer;
alter table `user`   add index fk_user_payment (`payment_oid_payment`), add constraint fk_user_payment foreign key (`payment_oid_payment`) references `payment` (`oid_payment`);


-- Campaigns_Contributions_byUsers [rel10]
alter table `contributions_bysupporters`  add column  `campaigns_oid_camp`  integer;
alter table `contributions_bysupporters`   add index fk_contributions_bysupporter_2 (`campaigns_oid_camp`), add constraint fk_contributions_bysupporter_2 foreign key (`campaigns_oid_camp`) references `campaigns` (`oid_camp`);


-- Campaigns_Keywords [rel2]
create table `campaigns_keywords` (
   `campaigns_oid_camp`  integer not null,
   `keywordstags_oid_keywords`  integer not null,
  primary key (`campaigns_oid_camp`, `keywordstags_oid_keywords`)
) ENGINE=InnoDB;
alter table `campaigns_keywords`   add index fk_campaigns_keywords_campaign (`campaigns_oid_camp`), add constraint fk_campaigns_keywords_campaign foreign key (`campaigns_oid_camp`) references `campaigns` (`oid_camp`);
alter table `campaigns_keywords`   add index fk_campaigns_keywords_keywords (`keywordstags_oid_keywords`), add constraint fk_campaigns_keywords_keywords foreign key (`keywordstags_oid_keywords`) references `keywordstags` (`oid_keywords`);


-- Campaigns_Questions [rel3]
alter table `questions`  add column  `campaigns_oid_camp`  integer;
alter table `questions`   add index fk_questions_campaigns (`campaigns_oid_camp`), add constraint fk_questions_campaigns foreign key (`campaigns_oid_camp`) references `campaigns` (`oid_camp`);


-- User_Campaigns [rel4]
alter table `campaigns`  add column  `user_oid_user`  integer;
alter table `campaigns`   add index fk_campaigns_user (`user_oid_user`), add constraint fk_campaigns_user foreign key (`user_oid_user`) references `user` (`oid_user`);


-- Campaigns_ContributionsByUser [rel5]
alter table `contributions_bysupporters`  add column  `contributionsperks_oid_contr`  integer;
alter table `contributions_bysupporters`   add index fk_contributions_bysupporters (`contributionsperks_oid_contr`), add constraint fk_contributions_bysupporters foreign key (`contributionsperks_oid_contr`) references `contributionsperks` (`oid_contr`);


-- Campaigns_ContrPerks [rel6]
create table `campaigns_contrperks` (
   `campaigns_oid_camp`  integer not null,
   `contributionsperks_oid_contr`  integer not null,
  primary key (`campaigns_oid_camp`, `contributionsperks_oid_contr`)
) ENGINE=InnoDB;
alter table `campaigns_contrperks`   add index fk_campaigns_contrperks_campai (`campaigns_oid_camp`), add constraint fk_campaigns_contrperks_campai foreign key (`campaigns_oid_camp`) references `campaigns` (`oid_camp`);
alter table `campaigns_contrperks`   add index fk_campaigns_contrperks_contri (`contributionsperks_oid_contr`), add constraint fk_campaigns_contrperks_contri foreign key (`contributionsperks_oid_contr`) references `contributionsperks` (`oid_contr`);


