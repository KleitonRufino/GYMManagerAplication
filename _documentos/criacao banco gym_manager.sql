CREATE TABLE atividadeextra (
    id integer NOT NULL,
    diaatividade date,
    duracao character varying(255),
    horaatividade date,
    nome character varying(255) NOT NULL,
    cliente_id integer
);

CREATE SEQUENCE atividadeextra_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE cliente (
    id integer NOT NULL,
    ativo boolean NOT NULL,
    cpf character varying(255),
    telefone character varying(255),
    datanascimento date,
    datavencimento date,
    nome character varying(255) NOT NULL,
    usuario_id integer
);

CREATE SEQUENCE cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE cobranca (
    id integer NOT NULL,
    datavencimento date,
    valor bigint,
    cliente_id integer
);

CREATE SEQUENCE cobranca_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE colaborador (
    id integer NOT NULL,
    cargo character varying(255),
    nome character varying(255) NOT NULL,
    salario double precision NOT NULL,
    usuario_id integer
);

CREATE SEQUENCE colaborador_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE condicaofisica (
    id integer NOT NULL,
    altura double precision,
    antebraco double precision,
    biceps double precision,
    cintura double precision,
    coxa double precision,
    datadacondicao date,
    gluteo double precision,
    mtorax double precision,
    panturrilha double precision,
    peso double precision,
    cliente_id integer
);

CREATE SEQUENCE condicaofisica_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

 CREATE TABLE conta (
    id integer NOT NULL,
    datavencimento date,
    descricao character varying(255) NOT NULL,
    statuspagamento boolean NOT NULL,
    tipoconta character varying(255),
    valorconta double precision,
    responsavel_id integer
);

CREATE SEQUENCE conta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE dieta (
    cliente_id integer,
    id integer NOT NULL,
    descricao character varying(255) NOT NULL,
    diadasemana date
);

CREATE SEQUENCE dieta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE dieta_refeicoes (
    dieta_id integer NOT NULL,
    refeicoes character varying(255)
);

CREATE TABLE fornecedor (
    id integer NOT NULL,
    nome character varying(255) NOT NULL
);

CREATE SEQUENCE fornecedor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE fornecedor_produto (
    fornecedor_id integer NOT NULL,
    produtos_id integer NOT NULL
);

CREATE TABLE guiadetreino (
    id integer NOT NULL,
    diadasemana character varying(255),
    nome character varying(255) NOT NULL,
    cliente_id integer
);

CREATE SEQUENCE guiadetreino_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

 CREATE TABLE guiadetreino_treinos (
    guiadetreino_id integer NOT NULL,
    treinos character varying(255)
);

CREATE TABLE produto (
    id integer NOT NULL,
    descricao character varying(255) NOT NULL,
    preco double precision NOT NULL
);

CREATE SEQUENCE produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

 CREATE TABLE usuario (
    id integer NOT NULL,
    login character varying(255) NOT NULL,
    senha character varying(255) NOT NULL
);

CREATE SEQUENCE usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

 ALTER TABLE ONLY atividadeextra ALTER COLUMN id SET DEFAULT nextval('atividadeextra_id_seq'::regclass);
 ALTER TABLE ONLY cliente ALTER COLUMN id SET DEFAULT nextval('cliente_id_seq'::regclass);
 ALTER TABLE ONLY cobranca ALTER COLUMN id SET DEFAULT nextval('cobranca_id_seq'::regclass);
 ALTER TABLE ONLY colaborador ALTER COLUMN id SET DEFAULT nextval('colaborador_id_seq'::regclass);
 ALTER TABLE ONLY condicaofisica ALTER COLUMN id SET DEFAULT nextval('condicaofisica_id_seq'::regclass);
 ALTER TABLE ONLY conta ALTER COLUMN id SET DEFAULT nextval('conta_id_seq'::regclass);
 ALTER TABLE ONLY dieta ALTER COLUMN id SET DEFAULT nextval('dieta_id_seq'::regclass);
 ALTER TABLE ONLY fornecedor ALTER COLUMN id SET DEFAULT nextval('fornecedor_id_seq'::regclass);
 ALTER TABLE ONLY guiadetreino ALTER COLUMN id SET DEFAULT nextval('guiadetreino_id_seq'::regclass);
 ALTER TABLE ONLY produto ALTER COLUMN id SET DEFAULT nextval('produto_id_seq'::regclass);
 ALTER TABLE ONLY usuario ALTER COLUMN id SET DEFAULT nextval('usuario_id_seq'::regclass);

 ALTER TABLE ONLY atividadeextra
    ADD CONSTRAINT atividadeextra_pkey PRIMARY KEY (id);


ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);


ALTER TABLE ONLY cobranca
    ADD CONSTRAINT cobranca_pkey PRIMARY KEY (id);


ALTER TABLE ONLY colaborador
    ADD CONSTRAINT colaborador_pkey PRIMARY KEY (id);



ALTER TABLE ONLY condicaofisica
    ADD CONSTRAINT condicaofisica_pkey PRIMARY KEY (id);


ALTER TABLE ONLY conta
    ADD CONSTRAINT conta_pkey PRIMARY KEY (id);


ALTER TABLE ONLY dieta
    ADD CONSTRAINT dieta_pkey PRIMARY KEY (id);


ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (id);


ALTER TABLE ONLY guiadetreino
    ADD CONSTRAINT guiadetreino_pkey PRIMARY KEY (id);


ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);

ALTER TABLE ONLY usuario
    ADD CONSTRAINT uk_g1orfqvgih1w8s3vyg15fq2b8 UNIQUE (login);


ALTER TABLE ONLY fornecedor_produto
    ADD CONSTRAINT uk_jsx6227ivnajv1bll3vtjjg3b UNIQUE (produtos_id);


ALTER TABLE ONLY produto
    ADD CONSTRAINT uk_r0nebj4byihfufsmxff4impwo UNIQUE (descricao);


ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);

ALTER TABLE ONLY cliente
    ADD CONSTRAINT fk_59sjoxx03o5h11578hamjgjcs FOREIGN KEY (usuario_id) REFERENCES usuario(id);


ALTER TABLE ONLY dieta_refeicoes
    ADD CONSTRAINT fk_62pybbfuuxj8oim9opsxogrv2 FOREIGN KEY (dieta_id) REFERENCES dieta(id);

ALTER TABLE ONLY dieta
    ADD CONSTRAINT fk_dieta_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id);

ALTER TABLE ONLY atividadeextra
    ADD CONSTRAINT fk_atvextra_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id);

ALTER TABLE ONLY conta
    ADD CONSTRAINT fk_7elc3wtbxiu8gil7vbb7e47to FOREIGN KEY (responsavel_id) REFERENCES colaborador(id);

ALTER TABLE ONLY guiadetreino
    ADD CONSTRAINT fk_io6l9m6c2hqoy27eg3qaxwbs2 FOREIGN KEY (cliente_id) REFERENCES cliente(id);

ALTER TABLE ONLY condicaofisica
    ADD CONSTRAINT fk_j00cdrnexuook743nnylct42f FOREIGN KEY (cliente_id) REFERENCES cliente(id);


ALTER TABLE ONLY fornecedor_produto
    ADD CONSTRAINT fk_jsx6227ivnajv1bll3vtjjg3b FOREIGN KEY (produtos_id) REFERENCES produto(id);


ALTER TABLE ONLY fornecedor_produto
    ADD CONSTRAINT fk_mac6xi5l6f93an65catifmpjj FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id);


ALTER TABLE ONLY colaborador
    ADD CONSTRAINT fk_o9entqi8uivjypxfqq2t9fm5r FOREIGN KEY (usuario_id) REFERENCES usuario(id);


ALTER TABLE ONLY cobranca
    ADD CONSTRAINT fk_ohtl1oirwduyiu6qcuga1tt3a FOREIGN KEY (cliente_id) REFERENCES cliente(id);


ALTER TABLE ONLY guiadetreino_treinos
    ADD CONSTRAINT fk_wmd25hd8hwm9emf0ut9138m9 FOREIGN KEY (guiadetreino_id) REFERENCES guiadetreino(id);

CREATE TABLE notificacao (
    id integer NOT NULL,
    mensagem character varying(255) NOT NULL,
    cliente_id int
);

CREATE SEQUENCE notificacao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY notificacao ALTER COLUMN id SET DEFAULT nextval('notificacao_id_seq'::regclass);

ALTER TABLE ONLY notificacao
    ADD CONSTRAINT notificacao_pkey PRIMARY KEY (id);

ALTER TABLE ONLY notificacao
    ADD CONSTRAINT fk_notif_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id);




CREATE TABLE mensalidades (
    id integer NOT NULL,
    mesreferencia character varying(255) NOT NULL,
    ano integer NOT NULL,
    cliente_id int
);

CREATE SEQUENCE mensalidades_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY mensalidades ALTER COLUMN id SET DEFAULT nextval('mensalidades_id_seq'::regclass);

ALTER TABLE ONLY mensalidades
    ADD CONSTRAINT mensalidades_pkey PRIMARY KEY (id);

ALTER TABLE ONLY mensalidades
    ADD CONSTRAINT fk_mensalidades_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id);
