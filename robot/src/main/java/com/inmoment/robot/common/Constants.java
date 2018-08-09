package com.inmoment.robot.common;

public interface Constants {
	String API_KEY = "LynVfTaFNW2rYwNpvphG77v3N1rs37rL2F64v4C0";
	String BASE_URL = "https://oke5yaeave.execute-api.us-west-2.amazonaws.com/prod";
	String X_API_KEY = "x-api-key";
	char MIDDLE_ALPHABET = 'M';
	String NOT_FOUND = "Not Found"; 
	
	// API paths
	
	// ARMS
	String MOVE_TO_NEXT_PAGE = "/move-to-next-page";
	String MOVE_TO_PREVIOUS_PAGE = "/move-to-previous-page";
	String JUMP_TO_FIRST_PAGE = "/jump-to-first-page";
	String JUMP_TO_LAST_PAGE = "/jump-to-last-page";
	
	
	// CAMERA
	String MOVE_TO_NEXT_TERM = "/move-to-next-term";
	String MOVE_TO_PREVIOUS_TERM = "/move-to-previous-term";
	String JUMP_TO_FIRST_TERM = "/jump-to-first-term";
	String JUMP_TO_LAST_TERM = "/jump-to-last-term";
	
}
