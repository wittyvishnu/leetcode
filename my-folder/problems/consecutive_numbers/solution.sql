# Write your MySQL query statement below
SELECT DISTINCT num AS ConsecutiveNums
FROM(
    select num,
    LAG(num,1) OVER(ORDER BY id) AS prev1,
    LAG(num,2) OVER(ORDER BY id) AS prev2
    from Logs
    ) n
where num=prev1 AND num=prev2