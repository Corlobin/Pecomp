INSERT INTO TB_CURSO (TB_CRS_NOME) VALUES ('Sistemas de Informação');
INSERT INTO TB_CURSO (TB_CRS_NOME) VALUES ('Ciencia da Computação');
INSERT INTO TB_CURSO (TB_CRS_NOME) VALUES ('TADS');

INSERT INTO TB_INSTITUICAO (TB_INS_NOME) VALUES ('IFES');
INSERT INTO TB_INSTITUICAO (TB_INS_NOME) VALUES ('UFES');
INSERT INTO TB_INSTITUICAO (TB_INS_NOME) VALUES ('UVV');

INSERT INTO TB_PESSOA (TB_PES_NOME, TB_PES_EMAIL, TB_PES_SENHA, TB_PES_IMG_NAME) VALUES ('Ricardo', 'anribrasil@gmail.com', '123', '1289486.jpeg');

INSERT INTO tb_livro(tb_lvr_url, tb_lvr_imagem, tb_lvr_titulo) VALUES ('http://google.com.br', 'livro1.gif','Computação Forense');

INSERT INTO TB_MATERIA (TB_MAT_DESCRICAO) VALUES ('Matematica');
INSERT INTO TB_MATERIA (TB_MAT_DESCRICAO) VALUES ('Fundamentos de Computação');
INSERT INTO TB_MATERIA (TB_MAT_DESCRICAO) VALUES ('Tecnologia da Computação');

INSERT INTO tb_dt_poscomp(tb_dt_inscricao, tb_dt_prova) VALUES ('2016-12-22 22:41:15.833', '2017-02-12 22:41:15.833');

INSERT INTO TB_QUESTOES (TB_QST_ANO) VALUES ('2016');

INSERT INTO tb_questoes(tb_qst_ano, tb_qst_enunciado, tb_qst_texto, tb_qst_titulo, materia_id) VALUES (2010, 'Enunciado 1 hahahha hahhaha hahah hahah', 'Texto 1 hahahah hha hha ahha', 'Título 1 dshdi cshcosd cidshciods', 1);

INSERT INTO tb_qst_opcao( tb_qst_gabarito, tb_qst_texto, questao_id) VALUES (true, 'alternativa a 1', 2);

INSERT INTO tb_qst_opcao( tb_qst_gabarito, tb_qst_texto, questao_id) VALUES (false, 'alternativa b 1', 2);

INSERT INTO tb_qst_opcao( tb_qst_gabarito, tb_qst_texto, questao_id) VALUES (false, 'alternativa c 1', 2);

INSERT INTO tb_questoes(tb_qst_ano, tb_qst_enunciado, materia_id) VALUES (2011, 'Enunciado 2 hahahha hahhaha hahah hahah', 2);

INSERT INTO tb_qst_opcao( tb_qst_gabarito, tb_qst_texto, questao_id) VALUES (false, 'alternativa a 3', 3);

INSERT INTO tb_qst_opcao( tb_qst_gabarito, tb_qst_texto, questao_id) VALUES (true, 'alternativa b 3', 3);

INSERT INTO tb_questoes(tb_qst_ano, tb_qst_enunciado, tb_qst_texto, materia_id) VALUES (2010, 'Enunciado 3 hahahha hahhaha hahah hahah', 'Texto 3 auduigaduigas dasud', 1);

INSERT INTO tb_qst_opcao( tb_qst_gabarito, tb_qst_texto, questao_id) VALUES (false, 'alternativa a 4', 4);

INSERT INTO tb_qst_opcao( tb_qst_gabarito, tb_qst_texto, questao_id) VALUES (true, 'alternativa b 4', 4);





