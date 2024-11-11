select * from empv2 order by department DESC;
select * from empv2 order by id;
select * from empv2 inner join ctc_structure on empv2.position = ctc_structure.position;
select * from ctc_structure left join empv2 on ctc_structure.position = empv2.position;
select * from empv2 right join ctc_structure on ctc_structure.position = empv2.position;
select * from ctc_structure full outer join empv2 on ctc_structure.position = empv2.position;

