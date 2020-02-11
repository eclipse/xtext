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