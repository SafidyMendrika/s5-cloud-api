CREATE OR REPLACE VIEW v_current_commission AS
    SELECT 
        *
    FROM commissions c 
    where date_insertion = (select max(date_insertion) from commissions);