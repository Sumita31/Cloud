package org.sumita.uw.Payment;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Payment")
public class PaymentProcessing {

	@POST
	@Path("{uid}/{cardno}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(@PathParam("uid") String uid, @PathParam("cardno")String cardno){
		String usrid = uid;
		int card = Integer.parseInt(cardno);
		String status = DatabaseProcessing.verifyCard(usrid, card);
		return Response.ok(status, MediaType.APPLICATION_JSON).build();
	}
}
