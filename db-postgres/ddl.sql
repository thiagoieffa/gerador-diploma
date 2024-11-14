CREATE TABLE aluno (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    nacionalidade VARCHAR(100),
    estado VARCHAR(50),
    data_de_nascimento DATE,
    rg VARCHAR(20),
    data_de_conclusao DATE,
    curso VARCHAR(255),
    nivel_de_especializacao VARCHAR(100),
    carga_horaria_em_horas VARCHAR(50)
);
