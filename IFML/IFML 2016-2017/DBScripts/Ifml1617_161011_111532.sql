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
   "name"  varchar(255),
   "wisdomscore"  int4,
   "payment"  int4,
  primary key ("oid_user")
);


-- Payment [ent1]
create table "public"."payment" (
   "oid_payment"  int4  not null,
   "currency"  varchar(255),
   "type"  varchar(255),
  primary key ("oid_payment")
);


-- Campaigns [ent2]
create table "public"."campaigns" (
   "oid_camp"  int4  not null,
   "title"  varchar(255),
   "description"  varchar(255),
   "amount"  float8,
   "status"  varchar(255),
   "expiration"  timestamp,
   "raised"  float8,
  primary key ("oid_camp")
);


-- Questions [ent3]
create table "public"."questions" (
   "oid_questions"  int4  not null,
   "question"  varchar(255),
   "answer"  varchar(255),
   "status"  varchar(255),
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
   "amount"  float8,
   "feedback"  int4,
  primary key ("oid_usercontr")
);


-- ContributionsPerks [ent6]
create table "public"."contributionsperks" (
   "oid_contr"  int4  not null,
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


-- Campaigns_ContributionsbySupporters [rel10]
alter table "public"."contributions_bysupporters"  add column  "campaigns_oid_camp"  int4;
alter table "public"."contributions_bysupporters"   add constraint fk_contributions_bysupporter_3 foreign key ("campaigns_oid_camp") references "public"."campaigns" ("oid_camp");


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


-- Perks_Contributions [rel5]
alter table "public"."contributions_bysupporters"  add column  "contributionsperks_oid_contr"  int4;
alter table "public"."contributions_bysupporters"   add constraint fk_contributions_bysupporters foreign key ("contributionsperks_oid_contr") references "public"."contributionsperks" ("oid_contr");


-- Campaigns_ContrPerks [rel6]
create table "public"."campaigns_contrperks" (
   "campaigns_oid_camp"  int4 not null,
   "contributionsperks_oid_contr"  int4 not null,
  primary key ("campaigns_oid_camp", "contributionsperks_oid_contr")
);
alter table "public"."campaigns_contrperks"   add constraint fk_campaigns_contrperks_campai foreign key ("campaigns_oid_camp") references "public"."campaigns" ("oid_camp");
alter table "public"."campaigns_contrperks"   add constraint fk_campaigns_contrperks_contri foreign key ("contributionsperks_oid_contr") references "public"."contributionsperks" ("oid_contr");


-- User_Contributions_bySupporters [rel7]
alter table "public"."contributions_bysupporters"  add column  "user_oid_user"  int4;
alter table "public"."contributions_bysupporters"   add constraint fk_contributions_bysupporter_2 foreign key ("user_oid_user") references "public"."user" ("oid_user");


-- User_Questions [rel8]
create table "public"."user_questions" (
   "user_oid_user"  int4 not null,
   "questions_oid_questions"  int4 not null,
  primary key ("user_oid_user", "questions_oid_questions")
);
alter table "public"."user_questions"   add constraint fk_user_questions_user foreign key ("user_oid_user") references "public"."user" ("oid_user");
alter table "public"."user_questions"   add constraint fk_user_questions_questions foreign key ("questions_oid_questions") references "public"."questions" ("oid_questions");


-- Campaigns.Quality [ent2#att26]
create view "public"."campaigns_quality_view" as
select AL1."oid_camp" as "oid_camp", avg(AL2."feedback") as "der_attr"
from  "public"."campaigns" AL1 
               left outer join "public"."contributions_bysupporters" AL2 on AL1."oid_camp"=AL2."campaigns_oid_camp"
group by AL1."oid_camp";


-- User.Reputation [User#att44]
create view "public"."user_reputation_view2" as
select AL1."oid_user" as "oid_user", avg(AL3."der_attr") as "der_attr"
from  "public"."user" AL1 
               left outer join "public"."campaigns" AL2 on AL1."oid_user"=AL2."user_oid_user"
               left outer join "public"."campaigns_quality_view" AL3 on AL2."oid_camp"=AL3."oid_camp"
group by AL1."oid_user";


-- Campaigns.Popularity [ent2#att27]
create view "public"."campaigns_popularity_view" as
select AL1."oid_camp" as "oid_camp", count(distinct AL2."oid_usercontr") as "der_attr"
from  "public"."campaigns" AL1 
               left outer join "public"."contributions_bysupporters" AL2 on AL1."oid_camp"=AL2."campaigns_oid_camp"
group by AL1."oid_camp";


-- ContributionsperksUser [rel12]
create view "public"."contributionsperkstouser_view" as
select distinct AL1."oid_contr" as "s_oid_contr", AL2."user_oid_user" as "T_user_oid_user"
from  "public"."contributionsperks" AL1 
               inner join "public"."contributions_bysupporters" AL2 on AL1."oid_contr"=AL2."contributionsperks_oid_contr";


-- Campaigns_Contributor [rel9]
create view "public"."campaigns_contributor_view" as
select distinct AL1."oid_camp" as "s_oid_camp", AL2."user_oid_user" as "T_user_oid_user"
from  "public"."campaigns" AL1 
               inner join "public"."contributions_bysupporters" AL2 on AL1."oid_camp"=AL2."campaigns_oid_camp";


