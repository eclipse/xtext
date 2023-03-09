/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * The purpose of this exception is to wrap checked exceptions that occurred while accessing the file system, i.e.
 * {@link java.io.IOException}.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.4
 */
public class RuntimeIOException extends RuntimeException {

	private static final long serialVersionUID = -7477488058010839013L;

	public RuntimeIOException() {
	}

	public RuntimeIOException(String message) {
		super(message);
	}

	public RuntimeIOException(String message, Throwable cause) {
		super(message, cause);
	}

	public RuntimeIOException(Throwable cause) {
		super(cause);
	}

}
