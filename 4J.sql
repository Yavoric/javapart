/*sql requests for the selection of the following data:
to withdraw the number of subscribers for all mobile operators from 20 to 40 years, sort*/
SELECT 
    o.name, COUNT(*)
FROM
    abonent a,
    operator o,
    phone_book p,
    operator_number op
WHERE
    a.age > BETWEEN 20 AND 40
        AND a.abonent_id = p.abonent_id
        AND o.operator_id = op.operator_id
        AND op.number = p.number
GROUP BY o.name
ORDER BY COUNT(*) DESC