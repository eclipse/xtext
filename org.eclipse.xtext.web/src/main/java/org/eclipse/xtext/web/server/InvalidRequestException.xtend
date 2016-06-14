/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Exception that can be thrown anytime while preparing or executing an Xtext service.
 * Clients invoking such a service directly or indirectly through {@link XtextServiceDispatcher}
 * must catch this exception and translate it to a proper error message.
 * An InvalidRequestException must never lead to an <em>internal server error</em>.
 */
@Accessors
class InvalidRequestException extends RuntimeException {
	
	new(String message) { super(message) }
	new(String message, Throwable cause) { super(message, cause) }
	
	/**
	 * The request parameters are not valid.
	 */
	static class InvalidParametersException extends InvalidRequestException {
		new(String message) { super(message) }
		new(String message, Throwable cause) { super(message, cause) }
	}
	
	/**
	 * The Xtext language could not be inferred from the parameters or metadata.
	 */
	static class UnknownLanguageException extends InvalidRequestException {
		new(String message) { super(message) }
		new(String message, Throwable cause) { super(message, cause) }
	}
	
	/**
	 * The requested resource was not found on the server.
	 */
	static class ResourceNotFoundException extends InvalidRequestException {
		new(String message) { super(message) }
		new(String message, Throwable cause) { super(message, cause) }
	}
	
	/**
	 * The required document state does not match the current document state.
	 * @see org.eclipse.xtext.web.server.model.XtextWebDocument#getStateId()
	 */
	static class InvalidDocumentStateException extends InvalidRequestException {
		new(String message) { super(message) }
		new(String message, Throwable cause) { super(message, cause) }
	}
	
	/**
	 * Permission to invoke the requested service was denied.
	 */
	static class PermissionDeniedException extends InvalidRequestException {
		new(String message) { super(message) }
		new(String message, Throwable cause) { super(message, cause) }
	}
	
}