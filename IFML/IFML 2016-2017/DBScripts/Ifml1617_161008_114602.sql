-- Campaigns.Popularity [ent2#att27]
create view `campaigns_popularity_view` as
select AL1.`oid_camp` as `oid_camp`, count(distinct AL2.`oid_usercontr`) as `der_attr`
from  `campaigns` AL1 
               left outer join `contributions_bysupporters` AL2 on AL1.`oid_camp`=AL2.`campaigns_oid_camp`
group by AL1.`oid_camp`;


