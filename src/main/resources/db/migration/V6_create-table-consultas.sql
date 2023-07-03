CREATE TABLE tb_consultas(

    id bigint not null auto_increment,
    medico_id bigint not null,
    paciente_id bigint not null,
    data datetime not null,


    primary key(id),
    CONSTRAINT fk_tb_consultas_medico_id FOREIGN KEY (medico_id) REFERENCES tb_medicos(id),
    CONSTRAINT fk_tb_consultas_paciente_id FOREIGN KEY (paciente_id) REFERENCES tb_pacientes(id)

);