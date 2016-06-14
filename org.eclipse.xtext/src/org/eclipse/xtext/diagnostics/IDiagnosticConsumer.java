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
public interface IDiagnosticConsumer {

	/**
	 * @param severity the severity of the diagnostic. May neither be <code>null</code> or <code>Severity.INFO</code>.
	 */
	void consume(Diagnostic diagnostic, Severity severity);

	/**
	 * @param severity the severity of the diagnostic. May neither be <code>null</code> or <code>Severity.INFO</code>.
	 */
	boolean hasConsumedDiagnostics(Severity severity);

}