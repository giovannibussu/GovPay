--GP-169
ALTER TABLE versamenti DROP foreign key fk_versamenti_1;
ALTER TABLE versamenti DROP foreign key fk_versamenti_2;
ALTER TABLE singoli_versamenti DROP foreign key fk_singoli_versamenti_1;
ALTER TABLE singoli_versamenti DROP foreign key fk_singoli_versamenti_2;
ALTER TABLE singoli_versamenti DROP foreign key fk_singoli_versamenti_3;
ALTER TABLE rpt DROP foreign key fk_rpt_1;
ALTER TABLE rpt DROP foreign key fk_rpt_2;
ALTER TABLE rpt DROP foreign key fk_rpt_3;
ALTER TABLE notifiche DROP foreign key fk_notifiche_1;
ALTER TABLE notifiche DROP foreign key fk_notifiche_2;
ALTER TABLE notifiche DROP foreign key fk_notifiche_3;
ALTER TABLE iuv DROP foreign key fk_iuv_1;
ALTER TABLE iuv DROP foreign key fk_iuv_2;

CREATE INDEX index_iuv_2 ON iuv (cod_versamento_ente,tipo_iuv,id_applicazione);

