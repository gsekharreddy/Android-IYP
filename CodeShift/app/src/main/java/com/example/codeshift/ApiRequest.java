// File: app/src/main/java/com/example/codeshift/ApiRequest.java
package com.example.codeshift;

public class ApiRequest {
	// These field names should match what the API expects in its JSON body.
	String sourceCode;
	String fromLanguage;
	String toLanguage;
	boolean explain;

	// Constructor to easily create this object
	public ApiRequest(String sourceCode, String fromLanguage, String toLanguage, boolean explain) {
		this.sourceCode = sourceCode;
		this.fromLanguage = fromLanguage;
		this.toLanguage = toLanguage;
		this.explain = explain;
	}
}