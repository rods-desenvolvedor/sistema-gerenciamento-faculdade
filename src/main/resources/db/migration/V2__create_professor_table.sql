CREATE EXTENSION IF NOT EXISTS "pgcrypto";


CREATE TABLE tb_professor(

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) NOT NULL,
    idade INTEGER NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL


);