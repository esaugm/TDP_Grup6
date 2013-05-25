--

-- PostgreSQL database dump

--



-- Dumped from database version 9.0.7

-- Dumped by pg_dump version 9.0.7

-- Started on 2013-04-14 19:36:01



SET statement_timeout = 0;

SET client_encoding = 'UTF8';

SET standard_conforming_strings = off;

SET check_function_bodies = false;

SET client_min_messages = warning;

SET escape_string_warning = off;



SET search_path = public, pg_catalog;



--

-- TOC entry 1930 (class 0 OID 0)

-- Dependencies: 155

-- Name: Taller_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres

--



SELECT pg_catalog.setval('Taller_ID_seq', 1, false);





--

-- TOC entry 1931 (class 0 OID 0)

-- Dependencies: 156

-- Name: Taller_ID_seq1; Type: SEQUENCE SET; Schema: public; Owner: postgres

--



SELECT pg_catalog.setval('Taller_ID_seq1', 1, false);





--

-- TOC entry 1932 (class 0 OID 0)

-- Dependencies: 158

-- Name: Usuari_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres

--



SELECT pg_catalog.setval('Usuari_ID_seq', 1, false);





--

-- TOC entry 1925 (class 0 OID 21313)

-- Dependencies: 154

-- Data for Name: Taller; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO Taller ( Cif, adreca, capacitat, capTaller, telefon, web, actiu, dataApertura, dataModificacio, dataBaixa) VALUES ( 'B11111111', 'C/Nort, 3 - 07760 - Ciutadella', 30, NULL, '971385175', 'www.taller1.com', true, '2013-04-11', NULL, NULL);

INSERT INTO Taller ( Cif, adreca, capacitat, capTaller, telefon, web, actiu, dataApertura, dataModificacio, dataBaixa) VALUES ( 'B22222221', 'C/Sud, 6 - 07750 - Ferreries', 25, NULL, '971155175', 'www.taller2.com', true, '2013-04-12', NULL, NULL);

INSERT INTO Taller ( Cif, adreca, capacitat, capTaller, telefon, web, actiu, dataApertura, dataModificacio, dataBaixa) VALUES ( 'B33333333', 'C/Est, 9 - 07740 - Es Mercadal', 20, NULL, '971375175', 'www.taller3.com', true, '2013-04-13', NULL, NULL);

INSERT INTO Taller ( Cif, adreca, capacitat, capTaller, telefon, web, actiu, dataApertura, dataModificacio, dataBaixa) VALUES ( 'B44444444', 'C/Oest, 12 - 07730 - Alaior', 15, NULL, '971335175', 'www.taller4.com', true, '2013-04-14', NULL, NULL);

INSERT INTO Taller ( Cif, adreca, capacitat, capTaller, telefon, web, actiu, dataApertura, dataModificacio, dataBaixa) VALUES ( 'B55555555', 'C/Tramontana, 15 - 07701 - MaÛ', 40, NULL, '971355175', 'www.taller5.com', true, '2013-04-15', NULL, NULL);





--

-- TOC entry 1926 (class 0 OID 21326)

-- Dependencies: 157 1925

-- Data for Name: Usuari; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO Usuari (ID, Taller, usuari, perfil, contrasenya, actiu, dataAlta, dataModificacio, dataBaixa, reparacionsassignades) VALUES (1, NULL, 'pepelui1', 'Administratiu', 'AAA1', true, '2013-04-11', NULL, NULL, 0);

INSERT INTO Usuari (ID, Taller, usuari, perfil, contrasenya, actiu, dataAlta, dataModificacio, dataBaixa, reparacionsassignades) VALUES (2, NULL, 'pepelui2', 'Administratiu', 'AAA2', true, '2013-04-12', NULL, NULL, 0);

INSERT INTO Usuari (ID, Taller, usuari, perfil, contrasenya, actiu, dataAlta, dataModificacio, dataBaixa, reparacionsassignades) VALUES (3, NULL, 'pepelui3', 'Administratiu', 'AAA3', true, '2013-04-13', NULL, NULL, 0);

INSERT INTO Usuari (ID, Taller, usuari, perfil, contrasenya, actiu, dataAlta, dataModificacio, dataBaixa, reparacionsassignades) VALUES (4, NULL, 'pepelui4', 'Administratiu', 'AAA4', true, '2013-04-14', NULL, NULL, 0);

INSERT INTO Usuari (ID, Taller, usuari, perfil, contrasenya, actiu, dataAlta, dataModificacio, dataBaixa, reparacionsassignades) VALUES (5, NULL, 'pepelui5', 'Administratiu', 'AAA5', true, '2013-04-15', NULL, NULL, 0);





--

-- TOC entry 1915 (class 0 OID 21266)

-- Dependencies: 144 1926

-- Data for Name: CapTaller; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO CapTaller (IdCapTaller) VALUES (1);

INSERT INTO CapTaller (IdCapTaller) VALUES (2);

INSERT INTO CapTaller (IdCapTaller) VALUES (3);

INSERT INTO CapTaller (IdCapTaller) VALUES (4);

INSERT INTO CapTaller (IdCapTaller) VALUES (5);





--

-- TOC entry 1918 (class 0 OID 21277)

-- Dependencies: 147 1926

-- Data for Name: Mecanic; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO Mecanic (IdMecanic, Disponible, IdRep1, IdRep2) VALUES (1, true, 1, 2);

INSERT INTO Mecanic (IdMecanic, Disponible, IdRep1, IdRep2) VALUES (2, true, 3, 4);

INSERT INTO Mecanic (IdMecanic, Disponible, IdRep1, IdRep2) VALUES (3, false, 5, 6);





--

-- TOC entry 1919 (class 0 OID 21281)

-- Dependencies: 148

-- Data for Name: Peca; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO Peca (CodiPeca, Descripcio, PVP, PVD, Marca, Model, IdProveidor) VALUES (1, 'Intermitent dret                                  ', 250, 280, 'Renault', 'Megane', 1);

INSERT INTO Peca (CodiPeca, Descripcio, PVP, PVD, Marca, Model, IdProveidor) VALUES (2, 'Valvula                                           ', 850, 925, 'BMW', '320', 2);

INSERT INTO Peca (CodiPeca, Descripcio, PVP, PVD, Marca, Model, IdProveidor) VALUES (3, 'Tub                                               ', 410, 513, 'Alfa', 'Rover', 2);





--

-- TOC entry 1920 (class 0 OID 21287)

-- Dependencies: 149

-- Data for Name: Proveidor; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO Proveidor (IdProveidor, Nom) VALUES (1, 'Recanvis SEAT');

INSERT INTO Proveidor (IdProveidor, Nom) VALUES (2, 'BMW');

INSERT INTO Proveidor (IdProveidor, Nom) VALUES (3, 'Renault');

INSERT INTO Proveidor (IdProveidor, Nom) VALUES (4, 'Fiat');





--

-- TOC entry 1922 (class 0 OID 21296)

-- Dependencies: 151 1918 1915

-- Data for Name: Reparacio; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO Reparacio (OrdreReparacio, IdCapTaller, Acceptada, IdMecanic, Assignada, Comptador, Observacions, NumCom, DataAssignacio, DataInici, DataFi) VALUES (1, 2, true, 1, true, 420, 'Fuita d''oli', 1, '2013-03-02', '2013-03-03', '2013-03-06');

INSERT INTO Reparacio (OrdreReparacio, IdCapTaller, Acceptada, IdMecanic, Assignada, Comptador, Observacions, NumCom, DataAssignacio, DataInici, DataFi) VALUES (2, 2, true, 2, true, 75, 'Intermitent dret', 2, '2013-04-01', '2013-04-04', '2013-04-04');





--

-- TOC entry 1917 (class 0 OID 21272)

-- Dependencies: 146 1919 1920 1922

-- Data for Name: Comanda; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO Comanda (NumCom, Estat, Date, CodiPeca, IdCapTaller, IdProveidor, OrdreReparacio, TipusReparacio) VALUES (1, true, '2013-02-02', 1, 1, 1, 1, true);

INSERT INTO Comanda (NumCom, Estat, Date, CodiPeca, IdCapTaller, IdProveidor, OrdreReparacio, TipusReparacio) VALUES (2, false, '2013-03-02', 2, 1, 1, 2, true);





--

-- TOC entry 1913 (class 0 OID 21257)

-- Dependencies: 142 1917

-- Data for Name: Albara; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO Albara (numAlbara, comantaris, Comanda) VALUES (21305, 'Todas las piezas correctas                        ', 1);





--

-- TOC entry 1914 (class 0 OID 21260)

-- Dependencies: 143

-- Data for Name: Asseguradora; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO Asseguradora (IdAsseguradora, CIF, nom, adreca, telefon) VALUES (1, 'B12345678', 'MUTUA MADRILEÑA', 'Avda. Castellana 39', 912345678);





--

-- TOC entry 1916 (class 0 OID 21269)

-- Dependencies: 145

-- Data for Name: Client; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO Client (nom, cognoms, adreca, nif, poblacio, codiPostal, numClient, dataAlta) VALUES ('Joan           ', 'Terradell Vidal                    ', 'Plaça Major, 23 2º

2ª                             ', '12465857 ', 'Barcelona                               ', 8014, 23654, '1995-02-20');

INSERT INTO Client (nom, cognoms, adreca, nif, poblacio, codiPostal, numClient, dataAlta) VALUES ('Ferran         ', 'Pons Margelí                       ', 'Carrer Constitució, 4 1º

2ª                       ', '71226575 ', 'Barcelona                               ', 8016, 24154, '1999-06-12');

INSERT INTO Client (nom, cognoms, adreca, nif, poblacio, codiPostal, numClient, dataAlta) VALUES ('Jose Fina      ', 'Pérez Manga                        ', 'Carrer del Arbres, 99

7º                          ', '21548789 ', 'Badalona                                ', 8912, 24250, '2000-10-10');

INSERT INTO Client (nom, cognoms, adreca, nif, poblacio, codiPostal, numClient, dataAlta) VALUES ('José Antonio   ', 'Fernández Fernández                ', 'Carrer Pelai, 33

1º 2ª                            ', '65235265 ', 'Badalona                                ', 8910, 24255, '2000-10-11');

INSERT INTO Client (nom, cognoms, adreca, nif, poblacio, codiPostal, numClient, dataAlta) VALUES ('Susana         ', 'GÛmez H‰nse                        ', 'Carrer Muntaner, 157 5º

2º                        ', '45547465 ', 'Barcelona                               ', 8016, 242655, '2000-11-11');

INSERT INTO Client (nom, cognoms, adreca, nif, poblacio, codiPostal, numClient, dataAlta) VALUES ('Juan Antonio   ', 'Segura Nicol·s                     ', 'Carrer Tier, 13

1º                                ', '12232314 ', 'Sant Adrià de Besós                     ', 8930, 25101, '2001-02-02');





--

-- TOC entry 1921 (class 0 OID 21293)

-- Dependencies: 150 1920

-- Data for Name: ProveidorPeca; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO ProveidorPeca (IdProveidorPeca, IdProveidor, IdPeca) VALUES (1, 1, 1);

INSERT INTO ProveidorPeca (IdProveidorPeca, IdProveidor, IdPeca) VALUES (2, 1, 2);

INSERT INTO ProveidorPeca (IdProveidorPeca, IdProveidor, IdPeca) VALUES (3, 2, 2);

INSERT INTO ProveidorPeca (IdProveidorPeca, IdProveidor, IdPeca) VALUES (4, 3, 3);





--

-- TOC entry 1923 (class 0 OID 21304)

-- Dependencies: 152 1914 1916 1922

-- Data for Name: Solicitud; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO Solicitud (numSol, comentaris, dataAlta, dataFinalitzacio, client, numReparacio, pendent, finalitzada, asseguradora, numPoliza) VALUES (1, 'Reparacio rapida                                                                                                             ', '2013-04-22', '2013-04-23', '12465857', 1, false, true, 1, '1');

INSERT INTO Solicitud (numSol, comentaris, dataAlta, dataFinalitzacio, client, numReparacio, pendent, finalitzada, asseguradora, numPoliza) VALUES (2, 'Fuita d''oli                                                                                                                  ', '2013-03-02', '2013-04-03', '45547465', 2, false, true, 1, '1');





--

-- TOC entry 1924 (class 0 OID 21310)

-- Dependencies: 153 1919 1925

-- Data for Name: StockPeca; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO StockPeca (IdStockPeca, CodiPeca, Stock, IdTaller, StockMinim) VALUES (1, 1, 25, 1, 6);

INSERT INTO StockPeca (IdStockPeca, CodiPeca, Stock, IdTaller, StockMinim) VALUES (2, 2, 10, 1, 2);

INSERT INTO StockPeca (IdStockPeca, CodiPeca, Stock, IdTaller, StockMinim) VALUES (3, 3, 14, 1, 4);





--

-- TOC entry 1927 (class 0 OID 21338)

-- Dependencies: 159 1922

-- Data for Name: Vehicle; Type: TABLE DATA; Schema: public; Owner: postgres

--



INSERT INTO Vehicle (marca, tipus, num_chasis, model, matricula, color, anyo, numReparacio) VALUES ('Renault        ', 'berlina        ', '123456789           ', 'Megane         ', '123456  ', 'negre     ', '2006-01-01', 1);

INSERT INTO Vehicle (marca, tipus, num_chasis, model, matricula, color, anyo, numReparacio) VALUES ('BMW            ', 'c              ', '123456777           ', '320            ', '654321  ', 'blau      ', '2010-01-01', 2);





-- Completed on 2013-04-12 19:36:01



--

-- PostgreSQL database dump complete

--


