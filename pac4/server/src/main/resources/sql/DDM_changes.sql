--
-- ***************************************
-- * SQL mods
-- ***************************************
-- * Uoc Primavera 2013,
-- * Grup06
-- * Fecha: 2013.05.10 12.05.13
-- * @author jiquintana (jiquintana@uoc.edu)
-- */

BEGIN WORK;

SET CONSTRAINTS ALL DEFERRED;
alter table usuari disable trigger all;

INSERT INTO usuari (id, taller, usuari, perfil, contrasenya, actiu, dataalta, datamodificacio, databaixa, reparacionsassignades)
VALUES (-1, -1, 'vacio', 'vacio', 'NULL', false, '2013-05-12', NULL, NULL, 0);

INSERT INTO captaller
(idcaptaller)
VALUES (-1);

INSERT INTO taller (id, cif, adreca, capacitat, captaller, telefon, web, actiu, dataapertura, datamodificacio, databaixa)
VALUES (-1, '00000000', 'vacio', 1, -1, '00000000', 'vacio', false, '2013-05-12', NULL, NULL);

INSERT INTO mecanic (idmecanic, disponible, idrep1, idrep2)
VALUES (-1, false, -1, -1);

INSERT INTO reparacio (ordrereparacio, idcaptaller, acceptada, idmecanic, assignada, comptador, observacions, numcom, dataassignacio, datainici, datafi)
VALUES (-1, -1, false, -1, false, 0, 'vacio', -1, NULL, NULL, NULL);

INSERT INTO asseguradora (idasseguradora, cif, nom, adreca, telefon)
VALUES (-1, '000000000', 'vacio', 'vacio', 0);

alter table usuari enable trigger all;

COMMIT;

-----------------------
-------- SS1 ----------
-----------------------

--Insertamos el usuario administrador por defecto: admin/admin
INSERT INTO Usuari (Taller, usuari, perfil, contrasenya, actiu, dataAlta, dataModificacio, dataBaixa, reparacionsassignades) VALUES ( NULL, 'admin', 'ADMINISTRADOR', 'admin', true, NULL, NULL, 0);
--Cambiamos el tipus usuari de los datos precargados
update Usuari set perfil= 'ADMINISTRATIU' where perfil='Administratiu';
--Añadimos nombre a los talleres precargados
update Taller set nom='Taller1' where id=1;
update Taller set nom='Taller2' where id=2;
update Taller set nom='Taller3' where id=3;
update Taller set nom='Taller4' where id=4;
update Taller set nom='Taller5' where id=5;
-----------------------
--- Fin cambios SS1 ---
-----------------------
