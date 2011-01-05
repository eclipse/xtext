/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IExpectedTypeProvider<T> {
	
	/**
	 * computes the expected type for the given obj
	 */
	public T getExpectedType(EObject obj);
	
	/**
	 * computes the expected type for the given reference, index and container object
	 */
	public T getExpectedType(EObject container, EReference reference, int index);
}
