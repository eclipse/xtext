/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
