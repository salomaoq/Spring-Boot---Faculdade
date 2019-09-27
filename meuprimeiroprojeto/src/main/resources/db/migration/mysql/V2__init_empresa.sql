INSERT INTO `flyway`.`empresa` (`id`, `cnpj`, `data_atualizacao`, `data_criacao`, `razao_social`) 
VALUES (NULL, '82198127000121', CURRENT_DATE(), CURRENT_DATE(), 'Uni-FACEF');

INSERT INTO `flyway`.`funcionario` (`id`, `nome`, `senha`, `cpf`, `valor_hora`, `qtd_horas_trabalho_dia`, `qtd_horas_almoco`, `perfil`, `data_criacao`, `data_atualizacao`)
VALUES (NULL, 'Joao Paulo', '54321', '000000000-00', 100.50, 8, 1, 'ROLE_ADMIN', CURRENT_DATE(), CURRENT_DATE());