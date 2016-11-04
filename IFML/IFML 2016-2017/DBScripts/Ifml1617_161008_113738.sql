-- User_Contributions_bySupporters [rel7]
alter table `contributions_bysupporters`  add column  `user_oid_user`  integer;
alter table `contributions_bysupporters`   add index fk_contributions_bysupporter_3 (`user_oid_user`), add constraint fk_contributions_bysupporter_3 foreign key (`user_oid_user`) references `user` (`oid_user`);


