package it.agid.pap.ws.rest.rendicontazione;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import it.agid.pap.util.FaultCodes;
import it.agid.pap.ws.rest.BasePapRsService;
import it.gov.digitpa.schemas._2011.ws.paa.FaultBean;
import it.govpay.bd.BasicBD;
import it.govpay.core.exceptions.GovPayException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Path("/pap/rends")
public class RendicontazioneContabileRestController extends BasePapRsService {
	
	public RendicontazioneContabileRestController() {
		super("PapRest");
	}
	
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response papAcquisisciRendicontazioni(@QueryParam("limit") Integer limit,
			@QueryParam("offset") Long offset, 
			@QueryParam("iban") String iban,
			@QueryParam("dominio") String codDominio,
			@QueryParam("iuv") String iuv,
			@QueryParam("trn") String trn) {


		BasicBD bd = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			bd = BasicBD.newInstance(UUID.randomUUID().toString());
			bd.getConnection();
			
			String query = "SELECT * FROM rendicontazione_contabile";
			
			boolean where = false;
			if(iban != null && !iban.isEmpty()) {
				query = query + " WHERE";
				query = query + " iban_accredito=?";
			}
			
			if(codDominio != null && !codDominio.isEmpty()) {
				if(!where) query = query + " WHERE";
				query = query + " codDominio=?";
			}
			
			if(iuv != null && !iuv.isEmpty()) {
				if(!where) query = query + " WHERE";
				query = query + " iuv=?";
			}
			
			if(trn != null && !trn.isEmpty()) {
				if(!where) query = query + " WHERE";
				query = query + " trn=?";
			}
			
			query = query + " LIMIT ? OFFSET ?";
			
			ps = bd.getConnection().prepareStatement(query);
			
			int pos = 1;
			if(iban != null && !iban.isEmpty()) {
				ps.setString(pos, iban);
				pos++;
			}
			
			if(codDominio != null && !codDominio.isEmpty()) {
				ps.setString(pos, codDominio);
				pos++;
			}
			
			if(iuv != null && !iuv.isEmpty()) {
				ps.setString(pos, iuv);
				pos++;
			}
			
			if(trn != null && !trn.isEmpty()) {
				ps.setString(pos, trn);
				pos++;
			}
			
			if(limit != null) {
				ps.setInt(pos, limit);
				pos++;
			} else {
				ps.setInt(pos, 25);
				pos++;
			}
			
			if(offset != null) {
				ps.setLong(pos, offset);
				pos++;
			} else {
				ps.setLong(pos, 0);
				pos++;
			}
			
			rs = ps.executeQuery();
			
			JSONArray rendicontazioni = new JSONArray();
			
			while (rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				JSONObject jsonObj = new JSONObject();
				for(int i = 1; i<=rsmd.getColumnCount(); i++) {
					Object obj = rs.getObject(i);
					if(obj instanceof Date)
						jsonObj.put(rsmd.getColumnLabel(i), df.format((Date) obj));
					else if(obj instanceof Time) 
						jsonObj.put(rsmd.getColumnLabel(i), df.format((Time) obj));
					else if(obj instanceof Timestamp) 
						jsonObj.put(rsmd.getColumnLabel(i), df.format((Timestamp) obj));
					else
						jsonObj.put(rsmd.getColumnLabel(i), obj);
				}
				rendicontazioni.add(jsonObj);
			}
			return Response.status(Status.OK).entity(rendicontazioni).build();
		} catch (Exception e) {
			new GovPayException(e).log(log);
			FaultBean fault = new FaultBean();
			fault.setFaultCode(FaultCodes.PAP_UNEXPECTED_ERROR.name());
			fault.setFaultString(e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(fault).build();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(bd != null) bd.closeConnection();
		}
	}
}
