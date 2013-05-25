--
-- ***************************************
-- * SQL mods
-- ***************************************
-- * Uoc Primavera 2013,
-- * Grup06
-- * Fecha: 2013.05.10 10.05.13
-- * @author jiquintana (jiquintana@uoc.edu)
-- */

-- Actualización del date style
ALTER DATABASE "TDP_GRUP6" SET DateStyle='European';

--
-- Actualizacion de dataalta automatica on inserts
-- Tablas Client + Solicitud
CREATE OR REPLACE FUNCTION update_dataalta() RETURNS TRIGGER AS $$
BEGIN
	NEW.dataalta := now();
        RETURN NEW;
END; $$
LANGUAGE plpgsql;


-- ****************
-- Modificacion tabla client::
-- ****************

--	creacion de secuencia a max(numclient)+1
--
CREATE SEQUENCE client_id_seq;
select setval('client_id_seq', (select max(numclient) from client) + 1);

--
-- cambio valor defecto numclient a siguiente valor secuencia
alter table client alter column numclient set default nextval('client_id_seq');

--
-- Eliminamos constrain not null dataalta
alter table client alter column dataalta drop not null;

--
-- creacion trigger actualizacion dataalta on insert
CREATE TRIGGER update_dataalta
BEFORE INSERT ON client
FOR EACH ROW EXECUTE PROCEDURE update_dataalta();


-- ****************
-- Modificacion tabla solicitud::
-- ****************

--
-- Creamos una nueva columna idtaller
alter table solicitud add column idtaller integer;

--	creacion de secuencia a max(numsol)+1
--
CREATE SEQUENCE solicitud_numsol_seq;
select setval('solicitud_numsol_seq', (select max(numsol) from solicitud) + 1);
--
-- cambio valor defecto numsol a siguiente valor secuencia
alter table solicitud alter column numsol set default nextval('solicitud_numsol_seq');

--
-- Eliminamos constrain not null dataalta y datafinalitzacio
alter table solicitud alter column dataalta drop not null;
alter table solicitud alter column datafinalitzacio drop not null;

--
-- Forzamos valores por defecto
alter table solicitud alter column pendent set default true;
alter table solicitud alter column finalitzada set default false;

-- creacion trigger actualizacion dataalta on insert
CREATE TRIGGER update_dataalta
BEFORE INSERT ON solicitud
FOR EACH ROW EXECUTE PROCEDURE update_dataalta();

--
-- Actualizacion de datafinalitzacio automatica on updates
-- Tablas Client + Solicitud
CREATE OR REPLACE FUNCTION update_datafinalitzacio() RETURNS TRIGGER AS $$
BEGIN
	IF NEW.finalitzada THEN
            NEW.datafinalitzacio := now();
    ELSE
	    NEW.datafinalitzacio := NULL;
	END IF;
    RETURN NEW;
END; $$
LANGUAGE plpgsql;

-- creacion trigger actualizacion datafinalitzacio on updates
CREATE TRIGGER update_datafinalitzacio
BEFORE update ON solicitud
FOR EACH ROW EXECUTE PROCEDURE update_datafinalitzacio();

-- ****************
-- Modificacion tabla stockpeca::
-- ****************

--	creacion de secuencia a max(numclient)+1
--
CREATE SEQUENCE stockpeca_id_seq;
select setval('stockpeca_id_seq', (select max(idstockpeca) from stockpeca) + 1);

--
-- cambio valor defecto numclient a siguiente valor secuencia
alter table stockpeca alter column idstockpeca set default nextval('stockpeca_id_seq');


-- ****************
-- Modificacion tabla peca::
-- ****************

--	creacion de secuencia a max(codipeca)+1
--
CREATE SEQUENCE peca_id_seq;
select setval('peca_id_seq', (select max(codipeca) from peca) + 1);

--
-- cambio valor defecto codipeca a siguiente valor secuencia
alter table peca alter column codipeca set default nextval('peca_id_seq');


-- ****************
-- Modificacion tabla reparacio::
-- ****************

--	creacion de secuencia a max(ordrereparacio)+1
--
CREATE SEQUENCE reparacio_id_seq;
select setval('reparacio_id_seq', (select max(ordrereparacio) from reparacio) + 1);

--
-- cambio valor defecto ordrereparacio a siguiente valor secuencia
alter table reparacio alter column ordrereparacio set default nextval('reparacio_id_seq');


--
-- Actualizacion de dataassignacio automatica on inserts
-- Tabla Reparacio
CREATE OR REPLACE FUNCTION update_dataassignacio() RETURNS TRIGGER AS $$
BEGIN
	NEW.dataassignacio := now();
        RETURN NEW;
END; $$
LANGUAGE plpgsql;

-- creacion trigger actualizacion dataassignacio on insert
CREATE TRIGGER update_dataassignacio
BEFORE INSERT ON reparacio
FOR EACH ROW EXECUTE PROCEDURE update_dataassignacio();

-----------------------
-------- SS1 ----------
-----------------------

-- Modificacion tabla Usuari
-- Se añaden los campos nom, cognom, adreca, nif, poblacio, codi_postal todos de tipo character varying
alter table Usuari add column nom character varying;
alter table Usuari add column cognom character varying;
alter table Usuari add column adreca character varying;
alter table Usuari add column nif character varying;
alter table Usuari add column poblacio character varying;
alter table Usuari add column codi_postal character varying;

-- Modificacion tabla Taller
-- Se añade el campo nom character varying
alter table Taller add column nom character varying;


-----------------------
--- Fin cambios SS1 ---
-----------------------

--
-- Eliminamos constrain not null idrep1 e idrep2 de la tabla mecanic
alter table mecanic alter column idrep1 drop not null;
alter table mecanic alter column idrep2 drop not null;