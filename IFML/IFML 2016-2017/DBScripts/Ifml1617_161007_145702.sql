-- User_ContributionsPerks [rel11]
alter table `contributionsperks`  add column  `user_oid_user`  integer;
alter table `contributionsperks`   add index fk_contributionsperks_user (`user_oid_user`), add constraint fk_contributionsperks_user foreign key (`user_oid_user`) references `user` (`oid_user`);


