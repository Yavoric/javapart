/*sql requests for the selection of the following data:
all mobile numbers of the selected subscriber*/

SELECT 
    a.first_name, a.last_name, p.number
FROM
    abonent a,
    phone_book p,
    operator o,
    operator_number op
WHERE
    a.abonent_id = 8
        AND a.abonent_id = p.abonent_id
        AND o.operator_id = op.operator_id
        AND op.number = p.number