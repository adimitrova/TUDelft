-- Campaigns.Quality [ent2#att26]
create view `campaigns_quality_view` as
select AL1.`oid_camp` as `oid_camp`, avg(AL2.`feedback`) as `der_attr`
from  `campaigns` AL1 
               left outer join `contributions_bysupporters` AL2 on AL1.`oid_camp`=AL2.`campaigns_oid_camp`
group by AL1.`oid_camp`;


