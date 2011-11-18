/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.lib;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

/**
 * This is an extension library for {@link EObject EMF objects}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@Deprecated
public class EObjectExtensions {

	/**
	 * Returns all the contents of {@code eObject} as an {@link Iterable}. That is, the {@code eObject} will not be
	 * provided by the results {@link Iterable#iterator() iterator}.
	 * 
	 * @param eObject
	 *            the object whose contents should be traversed. May not be <code>null</code>.
	 * @return an iterable that yields all the contents of the {@code eObject}. Never <code>null</code>.
	 */
	/**
	 * @deprecated use {@link org.eclipse.xtext.xbase.lib.IteratorExtensions#toIterable(Iterator)}
	 */
	@Deprecated
	public static Iterable<EObject> allContentsIterable(final EObject eObject) {
		if (eObject == null)
			throw new NullPointerException("eObject");
		return new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return eObject.eAllContents();
			}
		};
	}
}
