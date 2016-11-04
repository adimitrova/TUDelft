-- User_Payment [rel1]
alter table `user`  add column  `payment_oid_payment`  integer;
alter table `user`   add index fk_user_payment (`payment_oid_payment`), add constraint fk_user_payment foreign key (`payment_oid_payment`) references `payment` (`oid_payment`);


