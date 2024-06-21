CREATE TABLE tb_employee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    neighborhood varchar(100) not null,
    cep varchar(9) not null,
    complement varchar(100),
    number varchar(20),
    city varchar(100) not null,
    Specialty varchar(200) not null,
    FOREIGN KEY (user_id) REFERENCES tb_user(id)
);

CREATE TABLE tb_client (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    telephone BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES tb_user(id)
);