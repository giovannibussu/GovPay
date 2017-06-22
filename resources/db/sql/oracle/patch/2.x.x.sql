ALTER TABLE domini ADD avvisi_digitali NUMBER NOT NULL;

CREATE SEQUENCE seq_avvisi_digitali MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 NOCYCLE;

CREATE TABLE avvisi_digitali
(
	id_dominio NUMBER NOT NULL, -- Codice fiscale Ente Creditore
	anagrafica_beneficiario VARCHAR2(35) NOT NULL, -- Denominazione ente creditore
	id_messaggio_richiesta VARCHAR2(20) NOT NULL, -- Identificativo univoco nell'arco di 365gg
	id_tributo NUMBER, -- Macro categoria avviso (tassonomia_avviso)
	iuv VARCHAR2(35) NOT NULL, -- IUV
	anagrafica_pagatore VARCHAR2(70) NOT NULL, -- Ragione Sociale Soggetto Pagatore
	tipo_identificativo_univoco VARCHAR2(1) NOT NULL, -- F = Persona Fisica / G = Persona Giuridica
	codice_identificativo_univoco VARCHAR2(35) NOT NULL, -- Codice Fiscale / P.IVA Soggetto Pagatore
	data_scadenza_pagamento TIMESTAMP NOT NULL, -- Deve essere la stessa del versamento
	data_scadenza_avviso TIMESTAMP NOT NULL,
	importo_avviso DOUBLE NOT NULL,
	email_soggetto_pagatore VARCHAR2(255), -- NULLABLE Se presente viene inviata una mail al soggetto con le indicazioni per effettuare il pagamento
	cellulare_soggetto_pagatore VARCHAR2(35), -- NULLABLE Se presente viene inviato un sms al soggetto  con le indicazioni per effettuare il pagamento
	descrizione_pagamento VARCHAR2(140),
	url_avviso VARCHAR2(140), -- NULLABLE Url della pagina sulla quale il soggetto pagatore protrà consultare l'avviso
	id_versamento NUMBER NOT NULL,
	stato VARCHAR2(35) NOT NULL,
	descrizione_stato VARCHAR2(255),
	data_creazione TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	id_uo NUMBER NOT NULL,
	id NUMBER NOT NULL,
	-- unique constraints
	CONSTRAINT unique_avvisi_digitali_1 UNIQUE (id_messaggio_richiesta,id_dominio,id_versamento),
	-- fk/pk keys constraints
	-- CONSTRAINT fk_avvisi_digitali_1 FOREIGN KEY (id_uo) REFERENCES uo(id),
	-- CONSTRAINT fk_avvisi_digitali_2 FOREIGN KEY (id_versamento) REFERENCES versamenti(id),
	-- CONSTRAINT fk_avvisi_digitali_3 FOREIGN KEY (id_tributo) REFERENCES tributi(id),
	-- CONSTRAINT fk_avvisi_digitali_4 FOREIGN KEY (id_dominio) REFERENCES domini(id),
	CONSTRAINT pk_avvisi_digitali PRIMARY KEY (id)
);

CREATE TRIGGER trg_avvisi_digitali
BEFORE
insert on avvisi_digitali
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_avvisi_digitali.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/

CREATE SEQUENCE seq_avvisi_digitali_esiti MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 INCREMENT BY 1 CACHE 2 NOCYCLE;

CREATE TABLE avvisi_digitali_esiti
(
	id_dominio NUMBER NOT NULL, -- Codice fiscale Ente Creditore
	id_messaggio_richiesta VARCHAR2(20) NOT NULL, -- Identificativo univoco nell'arco di 365gg
	tipo_canale_esito NUMBER NOT NULL, -- 0 = Nessun Canale / 1 = SMS / 2 = E-Mail / 3 = Mobile Payment / 4 = Altro canale psp
	identificativo_canale VARCHAR2(35) NOT NULL, -- Identificativo del canale mobile a cui si riferisce l'esito dell'avviso. Presente solo se tipo_canale_esito = 2/4
	data_esito TIMESTAMP(3) NOT NULL,
	codice_esito NUMBER NOT NULL, -- Esito del singolo canale di invio 0 = OK / 1 = KO / N = Altri esiti da definire
	descrizione_esito VARCHAR2(140) NOT NULL, -- Descrizione dell'esito dell'operazione in caso di codice_esito <> 0
	id_avviso_digitale NUMBER NOT NULL,
	id NUMBER NOT NULL,
	CONSTRAINT unique_avvisi_digitali_esiti_1 UNIQUE (id_avviso_digitale,id_messaggio_richiesta),
	-- fk/pk keys constraints
	-- CONSTRAINT fk_avvisi_digitali_esiti_1 FOREIGN KEY (id_avviso_digitale) REFERENCES avvisi_digitali(id),
	CONSTRAINT pk_avvisi_digitali_esiti PRIMARY KEY (id)
);

CREATE TRIGGER trg_avvisi_digitali_esiti
BEFORE
insert on avvisi_digitali_esiti
for each row
begin
   IF (:new.id IS NULL) THEN
      SELECT seq_avvisi_digitali_esiti.nextval INTO :new.id
                FROM DUAL;
   END IF;
end;
/