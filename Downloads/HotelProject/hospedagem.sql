USE hospedagem;
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(15)
);


CREATE TABLE reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero_quarto INT NOT NULL,
    cliente_id INT NOT NULL,
    data_entrada DATE NOT NULL,
    data_saida DATE NOT NULL,
    status VARCHAR(20) DEFAULT 'Ativa',
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

INSERT INTO clientes (nome, cpf, telefone) VALUES
('Maria Silva', '123.456.789-00', '51987654321'),
('João Souza', '987.654.321-00', '51912345678');

INSERT INTO reservas (numero_quarto, cliente_id, data_entrada, data_saida) VALUES
(101, 1, '2025-01-10', '2025-01-15'),
(102, 2, '2025-01-12', '2025-01-18');
SELECT * FROM clientes;
