package com.inmoment.robot.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

import com.inmoment.robot.common.Constants;
import com.inmoment.robot.model.Status;

public class DictionaryService {
	ClientConfig config = new ClientConfig();
	Client client = ClientBuilder.newClient(config);
	
//	public static void main(String[] args) {
//		DictionaryService dictionaryService = new DictionaryService();
//		dictionaryService.getDefinition("abstain");
////		ClientConfig config = new ClientConfig();
////		Client client = ClientBuilder.newClient(config);
////		WebTarget target = client.target(Constants.BASE_URL);
////
////		Status status = target.path("/status").request().accept(MediaType.APPLICATION_JSON)
////				.header(Constants.X_API_KEY, Constants.API_KEY).get(Status.class);
////		System.out.println(status.getCurrentTerm());
//	}

	/**
	 * Gives back the definition of provided term
	 * 
	 * @param term
	 *            Term
	 * @return Definition of the term
	 */
	public String getDefinition(String term) {
		String definition;
		if ((Constants.MIDDLE_ALPHABET - term.toUpperCase().charAt(0)) > 0) {
			definition = searchPageFromStart(term);
		} else {
			definition = searchPageFromEnd(term);
		}
		return definition;
	}

	private String searchPageFromStart(String term) {

		WebTarget target = client.target(Constants.BASE_URL);

		
		Status status = target.path(Constants.JUMP_TO_FIRST_PAGE).request().accept(MediaType.APPLICATION_JSON)
				.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);
		status = target.path(Constants.JUMP_TO_FIRST_TERM).request().accept(MediaType.APPLICATION_JSON)
				.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);

		while (term.compareToIgnoreCase(status.getCurrentTerm()) >= 0) {
			status = target.path(Constants.MOVE_TO_NEXT_PAGE).request().accept(MediaType.APPLICATION_JSON)
					.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);
			System.out.println(status.getCurrentPageIndex() + " -> " +status.getCurrentTerm());

			if (status.getCurrentTerm().equalsIgnoreCase(term)) {
				return status.getCurrentTermDefinition();
			}
		}

		status = target.path(Constants.MOVE_TO_PREVIOUS_PAGE).request().accept(MediaType.APPLICATION_JSON)
				.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);

		Status statusLast = target.path(Constants.JUMP_TO_LAST_TERM).request().accept(MediaType.APPLICATION_JSON)
				.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);

		if (Math.abs(term.compareToIgnoreCase(status.getCurrentTerm())) <= Math
				.abs(term.compareToIgnoreCase(statusLast.getCurrentTerm()))) {
			return searchTermFromStart(status, term);
		} else {
			return searchTermFromEnd(status, term);
		}

	}

	private String searchPageFromEnd(String term) {
		WebTarget target = client.target(Constants.BASE_URL);

		Status status = target.path(Constants.JUMP_TO_LAST_PAGE).request().accept(MediaType.APPLICATION_JSON)
				.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);

		status = target.path(Constants.JUMP_TO_FIRST_TERM).request().accept(MediaType.APPLICATION_JSON)
				.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);

		while (term.compareToIgnoreCase(status.getCurrentTerm()) <= 0) {
			
			status = target.path(Constants.MOVE_TO_PREVIOUS_PAGE).request().accept(MediaType.APPLICATION_JSON)
					.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);
			System.out.println(status.getCurrentPageIndex() + " -> " +status.getCurrentTerm());
			

			if (status.getCurrentTerm().equalsIgnoreCase(term)) {
				return status.getCurrentTermDefinition();
			}
		}
		
		Status statusLast = target.path(Constants.JUMP_TO_LAST_TERM).request().accept(MediaType.APPLICATION_JSON)
				.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);

		if (Math.abs(term.compareToIgnoreCase(status.getCurrentTerm())) <= Math
				.abs(term.compareToIgnoreCase(statusLast.getCurrentTerm()))) {
			return searchTermFromStart(status, term);
		} else {
			return searchTermFromEnd(status, term);
		}

	}

	private String searchTermFromStart(Status status, String term) {

		WebTarget target = client.target(Constants.BASE_URL);

		status = target.path(Constants.JUMP_TO_FIRST_TERM).request().accept(MediaType.APPLICATION_JSON)
				.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);

		while (term.compareToIgnoreCase(status.getCurrentTerm()) >= 0) {

			status = target.path(Constants.MOVE_TO_NEXT_TERM).request().accept(MediaType.APPLICATION_JSON)
					.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);
			System.out.println(status.getCurrentPageIndex() + " -> " +status.getCurrentTerm());

			if (status.getCurrentTerm().equalsIgnoreCase(term)) {
				return status.getCurrentTermDefinition();
			}
		}
		return Constants.NOT_FOUND;
	}

	private String searchTermFromEnd(Status status, String term) {
		WebTarget target = client.target(Constants.BASE_URL);
		status = target.path(Constants.JUMP_TO_LAST_TERM).request().accept(MediaType.APPLICATION_JSON)
				.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);
		
		while (term.compareToIgnoreCase(status.getCurrentTerm()) <= 0) {
			

			status = target.path(Constants.MOVE_TO_PREVIOUS_TERM).request().accept(MediaType.APPLICATION_JSON)
					.header(Constants.X_API_KEY, Constants.API_KEY).post(null, Status.class);
			System.out.println(status.getCurrentPageIndex() + " -> " +status.getCurrentTerm());

			if (status.getCurrentTerm().equalsIgnoreCase(term)) {
				return status.getCurrentTermDefinition();
			}
		}
		return Constants.NOT_FOUND;
	}

}
