-- Task [ent1]
create table "public"."task" (
   "oid"  int4  not null,
   "title"  varchar(255),
   "description"  varchar(255),
   "reward"  float8,
   "expiration_date"  timestamp,
   "maximum_exec_time"  time,
  primary key ("oid")
);


-- Item [ent2]
create table "public"."item" (
   "oid"  int4  not null,
   "url"  varchar(255),
   "caption"  varchar(255),
   "title"  varchar(255),
  primary key ("oid")
);


-- Worker [ent3]
create table "public"."worker" (
   "oid"  int4  not null,
   "piggy_bank"  varchar(255),
   "birth_date"  timestamp,
   "name"  varchar(255),
  primary key ("oid")
);


-- Skill [ent4]
create table "public"."skill" (
   "oid"  int4  not null,
   "name"  varchar(255),
  primary key ("oid")
);


-- Annotation [ent5]
create table "public"."annotation" (
   "oid"  int4  not null,
   "confidence"  int4,
   "label"  varchar(255),
  primary key ("oid")
);


-- AnnotationCampaign [ent6]
create table "public"."annotationcampaign" (
   "oid"  int4  not null,
   "status"  varchar(255),
   "budget"  float8,
   "name"  varchar(255),
  primary key ("oid")
);


-- Requester [ent7]
create table "public"."requester" (
   "oid"  int4  not null,
  primary key ("oid")
);


-- Requester_AnnotationCampaign [rel10]
alter table "public"."annotationcampaign"  add column  "requester_oid"  int4;
alter table "public"."annotationcampaign"   add constraint fk_annotationcampaign_requeste foreign key ("requester_oid") references "public"."requester" ("oid");


-- Requester_User [rel11]
alter table "public"."user"  add column  "requester_oid"  int4;
alter table "public"."user"   add constraint fk_user_requester foreign key ("requester_oid") references "public"."requester" ("oid");


-- Task_Skill [rel2]
create table "public"."task_skill" (
   "task_oid"  int4 not null,
   "skill_oid"  int4 not null,
  primary key ("task_oid", "skill_oid")
);
alter table "public"."task_skill"   add constraint fk_task_skill_task foreign key ("task_oid") references "public"."task" ("oid");
alter table "public"."task_skill"   add constraint fk_task_skill_skill foreign key ("skill_oid") references "public"."skill" ("oid");


-- Worker_Skill [rel3]
create table "public"."worker_skill" (
   "worker_oid"  int4 not null,
   "skill_oid"  int4 not null,
  primary key ("worker_oid", "skill_oid")
);
alter table "public"."worker_skill"   add constraint fk_worker_skill_worker foreign key ("worker_oid") references "public"."worker" ("oid");
alter table "public"."worker_skill"   add constraint fk_worker_skill_skill foreign key ("skill_oid") references "public"."skill" ("oid");


-- User_Worker [rel4]
alter table "public"."worker"  add column  "user_oid"  int4;
alter table "public"."worker"   add constraint fk_worker_user foreign key ("user_oid") references "public"."user" ("oid");


-- Task_Worker [rel5]
create table "public"."task_worker" (
   "task_oid"  int4 not null,
   "worker_oid"  int4 not null,
  primary key ("task_oid", "worker_oid")
);
alter table "public"."task_worker"   add constraint fk_task_worker_task foreign key ("task_oid") references "public"."task" ("oid");
alter table "public"."task_worker"   add constraint fk_task_worker_worker foreign key ("worker_oid") references "public"."worker" ("oid");


-- Worker_Annotation [rel6]
alter table "public"."annotation"  add column  "worker_oid"  int4;
alter table "public"."annotation"   add constraint fk_annotation_worker foreign key ("worker_oid") references "public"."worker" ("oid");


-- Item_Annotation [rel7]
create table "public"."item_annotation" (
   "item_oid"  int4 not null,
   "annotation_oid"  int4 not null,
  primary key ("item_oid", "annotation_oid")
);
alter table "public"."item_annotation"   add constraint fk_item_annotation_item foreign key ("item_oid") references "public"."item" ("oid");
alter table "public"."item_annotation"   add constraint fk_item_annotation_annotation foreign key ("annotation_oid") references "public"."annotation" ("oid");


-- AnnotationCampaign_Item [rel8]
alter table "public"."item"  add column  "annotationcampaign_oid"  int4;
alter table "public"."item"   add constraint fk_item_annotationcampaign foreign key ("annotationcampaign_oid") references "public"."annotationcampaign" ("oid");


-- AnnotationCampaign_Task [rel9]
alter table "public"."task"  add column  "annotationcampaign_oid"  int4;
alter table "public"."task"   add constraint fk_task_annotationcampaign foreign key ("annotationcampaign_oid") references "public"."annotationcampaign" ("oid");


