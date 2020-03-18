package com.sapient.catalog.search.expection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class SAppsRuntimeException extends RuntimeException {
	public final int code;
    public final String message;
    
	public SAppsRuntimeException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
}
