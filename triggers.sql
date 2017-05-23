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

********************************************************************************************************************************************
