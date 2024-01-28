CREATE OR REPLACE VIEW v_current_commission AS
    SELECT 
        *
    FROM commissions c 
    where date_insertion = (select max(date_insertion) from commissions) LIMIT 1;



-- statistiques : 

-- benefices
CREATE OR REPLACE VIEW v_benefice AS 
    SELECT 
        COALESCE(sum(benefice),0) as benefice 
    FROM 
        benefices;


-- pourcentage d'annonce vendu
CREATE OR REPLACE VIEW v_count_annonce AS 
    SELECT 
        count(*)
    FROM annonces
    WHERE etat_annonce >= 0;

CREATE OR REPLACE VIEW v_count_annonce_vendu AS 
    SELECT 
        count(*)
    FROM annonces
    WHERE etat_annonce = 20;

CREATE OR REPLACE VIEW v_count_annonce_join_vendu AS
    SELECT 
        (select * from v_count_annonce) as annonces,
        (select * from v_count_annonce_vendu) as vendus;
   

-- top annonces favorites

CREATE OR REPLACE VIEW v_top_annonces AS
    SELECT 
        idAnnonce,
        count(*) 
    FROM 
        annonces_favorites 
    GROUP BY idAnnonce 
    ORDER BY count desc;



CREATE OR REPLACE VIEW v_annonce_valide AS 
    SELECT 
        *
    FROM annonces 
    WHERE etat_annonce = 20;


CREATE OR REPLACE FUNCTION generate_series_month(year int)
RETURNS TABLE(mois timestamp) AS $$
BEGIN
    RETURN QUERY SELECT generate_series(
        DATE (year || '-01-01'),
        DATE (year || '-12-31'),
        INTERVAL '1 month'
    )::timestamp AS mois;
END;
$$ LANGUAGE plpgsql;



CREATE OR REPLACE FUNCTION get_annonces_et_benefices(year int)
RETURNS TABLE(mois integer, nombre_annonces_benefices integer, nombre_total_annonces integer) AS $$
BEGIN
    RETURN QUERY
    SELECT
        extract(MONTH from g.mois)::integer as mois,
        COALESCE(COUNT(DISTINCT b.id_benefice), 0)::integer AS nombre_annonces_benefices,
        COALESCE(COUNT(DISTINCT a.id_annonce), 0)::integer AS nombre_total_annonces
    FROM generate_series_month(year) g
    LEFT JOIN benefices b ON date_trunc('month', b.date) = g.mois AND EXTRACT(YEAR FROM b.date) = year
    LEFT JOIN annonces a ON date_trunc('month', a.date_annonce) = g.mois AND EXTRACT(YEAR FROM a.date_annonce) = year
    GROUP BY g.mois
    ORDER BY g.mois;
END;
$$ LANGUAGE plpgsql;