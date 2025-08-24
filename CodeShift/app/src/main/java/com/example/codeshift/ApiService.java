// File: ApiService.java
package com.example.codeshift;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

	/**
	 * This is the correct method for the Gemini API.
	 * It makes a POST request to the generateContent endpoint.
	 * The API key is passed as a query parameter.
	 * The request prompt is sent in the body.
	 * It expects a response that can be parsed into our GeminiResponse class.
	 */
	@POST("v1beta/models/gemini-2.0-flash:generateContent")
	Call<MainActivity.GeminiResponse> generateContent(
			@Query("key") String apiKey,
			@Body MainActivity.GeminiRequest requestBody
	);
}
