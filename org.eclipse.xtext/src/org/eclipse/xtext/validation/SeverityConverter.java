/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.xtext.diagnostics.Severity;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public class SeverityConverter {
	
	public final static String SEVERITY_ERROR = "error";
	public final static String SEVERITY_WARNING = "warning";
	public final static String SEVERITY_INFO = "info";
	public final static String SEVERITY_IGNORE = "ignore";

	public Severity stringToSeverity(String severityAsString) {
		if (severityAsString == null)
			throw new IllegalArgumentException("Severity as string was null");
		if (severityAsString.equals(SEVERITY_ERROR)) {
			return Severity.ERROR;
		}
		if (severityAsString.equals(SEVERITY_WARNING)) {
			return Severity.WARNING;
		}
		if (severityAsString.equals(SEVERITY_INFO)) {
			return Severity.INFO;
		}
		if (severityAsString.equals(SEVERITY_IGNORE)) {
			return Severity.IGNORE;
		}
		throw new IllegalArgumentException("Unknown severity '"+severityAsString+"'.");
	}
}
