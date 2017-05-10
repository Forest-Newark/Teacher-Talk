--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: forestnewark
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO forestnewark;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: log; Type: TABLE; Schema: public; Owner: forestnewark
--

CREATE TABLE log (
    id integer NOT NULL,
    created timestamp without time zone,
    notes character varying(255),
    parent_name character varying(255),
    student_name character varying(255),
    template_sent character varying(255)
);


ALTER TABLE log OWNER TO forestnewark;

--
-- Name: message; Type: TABLE; Schema: public; Owner: forestnewark
--

CREATE TABLE message (
    id integer NOT NULL,
    english_message character varying(255),
    message_name character varying(255)
);


ALTER TABLE message OWNER TO forestnewark;

--
-- Name: parent; Type: TABLE; Schema: public; Owner: forestnewark
--

CREATE TABLE parent (
    id integer NOT NULL,
    password character varying(255),
    phone_number character varying(255),
    preferred_contact_method character varying(255),
    preferred_language character varying(255),
    primary_email character varying(255),
    primary_first_name character varying(255),
    primary_last_name character varying(255),
    secondary_email character varying(255),
    secondary_first_name character varying(255),
    secondary_last_name character varying(255)
);


ALTER TABLE parent OWNER TO forestnewark;

--
-- Name: student; Type: TABLE; Schema: public; Owner: forestnewark
--

CREATE TABLE student (
    id integer NOT NULL,
    grade character varying(255),
    notes character varying(255),
    school character varying(255),
    student_first_name character varying(255),
    student_last_name character varying(255),
    parent_id integer
);


ALTER TABLE student OWNER TO forestnewark;

--
-- Name: teacher; Type: TABLE; Schema: public; Owner: forestnewark
--

CREATE TABLE teacher (
    id integer NOT NULL,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    phone_number character varying(255),
    school_name character varying(255),
    subject_area character varying(255)
);


ALTER TABLE teacher OWNER TO forestnewark;

--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: forestnewark
--

SELECT pg_catalog.setval('hibernate_sequence', 100, true);


--
-- Data for Name: log; Type: TABLE DATA; Schema: public; Owner: forestnewark
--

COPY log (id, created, notes, parent_name, student_name, template_sent) FROM stdin;
4	2017-05-10 09:04:03.328372	student was abrasive	Will	Berry	4 days ago
1	2017-05-10 09:04:03.378455	student might have lice	Chris	Miles	3 days ago
2	2017-05-10 09:04:03.387885	student read exceptional well	Forest	Chuck	1 days ago
3	2017-05-10 09:04:03.389145	consider moving student to honors	Rasputin	King	7 days ago
\.


--
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: forestnewark
--

COPY message (id, english_message, message_name) FROM stdin;
1	Hello from Teacher Talk!	helloMessage
2	This message is to inform you that your child was absent from class today. While I will assist your student with the content they missed, it is their responsibility to make up all missing work.	Absent Message
\.


--
-- Data for Name: parent; Type: TABLE DATA; Schema: public; Owner: forestnewark
--

COPY parent (id, password, phone_number, preferred_contact_method, preferred_language, primary_email, primary_first_name, primary_last_name, secondary_email, secondary_first_name, secondary_last_name) FROM stdin;
1	password123	9194528196	email	english	forest.newark@gmail.com	Jim	Smith	forest.newark@gmail.com	Sally	Smith
2	password123	9195555555	email	spanish	forestjavadev@gmail.com	Chris	Mitchell	none	Wife	Mitchell
3	hi	9195555345	email	english	cwolf0913@gmail.com	Chris	Tang	none	Wife	adsf
\.


--
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: forestnewark
--

COPY student (id, grade, notes, school, student_first_name, student_last_name, parent_id) FROM stdin;
1	6	Very-Hyper	School Of The Arts	Johnny	Smith	1
2	7	Very Bright	School of the Arts	Sean	Mitchell	2
\.


--
-- Data for Name: teacher; Type: TABLE DATA; Schema: public; Owner: forestnewark
--

COPY teacher (id, email, first_name, last_name, password, phone_number, school_name, subject_area) FROM stdin;
1	forest.newark@gmail.com	forest	newark	admin	9194528196	\N	music
\.


--
-- Name: log log_pkey; Type: CONSTRAINT; Schema: public; Owner: forestnewark
--

ALTER TABLE ONLY log
    ADD CONSTRAINT log_pkey PRIMARY KEY (id);


--
-- Name: message message_pkey; Type: CONSTRAINT; Schema: public; Owner: forestnewark
--

ALTER TABLE ONLY message
    ADD CONSTRAINT message_pkey PRIMARY KEY (id);


--
-- Name: parent parent_pkey; Type: CONSTRAINT; Schema: public; Owner: forestnewark
--

ALTER TABLE ONLY parent
    ADD CONSTRAINT parent_pkey PRIMARY KEY (id);


--
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: forestnewark
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- Name: teacher teacher_pkey; Type: CONSTRAINT; Schema: public; Owner: forestnewark
--

ALTER TABLE ONLY teacher
    ADD CONSTRAINT teacher_pkey PRIMARY KEY (id);


--
-- Name: student fkqqq09m02bgrk47qoe6fs3ht4w; Type: FK CONSTRAINT; Schema: public; Owner: forestnewark
--

ALTER TABLE ONLY student
    ADD CONSTRAINT fkqqq09m02bgrk47qoe6fs3ht4w FOREIGN KEY (parent_id) REFERENCES parent(id);


--
-- PostgreSQL database dump complete
--

