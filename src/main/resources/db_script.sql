-- =====================================================
-- Schema gestrest - PostgreSQL
-- =====================================================

-- CUIDADO: apaga tudo que existe no schema gestrest
DROP SCHEMA IF EXISTS gestrest CASCADE;
CREATE SCHEMA gestrest;
SET search_path TO gestrest;

-- -----------------------------------------------------
-- Table tipo_usuario
-- -----------------------------------------------------
CREATE TABLE tipo_usuario (
  tipo_usuario_id SERIAL PRIMARY KEY,
  nome_tipo VARCHAR(45) NOT NULL
);

INSERT INTO tipo_usuario (nome_tipo) VALUES
  ('Dono de restaurante'),
  ('Consumidor');

-- -----------------------------------------------------
-- Table endereco
-- -----------------------------------------------------
CREATE TABLE endereco (
  endereco_id SERIAL PRIMARY KEY,
  rua VARCHAR(255),
  numero INTEGER,
  cidade VARCHAR(60) NOT NULL,
  cep VARCHAR(12) NOT NULL
);

INSERT INTO endereco (rua, numero, cidade, cep) VALUES
  ('Endereco padrão', 0, 'Cidade Padrão', '00000-000');

-- -----------------------------------------------------
-- Table usuario
-- -----------------------------------------------------
CREATE TABLE usuario (
  usuario_id SERIAL PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(120) NOT NULL,
  login VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  data_ultima_alteracao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  estado INTEGER NOT NULL DEFAULT 1,
  tipo_usuario_id INTEGER NOT NULL DEFAULT 1,
  endereco_id INTEGER NOT NULL DEFAULT 1,
  CONSTRAINT fk_usuario_tipo_usuario
    FOREIGN KEY (tipo_usuario_id)
    REFERENCES tipo_usuario (tipo_usuario_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_usuario_endereco
    FOREIGN KEY (endereco_id)
    REFERENCES endereco (endereco_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Índices opcionais (para performance, não obrigatórios)
CREATE INDEX idx_usuario_tipo_usuario ON usuario (tipo_usuario_id);
CREATE INDEX idx_usuario_endereco ON usuario (endereco_id);

-- -----------------------------------------------------
-- Table avaliacao
-- -----------------------------------------------------
CREATE TABLE avaliacao (
  avaliacao_id INTEGER NOT NULL,
  usuario_id INTEGER NOT NULL,
  comentario VARCHAR(255),
  data_hora TIMESTAMP NOT NULL,
  qtde_estrelas INTEGER NOT NULL,
  PRIMARY KEY (avaliacao_id, usuario_id),
  CONSTRAINT fk_avaliacao_usuario
    FOREIGN KEY (usuario_id)
    REFERENCES usuario (usuario_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

CREATE INDEX idx_avaliacao_usuario ON avaliacao (usuario_id);

-- -----------------------------------------------------
-- Table restaurante
-- -----------------------------------------------------
CREATE TABLE restaurante (
  restaurante_id INTEGER NOT NULL,
  nome VARCHAR(45) NOT NULL,
  endereco_id INTEGER NOT NULL,
  proprietario INTEGER NOT NULL,
  avaliacao_id INTEGER,
  avaliacao_usuario_id INTEGER,
  PRIMARY KEY (restaurante_id),
  CONSTRAINT fk_restaurante_endereco
    FOREIGN KEY (endereco_id)
    REFERENCES endereco (endereco_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_restaurante_usuario
    FOREIGN KEY (proprietario)
    REFERENCES usuario (usuario_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_restaurante_avaliacao
    FOREIGN KEY (avaliacao_usuario_id, avaliacao_id)
    REFERENCES avaliacao (usuario_id, avaliacao_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

CREATE INDEX idx_restaurante_endereco ON restaurante (endereco_id);
CREATE INDEX idx_restaurante_usuario ON restaurante (proprietario);
CREATE INDEX idx_restaurante_avaliacao ON restaurante (avaliacao_usuario_id, avaliacao_id);

-- -----------------------------------------------------
-- Table cardapio
-- -----------------------------------------------------
CREATE TABLE cardapio (
  restaurante_id INTEGER NOT NULL,
  PRIMARY KEY (restaurante_id),
  CONSTRAINT fk_cardapio_restaurante
    FOREIGN KEY (restaurante_id)
    REFERENCES restaurante (restaurante_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

CREATE INDEX idx_cardapio_restaurante ON cardapio (restaurante_id);

-- -----------------------------------------------------
-- Table tipo_item_cardapio
-- -----------------------------------------------------
CREATE TABLE tipo_item_cardapio (
  tipo_item_id INTEGER NOT NULL,
  nome_tipo VARCHAR(45) NOT NULL,
  PRIMARY KEY (tipo_item_id)
);

-- -----------------------------------------------------
-- Table item_cardapio
-- (ajuste: coluna 'item-cardapio_id' virou 'item_cardapio_id')
-- -----------------------------------------------------
CREATE TABLE item_cardapio (
  item_cardapio_id INTEGER NOT NULL,
  restaurante_id INTEGER NOT NULL,
  descricao VARCHAR(45) NOT NULL,
  ingredientes VARCHAR(45),
  valor NUMERIC(6) NOT NULL,
  estado INTEGER NOT NULL,
  tipo_item_cardapio_id INTEGER NOT NULL,
  avaliacao_id INTEGER,
  avaliacao_usuario_id INTEGER,
  PRIMARY KEY (item_cardapio_id, restaurante_id),
  CONSTRAINT fk_item_cardapio_cardapio
    FOREIGN KEY (restaurante_id)
    REFERENCES cardapio (restaurante_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_tipo_item_cardapio
    FOREIGN KEY (tipo_item_cardapio_id)
    REFERENCES tipo_item_cardapio (tipo_item_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_item_cardapio_avaliacao
    FOREIGN KEY (avaliacao_usuario_id, avaliacao_id)
    REFERENCES avaliacao (usuario_id, avaliacao_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

CREATE INDEX idx_item_cardapio_tipo_item ON item_cardapio (tipo_item_cardapio_id);
CREATE INDEX idx_item_cardapio_avaliacao ON item_cardapio (avaliacao_usuario_id, avaliacao_id);

-- -----------------------------------------------------
-- Table pedido
-- -----------------------------------------------------
CREATE TABLE pedido (
  usuario_id INTEGER NOT NULL,
  item_cardapio_id INTEGER NOT NULL,
  restaurante_id INTEGER NOT NULL,
  data_hora TIMESTAMP NOT NULL,
  qtde_item INTEGER NOT NULL,
  PRIMARY KEY (usuario_id, item_cardapio_id, restaurante_id),
  CONSTRAINT fk_pedido_usuario
    FOREIGN KEY (usuario_id)
    REFERENCES usuario (usuario_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_pedido_item_cardapio
    FOREIGN KEY (item_cardapio_id, restaurante_id)
    REFERENCES item_cardapio (item_cardapio_id, restaurante_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

CREATE INDEX idx_pedido_item_cardapio ON pedido (item_cardapio_id, restaurante_id);
CREATE INDEX idx_pedido_usuario ON pedido (usuario_id);
