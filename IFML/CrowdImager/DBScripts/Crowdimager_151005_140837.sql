-- User [User]
alter table "public"."user"  add column  "birth_date"  timestamp;
alter table "public"."user"  add column  "name"  varchar(255);
alter table "public"."user"  add column  "piggy_bank"  float8;


-- User_Task [rel12]
create table "public"."user_task" (
   "user_oid"  int4 not null,
   "task_oid"  int4 not null,
  primary key ("user_oid", "task_oid")
);
alter table "public"."user_task"   add constraint fk_user_task_user foreign key ("user_oid") references "public"."user" ("oid");
alter table "public"."user_task"   add constraint fk_user_task_task foreign key ("task_oid") references "public"."task" ("oid");


-- User_Skill [rel13]
create table "public"."user_skill" (
   "user_oid"  int4 not null,
   "skill_oid"  int4 not null,
  primary key ("user_oid", "skill_oid")
);
alter table "public"."user_skill"   add constraint fk_user_skill_user foreign key ("user_oid") references "public"."user" ("oid");
alter table "public"."user_skill"   add constraint fk_user_skill_skill foreign key ("skill_oid") references "public"."skill" ("oid");


-- User_Annotation [rel14]
alter table "public"."annotation"  add column  "user_oid"  int4;
alter table "public"."annotation"   add constraint fk_annotation_user foreign key ("user_oid") references "public"."user" ("oid");


-- User_AnnotationCampaign [rel15]
alter table "public"."annotationcampaign"  add column  "user_oid"  int4;
alter table "public"."annotationcampaign"   add constraint fk_annotationcampaign_user foreign key ("user_oid") references "public"."user" ("oid");


