---Creacion Tablas Personas en Postgres

CREATE TABLE IF NOT EXISTS persona
(
    persona_id SERIAL,
    nombre character varying(255) COLLATE pg_catalog."default",
    genero character varying(50) COLLATE pg_catalog."default",
    edad integer,
    identificacion character varying(50) COLLATE pg_catalog."default",
    direccion character varying(255) COLLATE pg_catalog."default",
    telefono character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT persona_pkey PRIMARY KEY (persona_id)
)

---Creacion Tablas Clientes
CREATE TABLE IF NOT EXISTS cliente
(
    cliente_id SERIAL,
    persona_id integer,
    contrasena character varying(255) COLLATE pg_catalog."default",
    estado boolean,
    CONSTRAINT cliente_pkey PRIMARY KEY (cliente_id),
    CONSTRAINT cliente_persona_id_fkey FOREIGN KEY (persona_id)
        REFERENCES persona (persona_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

---Creacion Tablas Cuentas

CREATE TABLE IF NOT EXISTS cuenta
(
    cuenta_id SERIAL,
    numero_cuenta character varying(20) COLLATE pg_catalog."default",
    tipo_cuenta character varying(50) COLLATE pg_catalog."default",
    saldo_inicial numeric,
    estado boolean,
    cliente_id integer,
    CONSTRAINT cuenta_pkey PRIMARY KEY (cuenta_id),
    CONSTRAINT cuenta_numero_cuenta_key UNIQUE (numero_cuenta),
    CONSTRAINT cliente_id FOREIGN KEY (cliente_id)
        REFERENCES cliente (cliente_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

---Creacion Tablas Movimientos
CREATE TABLE IF NOT EXISTS movimientos
(
    movimiento_id SERIAL,
    fecha date,
    tipo_movimiento character varying(50) COLLATE pg_catalog."default",
    valor numeric,
    saldo numeric,
    cuenta_id integer,
    CONSTRAINT movimientos_pkey PRIMARY KEY (movimiento_id),
    CONSTRAINT movimientos_cuenta_id_fkey FOREIGN KEY (cuenta_id)
        REFERENCES cuenta (cuenta_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
