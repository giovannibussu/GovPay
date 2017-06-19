CREATE SEQUENCE seq_avvisi_digitali start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE avvisi_digitali
(
	id_dominio BIGINT NOT NULL, -- Codice fiscale Ente Creditore
	anagrafica_beneficiario VARCHAR(35) NOT NULL, -- Denominazione ente creditore
	id_messaggio_richiesta VARCHAR(20) NOT NULL, -- Identificativo univoco nell'arco di 365gg
	id_tributo BIGINT, -- Macro categoria avviso (tassonomia_avviso)
	iuv VARCHAR(35) NOT NULL, -- IUV
	anagrafica_pagatore VARCHAR(70) NOT NULL, -- Ragione Sociale Soggetto Pagatore
	tipo_identificativo_univoco VARCHAR(1) NOT NULL, -- F = Persona Fisica / G = Persona Giuridica
	codice_identificativo_univoco VARCHAR(35) NOT NULL, -- Codice Fiscale / P.IVA Soggetto Pagatore
	data_scadenza_pagamento TIMESTAMP NOT NULL, -- Deve essere la stessa del versamento
	data_scadenza_avviso TIMESTAMP NOT NULL,
	importo_avviso DOUBLE PRECISION NOT NULL,
	email_soggetto_pagatore VARCHAR(255), -- NULLABLE Se presente viene inviata una mail al soggetto con le indicazioni per effettuare il pagamento
	cellulare_soggetto_pagatore VARCHAR(35), -- NULLABLE Se presente viene inviato un sms al soggetto  con le indicazioni per effettuare il pagamento
	descrizione_pagamento VARCHAR(140),
	url_avviso VARCHAR(140), -- NULLABLE Url della pagina sulla quale il soggetto pagatore protrà consultare l'avviso
	id_versamento BIGINT NOT NULL,
	stato VARCHAR(35) NOT NULL,
	descrizione_stato VARCHAR(255),
	data_creazione TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
	id_uo BIGINT NOT NULL,
	id BIGINT AUTO_INCREMENT,
	-- unique constraints
	CONSTRAINT unique_avvisi_digitali_1 UNIQUE (id_messaggio_richiesta,id_dominio,id_versamento),
	-- fk/pk keys constraints
	-- CONSTRAINT fk_avvisi_digitali_1 FOREIGN KEY (id_uo) REFERENCES uo(id),
	-- CONSTRAINT fk_avvisi_digitali_2 FOREIGN KEY (id_versamento) REFERENCES versamenti(id),
	-- CONSTRAINT fk_avvisi_digitali_3 FOREIGN KEY (id_tributo) REFERENCES tributi(id),
	-- CONSTRAINT fk_avvisi_digitali_4 FOREIGN KEY (id_dominio) REFERENCES domini(id),
	CONSTRAINT pk_avvisi_digitali PRIMARY KEY (id)
);

CREATE SEQUENCE seq_avvisi_digitali_esiti start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE avvisi_digitali_esiti
(
	id_dominio BIGINT NOT NULL, -- Codice fiscale Ente Creditore
	id_messaggio_richiesta VARCHAR(20) NOT NULL, -- Identificativo univoco nell'arco di 365gg
	tipo_canale_esito BIGINT NOT NULL, -- 0 = Nessun Canale / 1 = SMS / 2 = E-Mail / 3 = Mobile Payment / 4 = Altro canale psp
	identificativo_canale VARCHAR(35) NOT NULL, -- Identificativo del canale mobile a cui si riferisce l'esito dell'avviso. Presente solo se tipo_canale_esito = 2/4
	data_esito TIMESTAMP NOT NULL,
	codice_esito BIGINT NOT NULL, -- Esito del singolo canale di invio 0 = OK / 1 = KO / N = Altri esiti da definire
	descrizione_esito VARCHAR(140) NOT NULL, -- Descrizione dell'esito dell'operazione in caso di codice_esito <> 0
	id_avviso_digitale BIGINT NOT NULL,
	id BIGINT AUTO_INCREMENT,
	-- fk/pk keys constraints
	-- CONSTRAINT fk_avvisi_digitali_esiti_1 FOREIGN KEY (id_avviso_digitale) REFERENCES avvisi_digitali(id),
	CONSTRAINT pk_avvisi_digitali_esiti PRIMARY KEY (id)
);