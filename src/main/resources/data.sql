INSERT INTO endereco (rua, numero, cidade, cep)
SELECT 'Rua das Flores', 100, 'São Paulo', '01001-000'
WHERE NOT EXISTS (
    SELECT 1
    FROM endereco
    WHERE rua = 'Rua das Flores'
      AND numero = 100
      AND cidade = 'São Paulo'
);

INSERT INTO endereco (rua, numero, cidade, cep)
SELECT 'Rua Tico Tico', 200, 'São Paulo', '01001-010'
WHERE NOT EXISTS (
    SELECT 1
    FROM endereco
    WHERE rua = 'Rua Tico Tico'
      AND numero = 200
      AND cidade = 'São Paulo'
);


INSERT INTO tipo_usuario (nome_tipo)
SELECT 'Dono de Restaurante'
WHERE NOT EXISTS (
    SELECT 1
    FROM tipo_usuario
    WHERE nome_tipo = 'Dono de Restaurante'
);

INSERT INTO tipo_usuario (nome_tipo)
SELECT 'Cliente'
WHERE NOT EXISTS (
    SELECT 1
    FROM tipo_usuario
    WHERE nome_tipo = 'Cliente'
);