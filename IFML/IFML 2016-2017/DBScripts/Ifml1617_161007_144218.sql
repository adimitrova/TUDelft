-- Group [Group]
create table "public"."group" (
   "oid_group"  int4  not null,
   "groupname"  varchar(255),
  primary key ("oid_group")
);


-- Module [Module]
create table "public"."module" (
   "oid_module"  int4  not null,
   "moduleid"  varchar(255),
   "modulename"  varchar(255),
  primary key ("oid_module")
);


-- User [User]
create table "public"."user" (
   "oid_user"  int4  not null,
   "username"  varchar(255),
   "password"  varchar(255),
   "email"  varchar(255),
   "birthday"  varchar(255),
   "payment"  varchar(255),
   "name"  varchar(255),
   "wisdomscore"  varchar(255),
  primary key ("oid_user")
);


-- Payment [ent1]
create table "public"."payment" (
   "oid_payment"  int4  not null,
   "creditcardnumber"  varchar(255),
   "currency"  varchar(255),
   "expirationdate"  date,
  primary key ("oid_payment")
);


-- Campaigns [ent2]
create table "public"."campaigns" (
   "oid_camp"  int4  not null,
   "title"  varchar(255),
   "description"  varchar(255),
   "amount"  int4,
   "status"  bool,
   "quality"  int4,
   "popularity"  varchar(255),
   "expiration"  timestamp,
  primary key ("oid_camp")
);


-- Questions [ent3]
create table "public"."questions" (
   "oid_questions"  int4  not null,
   "question"  varchar(255),
   "answer"  varchar(255),
   "status"  bool,
  primary key ("oid_questions")
);


-- KeywordsTAGS [ent4]
create table "public"."keywordstags" (
   "oid_keywords"  int4  not null,
   "keyword"  varchar(255),
  primary key ("oid_keywords")
);


-- Contributions_bySupporters [ent5]
create table "public"."contributions_bysupporters" (
   "oid_usercontr"  int4  not null,
   "amount"  varchar(255),
   "user_id"  varchar(255),
  primary key ("oid_usercontr")
);


-- ContributionsPerks [ent6]
create table "public"."contributionsperks" (
   "oid_contr"  int4  not null,
   "userid"  int4,
   "campaignid"  int4,
   "titleperk"  varchar(255),
   "description"  varchar(255),
   "min_amount"  int4,
   "expirationperk"  date,
  primary key ("oid_contr")
);


-- Group_DefaultModule [Group2DefaultModule_DefaultModule2Group]
alter table "public"."group"  add column  "module_oid_module"  int4;
alter table "public"."group"   add constraint fk_group_module foreign key ("module_oid_module") references "public"."module" ("oid_module");


-- Group_Module [Group2Module_Module2Group]
create table "public"."group_module" (
   "group_oid_group"  int4 not null,
   "module_oid_module"  int4 not null,
  primary key ("group_oid_group", "module_oid_module")
);
alter table "public"."group_module"   add constraint fk_group_module_group foreign key ("group_oid_group") references "public"."group" ("oid_group");
alter table "public"."group_module"   add constraint fk_group_module_module foreign key ("module_oid_module") references "public"."module" ("oid_module");


-- User_DefaultGroup [User2DefaultGroup_DefaultGroup2User]
alter table "public"."user"  add column  "group_oid_group"  int4;
alter table "public"."user"   add constraint fk_user_group foreign key ("group_oid_group") references "public"."group" ("oid_group");


-- User_Group [User2Group_Group2User]
create table "public"."user_group" (
   "user_oid_user"  int4 not null,
   "group_oid_group"  int4 not null,
  primary key ("user_oid_user", "group_oid_group")
);
alter table "public"."user_group"   add constraint fk_user_group_user foreign key ("user_oid_user") references "public"."user" ("oid_user");
alter table "public"."user_group"   add constraint fk_user_group_group foreign key ("group_oid_group") references "public"."group" ("oid_group");


-- User_Payment [rel1]
alter table "public"."user"  add column  "payment_oid_payment"  int4;
alter table "public"."user"   add constraint fk_user_payment foreign key ("payment_oid_payment") references "public"."payment" ("oid_payment");


-- Campaigns_Contributions_byUsers [rel10]
alter table "public"."contributions_bysupporters"  add column  "campaigns_oid_camp"  int4;
alter table "public"."contributions_bysupporters"   add constraint fk_contributions_bysupporters foreign key ("campaigns_oid_camp") references "public"."campaigns" ("oid_camp");


-- Campaigns_Keywords [rel2]
create table "public"."campaigns_keywords" (
   "campaigns_oid_camp"  int4 not null,
   "keywordstags_oid_keywords"  int4 not null,
  primary key ("campaigns_oid_camp", "keywordstags_oid_keywords")
);
alter table "public"."campaigns_keywords"   add constraint fk_campaigns_keywords_campaign foreign key ("campaigns_oid_camp") references "public"."campaigns" ("oid_camp");
alter table "public"."campaigns_keywords"   add constraint fk_campaigns_keywords_keywords foreign key ("keywordstags_oid_keywords") references "public"."keywordstags" ("oid_keywords");


-- Campaigns_Questions [rel3]
alter table "public"."questions"  add column  "campaigns_oid_camp"  int4;
alter table "public"."questions"   add constraint fk_questions_campaigns foreign key ("campaigns_oid_camp") references "public"."campaigns" ("oid_camp");


-- User_Campaigns [rel4]
alter table "public"."campaigns"  add column  "user_oid_user"  int4;
alter table "public"."campaigns"   add constraint fk_campaigns_user foreign key ("user_oid_user") references "public"."user" ("oid_user");


-- Campaigns_ContributionsByUser [rel5]
alter table "public"."contributions_bysupporters"  add column  "contributionsperks_oid_contr"  int4;
alter table "public"."contributions_bysupporters"   add constraint fk_contributions_bysupporter_2 foreign key ("contributionsperks_oid_contr") references "public"."contributionsperks" ("oid_contr");


-- Campaigns_ContrPerks [rel6]
create table "public"."campaigns_contrperks" (
   "campaigns_oid_camp"  int4 not null,
   "contributionsperks_oid_contr"  int4 not null,
  primary key ("campaigns_oid_camp", "contributionsperks_oid_contr")
);
alter table "public"."campaigns_contrperks"   add constraint fk_campaigns_contrperks_campai foreign key ("campaigns_oid_camp") references "public"."campaigns" ("oid_camp");
alter table "public"."campaigns_contrperks"   add constraint fk_campaigns_contrperks_contri foreign key ("contributionsperks_oid_contr") references "public"."contributionsperks" ("oid_contr");


