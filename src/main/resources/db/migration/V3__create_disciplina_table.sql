CREATE EXTENSION IF NOT EXISTS "pgcrypto";


CREATE TABLE tb_disciplina(

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) NOT NULL,
    carga_horaria INTEGER NOT NULL,
    professor_id UUID NOT NULL,
    CONSTRAINT fk_professor
        FOREIGN KEY (professor_id)
        REFERENCES tb_professor(id)
        ON DELETE CASCADE
);