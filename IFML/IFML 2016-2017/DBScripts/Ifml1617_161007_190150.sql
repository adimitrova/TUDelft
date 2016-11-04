-- User.payment_type [User#att45]
create view `user_payment_type_view` as
select AL1.`oid_user` as `oid_user`, AL2.`type` as `der_attr`
from  `user` AL1 
               left outer join `payment` AL2 on AL1.`payment_oid_payment`=AL2.`oid_payment`
where AL1.`payment` = AL2.`oid_payment`;


