

CREATE TABLE tb_aluno_disciplina (

    aluno_id UUID NOT NULL,
    disciplina_id UUID NOT NULL,
    PRIMARY KEY (aluno_id, disciplina_id),
    CONSTRAINT fk_aluno FOREIGN KEY (aluno_id) REFERENCES tb_aluno(id) ON DELETE CASCADE,
    CONSTRAINT fk_disciplina FOREIGN KEY (disciplina_id) REFERENCES tb_disciplina(id) ON DELETE CASCADE

);