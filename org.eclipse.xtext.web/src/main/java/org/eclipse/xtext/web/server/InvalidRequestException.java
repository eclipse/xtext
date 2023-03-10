/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server;

/**
 * Exception that can be thrown anytime while preparing or executing an Xtext
 * service. Clients invoking such a service directly or indirectly through
 * {@link XtextServiceDispatcher} must catch this exception and translate it to
 * a proper error message. An InvalidRequestException must never lead to an
 * <em>internal server error</em>.
 */
public class InvalidRequestException extends RuntimeException {
	private static final long serialVersionUID = 1833024545060531279L;

	/**
	 * The request parameters are not valid.
	 */
	public static class InvalidParametersException extends InvalidRequestException {
		private static final long serialVersionUID = -5543694640103889039L;

		public InvalidParametersException(String message) {
			super(message);
		}

		public InvalidParametersException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	/**
	 * The Xtext language could not be inferred from the parameters or metadata.
	 */
	public static class UnknownLanguageException extends InvalidRequestException {
		private static final long serialVersionUID = 4069448061508416517L;

		public UnknownLanguageException(String message) {
			super(message);
		}

		public UnknownLanguageException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	/**
	 * The requested resource was not found on the server.
	 */
	public static class ResourceNotFoundException extends InvalidRequestException {
		private static final long serialVersionUID = -5065475982907147862L;

		public ResourceNotFoundException(String message) {
			super(message);
		}

		public ResourceNotFoundException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	/**
	 * The required document state does not match the current document state.
	 * 
	 * @see org.eclipse.xtext.web.server.model.XtextWebDocument#getStateId()
	 */
	public static class InvalidDocumentStateException extends InvalidRequestException {
		private static final long serialVersionUID = 6295176606149510699L;

		public InvalidDocumentStateException(String message) {
			super(message);
		}

		public InvalidDocumentStateException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	/**
	 * Permission to invoke the requested service was denied.
	 */
	public static class PermissionDeniedException extends InvalidRequestException {
		private static final long serialVersionUID = 2990973891054231055L;

		public PermissionDeniedException(String message) {
			super(message);
		}

		public PermissionDeniedException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	public InvalidRequestException(String message) {
		super(message);
	}

	public InvalidRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
