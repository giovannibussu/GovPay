--GP-169
DROP CONSTRAINT fk_versamenti_1;
DROP CONSTRAINT fk_versamenti_2;
DROP CONSTRAINT fk_singoli_versamenti_1;
DROP CONSTRAINT fk_singoli_versamenti_2;
DROP CONSTRAINT fk_singoli_versamenti_3;
DROP CONSTRAINT fk_rpt_1;
DROP CONSTRAINT fk_rpt_2;
DROP CONSTRAINT fk_rpt_3;
DROP CONSTRAINT fk_notifiche_1;
DROP CONSTRAINT fk_notifiche_2;
DROP CONSTRAINT fk_notifiche_3;
DROP CONSTRAINT fk_iuv_1;
DROP CONSTRAINT fk_iuv_2;

CREATE INDEX index_iuv_1 ON iuv (cod_versamento_ente,tipo_iuv,id_applicazione);

