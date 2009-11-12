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

import com.google.common.base.Function;

/**
 * Provides qualified names for EObjects.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IQualifiedNameProvider extends Function<EObject, String> {

	/**
	 * @return the qualified name for the given object, <code>null</code> if this {@link IQualifiedNameProvider} is not
	 *         responsible or if the given object doesn't have qualified name.
	 */
	public String getQualifiedName(EObject obj);

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public static abstract class AbstractImpl implements IQualifiedNameProvider {
		public String apply(EObject from) {
			return getQualifiedName(from);
		}
	}
}
