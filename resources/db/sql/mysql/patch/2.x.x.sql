ALTER TABLE domini ADD COLUMN avvisi_digitali TINYINT(1) NOT NULL DEFAULT 0 AFTER custom_iuv;

CREATE TABLE avvisi_digitali
(
    id_messaggio_richiesta VARCHAR(20) NOT NULL, -- Identificativo univoco in assoluto (primi 4 caratteri occupati dall'anno)
	id_dominio BIGINT NOT NULL, -- FK dominio
	codice_avviso VARCHAR(18) NOT NULL, -- numero avviso
	stato VARCHAR(35) NOT NULL,
	descrizione_stato VARCHAR(255),
	importo_avviso DOUBLE NOT NULL,
	descrizione_pagamento VARCHAR(140) NOT NULL,
	tassonomia VARCHAR(2) NOT NULL,
	anagrafica_pagatore VARCHAR(70) NOT NULL, -- Ragione Sociale Soggetto Pagatore
	tipo_identificativo_univoco VARCHAR(1) NOT NULL, -- F = Persona Fisica / G = Persona Giuridica
	codice_identificativo_univoco VARCHAR(35) NOT NULL, -- Codice Fiscale / P.IVA Soggetto Pagatore
	email_soggetto_pagatore VARCHAR(255), -- NULLABLE Se presente viene inviata una mail al soggetto con le indicazioni per effettuare il pagamento
	cellulare_soggetto_pagatore VARCHAR(35), -- NULLABLE Se presente viene inviato un sms al soggetto  con le indicazioni per effettuare il pagamento
	data_scadenza_pagamento TIMESTAMP(3) NOT NULL, -- Deve essere la stessa del versamento
	data_scadenza_avviso TIMESTAMP(3) NOT NULL,
	data_creazione TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
	url_avviso VARCHAR(140), -- NULLABLE Url della pagina sulla quale il soggetto pagatore protrà consultare l'avviso
	id BIGINT AUTO_INCREMENT,
	-- unique constraints
	CONSTRAINT unique_avvisi_digitali_1 UNIQUE (id_messaggio_richiesta),
	CONSTRAINT unique_avvisi_digitali_2 UNIQUE (id_dominio, codice_avviso),
	-- fk/pk keys constraints
	CONSTRAINT fk_avvisi_digitali_1 FOREIGN KEY (id_dominio) REFERENCES domini(id),
	CONSTRAINT pk_avvisi_digitali PRIMARY KEY (id)
)ENGINE INNODB CHARACTER SET latin1 COLLATE latin1_general_cs;

CREATE TABLE avvisi_digitali_esiti
(
	id_avviso_digitale BIGINT NOT NULL, -- FK all'avviso digitale
	identificativo_canale VARCHAR(35), -- Identificativo del canale mobile a cui si riferisce l'esito dell'avviso. Presente solo se tipo_canale_esito = 2/4
	tipo_canale_esito BIGINT NOT NULL, -- 0 = Nessun Canale / 1 = SMS / 2 = E-Mail / 3 = Mobile Payment / 4 = Altro canale psp
	data_esito TIMESTAMP(3) NOT NULL,
	codice_esito BIGINT NOT NULL, -- Esito del singolo canale di invio 0 = OK / 1 = KO / N = Altri esiti da definire
	descrizione_esito VARCHAR(140), -- Descrizione dell'esito dell'operazione in caso di codice_esito <> 0
	id BIGINT AUTO_INCREMENT,
	-- unique constraints
	CONSTRAINT fk_avvisi_digitali_esiti_1 FOREIGN KEY (id_avviso_digitale) REFERENCES avvisi_digitali(id),
	-- fk/pk keys constraints
	CONSTRAINT pk_avvisi_digitali_esiti PRIMARY KEY (id)
)ENGINE INNODB CHARACTER SET latin1 COLLATE latin1_general_cs;

-- index
CREATE INDEX index_avvisi_digitali_esiti_1 ON avvisi_digitali_esiti (id,id_avviso_digitale);