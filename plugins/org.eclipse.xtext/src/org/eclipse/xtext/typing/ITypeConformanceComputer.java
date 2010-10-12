/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.typing;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface ITypeConformanceComputer<T> {
	
	public static final String ISSUE_NON_CONFORMANT_TYPES = "ISSUE_NON_CONFORMANT_TYPES";
	
	/**
	 * @return whether typeB conforms to typeA. That is if a value of typeA is expected in some context whether a value of typeB is valid.
	 */
	public boolean isConformant(T typeA, T typeB);
	
	/**
	 * TODO move this to another interface
	 * returns the name of a type
	 */
	public String getName(T actual);
	
}
