/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import org.eclipse.emf.ecore.EObject;

/**
 * Provides qualified names for EObjects.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IQualifiedNameProvider {

	/**
	 * @return the qualified name for the given object, <code>null</code> if this {@link IQualifiedNameProvider} is not
	 *         responsible or if the given object doesn't have qualified name.
	 */
	public String getQualifiedName(EObject obj);

	/**
	 *@return the delimiter this {@link IQualifiedNameProvider} uses to delimit name space fragments (i.e. '.' in Java)
	 */
	public String getDelimiter();

	/**
	 *@return if supported, this method returns the character which is used as awildcard in imports (i.e. '*' in Java, '_' in Scala)
	 */
	public String getWildcard();

	
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public static abstract class AbstractImpl implements IQualifiedNameProvider {
	}
}
