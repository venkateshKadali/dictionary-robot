package com.inmoment.robot.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.inmoment.robot.model.Word;
import com.inmoment.robot.service.DictionaryService;

@Path("/dict")
public class DictionaryApi {
	private DictionaryService dictionaryService = new DictionaryService();
	
	@POST
	@Path("/getDefinition")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDefinition(Word word) {
		if(word == null || word.getTerm() == null || "".equals(word.getTerm())) {
			String error = "Not Found";
			return Response.status(400).entity(error).build();	
		}
		String definition = dictionaryService.getDefinition(word.getTerm());
		word.setDefinition(definition);
		return Response.status(200).entity(word).build();
	}
}
