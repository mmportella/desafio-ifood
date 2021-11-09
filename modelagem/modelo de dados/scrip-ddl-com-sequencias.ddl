-- Gerado por Oracle SQL Developer Data Modeler 21.2.0.183.1957
--   em:        2021-11-09 19:19:30 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE t_ifd_pedido (
    cd_pedido                  NUMBER(14) NOT NULL,
    cd_usuario                 NUMBER(8),
    endereco                   VARCHAR2(60) NOT NULL,
    vl_pedido                  NUMBER(6, 2) NOT NULL,
    vl_taxa                    NUMBER(5, 2) NOT NULL,
    restaurante_cd_restaurante NUMBER(8) NOT NULL
);

ALTER TABLE t_ifd_pedido ADD CONSTRAINT pedido_pk PRIMARY KEY ( cd_pedido );

CREATE TABLE t_ifd_pedido_produto (
    pedido_cd_pedido  NUMBER(14) NOT NULL,
    roduto_cd_produto NUMBER(8) NOT NULL,
    qt_produto        NUMBER(4) NOT NULL
);

ALTER TABLE t_ifd_pedido_produto ADD CONSTRAINT pedido_produto_pk PRIMARY KEY ( pedido_cd_pedido,
                                                                                roduto_cd_produto );

CREATE TABLE t_ifd_produto (
    cd_produto                 NUMBER(8) NOT NULL,
    nm_produto                 VARCHAR2(60) NOT NULL,
    preco                      NUMBER(6, 2) NOT NULL,
    restaurante_cd_restaurante NUMBER(8) NOT NULL
);

ALTER TABLE t_ifd_produto ADD CONSTRAINT produto_pk PRIMARY KEY ( cd_produto );

CREATE TABLE t_ifd_restaurante (
    cd_restaurante   NUMBER(8) NOT NULL,
    cnpj             NUMBER(14) NOT NULL,
    nm_restaurante   VARCHAR2(30) NOT NULL,
    endereco         VARCHAR2(60) NOT NULL,
    telefone         NUMBER(11) NOT NULL,
    tp_restaurante   VARCHAR2(30) NOT NULL,
    hr_funcionamento VARCHAR2(10) NOT NULL,
    avaliacao        NUMBER(1),
    preco_medio      NUMBER(5, 2),
    pedido_minimo    NUMBER(5, 2) NOT NULL,
    retirada         CHAR(1)
);

ALTER TABLE t_ifd_restaurante ADD CONSTRAINT restaurante_pk PRIMARY KEY ( cd_restaurante );

ALTER TABLE t_ifd_pedido_produto
    ADD CONSTRAINT pedido_produto_fk FOREIGN KEY ( roduto_cd_produto )
        REFERENCES t_ifd_produto ( cd_produto );

ALTER TABLE t_ifd_pedido
    ADD CONSTRAINT pedido_restaurante_fk FOREIGN KEY ( restaurante_cd_restaurante )
        REFERENCES t_ifd_restaurante ( cd_restaurante );

ALTER TABLE t_ifd_pedido_produto
    ADD CONSTRAINT produto_pedido_fk FOREIGN KEY ( pedido_cd_pedido )
        REFERENCES t_ifd_pedido ( cd_pedido );

ALTER TABLE t_ifd_produto
    ADD CONSTRAINT produto_restaurante_fk FOREIGN KEY ( restaurante_cd_restaurante )
        REFERENCES t_ifd_restaurante ( cd_restaurante );

CREATE SEQUENCE seq_restaurante
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999
NOCACHE
NOORDER
NOCYCLE;

CREATE SEQUENCE seq_produto
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999
NOCACHE
NOORDER
NOCYCLE;

CREATE SEQUENCE seq_pedido
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999999
NOCACHE
NOORDER
NOCYCLE;

-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             0
-- ALTER TABLE                              8
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
