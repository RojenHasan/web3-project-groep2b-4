CREATE SCHEMA if not exists groep2b4;
GRANT ALL ON SCHEMA groep2b4 TO local_r0866160;
GRANT ALL ON SCHEMA groep2b4 TO r0866160;
GRANT ALL ON SCHEMA groep2b4 TO local_r0867998;
GRANT ALL ON SCHEMA groep2b4 TO r0867998;
GRANT ALL ON SCHEMA groep2b4 TO local_u0015529;
GRANT ALL ON SCHEMA groep2b4 TO local_u0034562;



CREATE SEQUENCE if not exists  groep2b4.user_id_seq;

GRANT ALL ON SEQUENCE groep2b4.user_id_seq TO local_r0866160;
GRANT ALL ON SEQUENCE groep2b4.user_id_seq TO r0866160;
GRANT ALL ON SEQUENCE groep2b4.user_id_seq TO local_r0867998;
GRANT ALL ON SEQUENCE groep2b4.user_id_seq TO r0867998;
GRANT ALL ON SEQUENCE groep2b4.user_id_seq TO local_u0034562;
GRANT ALL ON SEQUENCE groep2b4.user_id_seq TO local_u0015529;



CREATE TABLE if not exists groep2b4.user
(   userid integer NOT NULL DEFAULT nextval('groep2b4.user_id_seq'::regclass),
email character varying(255) COLLATE pg_catalog."default" NOT NULL,
password character varying(255) COLLATE pg_catalog."default" NOT NULL,
firstname character varying(255) COLLATE pg_catalog."default" NOT NULL,
lastname character varying(255) COLLATE pg_catalog."default" NOT NULL,
role character varying(255) COLLATE pg_catalog."default" NOT NULL,
team character varying(255) COLLATE pg_catalog."default" NOT NULL,
CONSTRAINT user_pkey PRIMARY KEY (userid)
);

GRANT ALL PRIVILEGES ON TABLE groep2b4.user TO local_r0866160;
GRANT ALL PRIVILEGES ON TABLE groep2b4.user TO r0866160;
GRANT ALL PRIVILEGES ON TABLE groep2b4.user TO local_r0867998;
GRANT ALL PRIVILEGES ON TABLE groep2b4.user TO r0867998;
GRANT ALL PRIVILEGES ON TABLE groep2b4.user TO local_u0015529;
GRANT ALL PRIVILEGES ON TABLE groep2b4.user TO local_u0034562;





