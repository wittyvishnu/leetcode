# Write your MySQL query statement below
select person_name from (
    select person_name,
    sum(weight) over(order by turn) as running_weights
    from Queue
) q
where running_weights<=1000
order by running_weights desc
Limit 1