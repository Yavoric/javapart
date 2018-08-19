/*sql requests for the selection of the following data:
operator with the largest number of mobile numbers*/
SELECT 
    o.name, COUNT(*) AS quantity_numbers
FROM
    operator o,
    phone_book p,
    operator_number op
WHERE
    op.operator_id = o.operator_id
        AND p.number = op.number
GROUP BY o.name
ORDER BY COUNT(*) DESC
LIMIT 1