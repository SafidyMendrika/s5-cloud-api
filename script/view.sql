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
    ORDER BY count;

