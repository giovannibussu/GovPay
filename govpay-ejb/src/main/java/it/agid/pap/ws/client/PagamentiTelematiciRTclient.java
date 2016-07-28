package it.agid.pap.ws.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PagamentiTelematiciRTclient {
	public static void main(String[] args) {

		try {
			URL url = new URL("http://localhost:8080/pap-web/rest/rpt/invia");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"identificativoMessaggioRichiesta\":\"id_mex_req_esempio\",\"dataOraMessaggioRichiesta\":1374243255684,\"autenticazioneSoggetto\":\"USR\",\"datiVersamento\":{\"datiSingoloVersamento\":[{\"datiVersamento\":null,\"importoSingoloVersamento\":0.0,\"ibanAccredito\":\"iban_accr0\",\"credenzialiPagatore\":\"user_pag0\",\"id\":null,\"causaleVersamento\":\"0 Perche' si!\",\"datiSpecificiRiscossione\":\"dat_spec_risc0\",\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false},{\"datiVersamento\":null,\"importoSingoloVersamento\":1.0,\"ibanAccredito\":\"iban_accr1\",\"credenzialiPagatore\":\"user_pag1\",\"id\":null,\"causaleVersamento\":\"1 Perche' si!\",\"datiSpecificiRiscossione\":\"dat_spec_risc1\",\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false},{\"datiVersamento\":null,\"importoSingoloVersamento\":2.0,\"ibanAccredito\":\"iban_accr2\",\"credenzialiPagatore\":\"user_pag2\",\"id\":null,\"causaleVersamento\":\"2 Perche' si!\",\"datiSpecificiRiscossione\":\"dat_spec_risc2\",\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false},{\"datiVersamento\":null,\"importoSingoloVersamento\":3.0,\"ibanAccredito\":\"iban_accr3\",\"credenzialiPagatore\":\"user_pag3\",\"id\":null,\"causaleVersamento\":\"3 Perche' si!\",\"datiSpecificiRiscossione\":\"dat_spec_risc3\",\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false},{\"datiVersamento\":null,\"importoSingoloVersamento\":4.0,\"ibanAccredito\":\"iban_accr4\",\"credenzialiPagatore\":\"user_pag4\",\"id\":null,\"causaleVersamento\":\"4 Perche' si!\",\"datiSpecificiRiscossione\":\"dat_spec_risc4\",\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false}],\"dataEsecuzionePagamento\":1374243255684,\"importoTotaleDaVersare\":1200.0,\"tipoVersamento\":\"PO\",\"identificativoUnivocoVersamento\":\"iuv_esempio\",\"firmaRicevuta\":0,\"id\":null,\"codiceContestoPagamento\":\"65494368-7506-495d-b3c4-9849ae7b7c1c\",\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false},\"xml\":null,\"identificativoPSP\":null,\"identificativoIntermediarioPSP\":null,\"identificativoCanale\":null,\"id\":null,\"versioneOggetto\":\"versione_oggetto\",\"dominio\":{\"identificativoDominio\":\"ident_dominio_esempio\",\"identificativoStazioneRichiedente\":\"staz_rich_dominio_esempio\",\"id\":null,\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false},\"soggettoVersante\":{\"identificativoUnivocoVersante\":{\"id\":null,\"tipoIdentificativoUnivoco\":\"F\",\"codiceIdentificativoUnivoco\":\"UID_vers_fg\",\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false},\"anagraficaVersante\":\"anag_vers\",\"indirizzoVersante\":\"ind_vers\",\"civicoVersante\":\"civic_vers\",\"capVersante\":\"cap_vers\",\"localitaVersante\":\"loc_vers\",\"provinciaVersante\":\"prov_vers\",\"nazioneVersante\":\"naz_vers\",\"emailVersante\":\"mail_vers\",\"id\":null,\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false},\"soggettoPagatore\":{\"identificativoUnivocoPagatore\":{\"id\":null,\"tipoIdentificativoUnivoco\":\"F\",\"codiceIdentificativoUnivoco\":\"UID_pag_fg\",\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false},\"anagraficaPagatore\":\"anag_pag\",\"indirizzoPagatore\":\"ind_pag\",\"civicoPagatore\":\"civ_pag\",\"capPagatore\":\"cap_pag\",\"localitaPagatore\":\"loc_pag\",\"provinciaPagatore\":\"prov_pag\",\"id\":null,\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false},\"enteBeneficiario\":{\"identificativoUnivocoBeneficiario\":{\"id\":null,\"tipoIdentificativoUnivoco\":\"G\",\"codiceIdentificativoUnivoco\":\"UID_benef\",\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false},\"denominazioneBeneficiario\":\"denom_benef_esempio\",\"codiceUnitOperBeneficiario\":\"CUOB_esempio\",\"denomUnitOperBeneficiario\":\"denom_unit_oper_benef_esempio\",\"indirizzoBeneficiario\":\"indr_benef_esempio\",\"civicoBeneficiario\":\"32/TER\",\"capBeneficiario\":\"00000\",\"localitaBeneficiario\":\"local_ben_esempio\",\"provinciaBeneficiario\":\"prov_ben_esempio\",\"nazioneBeneficiario\":\"naz_ben_esempio\",\"id\":null,\"denominazione\":\"denom_benef_esempio\",\"denomUnitOper\":\"denom_unit_oper_benef_esempio\",\"indirizzo\":\"indr_benef_esempio\",\"cap\":\"00000\",\"localita\":\"local_ben_esempio\",\"provincia\":\"prov_ben_esempio\",\"nazione\":\"naz_ben_esempio\",\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false},\"insertDate\":null,\"lastUpdate\":null,\"cancelled\":false}";
			/*
			 * .header("identPSP", identPSP) .header("identIntermPSP",
			 * identIntermPSP).header("iuv", iuv) .header("identCanale",
			 * identCanale) .post(ClientResponse.class, rpt);
			 */

			String identPSP = "51";
			String identIntermPSP = "Simon";
			String iuv = "";
			String identCanale = "canale";
			conn.setRequestProperty("identPSP", identPSP);
			conn.setRequestProperty("identIntermPSP", identIntermPSP);
			conn.setRequestProperty("iuv", iuv);
			conn.setRequestProperty("identCanale", identCanale);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			/*
			 * if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			 * System.out.println("errore"); throw new
			 * RuntimeException("Failed : HTTP error code : " +
			 * conn.getResponseCode()); }
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (Exception e) {

		}

	}
}
