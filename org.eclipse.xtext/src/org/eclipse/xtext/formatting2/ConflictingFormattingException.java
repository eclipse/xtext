/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

/**
 * An exception to indicate that a region of the document was formatted with
 * conflicting settings.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ConflictingFormattingException extends RuntimeException {

	private static final long serialVersionUID = 4660608498421246649L;

	public ConflictingFormattingException() {
		super();
	}

	public ConflictingFormattingException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConflictingFormattingException(String message) {
		super(message);
	}

}
