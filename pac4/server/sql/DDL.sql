--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.8
-- Dumped by pg_dump version 9.1.8
-- Started on 2013-04-14 19:07:41 CEST

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 180 (class 3079 OID 11907)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2258 (class 0 OID 0)
-- Dependencies: 180
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 179 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2259 (class 0 OID 0)
-- Dependencies: 179
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 161 (class 1259 OID 19331)
-- Dependencies: 6
-- Name: Albara; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE Albara (
    numAlbara integer NOT NULL,
    comantaris character(50),
    Comanda integer NOT NULL
);


ALTER TABLE public.Albara OWNER TO postgres;

--
-- TOC entry 162 (class 1259 OID 19334)
-- Dependencies: 6
-- Name: Asseguradora; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE Asseguradora (
    IdAsseguradora integer NOT NULL,
    CIF character varying NOT NULL,
    nom character varying NOT NULL,
    adreca character varying,
    telefon integer
);


ALTER TABLE public.Asseguradora OWNER TO postgres;

--
-- TOC entry 163 (class 1259 OID 19340)
-- Dependencies: 6
-- Name: CapTaller; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE CapTaller (
    IdCapTaller integer NOT NULL
);


ALTER TABLE public.CapTaller OWNER TO postgres;

--
-- TOC entry 164 (class 1259 OID 19343)
-- Dependencies: 6
-- Name: Client; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE Client (
    nom character(15) NOT NULL,
    cognoms character(35) NOT NULL,
    adreca character(50) NOT NULL,
    nif character(9) NOT NULL,
    poblacio character(40) NOT NULL,
    codiPostal integer,
    numClient integer NOT NULL,
    dataAlta date NOT NULL
);


ALTER TABLE public.Client OWNER TO postgres;

--
-- TOC entry 165 (class 1259 OID 19346)
-- Dependencies: 2183 2184 6
-- Name: Comanda; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE Comanda (
    NumCom integer NOT NULL,
    Estat boolean DEFAULT true NOT NULL,
    Date date NOT NULL,
    CodiPeca integer NOT NULL,
    IdCapTaller integer NOT NULL,
    IdProveidor integer NOT NULL,
    OrdreReparacio integer NOT NULL,
    TipusReparacio boolean DEFAULT true NOT NULL
);


ALTER TABLE public.Comanda OWNER TO postgres;

--
-- TOC entry 166 (class 1259 OID 19351)
-- Dependencies: 2185 6
-- Name: Mecanic; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE Mecanic (
    IdMecanic integer NOT NULL,
    Disponible boolean DEFAULT true NOT NULL,
    IdRep1 integer NOT NULL,
    IdRep2 integer NOT NULL
);


ALTER TABLE public.Mecanic OWNER TO postgres;

--
-- TOC entry 167 (class 1259 OID 19355)
-- Dependencies: 6
-- Name: Peca; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE Peca (
    CodiPeca integer NOT NULL,
    Descripcio character(50) NOT NULL,
    PVP real NOT NULL,
    PVD real NOT NULL,
    Marca character varying NOT NULL,
    Model character varying NOT NULL,
    IdProveidor integer NOT NULL
);


ALTER TABLE public.Peca OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 19361)
-- Dependencies: 6
-- Name: Proveidor; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE Proveidor (
    IdProveidor integer NOT NULL,
    Nom character varying NOT NULL
);


ALTER TABLE public.Proveidor OWNER TO postgres;

--
-- TOC entry 169 (class 1259 OID 19367)
-- Dependencies: 6
-- Name: ProveidorPeca; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE ProveidorPeca (
    IdProveidorPeca integer NOT NULL,
    IdProveidor integer NOT NULL,
    IdPeca integer NOT NULL
);


ALTER TABLE public.ProveidorPeca OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 19370)
-- Dependencies: 2186 2187 6
-- Name: Reparacio; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE Reparacio (
    OrdreReparacio integer NOT NULL,
    IdCapTaller integer NOT NULL,
    Acceptada boolean DEFAULT false NOT NULL,
    IdMecanic integer NOT NULL,
    Assignada boolean DEFAULT false NOT NULL,
    Comptador double precision,
    Observacions character varying(500),
    NumCom integer NOT NULL,
    DataAssignacio date,
    DataInici date,
    DataFi date
);


ALTER TABLE public.Reparacio OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 19378)
-- Dependencies: 6
-- Name: Solicitud; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE Solicitud (
    numSol integer NOT NULL,
    comentaris character(125),
    dataAlta date NOT NULL,
    dataFinalitzacio date NOT NULL,
    client character(8) NOT NULL,
    numReparacio integer,
    pendent boolean,
    finalitzada boolean,
    asseguradora integer,
    numPoliza character varying
);


ALTER TABLE public.Solicitud OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 19384)
-- Dependencies: 6
-- Name: StockPeca; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE StockPeca (
    IdStockPeca integer NOT NULL,
    CodiPeca integer NOT NULL,
    Stock integer NOT NULL,
    IdTaller integer NOT NULL,
    StockMinim integer NOT NULL
);


ALTER TABLE public.StockPeca OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 19387)
-- Dependencies: 2188 2189 2191 6
-- Name: Taller; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE Taller (
    ID integer NOT NULL,
    Cif character varying NOT NULL,
    adreca character varying NOT NULL,
    capacitat integer NOT NULL,
    capTaller integer,
    telefon character varying,
    web character varying,
    actiu boolean DEFAULT true NOT NULL,
    dataApertura date DEFAULT now() NOT NULL,
    dataModificacio date,
    dataBaixa date,
    CONSTRAINT ck_capacitat CHECK ((capacitat > 0))
);


ALTER TABLE public.Taller OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 19396)
-- Dependencies: 6
-- Name: Taller_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE Taller_ID_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.Taller_ID_seq OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 19398)
-- Dependencies: 6 173
-- Name: Taller_ID_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE Taller_ID_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.Taller_ID_seq1 OWNER TO postgres;

--
-- TOC entry 2262 (class 0 OID 0)
-- Dependencies: 175
-- Name: Taller_ID_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE Taller_ID_seq1 OWNED BY Taller.ID;


--
-- TOC entry 176 (class 1259 OID 19400)
-- Dependencies: 2192 2193 2194 2196 6
-- Name: Usuari; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE Usuari (
    ID integer NOT NULL,
    Taller integer,
    usuari character varying,
    perfil character varying NOT NULL,
    contrasenya character varying NOT NULL,
    actiu boolean DEFAULT true NOT NULL,
    dataAlta date DEFAULT now() NOT NULL,
    dataModificacio date,
    dataBaixa date,
    reparacionsassignades integer DEFAULT 0,
    CONSTRAINT ck_reparacionsAssignades CHECK (((reparacionsassignades >= 0) AND (reparacionsassignades <= 2)))
);
ALTER TABLE ONLY Usuari ALTER COLUMN usuari SET STORAGE PLAIN;


ALTER TABLE public.Usuari OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 19410)
-- Dependencies: 176 6
-- Name: Usuari_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE Usuari_ID_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.Usuari_ID_seq OWNER TO postgres;

--
-- TOC entry 2265 (class 0 OID 0)
-- Dependencies: 177
-- Name: Usuari_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE Usuari_ID_seq OWNED BY Usuari.ID;


--
-- TOC entry 178 (class 1259 OID 19412)
-- Dependencies: 6
-- Name: Vehicle; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE Vehicle (
    marca character(15) NOT NULL,
    tipus character(15) NOT NULL,
    num_chasis character(20) NOT NULL,
    model character(15) NOT NULL,
    matricula character(8) NOT NULL,
    color character(10) NOT NULL,
    anyo date NOT NULL,
    numReparacio integer NOT NULL
);


ALTER TABLE public.Vehicle OWNER TO postgres;

--
-- TOC entry 2190 (class 2604 OID 19415)
-- Dependencies: 175 173
-- Name: ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Taller ALTER COLUMN ID SET DEFAULT nextval('Taller_ID_seq1'::regclass);


--
-- TOC entry 2195 (class 2604 OID 19416)
-- Dependencies: 177 176
-- Name: ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Usuari ALTER COLUMN ID SET DEFAULT nextval('Usuari_ID_seq'::regclass);


--
-- TOC entry 2202 (class 2606 OID 19418)
-- Dependencies: 163 163 2249
-- Name: PK_CapTaller_IdCapTaller; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY CapTaller
    ADD CONSTRAINT PK_CapTaller_IdCapTaller PRIMARY KEY (IdCapTaller);


--
-- TOC entry 2206 (class 2606 OID 19420)
-- Dependencies: 165 165 2249
-- Name: PK_Comanda_NumCom; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Comanda
    ADD CONSTRAINT PK_Comanda_NumCom PRIMARY KEY (NumCom);


--
-- TOC entry 2200 (class 2606 OID 19422)
-- Dependencies: 162 162 2249
-- Name: PK_IdAsseguradora; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Asseguradora
    ADD CONSTRAINT PK_IdAsseguradora PRIMARY KEY (IdAsseguradora);


--
-- TOC entry 2208 (class 2606 OID 19424)
-- Dependencies: 166 166 2249
-- Name: PK_Mecanic_IdMecanic; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Mecanic
    ADD CONSTRAINT PK_Mecanic_IdMecanic PRIMARY KEY (IdMecanic);


--
-- TOC entry 2210 (class 2606 OID 19426)
-- Dependencies: 167 167 2249
-- Name: PK_Peca_CodiPeca; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Peca
    ADD CONSTRAINT PK_Peca_CodiPeca PRIMARY KEY (CodiPeca);


--
-- TOC entry 2214 (class 2606 OID 19428)
-- Dependencies: 169 169 2249
-- Name: PK_ProveidorPeca; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY ProveidorPeca
    ADD CONSTRAINT PK_ProveidorPeca PRIMARY KEY (IdProveidorPeca);


--
-- TOC entry 2212 (class 2606 OID 19430)
-- Dependencies: 168 168 2249
-- Name: PK_Proveidor_IdProveidor; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Proveidor
    ADD CONSTRAINT PK_Proveidor_IdProveidor PRIMARY KEY (IdProveidor);


--
-- TOC entry 2216 (class 2606 OID 19432)
-- Dependencies: 170 170 2249
-- Name: PK_Reparacio_OrdreReparacio; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Reparacio
    ADD CONSTRAINT PK_Reparacio_OrdreReparacio PRIMARY KEY (OrdreReparacio);


--
-- TOC entry 2220 (class 2606 OID 19434)
-- Dependencies: 172 172 2249
-- Name: PK_StockPeca_CodiPeca; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY StockPeca
    ADD CONSTRAINT PK_StockPeca_CodiPeca PRIMARY KEY (IdStockPeca);


--
-- TOC entry 2225 (class 2606 OID 19436)
-- Dependencies: 176 176 2249
-- Name: ck_usuariUnic; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Usuari
    ADD CONSTRAINT ck_usuariUnic UNIQUE (usuari);


--
-- TOC entry 2223 (class 2606 OID 19438)
-- Dependencies: 173 173 2249
-- Name: pk_Taller; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Taller
    ADD CONSTRAINT pk_Taller PRIMARY KEY (ID);


--
-- TOC entry 2228 (class 2606 OID 19440)
-- Dependencies: 176 176 2249
-- Name: pk_Usuari; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Usuari
    ADD CONSTRAINT pk_Usuari PRIMARY KEY (ID);


--
-- TOC entry 2204 (class 2606 OID 19442)
-- Dependencies: 164 164 2249
-- Name: pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Client
    ADD CONSTRAINT pkey PRIMARY KEY (nif);


--
-- TOC entry 2198 (class 2606 OID 19444)
-- Dependencies: 161 161 2249
-- Name: pkey_albara; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Albara
    ADD CONSTRAINT pkey_albara PRIMARY KEY (numAlbara);


--
-- TOC entry 2218 (class 2606 OID 19446)
-- Dependencies: 171 171 2249
-- Name: pkey_solicitud; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Solicitud
    ADD CONSTRAINT pkey_solicitud PRIMARY KEY (numSol);


--
-- TOC entry 2230 (class 2606 OID 19448)
-- Dependencies: 178 178 2249
-- Name: pkey_vehicle; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY Vehicle
    ADD CONSTRAINT pkey_vehicle PRIMARY KEY (num_chasis);


--
-- TOC entry 2226 (class 1259 OID 19449)
-- Dependencies: 176 2249
-- Name: fki_Taller; Type: INDEX; Schema: public; Owner: postgres; Tablespace:
--

CREATE INDEX fki_Taller ON Usuari USING btree (Taller);


--
-- TOC entry 2221 (class 1259 OID 19450)
-- Dependencies: 173 2249
-- Name: fki_capTaller; Type: INDEX; Schema: public; Owner: postgres; Tablespace:
--

CREATE INDEX fki_capTaller ON Taller USING btree (capTaller);


--
-- TOC entry 2240 (class 2606 OID 19451)
-- Dependencies: 171 162 2199 2249
-- Name: FK_Asseguradora; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Solicitud
    ADD CONSTRAINT FK_Asseguradora FOREIGN KEY (asseguradora) REFERENCES Asseguradora(IdAsseguradora);


--
-- TOC entry 2232 (class 2606 OID 19456)
-- Dependencies: 2227 163 176 2249
-- Name: FK_CapTaller_IdCapTaller_Usuari_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY CapTaller
    ADD CONSTRAINT FK_CapTaller_IdCapTaller_Usuari_ID FOREIGN KEY (IdCapTaller) REFERENCES Usuari(ID);


--
-- TOC entry 2231 (class 2606 OID 19534)
-- Dependencies: 161 165 2205 2249
-- Name: FK_Comanda; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Albara
    ADD CONSTRAINT FK_Comanda FOREIGN KEY (Comanda) REFERENCES Comanda(NumCom);


--
-- TOC entry 2233 (class 2606 OID 19461)
-- Dependencies: 165 167 2209 2249
-- Name: FK_Comanda_CodiPeca_Peca_CodiPeca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Comanda
    ADD CONSTRAINT FK_Comanda_CodiPeca_Peca_CodiPeca FOREIGN KEY (CodiPeca) REFERENCES Peca(CodiPeca);


--
-- TOC entry 2234 (class 2606 OID 19466)
-- Dependencies: 165 168 2211 2249
-- Name: FK_Comanda_IdProveidor_Proveidor_IdProveidor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Comanda
    ADD CONSTRAINT FK_Comanda_IdProveidor_Proveidor_IdProveidor FOREIGN KEY (IdProveidor) REFERENCES Proveidor(IdProveidor);


--
-- TOC entry 2235 (class 2606 OID 19471)
-- Dependencies: 165 170 2215 2249
-- Name: FK_Comanda_OrdreReparacio_Reparacio_OrdreReparacio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Comanda
    ADD CONSTRAINT FK_Comanda_OrdreReparacio_Reparacio_OrdreReparacio FOREIGN KEY (OrdreReparacio) REFERENCES Reparacio(OrdreReparacio);


--
-- TOC entry 2238 (class 2606 OID 19476)
-- Dependencies: 166 2207 170 2249
-- Name: FK_IdMecanic; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Reparacio
    ADD CONSTRAINT FK_IdMecanic FOREIGN KEY (IdMecanic) REFERENCES Mecanic(IdMecanic);


--
-- TOC entry 2236 (class 2606 OID 19481)
-- Dependencies: 176 166 2227 2249
-- Name: FK_Mecanic_IdMecanic_Usuari_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Mecanic
    ADD CONSTRAINT FK_Mecanic_IdMecanic_Usuari_ID FOREIGN KEY (IdMecanic) REFERENCES Usuari(ID);


--
-- TOC entry 2237 (class 2606 OID 19486)
-- Dependencies: 169 168 2211 2249
-- Name: FK_ProveidorPeca_IdProveidorPeca_Proveidor_IdProveidor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ProveidorPeca
    ADD CONSTRAINT FK_ProveidorPeca_IdProveidorPeca_Proveidor_IdProveidor FOREIGN KEY (IdProveidor) REFERENCES Proveidor(IdProveidor);


--
-- TOC entry 2239 (class 2606 OID 19491)
-- Dependencies: 170 163 2201 2249
-- Name: FK_Reparacio_IdCapTaller_CapTaller_IdCapTaller; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Reparacio
    ADD CONSTRAINT FK_Reparacio_IdCapTaller_CapTaller_IdCapTaller FOREIGN KEY (IdCapTaller) REFERENCES CapTaller(IdCapTaller);


--
-- TOC entry 2243 (class 2606 OID 19496)
-- Dependencies: 172 167 2209 2249
-- Name: FK_StockPeca_CodiPeca_Peca_CodiPeca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY StockPeca
    ADD CONSTRAINT FK_StockPeca_CodiPeca_Peca_CodiPeca FOREIGN KEY (CodiPeca) REFERENCES Peca(CodiPeca);


--
-- TOC entry 2244 (class 2606 OID 19501)
-- Dependencies: 172 173 2222 2249
-- Name: FK_StockPeca_IdTaller_Taller_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY StockPeca
    ADD CONSTRAINT FK_StockPeca_IdTaller_Taller_ID FOREIGN KEY (IdTaller) REFERENCES Taller(ID);


--
-- TOC entry 2241 (class 2606 OID 19506)
-- Dependencies: 171 164 2203 2249
-- Name: FK_client; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Solicitud
    ADD CONSTRAINT FK_client FOREIGN KEY (client) REFERENCES Client(nif);


--
-- TOC entry 2242 (class 2606 OID 19511)
-- Dependencies: 2215 171 170 2249
-- Name: FK_numReparacio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Solicitud
    ADD CONSTRAINT FK_numReparacio FOREIGN KEY (numReparacio) REFERENCES Reparacio(OrdreReparacio);


--
-- TOC entry 2246 (class 2606 OID 19516)
-- Dependencies: 173 176 2222 2249
-- Name: fk_Taller; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Usuari
    ADD CONSTRAINT fk_Taller FOREIGN KEY (Taller) REFERENCES Taller(ID);


--
-- TOC entry 2245 (class 2606 OID 19521)
-- Dependencies: 173 176 2227 2249
-- Name: fk_capTaller; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Taller
    ADD CONSTRAINT fk_capTaller FOREIGN KEY (capTaller) REFERENCES Usuari(ID);


--
-- TOC entry 2247 (class 2606 OID 19526)
-- Dependencies: 2215 170 178 2249
-- Name: fk_numReparacio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY Vehicle
    ADD CONSTRAINT fk_numReparacio FOREIGN KEY (numReparacio) REFERENCES Reparacio(OrdreReparacio);


--
-- TOC entry 2254 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 2257 (class 0 OID 0)
-- Dependencies: 161
-- Name: Albara; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE Albara FROM PUBLIC;
REVOKE ALL ON TABLE Albara FROM postgres;
GRANT ALL ON TABLE Albara TO postgres;
GRANT ALL ON TABLE Albara TO PUBLIC;


--
-- TOC entry 2258 (class 0 OID 0)
-- Dependencies: 164
-- Name: Client; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE Client FROM PUBLIC;
REVOKE ALL ON TABLE Client FROM postgres;
GRANT ALL ON TABLE Client TO postgres;
GRANT ALL ON TABLE Client TO PUBLIC;


--
-- TOC entry 2259 (class 0 OID 0)
-- Dependencies: 171
-- Name: Solicitud; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE Solicitud FROM PUBLIC;
REVOKE ALL ON TABLE Solicitud FROM postgres;
GRANT ALL ON TABLE Solicitud TO postgres;
GRANT ALL ON TABLE Solicitud TO PUBLIC;


--
-- TOC entry 2260 (class 0 OID 0)
-- Dependencies: 173
-- Name: Taller; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE Taller FROM PUBLIC;
REVOKE ALL ON TABLE Taller FROM postgres;
GRANT ALL ON TABLE Taller TO postgres;
GRANT ALL ON TABLE Taller TO PUBLIC;


--
-- TOC entry 2261 (class 0 OID 0)
-- Dependencies: 174
-- Name: Taller_ID_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE Taller_ID_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE Taller_ID_seq FROM postgres;
GRANT ALL ON SEQUENCE Taller_ID_seq TO postgres;
GRANT ALL ON SEQUENCE Taller_ID_seq TO PUBLIC;


--
-- TOC entry 2263 (class 0 OID 0)
-- Dependencies: 175
-- Name: Taller_ID_seq1; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE Taller_ID_seq1 FROM PUBLIC;
REVOKE ALL ON SEQUENCE Taller_ID_seq1 FROM postgres;
GRANT ALL ON SEQUENCE Taller_ID_seq1 TO postgres;
GRANT ALL ON SEQUENCE Taller_ID_seq1 TO PUBLIC;


--
-- TOC entry 2264 (class 0 OID 0)
-- Dependencies: 176
-- Name: Usuari; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE Usuari FROM PUBLIC;
REVOKE ALL ON TABLE Usuari FROM postgres;
GRANT ALL ON TABLE Usuari TO postgres;
GRANT ALL ON TABLE Usuari TO PUBLIC;


--
-- TOC entry 2266 (class 0 OID 0)
-- Dependencies: 177
-- Name: Usuari_ID_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE Usuari_ID_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE Usuari_ID_seq FROM postgres;
GRANT ALL ON SEQUENCE Usuari_ID_seq TO postgres;
GRANT ALL ON SEQUENCE Usuari_ID_seq TO PUBLIC;


--
-- TOC entry 2267 (class 0 OID 0)
-- Dependencies: 178
-- Name: Vehicle; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE Vehicle FROM PUBLIC;
REVOKE ALL ON TABLE Vehicle FROM postgres;
GRANT ALL ON TABLE Vehicle TO postgres;
GRANT ALL ON TABLE Vehicle TO PUBLIC;


--
-- TOC entry 1484 (class 826 OID 19532)
-- Dependencies: 2249
-- Name: DEFAULT PRIVILEGES FOR SEQUENCES; Type: DEFAULT ACL; Schema: -; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres REVOKE ALL ON SEQUENCES  FROM PUBLIC;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres REVOKE ALL ON SEQUENCES  FROM postgres;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT ALL ON SEQUENCES  TO postgres;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT ALL ON SEQUENCES  TO PUBLIC;


-- Completed on 2013-04-14 19:07:41 CEST

--
-- PostgreSQL database dump complete
--
