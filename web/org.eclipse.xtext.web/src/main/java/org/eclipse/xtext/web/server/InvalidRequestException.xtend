/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server

import java.lang.Exception
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Exception that can be thrown anytime while preparing or executing an Xtext service.
 * Clients invoking such a service directly or indirectly through {@link XtextServiceDispatcher}
 * must catch this exception and translate it to a proper error message.
 * An InvalidRequestException must never lead to an <em>internal server error</em>.
 */
@Accessors
class InvalidRequestException extends Exception {
	
	/**
	 * The exception type can be used as a hint for translating the exception into a proper
	 * error message for the client.
	 */
	static enum Type {
		INVALID_PARAMETERS,
		UNKNOWN_LANGUAGE,
		RESOURCE_NOT_FOUND,
		INVALID_DOCUMENT_STATE,
		PERMISSION_DENIED
	}
	
	val Type type
	
	new(Type type, String message) {
		super(message)
		this.type = type
	}
	
	new(Type type, String message, Throwable cause) {
		super(message, cause)
		this.type = type
	}
	
}