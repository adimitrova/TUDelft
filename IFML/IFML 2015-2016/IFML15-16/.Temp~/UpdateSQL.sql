-- Group [Group]
create table "public"."group" (
   "oid"  int4  not null,
   "groupname"  varchar(255),
  primary key ("oid")
);


-- Module [Module]
create table "public"."module" (
   "oid"  int4  not null,
   "moduleid"  varchar(255),
   "modulename"  varchar(255),
  primary key ("oid")
);


-- User [User]
create table "public"."user" (
   "oid"  int4  not null,
   "username"  varchar(255),
   "password"  varchar(255),
   "email"  varchar(255),
   "birth_date"  timestamp,
   "name"  varchar(255),
   "score"  float8,
   "piggy_bank"  float8,
  primary key ("oid")
);


-- Skill [ent10]
create table "public"."skill" (
   "oid"  int4  not null,
   "name"  varchar(255),
  primary key ("oid")
);


-- Task [ent3]
create table "public"."task" (
   "oid"  int4  not null,
   "title"  varchar(255),
   "description"  varchar(255),
   "reward"  float8,
   "expiration_date"  timestamp,
   "maximum_exec_time"  time,
   "grade"  int4,
  primary key ("oid")
);


-- AnnotationCampaign [ent7]
create table "public"."annotationcampaign" (
   "oid"  int4  not null,
   "status"  varchar(255),
   "budget"  float8,
   "name"  varchar(255),
  primary key ("oid")
);


-- Item [ent8]
create table "public"."item" (
   "oid"  int4  not null,
   "url"  varchar(255),
   "caption"  varchar(255),
   "title"  varchar(255),
  primary key ("oid")
);


-- Annotation [ent9]
create table "public"."annotation" (
   "oid"  int4  not null,
   "confidence"  int4,
   "label"  varchar(255),
   "marked"  bool,
  primary key ("oid")
);


-- Group_DefaultModule [Group2DefaultModule_DefaultModule2Group]
alter table "public"."group"  add column  "module_oid"  int4;
alter table "public"."group"   add constraint fk_group_module foreign key ("module_oid") references "public"."module" ("oid");


-- Group_Module [Group2Module_Module2Group]
create table "public"."group_module" (
   "group_oid"  int4 not null,
   "module_oid"  int4 not null,
  primary key ("group_oid", "module_oid")
);
alter table "public"."group_module"   add constraint fk_group_module_group foreign key ("group_oid") references "public"."group" ("oid");
alter table "public"."group_module"   add constraint fk_group_module_module foreign key ("module_oid") references "public"."module" ("oid");


-- User_DefaultGroup [User2DefaultGroup_DefaultGroup2User]
alter table "public"."user"  add column  "group_oid"  int4;
alter table "public"."user"   add constraint fk_user_group foreign key ("group_oid") references "public"."group" ("oid");


-- User_Group [User2Group_Group2User]
create table "public"."user_group" (
   "user_oid"  int4 not null,
   "group_oid"  int4 not null,
  primary key ("user_oid", "group_oid")
);
alter table "public"."user_group"   add constraint fk_user_group_user foreign key ("user_oid") references "public"."user" ("oid");
alter table "public"."user_group"   add constraint fk_user_group_group foreign key ("group_oid") references "public"."group" ("oid");


-- User_Skill [rel10]
create table "public"."user_skill" (
   "user_oid"  int4 not null,
   "skill_oid"  int4 not null,
  primary key ("user_oid", "skill_oid")
);
alter table "public"."user_skill"   add constraint fk_user_skill_user foreign key ("user_oid") references "public"."user" ("oid");
alter table "public"."user_skill"   add constraint fk_user_skill_skill foreign key ("skill_oid") references "public"."skill" ("oid");


-- Task_Skill [rel11]
create table "public"."task_skill" (
   "task_oid"  int4 not null,
   "skill_oid"  int4 not null,
  primary key ("task_oid", "skill_oid")
);
alter table "public"."task_skill"   add constraint fk_task_skill_task foreign key ("task_oid") references "public"."task" ("oid");
alter table "public"."task_skill"   add constraint fk_task_skill_skill foreign key ("skill_oid") references "public"."skill" ("oid");


-- User_AnnotationCampaign [rel16]
alter table "public"."annotationcampaign"  add column  "user_oid"  int4;
alter table "public"."annotationcampaign"   add constraint fk_annotationcampaign_user foreign key ("user_oid") references "public"."user" ("oid");


-- Item_Annotation [rel3]
create table "public"."item_annotation" (
   "item_oid"  int4 not null,
   "annotation_oid"  int4 not null,
  primary key ("item_oid", "annotation_oid")
);
alter table "public"."item_annotation"   add constraint fk_item_annotation_item foreign key ("item_oid") references "public"."item" ("oid");
alter table "public"."item_annotation"   add constraint fk_item_annotation_annotation foreign key ("annotation_oid") references "public"."annotation" ("oid");


-- AnnotationCampaign_Task [rel4]
alter table "public"."task"  add column  "annotationcampaign_oid"  int4;
alter table "public"."task"   add constraint fk_task_annotationcampaign foreign key ("annotationcampaign_oid") references "public"."annotationcampaign" ("oid");


-- Task_Item [rel5]
create table "public"."task_item" (
   "task_oid"  int4 not null,
   "item_oid"  int4 not null,
  primary key ("task_oid", "item_oid")
);
alter table "public"."task_item"   add constraint fk_task_item_task foreign key ("task_oid") references "public"."task" ("oid");
alter table "public"."task_item"   add constraint fk_task_item_item foreign key ("item_oid") references "public"."item" ("oid");


-- User_Annotation [rel6]
alter table "public"."annotation"  add column  "user_oid"  int4;
alter table "public"."annotation"   add constraint fk_annotation_user foreign key ("user_oid") references "public"."user" ("oid");


-- User_Task [rel8]
create table "public"."user_task" (
   "user_oid"  int4 not null,
   "task_oid"  int4 not null,
  primary key ("user_oid", "task_oid")
);
alter table "public"."user_task"   add constraint fk_user_task_user foreign key ("user_oid") references "public"."user" ("oid");
alter table "public"."user_task"   add constraint fk_user_task_task foreign key ("task_oid") references "public"."task" ("oid");


