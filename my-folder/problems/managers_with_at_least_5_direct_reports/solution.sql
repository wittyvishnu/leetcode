# Write your MySQL query statement below
select e2.name
from Employee e1
join Employee e2 on e2.id=e1.managerId
group by e1.managerId
having count(*)>=5;

