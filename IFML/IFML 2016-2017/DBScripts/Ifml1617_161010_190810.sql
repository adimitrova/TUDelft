-- User.Reputation [User#att44]
create view `user_reputation_view` as
select AL1.`oid_user` as `oid_user`, avg(AL3.`der_attr`) as `der_attr`
from  `user` AL1 
               left outer join `campaigns` AL2 on AL1.`oid_user`=AL2.`user_oid_user`
               left outer join `campaigns_quality_view` AL3 on AL2.`oid_camp`=AL3.`oid_camp`
group by AL1.`oid_user`;


