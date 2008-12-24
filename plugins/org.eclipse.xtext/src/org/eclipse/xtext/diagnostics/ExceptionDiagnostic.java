/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
	public int getLength() {
		return 1;
	}

	public int getOffset() {
		return 0;
	}

	public int getColumn() {
		return 0;
	}

	public int getLine() {
		return 1;
	}

	public String getLocation() {
		return null;
	}

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
