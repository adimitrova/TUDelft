--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6rc1
-- Dumped by pg_dump version 9.6rc1

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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: annotation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE annotation (
    oid integer NOT NULL,
    confidence integer,
    label character varying(255),
    marked boolean,
    user_oid integer
);


ALTER TABLE annotation OWNER TO postgres;

--
-- Name: annotationcampaign; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE annotationcampaign (
    oid integer NOT NULL,
    status character varying(255),
    budget double precision,
    name character varying(255),
    user_oid integer
);


ALTER TABLE annotationcampaign OWNER TO postgres;

--
-- Name: group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "group" (
    oid integer NOT NULL,
    groupname character varying(255),
    module_oid integer
);


ALTER TABLE "group" OWNER TO postgres;

--
-- Name: group_module; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE group_module (
    group_oid integer NOT NULL,
    module_oid integer NOT NULL
);


ALTER TABLE group_module OWNER TO postgres;

--
-- Name: item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE item (
    oid integer NOT NULL,
    url character varying(255),
    caption character varying(255),
    title character varying(255)
);


ALTER TABLE item OWNER TO postgres;

--
-- Name: item_annotation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE item_annotation (
    item_oid integer NOT NULL,
    annotation_oid integer NOT NULL
);


ALTER TABLE item_annotation OWNER TO postgres;

--
-- Name: module; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE module (
    oid integer NOT NULL,
    moduleid character varying(255),
    modulename character varying(255)
);


ALTER TABLE module OWNER TO postgres;

--
-- Name: skill; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE skill (
    oid integer NOT NULL,
    name character varying(255)
);


ALTER TABLE skill OWNER TO postgres;

--
-- Name: task; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE task (
    oid integer NOT NULL,
    title character varying(255),
    description character varying(255),
    reward double precision,
    expiration_date timestamp without time zone,
    maximum_exec_time time without time zone,
    grade integer,
    annotationcampaign_oid integer
);


ALTER TABLE task OWNER TO postgres;

--
-- Name: task_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE task_item (
    task_oid integer NOT NULL,
    item_oid integer NOT NULL
);


ALTER TABLE task_item OWNER TO postgres;

--
-- Name: task_skill; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE task_skill (
    task_oid integer NOT NULL,
    skill_oid integer NOT NULL
);


ALTER TABLE task_skill OWNER TO postgres;

--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "user" (
    oid integer NOT NULL,
    username character varying(255),
    password character varying(255),
    email character varying(255),
    birth_date timestamp without time zone,
    name character varying(255),
    score double precision,
    piggy_bank double precision,
    group_oid integer
);


ALTER TABLE "user" OWNER TO postgres;

--
-- Name: user_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE user_group (
    user_oid integer NOT NULL,
    group_oid integer NOT NULL
);


ALTER TABLE user_group OWNER TO postgres;

--
-- Name: user_skill; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE user_skill (
    user_oid integer NOT NULL,
    skill_oid integer NOT NULL
);


ALTER TABLE user_skill OWNER TO postgres;

--
-- Name: user_task; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE user_task (
    user_oid integer NOT NULL,
    task_oid integer NOT NULL
);


ALTER TABLE user_task OWNER TO postgres;

--
-- Data for Name: annotation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY annotation (oid, confidence, label, marked, user_oid) FROM stdin;
5	8	Item 1 > Task 3 > Annot 2 ANNOTATION	f	3
4	8	IFML Task 1 > Item 1 > ANNOTATION 1 GOOD	f	2
6	2	C3_T2_I1_ANNOTATED	f	3
\.


--
-- Data for Name: annotationcampaign; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY annotationcampaign (oid, status, budget, name, user_oid) FROM stdin;
1	Open	100	IFML	1
2	Open	100	Software Dev	1
3	Open	50	Campaign 3	1
\.


--
-- Data for Name: group; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "group" (oid, groupname, module_oid) FROM stdin;
2	worker	2
1	requester	1
\.


--
-- Data for Name: group_module; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY group_module (group_oid, module_oid) FROM stdin;
1	1
2	2
\.


--
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY item (oid, url, caption, title) FROM stdin;
1	http://4.bp.blogspot.com/-X1lalO3qcOI/USaGRTMzcyI/AAAAAAAAKMI/_c1D9uFbfgs/s1600/IFML-example.png	Explain why IS or IS NOT	Is this IFML problem true?
2	http://dbgroup.elet.polimi.it/img/logoWebRatio.jpg	Item 1 > Task 3 > Annot 2	Item 1 > Task 3 > Annot 2
3	C3_T2_I1	C3_T2_I1	C3_T2_I1
4	Task 3 > Item 2	Task 3 > Item 2	Task 3 > Item 2
\.


--
-- Data for Name: item_annotation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY item_annotation (item_oid, annotation_oid) FROM stdin;
1	4
2	5
\.


--
-- Data for Name: module; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY module (oid, moduleid, modulename) FROM stdin;
1	sv3	1
2	sv2	2
\.


--
-- Data for Name: skill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY skill (oid, name) FROM stdin;
1	Soft.Eng
2	Data Mining
3	Web Science
4	IFML
5	Python Programmin
6	C# Programming
7	Java Programming
\.


--
-- Data for Name: task; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY task (oid, title, description, reward, expiration_date, maximum_exec_time, grade, annotationcampaign_oid) FROM stdin;
1	IFML Task 1	IFML First task	50	2016-09-21 00:00:00	09:00:00	10	1
2	IFML Task 2	IFML First task	50	2016-09-21 00:00:00	09:00:00	10	1
3	Soft.Dev Task 1	Soft Dev First task	50	2016-09-21 00:00:00	09:00:00	10	2
4	Soft.Dev Task 2	Soft Dev Second task	50	2016-09-21 00:00:00	09:00:00	10	2
5	C3_T1	C3_T1	50	2016-09-21 00:00:00	09:00:00	10	3
6	C3_T2	C3_T2	50	2016-09-21 00:00:00	09:00:00	10	3
\.


--
-- Data for Name: task_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY task_item (task_oid, item_oid) FROM stdin;
1	1
3	2
6	3
3	4
\.


--
-- Data for Name: task_skill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY task_skill (task_oid, skill_oid) FROM stdin;
1	4
1	3
2	3
2	4
3	5
3	7
4	6
5	6
6	3
6	4
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "user" (oid, username, password, email, birth_date, name, score, piggy_bank, group_oid) FROM stdin;
1	req	req	req@req.com	2016-09-06 00:00:00	Requester	0	0	1
3	work2	work2	work2@work2.com	2016-09-06 00:00:00	Worker 2	0	0	2
2	work	work	work@work.com	2016-09-06 00:00:00	Worker 1	0	200	2
\.


--
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_group (user_oid, group_oid) FROM stdin;
1	1
2	2
3	2
\.


--
-- Data for Name: user_skill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_skill (user_oid, skill_oid) FROM stdin;
2	4
2	3
3	7
3	5
\.


--
-- Data for Name: user_task; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_task (user_oid, task_oid) FROM stdin;
3	3
2	6
\.


--
-- Name: annotation annotation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY annotation
    ADD CONSTRAINT annotation_pkey PRIMARY KEY (oid);


--
-- Name: annotationcampaign annotationcampaign_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY annotationcampaign
    ADD CONSTRAINT annotationcampaign_pkey PRIMARY KEY (oid);


--
-- Name: group_module group_module_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_module
    ADD CONSTRAINT group_module_pkey PRIMARY KEY (group_oid, module_oid);


--
-- Name: group group_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "group"
    ADD CONSTRAINT group_pkey PRIMARY KEY (oid);


--
-- Name: item_annotation item_annotation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item_annotation
    ADD CONSTRAINT item_annotation_pkey PRIMARY KEY (item_oid, annotation_oid);


--
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item
    ADD CONSTRAINT item_pkey PRIMARY KEY (oid);


--
-- Name: module module_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY module
    ADD CONSTRAINT module_pkey PRIMARY KEY (oid);


--
-- Name: skill skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (oid);


--
-- Name: task_item task_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task_item
    ADD CONSTRAINT task_item_pkey PRIMARY KEY (task_oid, item_oid);


--
-- Name: task task_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task
    ADD CONSTRAINT task_pkey PRIMARY KEY (oid);


--
-- Name: task_skill task_skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task_skill
    ADD CONSTRAINT task_skill_pkey PRIMARY KEY (task_oid, skill_oid);


--
-- Name: user_group user_group_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_group
    ADD CONSTRAINT user_group_pkey PRIMARY KEY (user_oid, group_oid);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (oid);


--
-- Name: user_skill user_skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_skill
    ADD CONSTRAINT user_skill_pkey PRIMARY KEY (user_oid, skill_oid);


--
-- Name: user_task user_task_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_task
    ADD CONSTRAINT user_task_pkey PRIMARY KEY (user_oid, task_oid);


--
-- Name: annotation fk_annotation_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY annotation
    ADD CONSTRAINT fk_annotation_user FOREIGN KEY (user_oid) REFERENCES "user"(oid);


--
-- Name: annotationcampaign fk_annotationcampaign_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY annotationcampaign
    ADD CONSTRAINT fk_annotationcampaign_user FOREIGN KEY (user_oid) REFERENCES "user"(oid);


--
-- Name: group fk_group_module; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "group"
    ADD CONSTRAINT fk_group_module FOREIGN KEY (module_oid) REFERENCES module(oid);


--
-- Name: group_module fk_group_module_group; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_module
    ADD CONSTRAINT fk_group_module_group FOREIGN KEY (group_oid) REFERENCES "group"(oid);


--
-- Name: group_module fk_group_module_module; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_module
    ADD CONSTRAINT fk_group_module_module FOREIGN KEY (module_oid) REFERENCES module(oid);


--
-- Name: item_annotation fk_item_annotation_annotation; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item_annotation
    ADD CONSTRAINT fk_item_annotation_annotation FOREIGN KEY (annotation_oid) REFERENCES annotation(oid);


--
-- Name: item_annotation fk_item_annotation_item; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item_annotation
    ADD CONSTRAINT fk_item_annotation_item FOREIGN KEY (item_oid) REFERENCES item(oid);


--
-- Name: task fk_task_annotationcampaign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task
    ADD CONSTRAINT fk_task_annotationcampaign FOREIGN KEY (annotationcampaign_oid) REFERENCES annotationcampaign(oid);


--
-- Name: task_item fk_task_item_item; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task_item
    ADD CONSTRAINT fk_task_item_item FOREIGN KEY (item_oid) REFERENCES item(oid);


--
-- Name: task_item fk_task_item_task; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task_item
    ADD CONSTRAINT fk_task_item_task FOREIGN KEY (task_oid) REFERENCES task(oid);


--
-- Name: task_skill fk_task_skill_skill; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task_skill
    ADD CONSTRAINT fk_task_skill_skill FOREIGN KEY (skill_oid) REFERENCES skill(oid);


--
-- Name: task_skill fk_task_skill_task; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task_skill
    ADD CONSTRAINT fk_task_skill_task FOREIGN KEY (task_oid) REFERENCES task(oid);


--
-- Name: user fk_user_group; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT fk_user_group FOREIGN KEY (group_oid) REFERENCES "group"(oid);


--
-- Name: user_group fk_user_group_group; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_group
    ADD CONSTRAINT fk_user_group_group FOREIGN KEY (group_oid) REFERENCES "group"(oid);


--
-- Name: user_group fk_user_group_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_group
    ADD CONSTRAINT fk_user_group_user FOREIGN KEY (user_oid) REFERENCES "user"(oid);


--
-- Name: user_skill fk_user_skill_skill; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_skill
    ADD CONSTRAINT fk_user_skill_skill FOREIGN KEY (skill_oid) REFERENCES skill(oid);


--
-- Name: user_skill fk_user_skill_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_skill
    ADD CONSTRAINT fk_user_skill_user FOREIGN KEY (user_oid) REFERENCES "user"(oid);


--
-- Name: user_task fk_user_task_task; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_task
    ADD CONSTRAINT fk_user_task_task FOREIGN KEY (task_oid) REFERENCES task(oid);


--
-- Name: user_task fk_user_task_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_task
    ADD CONSTRAINT fk_user_task_user FOREIGN KEY (user_oid) REFERENCES "user"(oid);


--
-- PostgreSQL database dump complete
--

