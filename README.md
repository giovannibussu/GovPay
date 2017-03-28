# GovPay OpenAPI Specification
[![Build Status](https://travis-ci.org/link-it/GovPay.svg?branch=master)](https://travis-ci.org/link-it/GovPay)

## Steps to finish

1. Enable [Travis](https://docs.travis-ci.com/user/getting-started/#To-get-started-with-Travis-CI%3A) for your repository (**note**: you already have `.travis.yml` file)
2. [Create GitHub access token](https://help.github.com/articles/creating-an-access-token-for-command-line-use/); check `public_repo` on `Select scopes` section.
3. Use the token value as a value for [Travis environment variable](https://docs.travis-ci.com/user/environment-variables/#Defining-Variables-in-Repository-Settings) with the name `GH_TOKEN`
4. Make a test commit to trigger CI: `git commit --allow-empty -m "Test Travis CI" && git push`
5. Wait until Travis build is finished. You can check progress by clicking on the `Build Status` badge at the top
6. If you did everything correct, https://link-it.github.io/GovPay/ will lead to your new docs
7. **[Optional]** You can setup [custom domain](https://help.github.com/articles/using-a-custom-domain-with-github-pages/) (just create `web/CNAME` file)
8. Start writing/editing your OpenAPI spec: check out [usage](#usage) section below
9. **[Optional]** If you document public API consider adding it into [APIs.guru](https://APIs.guru) directory using [this form](https://apis.guru/add-api/).
10. Delete this section :smile:

## Links

- Documentation(ReDoc): https://link-it.github.io/GovPay/
- SwaggerUI: https://link-it.github.io/GovPay/swagger-ui/
- Look full spec:
    + JSON https://link-it.github.io/GovPay/swagger.json
    + YAML https://link-it.github.io/GovPay/swagger.yaml
- Preview spec version for branch `[branch]`: https://link-it.github.io/GovPay/preview/[branch]

**Warning:** All above links are updated only after Travis CI finishes deployment

## Working on specification
### Install

1. Install [Node JS](https://nodejs.org/)
2. Clone repo and `cd`
    + Run `npm install`

### Usage

1. Run `npm start`
2. Checkout console output to see where local server is started. You can use all [links](#links) (except `preview`) by replacing https://link-it.github.io/GovPay/ with url from the message: `Server started <url>`
3. Make changes using your favorite editor or `swagger-editor` (look for URL in console output)
4. All changes are immediately propagated to your local server, moreover all documentation pages will be automagically refreshed in a browser after each change
**TIP:** you can open `swagger-editor`, documentation and `swagger-ui` in parallel
5. Once you finish with the changes you can run tests using: `npm test`
6. Share you changes with the rest of the world by pushing to GitHub :smile:




# GovPay - Porta di accesso al sistema PagoPA
GovPay implementa il protocollo di colloquio con l'infrastruttura tecnologia Nodo dei Pagamenti SPC del progetto PagoPa per l'integrazione degli enti pubblici con la rete interbancaria.

## Documentazione

* [Introduzione a GovPay](./resources/doc/pdf/GovPay-PagoPA.pdf)
* [Manuale Integrazione](./resources/doc/pdf/GovPay-ManualeIntegrazioneSOAP.pdf) ([Rest](./resources/doc/pdf/GovPay-ManualeIntegrazioneREST.pdf))
* [Manuale Utente](./resources/doc/pdf/GovPay-ManualeUtente.pdf)

## Contatti

- Mailing list: [Utenti GovPay](http://www.gov4j.it/mailman/listinfo/utenti-govpay)
- Segnalazioni: [GitHub Issues](https://github.com/link-it/GovPay/issues)

## Funzionalità

Di seguito un elenco delle principali funzionalità del prodotto.
* implementazione delle Specifiche PagoPA, con supporto per pagamenti di tipo immediato, differito e ad iniziativa PSP sia monobeneficiario che multibeneficiario.
* supporto allo storno dei pagamenti.
* supporto ai pagamenti su circuito MyBank.
* supporto al pagamento della Marca da Bollo Telematica.
* aggiornato alla versione 1.7.2 delle interfacce Nodo dei Pagamenti.
* integrazione con gli applicativi dell'Ente preposti alla gestione delle posizioni creditorie tramite Web API.
* integrazione semplificata del/i portali cittadini dell'Ente.
* implementazione di servizi accessori ai pagamenti.
  * servizio di generazione IUV
  * produzione codici per BarCode e QrCode
  * produzione tracciati di Iban Accredito e Tabella Controparti
  * gestione flussi rendicontazione
  * gestione rendicontazione senza rpt
  * risoluzione pagamenti incompleti
  * giornale degli eventi
  * ...
* completa integrazione con il software di Porta di Dominio OpenSPCoop.
* cruscotto Web di gestione e configurazione.

## Licenza

GovPay - Porta di Accesso al Nodo dei Pagamenti SPC
http://www.gov4j.it/govpay

Copyright (c) 2014-2017 Link.it srl (http://www.link.it).

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
