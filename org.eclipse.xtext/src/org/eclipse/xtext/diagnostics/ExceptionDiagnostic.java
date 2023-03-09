/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.diagnostics;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExceptionDiagnostic implements Diagnostic {

	private final Exception exception;
	
	public ExceptionDiagnostic(Exception exception) {
		this.exception = exception;
	}
	
	@Override
	public int getLength() {
		return 1;
	}

	@Override
	public int getOffset() {
		return 0;
	}

	@Override
	public int getColumn() {
		return 0;
	}

	@Override
	public int getLine() {
		return 1;
	}

	@Override
	public int getColumnEnd() {
		return 0;
	}

	@Override
	public int getLineEnd() {
		return 1;
	}

	@Override
	public String getLocation() {
		return null;
	}

	@Override
	public String getMessage() {
		return exception.getClass().getSimpleName() + ": " + exception.getMessage() + " (see logs for details)";
	}
	
	@Override
	public String toString() {
		return getMessage();
	}

	public Exception getException() {
		return exception;
	}

}
