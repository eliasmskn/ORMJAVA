************************************Interdiction de suppression si programmé dans le planning*************************************************
Delimiter //
create trigger DEL_PROF_AFF
after delete on professeur for each row
begin

declare numrows INTEGER;
declare msg varchar(128);

     select count(*) into numrows
     from affectation
     where
          affectation.id_prof = :old.id_prof;
     if (numrows > 0) then
          set msg = concat('Erreur Trigger BD: professeur en cours d affectation: ', cast(new.id as char));
          signal sqlstate '45000' set message_text = msg;
     end if;

end;
//
Delimiter;


create trigger DEL_SALLE_AFF
after delete on salle for each row
declare numrows INTEGER;
begin

     select count(*) into numrows
     from affectation
     where
          affectation.id_salle = :old.id_salle;
     if (numrows > 0) then
          raise_application_error(
          -20001,
          'Impossible de supprimer "Cette salle", affectation en cours !!! .');
     end if;

end;
/


create trigger DEL_MAT_AFF
after delete on matiere for each row
declare numrows INTEGER;
begin

     select count(*) into numrows
     from affectation
     where
          affectation.id_matiere = :old.id_matiere;
     if (numrows > 0) then
          raise_application_error(
          -20001,
          'Impossible de supprimer "Cette matiere", affectation en cours !!! .');
     end if;

end;
/



create trigger DEL_CLASSE_AFF
after delete on classe for each row
declare numrows INTEGER;
begin

     select count(*) into numrows
     from affectation
     where
          affectation.id_classe = :old.id_classe;
     if (numrows > 0) then
          raise_application_error(
          -20001,
          'Impossible de supprimer "Cette classe", affectation en cours !!! .');
     end if;

end;
/



create trigger DEL_PROF_AFF
after delete on professeur for each row
declare numrows INTEGER;
begin

     select count(*) into numrows
     from affectation
     where
          affectation.id_prof = :old.id_prof;
     if (numrows > 0) then
          raise_application_error(
          -20001,
          'Impossible de supprimer "Ce professeur", affectation en cours !!! .');
     end if;

end;
/

************************************Trigger de suppression  on cascade si programmé dans le planning*************************************************


CREATE TRIGGER Suppr_prof
BEFORE DELETE ON professeur
FOR EACH ROW
DELETE FROM affectation
WHERE affectation.id_prof = Old.id_prof;

CREATE TRIGGER Suppr_classe
BEFORE DELETE ON classe
FOR EACH ROW
DELETE FROM affectation
WHERE affectation.id_classe = Old.id_classe;

CREATE TRIGGER Suppr_matiere
BEFORE DELETE ON matiere
FOR EACH ROW
DELETE FROM affectation
WHERE affectation.matiere = Old.matiere;

CREATE TRIGGER Suppr_salle
BEFORE DELETE ON salle
FOR EACH ROW
DELETE FROM affectation
WHERE affectation.id_salle = Old.id_salle;


********************************************************************************************************************************************
