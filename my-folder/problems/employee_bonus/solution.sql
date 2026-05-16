# Write your MySQL query statement below
select e.name,b.bonus from Employee e
left join Bonus b on b.empid=e.empid
where bonus<1000 OR bonus is NULL; 
