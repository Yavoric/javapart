/*sql requests for the selection of the following data:
all subscribers by the list of numbers*/
SELECT 
    a.first_name,
    a.last_name,
    a.gender,
    a.age,
    p.number,
    p.date_of_registr,
    o.price,
    o.name,
    o.address
FROM
    abonent a,
    phone_book p,
    operator o,
    operator_number op
WHERE
    a.abonent_id = p.abonent_id
        AND o.operator_id = op.operator_id
        AND op.number = p.number
