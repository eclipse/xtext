/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.services;

import com.google.common.annotations.Beta;

/**
 * Represents a compiler problem or warning.
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface Problem {
	
	/**
	 * The severity of a problem 
	 */
	enum Severity {
		ERROR, WARNING, INFO, IGNORE
	}
	
	/**
	 * @return the problem kind identifier.
	 */
	String getId();
	
	/**
	 * @return the user message of the problem
	 */
	String getMessage();
	
	/**
	 * @return the problem's severity
	 */
	Severity getSeverity();
}
