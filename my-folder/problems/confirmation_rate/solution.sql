SELECT 
    s.user_id,
    ROUND(
        case
        when  count(c.action)=0 then 0
        else  sum(c.action='confirmed')/count(c.action)
        end
        ,2
    ) AS confirmation_rate
FROM Signups s
LEFT JOIN Confirmations c
ON s.user_id = c.user_id
GROUP BY s.user_id;