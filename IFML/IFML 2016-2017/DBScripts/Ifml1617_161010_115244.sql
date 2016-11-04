-- Contributions_bySupporters [ent5]
alter table `contributions_bysupporters`  add column  `feedback`  integer;


-- User_Questions [rel8]
create table `user_questions` (
   `user_oid_user`  integer not null,
   `questions_oid_questions`  integer not null,
  primary key (`user_oid_user`, `questions_oid_questions`)
) ENGINE=InnoDB;
alter table `user_questions`   add index fk_user_questions_user (`user_oid_user`), add constraint fk_user_questions_user foreign key (`user_oid_user`) references `user` (`oid_user`);
alter table `user_questions`   add index fk_user_questions_questions (`questions_oid_questions`), add constraint fk_user_questions_questions foreign key (`questions_oid_questions`) references `questions` (`oid_questions`);


-- ContributionsperksUser [rel12]
create view `contributionsperkstouser_view` as
select distinct AL1.`oid_contr` as `s_oid_contr`, AL2.`user_oid_user` as `T_user_oid_user`
from  `contributionsperks` AL1 
               inner join `contributions_bysupporters` AL2 on AL1.`oid_contr`=AL2.`contributionsperks_oid_contr`;


-- Campaigns_Contributor [rel9]
create view `campaigns_contributor_view` as
select distinct AL1.`oid_camp` as `s_oid_camp`, AL2.`user_oid_user` as `T_user_oid_user`
from  `campaigns` AL1 
               inner join `contributions_bysupporters` AL2 on AL1.`oid_camp`=AL2.`campaigns_oid_camp`;


